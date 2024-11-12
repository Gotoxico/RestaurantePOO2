/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import restaurante.poo.Reserva.Horario;
import restaurante.poo.Reserva.Reserva;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import restaurante.poo.Observador.Subject;
import restaurante.poo.Output.OutputConsole;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 * Classe que representa uma mesa do restaurante
 * Contém atributos e métodos para gerenciar reservas, disponibilidade e ocupação
 * 
 * @author renna
 */
public class Mesa extends Subject{
    private final OutputInterface output;
    private String numeroMesa;                         
    private int capacidadeMaxima;
    private Boolean disponibilidadeFlag;
    private List<Reserva> reservasMarcadas;
    private List<Garcom> garcomResponsavel;               //implementar List
    private ClienteRestaurante clienteResponsavel;
    private Comanda comandaAtiva;
    private boolean chamadaGarcom;
    
    
    /**
     * Construtor padrão da classe Mesa, inicializando com valores padrão
     */
    public Mesa() {                             
        this.output = OutputFactory.getInstance().getTipoOutput(null);
        this.numeroMesa = "Indefinido";
        this.capacidadeMaxima = 0;
        this.disponibilidadeFlag = true; 
        this.reservasMarcadas = new ArrayList<>();
        this.garcomResponsavel = null;
        this.clienteResponsavel = null;     
        this.chamadaGarcom = false;
    }
    
    /**
     * Construtor da classe Mesa com parâmetros
     * 
     * @param tipoOutput Tipo de saída utilizada
     * @param numeroMesa Número identificador da mesa
     * @param capacidadeMaxima Capacidade máxima de pessoas na mesa
     */
    public Mesa(String tipoOutput, String numeroMesa, int capacidadeMaxima) {  
        this.output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
        this.numeroMesa = numeroMesa;
        this.capacidadeMaxima = capacidadeMaxima;       
        this.disponibilidadeFlag = true;               
        this.reservasMarcadas = new ArrayList<>();      
        this.garcomResponsavel = null;                  
        this.clienteResponsavel = null;     
    }
    
    
    /**
     * Verifica se a mesa está disponível para uma data, horário e cliente específicos
     * 
     * @param data Data da reserva
     * @param horario Horário da reserva
     * @param nomeCliente Nome do cliente para a reserva
     * @return true se a mesa estiver disponível, false caso contrário
     * 
     */
    public boolean verificarDisponibilidadeDataHorarioNome(LocalDate data, LocalTime horario, String nomeCliente) {         
        for (Reserva reservaData : reservasMarcadas) {
            if (reservaData.getData().equals(data)) {
                for (Horario horarioReserva : reservaData.getHorarios()) {
                    if (horarioReserva.getHorario().equals(horario) && horarioReserva.isDisponibilidade()) {
                        if (nomeCliente == null && horarioReserva.getNome() != null ||       
                            nomeCliente != null && !nomeCliente.equals(horarioReserva.getNome())) {  
                            return false;
                        }
                    }
                }
            }
        }
        return true; 
    }

    /**
     * Ocupa a mesa para um cliente específico em uma data e horário
     * 
     * @param cliente Cliente que ocupará a mesa
     * @param data Data de ocupação
     * @param horario Horário de ocupação
     * @return true se a ocupação for bem-sucedida, false caso contrário
     */
    public boolean ocuparMesa(ClienteRestaurante cliente, LocalDate data, LocalTime horario) {
        String nomeCliente = cliente.getNomeCliente();
        if (!verificarDisponibilidadeDataHorarioNome(data, horario, nomeCliente)) {
            output.display("A mesa " + numeroMesa + " está reservada para esse horário.");  
            return false;
        }
        if (!disponibilidadeFlag) {
            output.display("A mesa " + numeroMesa + " já está ocupada.");   
            return false;
        }
        this.clienteResponsavel = cliente;      
        this.disponibilidadeFlag = false;       
        output.display("A mesa " + numeroMesa + " foi ocupada com sucesso por " + cliente.getNomeCliente() + " em " + data + " às " + horario);
        return true;
    }
    
