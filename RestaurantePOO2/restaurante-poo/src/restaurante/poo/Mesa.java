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
import restaurante.poo.Output.OutputConsole;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 * Classe que representa uma mesa do restaurante
 * Contém atributos e métodos para gerenciar reservas, disponibilidade e ocupação
 * 
 * @author renna
 */
public class Mesa {
    private final OutputInterface output;
    private String numeroMesa;                         
    private int capacidadeMaxima;
    private Boolean disponibilidadeFlag;
    private List<Reserva> reservasMarcadas;
    private Garcom garcomResponsavel;
    private ClienteRestaurante clienteResponsavel;
    private Pedido pedido;
    
    /**
     * @Brief: construtor padrão da classe Mesa, inicializando com valores padrão
     */
    public Mesa() {                             
        this.output = OutputFactory.getInstance().getTipoOutput(null);
        this.numeroMesa = "Indefinido";
        this.capacidadeMaxima = 0;
        this.disponibilidadeFlag = true; 
        this.reservasMarcadas = new ArrayList<>();
        this.garcomResponsavel = null;
        this.clienteResponsavel = null;
        this.pedido = null;
    }
    
    /**
     * @Brief: Construtor da classe Mesa com parâmetros
     * 
     * @Parameter: tipoOutput Tipo de saida utilizada
     * @Parameter: numeroMesa Número identificador da mesa
     * @Parameter: capacidadeMaxima capacidade máxima de pessoas na mesa
     */
    public Mesa(String tipoOutput, String numeroMesa, int capacidadeMaxima) {  
        this.output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
        this.numeroMesa = numeroMesa;
        this.capacidadeMaxima = capacidadeMaxima;       
        this.disponibilidadeFlag = true;               
        this.reservasMarcadas = new ArrayList<>();      
        this.garcomResponsavel = null;                  
        this.clienteResponsavel = null;
        this.pedido = null;
    }

    /**
     * @Brief: verifica se a mesa está disponível para uma data, horário e cliente específicos
     * 
     * @Parameter: data Data da reserva
     * @Parameter: horario Horário da reserva
     * @Parameter: nomeCliente nome do cliente para a reserva
     * @Return: true se a mesa estiver disponível, false caso contrário
     */
    public boolean verificarDisponibilidadeDataHorarioNome(LocalDate data, LocalTime horario, String nomeCliente) {         
        for (Reserva reservaData : reservasMarcadas) {
            if (reservaData.getData().equals(data)) {
                for (Horario horarioReserva : reservaData.getHorarios()) {
                    if (horarioReserva.getHorario().equals(horario) && horarioReserva.isDisponibilidade()){
                        if(nomeCliente == null && horarioReserva.getNome() != null ||       
                            nomeCliente != null && !nomeCliente.equals(horarioReserva.getNome())){  
                            return false;
                        }
                    }
                }
            }
        }
        return true; 
    }

    /**
     * @Brief: ocupa a mesa para um cliente específico em uma data e horário
     * 
     * @Parameter: cliente Cliente que ocupará a mesa
     * @Parameter: data Data de ocupação
     * @Parameter: horario Horário de ocupação
     * @Return: true se a ocupação for bem sucedida, false caso contrário
     */
    public boolean ocuparMesa(ClienteRestaurante cliente, LocalDate data, LocalTime horario) {
        String nomeCliente = cliente.getNomeCliente();
        if (!verificarDisponibilidadeDataHorarioNome(data, horario,nomeCliente)) {
            output.display("A mesa " + numeroMesa + " está reservada para esse horário.");  
            return false;
        }
        if (!disponibilidadeFlag) {
            output.display("A mesa " + numeroMesa + " já está ocupada.");   
            return false;
        }
        this.clienteResponsavel = cliente;      
        this.disponibilidadeFlag = false;       
        output.display("A mesa "+numeroMesa+" foi ocupada com sucesso por "+cliente.getNomeCliente()+" em "+data+" às" + horario);
        return true;
    }
    
    /**
     * @Brief: libera a mesa novamente para ocupação
     */
    public void liberarMesa() {         
        this.disponibilidadeFlag = true;
        this.clienteResponsavel = null;
        this.pedido = null;
        if(output instanceof OutputConsole){
            output.display("A mesa " + numeroMesa + " foi liberada para uso.");
        }
    }
    
