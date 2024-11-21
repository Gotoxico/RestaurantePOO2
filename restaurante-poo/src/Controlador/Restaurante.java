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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import restaurante.poo.Reserva.ReservaMesa;
import restaurante.poo.ClienteRestaurante;
import restaurante.poo.Garcom;
import restaurante.poo.ItemMenu;
import restaurante.poo.Menu;
import restaurante.poo.Mesa;
import restaurante.poo.ObserverQueue;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;
import restaurante.poo.Pessoa;
import restaurante.poo.SubjectQueue;
import restaurante.poo.Comanda;
import restaurante.poo.PagamentoPedido;
/**
 *
 * @author rodri
 */
public class Restaurante implements SubjectQueue{
    private ArrayList<Garcom> garcoms = new ArrayList<>();
    private ArrayList<ClienteRestaurante> clientes = new ArrayList<>();
    private Queue <Pessoa> fila = new LinkedList<>();
    private final ReservaMesa reserva;
    private Menu menu;
    private int contadorClientes = 0, maximoMesas, contadorMesas = 0;
    private String nomeRestaurante, tipoOutput;
    private final OutputFactory outputFactory;
    private final OutputInterface output;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ArrayList<ObserverQueue> observers = new ArrayList<>();
    
    /**
     * 
     * @param nomeRestaurante
     * @param outputFactory
     * @param tipoOutput
     * @param maximoMesas
     * @param nomeMenu
     * @param descricaoMenu
     * @param horarioDisponibilidade 
     */
    public Restaurante(String nomeRestaurante, OutputFactory outputFactory, String tipoOutput, int maximoMesas, String nomeMenu, String descricaoMenu, String horarioDisponibilidade){
        this.nomeRestaurante = nomeRestaurante;
        this.maximoMesas = maximoMesas;
        reserva = ReservaMesa.getInstance(maximoMesas, tipoOutput);
        menu = new Menu(outputFactory, tipoOutput, nomeRestaurante, nomeMenu, descricaoMenu, horarioDisponibilidade);
        this.outputFactory = outputFactory;
        this.tipoOutput = tipoOutput;
        this.output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
        
        scheduler.scheduleAtFixedRate(() -> {
            Pessoa pessoa = new Pessoa();
            fila.add(pessoa);
            notifyObservers(pessoa);
        }, 0, 10, TimeUnit.SECONDS);
    }
        
    /**
     * 
     * @param numeroMesa
     * @param capacidadeMaxima 
     */
    //Classe Mesa
    public void adicionarMesa(String numeroMesa, int capacidadeMaxima){
        reserva.adicionarMesa(tipoOutput, capacidadeMaxima, numeroMesa);
    }
    
    public void cadastrarReserva(LocalDate data, LocalTime horarioReserva, String nomeCliente, int quantidadePessoas){
        reserva.reservarMesa(data, horarioReserva, nomeCliente, quantidadePessoas);
    }
    
    public void verificarDisponibilidade(int maximoMesas, LocalDate data, LocalTime horario){
        Mesa mesa = reserva.verificarDisponibilidade(maximoMesas, data, horario);
        if(mesa != null){
            output.display("Mesa " + mesa.getNumeroMesa() + " disponivel");
        }
        else{
            output.display("Mesa indisponivel");
        }
    }
    
    /**
     * 
     * @param numeroMesa 
     */    
    public void removerMesa(String numeroMesa){
        reserva.removerMesa(numeroMesa);
    }
    
    /**
     * 
     * @param numeroMesa 
     */
    public void liberarMesa(String numeroMesa){
        reserva.liberarMesa(numeroMesa);
    }
    
    /**
     * 
     * @param data
     * @param hora
     * @param nome
     * @param quantidade 
     */
    //Classe ReservaMesa
    public void reservarMesa(LocalDate data, LocalTime hora, String nome, int quantidade){
        reserva.reservarMesa(data, hora, nome, quantidade);
    }
        
    /**
     * 
     * @param data
     * @param hora
     * @param nome
     * @param quantidade 
     */
    public void cancelarReservaMesa(LocalDate data, LocalTime hora, String nome, int quantidade){
        reserva.cancelarReserva(data, hora, nome, quantidade);
    }
    
    public void adicionarCliente(ClienteRestaurante clienteRestaurante){
        clientes.add(clienteRestaurante);
        aumentarContadorClientes();
    }
    
    public void aumentarContadorClientes(){
        contadorClientes++;
    }
        