    /**
     * Libera a mesa novamente para ocupação.
     * É chamada externamente pelo garçom após update
     */
    public void liberarMesa() {         
        this.disponibilidadeFlag = true;
        this.clienteResponsavel = null;         
        if (output instanceof OutputConsole) {
            output.display("A mesa " + numeroMesa + " foi liberada para uso.");
        }
       
    }
    
    
    /**
     * Adiciona uma reserva à mesa
     * 
     * @param data Data da reserva
     * @param horarioReserva Horário da reserva
     * @param nomeCliente Nome do cliente que fez a reserva
     */
    public void adicionarReserva(LocalDate data, LocalTime horarioReserva, String nomeCliente) {
        Reserva reserva = new Reserva(data, Constantes.HORARIO_INICIO, Constantes.HORARIO_TERMINO); 
        reserva.inserirReserva(nomeCliente, horarioReserva);     
        
        if (this.verificarDisponibilidadeDataHorarioNome(data, horarioReserva, nomeCliente)) {  
            reservasMarcadas.add(reserva);  
            output.display("Reserva adicionada para a mesa " + numeroMesa + " em " + reserva.getData());
        } else {
            output.display("Mesa não está disponível para reservar.");
        }
    }
    
    /**
     * Cancela uma reserva específica da mesa
     * 
     * @param data Data da reserva
     * @param hora Horário da reserva
     * @param nomeCliente Nome do cliente da reserva
     */
    public void cancelarReserva(LocalDate data, LocalTime hora, String nomeCliente) { 
        for (Reserva reservaData : reservasMarcadas) {  
            if (reservaData.getData().equals(data)) {
                for (Horario horarioReserva : reservaData.getHorarios()) {  
                    if (horarioReserva.getHorario().equals(hora) && !horarioReserva.isDisponibilidade() &&
                            horarioReserva.getNome().equals(nomeCliente)) {   
                        reservaData.cancelarReserva(nomeCliente, hora);          
                    }
                }
            }
        }
    }
    
    // Getters e Setters

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public Boolean getDisponibilidadeFlag() {
        return disponibilidadeFlag;
    }

    
    public ClienteRestaurante getClienteResponsavel() {
        return clienteResponsavel;
    }

    public Comanda getComandaAtiva() {
        return comandaAtiva;
    }

    public void setComandaAtiva(Comanda comandaAtiva) {
        this.comandaAtiva = comandaAtiva;
        this.disponibilidadeFlag = (comandaAtiva == null);
    }

    public List<Reserva> getReservasMarcadas() {
        return reservasMarcadas;
    }
    
    
    // A PARTIR DAQUI IMPLEMENTAÇÕES NOVAS
    public List getGarcomResponsavel() {
        return garcomResponsavel;
    }
    
     /**
     * Remove um garçom da lista de garçons responsáveis pela mesa.
     * 
     * @param registroGarcom Registro do garçom a ser removido.
     */
    public void removerGarcom(String registroGarcom){
        for( Garcom i : garcomResponsavel){
            if(i.getRegistroGarcom().equals(registroGarcom)){
                super.removeObserver(i);
                output.display("Garçom com registro " + registroGarcom + " removido com sucesso.");
            return;  
            }
        }
        output.display("Garçom com registro " + registroGarcom + " não encontrado.");
    }
    
    /**
     * Notifica os garçons responsáveis pela mesa. Usado para fechar comanda e liberar a mesa
     */                         
    public void chamarGarcom(){
        chamadaGarcom = true;
        super.notifyObserver();
    }
    
    /**
     * Adiciona um garçom à lista de garçons responsáveis pela comanda.
     * 
     * @param garcomResponsavel O garçom a ser adicionado à lista.
     */
    public void addGarcom(Garcom garcomResponsavel) {
        super.addObserver(garcomResponsavel);
    }
    
    
    /**
     * Abre uma nova comanda para a mesa, se ainda não estiver aberta.
     * 
     * @return Comanda aberta.
     */
    private Comanda abrirComanda(){
        if(comandaAtiva == null){
            this.comandaAtiva = new Comanda(this);
        }       
        return comandaAtiva;
    }
    
    /**
     * Fecha a comanda, método usado externamente pelo garçom.
     * Acessa método interno da comanda
     */
    public void fecharComanda(){
        if(comandaAtiva != null){
            comandaAtiva.fecharComanda();
        }       
    }
    
    /**
     * Método para adcionar itens do menu na comanda da mesa
     * @param: item (itemMenu), item para adcionar na comanda.
     */
    public void fazerPedido(ItemMenu item){
        Comanda c = abrirComanda();                        
        c.adicionarItem(item);
    }
    
}
