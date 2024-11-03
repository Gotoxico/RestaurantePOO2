/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import restaurante.poo.Reserva.ReservaMesa;
import restaurante.poo.ClienteRestaurante;
import restaurante.poo.Garcom;
import restaurante.poo.ItemMenu;
import restaurante.poo.Menu;
import restaurante.poo.Mesa;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;
/**
 *
 * @author rodri
 */
public class Restaurante {
    private ArrayList<Garcom> garcoms;
    private ArrayList<ClienteRestaurante> clientes;
    private Queue <ClienteRestaurante> fila = new LinkedList<>();
    private final ReservaMesa reserva;
    private Menu menu;
    private int contadorClientes = 0, maximoMesas, contadorMesas = 0;
    private String nomeRestaurante, tipoOutput;
    private final OutputFactory outputFactory;
    private final OutputInterface output;
    
    public Restaurante(String nomeRestaurante, OutputFactory outputFactory, String tipoOutput, int maximoMesas, String nomeMenu, String descricaoMenu, String horarioDisponibilidade){
        this.nomeRestaurante = nomeRestaurante;
        this.maximoMesas = maximoMesas;
        reserva = ReservaMesa.getInstance(maximoMesas, tipoOutput);
        menu = new Menu(outputFactory, tipoOutput, nomeRestaurante, nomeMenu, descricaoMenu, horarioDisponibilidade);
        this.outputFactory = outputFactory;
        this.tipoOutput = tipoOutput;
        this.output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
    }
        
    //Classe Mesa
    public void adicionarMesa(String numeroMesa, int capacidadeMaxima){
        reserva.adicionarMesa(tipoOutput, capacidadeMaxima, numeroMesa);
    }
        
    public void removerMesa(String numeroMesa){
        reserva.removerMesa(numeroMesa);
    }
    
    public void liberarMesa(String numeroMesa){
        reserva.liberarMesa(numeroMesa);
    }
        
    //Classe ReservaMesa
    public void reservarMesa(LocalDate data, LocalTime hora, String nome, int quantidade){
        reserva.reservarMesa(data, hora, nome, quantidade);
    }
        
    public void cancelarReservaMesa(LocalDate data, LocalTime hora, String nome, int quantidade){
        reserva.cancelarReserva(data, hora, nome, quantidade);
    }

    //Classe ClienteRestaurante (Gabrielly)
    public void criarCliente(ClienteRestaurante c){
        clientes.add(c);
        contadorClientes++;
    }
        
    //Classe Garcom (Marcos)
    public void adicionarGarcom(Garcom garcom){
        this.garcoms.add(garcom);
    }
        
    //Classe Menu
    public void adicionarItemMenu(String nomeItem, String descricaoItem, double preco){
        ItemMenu item = new ItemMenu(nomeItem, descricaoItem, preco);
        menu.adicionarItem(item);
    }
    
    public void removerItemMenu(String nomeItem, double preco){
        menu.removerItem(nomeItem, preco);
    }
        
    public void alterarPrecoItemMenu(String nomeItem, String descricaoItem, double preco){
        ItemMenu itemAtualizado = new ItemMenu(nomeItem, descricaoItem, preco);
        menu.atualizarItem(itemAtualizado);
    }
    
    public void exibirMenu(){
        menu.exibirMenu();
    }
        
    //Pedido
    public void adicionarPedido(String numeroMesa){
        Mesa mesa = reserva.getMesa(numeroMesa);
            int opcao = 0;
            Scanner scan = new Scanner(System.in);
            do {
                output.display("Digite opcao desejada: \n1 - Adicionar Item\n2 - Remover Item\n3 - Encerrar Ordem");
                opcao = scan.nextInt();
                String nomeItem;
                int quantidadeItens;
                ItemMenu item;
                       
                switch (opcao) {
                    case 1:
                        output.display("Digite nome Item: ");
                        nomeItem = scan.nextLine();
                        output.display("Digite quantidade itens: ");
                        quantidadeItens = scan.nextInt();
                        item = menu.buscarItemPorNome(nomeItem);
                        for (int i = 0; i < quantidadeItens; i++) {
                            mesa.getPedido().addPedido(item);
                        }
                        break;
                                
                    case 2:
                        output.display("Digite nome Item: ");
                        nomeItem = scan.nextLine();
                        output.display("Digite quantidade itens: ");
                        quantidadeItens = scan.nextInt();
                        item = menu.buscarItemPorNome(nomeItem);
                        for (int i = 0; i < quantidadeItens; i++) {
                            mesa.getPedido().removerItem(item);
                        }
                        break;                                
                                
                    default:
                        output.display("Opcao inválida!\n");
                        break;
                }
                        
            } while (opcao != 3);
            scan.close();
    }
        
        
    //Pagamento pedido
    public void pagar(){
        
    }
    
}
