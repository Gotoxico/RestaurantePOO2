/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import Controlador.Restaurante;
import UISegregation.Administrador;
import UISegregation.Editor;
import UISegregation.Visualizador;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import restaurante.poo.Atendente;
import restaurante.poo.Constantes;
import restaurante.poo.Cozinheiro;
import restaurante.poo.Garcom;
import restaurante.poo.Gerador;
import restaurante.poo.Gerente;
import restaurante.poo.Cartao.Cartao;
import restaurante.poo.Mesa;
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
    static Atendente atendente = new Atendente(Constantes.SALARIO_MINIMO, Gerador.geradorAleatorioNome(), "oqequwqioe@email.com",  restaurante, output);
    static Cozinheiro cozinheiro = new Cozinheiro("Cozinheiro", Constantes.SALARIO_MINIMO, Gerador.geradorAleatorioNome(), "uqywiweyquiwiueq@email.com", output, tipoOutput);
    static Garcom garcom = new Garcom(Gerador.geradorAleatorioNome(), "qhejyqgtyeqtyugw@email.com", "Garcom1", Constantes.SALARIO_MINIMO, 10, output);
    static Gerente gerente = new Gerente(Constantes.SALARIO_MINIMO*2, Gerador.geradorAleatorioNome(), "ujquiqweyuqguyeq@email.com", output);
    static Scanner sc = new Scanner(System.in);
    
    /**
     * 
     * @return 
     */
    public static Visualizador menuSelecaoTipoUsuario(){
        output.display("Digite tipo de usuário: ");
        output.display("1 - Cozinheiro");
        output.display("2 - Chef");
        output.display("3 - Garçom");
        output.display("4 - Atendente");
        output.display("5 - Gerente");
        int opc = sc.nextInt();
        if(opc == 1){ 
            return cozinheiro;
        }
        if(opc == 2){
            
        }
        if(opc == 3){
            return garcom;
        }
        
        if(opc == 4){
            return atendente;
        }
        
        return gerente;
    }
    
    /**
     * 
     * @param usuario 
     */
    public static void mostrarUI(Visualizador usuario){
        usuario.visualizarConteudo(new Principal());
        
        if(usuario instanceof Editor){
            ((Editor) usuario).editarConteudo(new Principal());
        }
        
        if(usuario instanceof Administrador){
            ((Administrador) usuario).manejarUsuarios(new Principal());
        }
    }
    
    public static void menuPrincipal() {
        int opc = 0;
        restaurante.adicionarObserver(atendente);

        output.display("=================== MENU PRINCIPAL ========================");
        output.display("Selecione sua opção: ");
        //output.display("1 - Cadastrar Cliente"); //Desnecessário, pois agora toda vez que uma pessoa entra na fila a cada 30 segundos, o atendente cria o cliente
        output.display("1 - Cadastrar Reserva");
        output.display("2 - Verificar Disponibilidade");
        output.display("3 - Cancelar Reserva");
        output.display("4 - Cadastrar Mesa");
        output.display("5 - Remover Mesa");
        output.display("6 - Imprimir Menu");
        output.display("7 - Cadastrar ItemMenu");
        output.display("8 - Remover ItemMenu");
        output.display("9 - Cadastrar Pedido");
        output.display("10 - Cadastrar Garçom");
        output.display("11 - Cadastrar Cartão");
        opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                cadastrarReserva();
                break;
            case 2:
                verificarDisponibilidade();
                break;
            case 3:
                cancelarReserva();
                break;
            case 4:
                cadastrarMesa();
                break;
            case 5:
                removerMesa();
                break;
            case 6:
                imprimirMenu();
            break;
            case 7:
                cadastrarItemMenu();
            break;
            case 8:
                removerItemMenu();
            break;
            case 9:
                cadastrarPedido();
            break;
            case 10:
                cadastrarGarcom();
            break;
            case 11:
                cadastrarCartao();
            break;
            default:
                output.display("Opção invalida");
                menuPrincipal();
                break;
        }
    }

    public static void cadastrarReserva() {
        output.display("Data da Reserva: ");
        String data = sc.nextLine();

        output.display("Horário: ");
        String horario = sc.nextLine();

        restaurante.cadastrarReserva(LocalDate.MAX, LocalTime.NOON, horario);
    }
    
    public static void verificarDisponibilidade(){
        output.display("Quantidade máxima da mesa: ");
        int maximoMesas = sc.nextInt();
        
       restaurante.verificarDisponibilidade(maximoMesas, LocalDate.MAX, LocalTime.MIN);
    }
    
    public static void cancelarReserva(){
        output.display("Data: ");
        String data = sc.nextLine();
        
        output.display("Horário: ");
        String horario = sc.nextLine();
        
        output.display("Nome: ");
        String nome = sc.nextLine();
        
        output.display("Quantidade: ");
        int quantidade = sc.nextInt();
        
        restaurante.cancelarReservaMesa(LocalDate.MAX, LocalTime.NOON, nome, quantidade);
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
            Visualizador usuario = menuSelecaoTipoUsuario();
            mostrarUI(usuario);
        }
    }
}

