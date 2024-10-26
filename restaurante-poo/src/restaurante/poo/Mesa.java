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
 *
 * @author renna
 */
public class Mesa {
    private OutputInterface output;
    private String numeroMesa;                         //atributos necessários
    private int capacidadeMaxima;
    private Boolean disponibilidadeFlag;
    private List<Reserva> reservasMarcadas;
    private Garcom garcomResponsavel;
    private ClienteRestaurante clienteResponsavel;
    private Pedido pedido;

    public Mesa() {                             //construtor vazio
        this.output = OutputFactory.getTipoOutput(null);
        this.numeroMesa = "Indefinido";
        this.capacidadeMaxima = 0;
        this.disponibilidadeFlag = true; // Mesa está disponível por padrão
        this.reservasMarcadas = new ArrayList<>();
        this.garcomResponsavel = null;
        this.clienteResponsavel = null;
        this.pedido = null;
    }

    public Mesa(String tipoOutput, String numeroMesa, int capacidadeMaxima) {  //construtor básico
        this.output = OutputFactory.getTipoOutput(tipoOutput);
        this.numeroMesa = numeroMesa;
        this.capacidadeMaxima = capacidadeMaxima;       
        this.disponibilidadeFlag = true;                // Mesa disponível por padrão
        this.reservasMarcadas = new ArrayList<>();      
        this.garcomResponsavel = null;                  //Passar demais atributos por meio de métodos
        this.clienteResponsavel = null;
        this.pedido = null;
    }


    public boolean verificarDisponibilidadeDataHorarioNome(LocalDate data, LocalTime horario, String nomeCliente) {        //verifica a disponibilidade da mesa com base nas reservas marcadas da mesa     
        for (Reserva reservaData : reservasMarcadas) {
            if (reservaData.getData().equals(data)) {
                for (Horario horarioReserva : reservaData.getHorarios()) {
                    if (horarioReserva.getHorario().equals(horario) && horarioReserva.isDisponibilidade()){
                        if(nomeCliente == null && horarioReserva.getNome() != null ||       //se o nome passado for nulo, verifica se existe qlqr nome lá
                            nomeCliente != null && !nomeCliente.equals(horarioReserva.getNome())){  //se não for null, verifica se o nome não bate
                            return false;
                        }
                    }
                }
            }
        }
        return true; // Mesa está disponivel
    }


    public boolean ocuparMesa(ClienteRestaurante cliente, LocalDate data, LocalTime horario) {
        String nomeCliente = cliente.getNomeCliente();
        if (!verificarDisponibilidadeDataHorarioNome(data, horario,nomeCliente)) {
            if(output instanceof OutputConsole){
                System.out.println("A mesa " + numeroMesa + " está reservada para esse horário.");  //Se a mesa não está reservada
            }
            return false;
        }
        if (!disponibilidadeFlag) {
            if(output instanceof OutputConsole){
                System.out.println("A mesa " + numeroMesa + " já está ocupada.");   //Se a mesa não está
            } 
            return false;
        }
        this.clienteResponsavel = cliente;      //atribui cliente à mesa
        this.disponibilidadeFlag = false;       //muda status de disponibilidade
        if(output instanceof OutputConsole){
            System.out.println("A mesa "+numeroMesa+" foi ocupada com sucesso por "+cliente.getNomeCliente()+" em "+data+" às" + horario);
        }
        return true;
    }

    public void liberarMesa() {         //função que renova o status da mesa para ocupação
        this.disponibilidadeFlag = true;
        this.clienteResponsavel = null;
        this.pedido = null;
        if(output instanceof OutputConsole){
            System.out.println("A mesa " + numeroMesa + " foi liberada para uso.");
        }
    }

    public void adicionarReserva(LocalDate data,LocalTime horarioReserva, String nomeCliente) {
    //adcionar reserva a lista de reserva da mesa
        Reserva reserva = new Reserva(data,Constantes.HORARIO_INICIO, Constantes.HORARIO_TERMINO); //constantes para horario de funcionamento
        reserva.inserirReserva(nomeCliente, horarioReserva);     //Cria reserva e insere o horario e data
        
        if(this.verificarDisponibilidadeDataHorarioNome(data, horarioReserva, nomeCliente)== true){  //é associado a mesa após verificação
            reservasMarcadas.add(reserva);  //adciona ao array list
            if(output instanceof OutputConsole){
                System.out.println("Reserva adicionada para a mesa " + numeroMesa + " em " + reserva.getData());
            }
        }else{
            if(output instanceof OutputConsole){
                System.out.println("Mesa não está disponível para reservar");
            }
        }
    }
    
    public void cancelarReserva(LocalDate data, LocalTime hora, String nomeCliente){    //ALTERAR E COLOCAR UM REMOVE?
//    if(this.verificarDisponibilidadeDataHorario(data, hora)== false){
//        System.out.println("Reserva não encontrada");
//        return;
//    }
        for (Reserva reservaData : reservasMarcadas) {  //Percorre Array procurando a Data
            if (reservaData.getData().equals(data)) {
                for (Horario horarioReserva : reservaData.getHorarios()) {  //se a data coincidir procura os horarios
                    if (horarioReserva.getHorario().equals(hora) && !horarioReserva.isDisponibilidade() &&
                            horarioReserva.getNome().equals(nomeCliente)) {   //procura o horário correto, verifica a mesa NÃO está livre, verifica o nome
                        reservaData.cancelarReserva(nomeCliente,hora);          //se encontrar cancela através da classe Reserva   
                    }
                }
            }
        }
        //return true; // Mesa está disponivel
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

    public Garcom getGarcomResponsavel() {
        return garcomResponsavel;
    }

    public void setGarcomResponsavel(Garcom garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
    }

    public ClienteRestaurante getClienteResponsavel() {
        return clienteResponsavel;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Reserva> getReservasMarcadas() {
        return reservasMarcadas;
    }

//    public void setReservasMarcadas(List<Reserva> reservasMarcadas) {
//        this.reservasMarcadas = reservasMarcadas;
//    };
    
}
