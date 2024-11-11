/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import Controlador.Restaurante;
import java.util.Scanner;
import restaurante.poo.Atendente;
import restaurante.poo.Constantes;
import restaurante.poo.Gerador;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 *
 * @author rodri
 */
public class Principal {

    static String tipoOutput = "console";
    static OutputInterface output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
    static Restaurante restaurante = new Restaurante("Restaurante FCT", OutputFactory.getInstance(), tipoOutput, 30, "Menu Normal", "Menu pensado para as operações cotidianas do Restaurante FCT", "11:00 - 14:00 e 17:00 - 22:00");
    static Atendente atendente = new Atendente(Constantes.SALARIO_MINIMO, Gerador.geradorAleatorioNome(), "oqequwqioe@email.com",  restaurante);
    static Scanner sc = new Scanner(System.in);

    public static void menuPrincipal() {
        int opc = 0;
        restaurante.adicionarObserver(atendente);

        output.display("=================== MENU PRINCIPAL ========================");
        output.display("Selecione sua opção: ");
        //output.display("1 - Cadastrar Cliente"); //Desnecessário, pois agora toda vez que uma pessoa entra na fila a cada 30 segundos, o atendente cria o cliente
        //output.display("2 - Cadastrar Reserva");
        output.display("1 - Cadastrar Mesa");
        output.display("2 - Remover Mesa");
        output.display("3 - Imprimir Menu");
        output.display("4 - Cadastrar ItemMenu");
        output.display("5 - Remover ItemMenu");
        output.display("6 - Cadastrar Pedido");
        output.display("7 - Cadastrar Garçom");
        output.display("8 - Cadastrar Cartão");
        opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                cadastrarMesa();
                break;
            case 2:
                removerMesa();
                break;
            case 3:
                imprimirMenu();
                break;
            case 4:
                cadastrarItemMenu();
                break;
            case 5:
                removerItemMenu();
                break;
            case 6:
                cadastrarPedido();
                break;
            case 7:
                cadastrarGarcom();
            break;
            case 8:
                cadastrarCartao();
            break;
            default:
                output.display("Opção invalida");
                menuPrincipal();
                break;
        }
    }

    public static void cadastrarReserva() {
       
    }

    public static void cadastrarMesa() {
        output.display("Número da mesa: ");
        String numeroMesa = sc.nextLine();

        output.display("Capacidade: ");
        int capacidade = sc.nextInt();

        restaurante.adicionarMesa(numeroMesa, capacidade);
    }
   
    public static void removerMesa() {
        output.display("Número da mesa: ");
        String numeroMesa = sc.nextLine();

        restaurante.removerMesa(numeroMesa);
    }

    public static void imprimirMenu() {
        output.display("Menu: ");
        restaurante.exibirMenu();
    }

    public static void cadastrarItemMenu() {
        output.display("Nome: ");
        String nomeItem = sc.nextLine();

        output.display("Descrição: ");
        String descricaoItem = sc.nextLine();

        output.display("Preço: ");
        double preco = sc.nextDouble();

        restaurante.adicionarItemMenu(nomeItem, descricaoItem, preco);
    }

    public static void removerItemMenu() {
        output.display("Nome: ");
        String nomeItem = sc.nextLine();

        output.display("Preço: ");
        double preco = sc.nextDouble();

        restaurante.removerItemMenu(nomeItem, preco);
    }

    public static void cadastrarPedido() {
        output.display("Numero da mesa: ");
        String numeroMesa = sc.nextLine();
       
        restaurante.adicionarPedido(numeroMesa);
    }
   
    public static void cadastrarGarcom(){
        output.display("Nome: ");
        String nome = sc.nextLine();
       
        output.display("Email: ");
        String email = sc.nextLine();
       
        output.display("Registro do Garçom: ");
        String registroGarcom = sc.nextLine();
       
        output.display("Salario base: ");
        double salarioBaseGarcom = sc.nextInt();
       
        output.display("Gorjeta: ");
        double gorjetaGarcom = sc.nextInt();

        restaurante.adicionarGarcom(nome, email, registroGarcom, salarioBaseGarcom, gorjetaGarcom);
    }
   
    public static void cadastrarCartao(){
    }

    public static void main(String[] args) {
        while (true) {
            
            menuPrincipal();
        }
    }
}

