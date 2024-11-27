/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
     * @Brief: Construtor da classe Restaurante
     * @Parameter: nomeRestaurante Nome do restaurante
     * @Parameter: outputFactory Fábrica de saídas
     * @Parameter: tipoOutput Tipo de saída
     * @Parameter: maximoMesas Número máximo de mesas no restaurante
     * @Parameter: nomeMenu Nome do menu
     * @Parameter: descricaoMenu Descrição do menu
     * @Parameter: horarioDisponibilidade Horário de disponibilidade do menu
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
            if (!fila.contains(pessoa)) {
                fila.add(pessoa);
                notifyObservers(pessoa);
            }
        }, 0, 30, TimeUnit.SECONDS);
    }
    
    /**
     * @Brief: Adiciona uma nova mesa ao restaurante
     * @Parameter: numeroMesa Número identificador da mesa
     * @Parameter: capacidadeMaxima Capacidade máxima de pessoas da mesa
     * @Return: none
     */
    public void adicionarMesa(String numeroMesa, int capacidadeMaxima){
        reserva.adicionarMesa(tipoOutput, capacidadeMaxima, numeroMesa);
    }
    
    /**
     * @Brief: Cadastra uma nova reserva no restaurante
     * @Parameter: data Data da reserva
     * @Parameter: horarioReserva Horário da reserva
     * @Parameter: nomeCliente Nome do cliente
     * @Parameter: quantidadePessoas Número de pessoas na reserva
     * @Return: none
     */
    public void cadastrarReserva(LocalDate data, LocalTime horarioReserva, String nomeCliente, int quantidadePessoas){
        reserva.reservarMesa(data, horarioReserva, nomeCliente, quantidadePessoas);
    }
    
    /**
     * @Brief: Verifica a disponibilidade de mesas
     * @Parameter: maximoMesas Número máximo de mesas a verificar
     * @Parameter: data Data de verificação
     * @Parameter: horario Horário de verificação
     * @Return: none
     */
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
     * @Brief: Remove uma mesa pelo número
     * @Parameter: numeroMesa Número identificador da mesa
     * @Return: none
     */    
    public void removerMesa(String numeroMesa){
        reserva.removerMesa(numeroMesa);
    }
    
    public void exibirMesas(){
        reserva.exibirMesas();
    }
    
    /**
     * @Brief: Libera uma mesa ocupada
     * @Parameter: numeroMesa Número identificador da mesa
     * @Return: none
     */
    public void liberarMesa(String numeroMesa){
        reserva.liberarMesa(numeroMesa);
    }
    
    /**
     * @Brief: Reserva uma mesa para o cliente
     * @Parameter: data Data da reserva
     * @Parameter: hora Horário da reserva
     * @Parameter: nome Nome do cliente
     * @Parameter: quantidade Quantidade de pessoas
     */
    public void reservarMesa(LocalDate data, LocalTime hora, String nome, int quantidade){
        reserva.reservarMesa(data, hora, nome, quantidade);
    }
        
    /**
     * @Brief: Cancela uma reserva de mesa
     * @Parameter: data Data da reserva
     * @Parameter: hora Horário da reserva
     * @Parameter: nome Nome do cliente
     * @Parameter: quantidade Quantidade de pessoas
     */
    public void cancelarReservaMesa(LocalDate data, LocalTime hora, String nome, int quantidade){
        reserva.cancelarReserva(data, hora, nome, quantidade);
    }
    
    /**
     * @Brief: Adiciona um cliente à lista de clientes do restaurante
     * @Parameter: clienteRestaurante Objeto ClienteRestaurante a ser adicionado
     */
    public void adicionarCliente(ClienteRestaurante clienteRestaurante){
        if (!clientes.contains(clienteRestaurante)) {
            clientes.add(clienteRestaurante);
        }
        aumentarContadorClientes();
    }
    
    /**
     * @Brief: Exibir todos os clientes que foram adicionados pela atendente na fila de clientes
     */
    public void exibirClientesFila(){
        for (ClienteRestaurante cliente : clientes){
            output.display("Nome Cliente: " + cliente.getNomeCliente());
        }
    }
    /**
     * @Brief: Retornar tamanho da fila de clientes
     */
    public int getTamanhoFilaClientes(){
        return clientes.size();
    }
    
    /**
     * @Brief: Cadastra reserva para clientes na fila do restaurante
     * 
     * @param data
     * @param horarioReserva
     * @param nomeCliente
     * @param quantidadePessoas 
     */
    public void cadastrarReservaClienteFila(LocalDate data, LocalTime horarioReserva, String nomeCliente, int quantidadePessoas){
        reserva.reservarMesa(data, horarioReserva, nomeCliente, quantidadePessoas);
        Iterator<ClienteRestaurante> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            ClienteRestaurante cliente = iterator.next();
            if (cliente.getNomeCliente().equals(nomeCliente)) {
                iterator.remove(); 
            }
        }
    }
    
    public void aumentarContadorClientes(){
        contadorClientes++;
    }
        
    /**
     * @Brief: Adiciona um novo garçom ao restaurante
     * @Parameter: nome Nome do garçom
     * @Parameter: email Email do garçom
     * @Parameter: registroGarcom Registro identificador do garçom
     * @Parameter: salarioBaseGarcom Salário base do garçom
     * @Parameter: gorjetaGarcom Gorjeta recebida pelo garçom
     */
    public void adicionarGarcom(String nome, String email, String registroGarcom, double salarioBaseGarcom){
        Garcom garcom = new Garcom(nome, email, registroGarcom,salarioBaseGarcom, output);
        this.garcoms.add(garcom);
    }
    
    /**
     * @Brief: Adiciona um novo item ao menu do restaurante
     * @Parameter: nomeItem Nome do item
     * @Parameter: descricaoItem Descrição do item
     * @Parameter: preco Preço do item
     */
    public void adicionarItemMenu(String nomeItem, String descricaoItem, double preco){
        ItemMenu item = new ItemMenu(nomeItem, descricaoItem, preco);
        menu.adicionarItem(item);
    }
    
    /**
     * @Brief: Remove um item do menu do restaurante
     * @Parameter: nomeItem Nome do item
     * @Parameter: preco Preço do item
     */
    public void removerItemMenu(String nomeItem, double preco){
        menu.removerItem(nomeItem, preco);
    }
        
    /**
     * @Brief: Altera o preço de um item do menu do restaurante
     * @Parameter: nomeItem Nome do item
     * @Parameter: descricaoItem Descrição do item
     * @Parameter: preco Novo preço do item
     */
    public void alterarPrecoItemMenu(String nomeItem, String descricaoItem, double preco){
        ItemMenu itemAtualizado = new ItemMenu(nomeItem, descricaoItem, preco);
        menu.atualizarItem(itemAtualizado);
    }
    
    public void exibirMenu(){
        menu.exibirMenu();
    }
        
    /**
     * @Brief: Adiciona um pedido a uma mesa
     * @Parameter: numeroMesa Número identificador da mesa
     */
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
     * @Brief: Realiza o pagamento de um pedido para uma mesa
     * @Parameter: numeroMesa Número identificador da mesa
     */
    public void pagar(String numeroMesa){
        Mesa mesa = reserva.getMesa(numeroMesa);
        Comanda comanda = mesa.getComandaAtiva();
        PagamentoPedido pagamento = new PagamentoPedido(comanda);
        pagamento.realizarPagamento();
    }
    
    /**
     * @Brief: Adiciona um observador a fila
     * @Parameter: observerQueue Observador da fila
     */
    @Override
    public void adicionarObserver(ObserverQueue observerQueue){
        observers.add(observerQueue);
    }
    
    /**
     * @Parameter: observerQueue Observador da fila
     * @Brief: Remove um atendente como observador da fila
     */
    @Override
    public void removerObserver(ObserverQueue observerQueue){
        observers.remove(observerQueue);
    }
    
    /**
     * @Parameter: pessoa Objeto Pessoa adicionado a fila
     * @Brief: Avisa os atendentes sobre uma pessoa na fila
     */
    @Override
    public void notifyObservers(Pessoa pessoa){
        for(ObserverQueue observer : observers){
            observer.update(pessoa);
        }
    }
    
    /**
     * @Brief: Parar o scheduler de adicionar pessoas a fila
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