    /**
     * 
     * @param nome
     * @param email
     * @param registroGarcom
     * @param salarioBaseGarcom
     * @param gorjetaGarcom 
     */
    //Classe Garcom (Marcos)
    public void adicionarGarcom(String nome, String email, String registroGarcom, double salarioBaseGarcom, double gorjetaGarcom){
        Garcom garcom = new Garcom(nome, email, registroGarcom,salarioBaseGarcom, gorjetaGarcom, output);
        this.garcoms.add(garcom);
    }
        
    /**
     * 
     * @param nomeItem
     * @param descricaoItem
     * @param preco 
     */
    //Classe Menu
    public void adicionarItemMenu(String nomeItem, String descricaoItem, double preco){
        ItemMenu item = new ItemMenu(nomeItem, descricaoItem, preco);
        menu.adicionarItem(item);
    }
    
    /**
     * 
     * @param nomeItem
     * @param preco 
     */
    public void removerItemMenu(String nomeItem, double preco){
        menu.removerItem(nomeItem, preco);
    }
        
    /**
     * 
     * @param nomeItem
     * @param descricaoItem
     * @param preco 
     */
    public void alterarPrecoItemMenu(String nomeItem, String descricaoItem, double preco){
        ItemMenu itemAtualizado = new ItemMenu(nomeItem, descricaoItem, preco);
        menu.atualizarItem(itemAtualizado);
    }
    
    /**
     * 
     */
    public void exibirMenu(){
        menu.exibirMenu();
    }
        
    /**
     * 
     * @param numeroMesa 
     */
    //Pedido
    public void adicionarPedido(String numeroMesa){
        Mesa mesa = reserva.getMesa(numeroMesa);
            int opcao = 0;
            Scanner scan = new Scanner(System.in);
            do {
                output.display("Digite opcao desejada: \n1 - Adicionar Item\n2 - Remover Item\n3 - Encerrar Ordem");
                if (scan.hasNextInt()) {
                    opcao = scan.nextInt();
                    scan.nextLine(); 
                } else {
                    output.display("Opcao inválida! Por favor, insira um número.");
                    scan.nextLine(); 
                    continue; 
                }
                String nomeItem;
                int quantidadeItens;
                ItemMenu item;
                       
                switch (opcao) {
                    case 1:
                        scan.nextLine();
                        output.display("Digite nome Item: ");
                        nomeItem = scan.nextLine();
                        output.display("Digite quantidade itens: ");
                        quantidadeItens = scan.nextInt();
                        item = menu.buscarItemPorNome(nomeItem);
                        for (int i = 0; i < quantidadeItens; i++) {
                            mesa.fazerPedido(item);                            
                        }
                        break;
                                
                    case 2:
                        scan.nextLine();
                        output.display("Digite nome Item: ");
                        nomeItem = scan.nextLine();
                        output.display("Digite quantidade itens: ");
                        quantidadeItens = scan.nextInt();
                        item = menu.buscarItemPorNome(nomeItem);
                        for (int i = 0; i < quantidadeItens; i++) {
                            mesa.getComandaAtiva().removerItemPedido(item);
                        }
                        break;                                
                    
                    case 3:
                        output.display("Encerrando a ordem.\n");
                        break;
                        
                    default:
                        output.display("Opcao inválida!\n");
                        break;
                }
                        
            } while (opcao != 3);
    }
        
    /**
     * 
     */    
    //Pagamento pedido
    public void pagar(String numeroMesa){
        Mesa mesa = reserva.getMesa(numeroMesa);
        Comanda comanda = mesa.getComandaAtiva();
        PagamentoPedido pagamento = new PagamentoPedido(comanda);
        pagamento.realizarPagamento();
    }
    
    /**
     * 
     * @param observerQueue 
     * 
     * @Brief: Adiciona um atendente como observador da fila
     */
    @Override
    public void adicionarObserver(ObserverQueue observerQueue){
        observers.add(observerQueue);
    }
    
    /**
     * 
     * @param observerQueue 
     * 
     * @Brief: Remove um atendente como observador da fila
     */
    @Override
    public void removerObserver(ObserverQueue observerQueue){
        observers.remove(observerQueue);
    }
    
    /**
     * 
     * @param pessoa 
     * 
     * @Brief: Avisa os atendentes sobre uma pessoa na fila
     */
    @Override
    public void notifyObservers(Pessoa pessoa){
        for(ObserverQueue observer : observers){
            observer.update(pessoa);
        }
    }
    
    /**
     * Brief: Parar Scheduler
     */
    public void pararScheduler() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
    }
    
}

