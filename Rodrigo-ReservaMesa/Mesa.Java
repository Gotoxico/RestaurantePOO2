package Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Mesa {                 
    private String numeroMesa;                         //atributos 
    private int capacidadeMaxima;
    private Boolean disponibilidadeFlag;
    private List<Data> reservasMarcadas;
    private Garcom garcomResponsavel;
    private Cliente clienteResponsavel;
    private Pedido pedido;

    public Mesa() {                             //construtor vazio
        this.numeroMesa = "Indefinido";
        this.capacidadeMaxima = 0;
        this.disponibilidadeFlag = true; // Mesa está disponível por padrão
        this.reservasMarcadas = new ArrayList<>();
        this.garcomResponsavel = null;
        this.clienteResponsavel = null;
        this.pedido = null;
    }

    public Mesa(String numeroMesa, int capacidadeMaxima) {  //construtor básico
        this.numeroMesa = numeroMesa;
        this.capacidadeMaxima = capacidadeMaxima;       
        this.disponibilidadeFlag = true;                // Mesa disponível por padrão
        this.reservasMarcadas = new ArrayList<>();      
        this.garcomResponsavel = null;                  //Passar demais atributos por meio de métodos
        this.clienteResponsavel = null;
        this.pedido = null;
    }


    public boolean verificarDisponibilidadeDataHorario(LocalDate data, LocalTime horario) {        //verifica a disponibilidade da mesa com base nas reservas marcadas da mesa
        for (Data reservaData : reservasMarcadas) {
            if (reservaData.getData().equals(data)) {
                for (Horario horarioReserva : reservaData.getHorarios()) {
                    if (horarioReserva.getHorario().equals(horario) && horarioReserva.isDisponibilidade()) {
                        return false;     // Se a mesa estiver reservada
                    }
                }
            }
        }
        return true; // Mesa está disponivel
    }


    public boolean ocuparMesa(Cliente cliente, LocalDate data, LocalTime horario) {
        if (!isDisponivel(data, horario)) {
            System.out.println("A mesa " + numeroMesa + " está reservada para esse horário.");  //Se a mesa não está reservada
            return false;
        }
        if (!disponibilidadeFlag) {
            System.out.println("A mesa " + numeroMesa + " já está ocupada.");   //Se a mesa não está 
            return false;
        }
        this.clienteResponsavel = cliente;      //atribui cliente à mesa
        this.disponibilidadeFlag = false;       //muda status de disponibilidade
        System.out.println("A mesa "+numeroMesa+" foi ocupada com sucesso por "+cliente.getNome()+" em "+data+" às" + horario);
        return true;
    }

    public void liberarMesa() {         //função que renova o status da mesa para ocupação
        this.disponibilidadeFlag = true;
        this.clienteResponsavel = null;
        this.pedido = null;
        System.out.println("A mesa " + numeroMesa + " foi liberada para uso.");
    }

    public void adicionarReserva(LocalDate data, Localtime horario) {        //adcionar reserva a lista de reserva da mesa
        reservasMarcadas.add(reserva);  //adciona ao array list
        System.out.println("Reserva adicionada para a mesa " + numeroMesa + " em " + reserva.getData());
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

    public Cliente getClienteResponsavel() {
        return clienteResponsavel;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Data> getReservasMarcadas() {
        return reservasMarcadas;
    }

    public void setReservasMarcadas(List<Data> reservasMarcadas) {
        this.reservasMarcadas = reservasMarcadas;
    }
}