    /**
     * @Brief: Adiciona uma reserva a mesa
     * 
     * @Parameter: data Data da reserva
     * @Parameter: horarioReserva horario da reserva
     * @Parameter: nomeCliente Nome do cliente que fez a reserva
     */
    public void adicionarReserva(LocalDate data,LocalTime horarioReserva, String nomeCliente) {
        Reserva reserva = new Reserva(data,Constantes.HORARIO_INICIO, Constantes.HORARIO_TERMINO); 
        reserva.inserirReserva(nomeCliente, horarioReserva);     
        
        if(this.verificarDisponibilidadeDataHorarioNome(data, horarioReserva, nomeCliente)== true){  
            reservasMarcadas.add(reserva);  
            output.display("Reserva adicionada para a mesa " + numeroMesa + " em " + reserva.getData());
        }else{
            output.display("Mesa não está disponível para reservar");
        }
    }
    
    /**
     * @Brief: Cancela uma reserva específica na mesa
     * 
     * @Parameter: data Data da reserva a ser cancelada.
     * @Parameter: hora Horário da reserva a ser cancelada.
     * @Parameter: nomeCliente Nome do cliente que fez a reserva.
     */
    public void cancelarReserva(LocalDate data, LocalTime hora, String nomeCliente){    
//    if(this.verificarDisponibilidadeDataHorario(data, hora)== false){
//        output.display("Reserva não encontrada");
//        return;
//    }
        for (Reserva reservaData : reservasMarcadas) {  
            if (reservaData.getData().equals(data)) {
                for (Horario horarioReserva : reservaData.getHorarios()) {  
                    if (horarioReserva.getHorario().equals(hora) && !horarioReserva.isDisponibilidade() &&
                            horarioReserva.getNome().equals(nomeCliente)) {   
                        reservaData.cancelarReserva(nomeCliente,hora);             
                    }
                }
            }
        }
    }
    
    /**
     * @Brief: Obtém o número da mesa
     * 
     * @Return: Numero da mesa
     */
    public String getNumeroMesa() {
        return numeroMesa;
    }
    
    /**
     * @Brief: define o número da mesa
     * 
     * @Parameter: numeroMesa Novo número da mesa
     */
    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    
    /**
     * @Brief: obtém a capacidade máxima da mesa
     * 
     * @Return: Capacidade máxima da mesa
     */
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
     * @Brief: Define a capacidade máxima da mesa
     * 
     * @Parameter: capacidadeMaxima Nova capacidade máxima da mesa
     */
    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * @Brief: obtém o status de disponibilidade da mesa.
     * 
     * @Return: true se a mesa estiver disponível, false caso contrário
     */
    public Boolean getDisponibilidadeFlag() {
        return disponibilidadeFlag;
    }

    /**
     * @Brief: obtém o garçom responsável pela mesa
     * 
     * @Return: garçom responsável
     */
    public Garcom getGarcomResponsavel() {
        return garcomResponsavel;
    }

    /**
     * @Brief: Define o garçom responsável pela mesa
     * 
     * @Parameter: garcomResponsavel Novo garçom responsável
     */
    public void setGarcomResponsavel(Garcom garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
    }

    /**
     * @Brief: Obtém o cliente atualmente responsável pela mesa
     * 
     * @Return: Cliente responsável
     */
    public ClienteRestaurante getClienteResponsavel() {
        return clienteResponsavel;
    }

    /**
     * @Brief: Obtém o pedido associado à mesa
     * 
     * @Return: Pedido da mesa
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @Brief: Define o pedido associado à mesa
     * 
     * @Parameter: pedido Novo pedido da mesa
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @Brief: Obtém a lista de reservas feitas para a mesa
     * 
     * @Return: lista de reservas
     */
    public List<Reserva> getReservasMarcadas() {
        return reservasMarcadas;
    }

//    public void setReservasMarcadas(List<Reserva> reservasMarcadas) {
//        this.reservasMarcadas = reservasMarcadas;
//    };
    
}
