/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;
import restaurante.poo.ClienteRestaurante;
import restaurante.poo.Mesa;

/**
 *
 * @author rodri
 */
public class ReservaMesa {
    private int quantidadeAtual, quantidadeMaxima; 
    private Mesa mesas[];
    private Queue<ClienteRestaurante> queue = new LinkedList<>();

    public ReservaMesa() {
        quantidadeAtual = 0;
        quantidadeMaxima = Integer.MAX_VALUE;
        mesas = new Mesa[quantidadeMaxima];
    }
    
    public ReservaMesa(int quantidadeMaxima) {
        quantidadeAtual = 0;
        this.quantidadeMaxima = quantidadeMaxima;
        mesas = new Mesa[quantidadeMaxima];
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
        mesas = new Mesa[quantidadeMaxima];
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }
    
    /*
    @Brief Adiciona uma mesa ao vetor de mesas
    
    @Parameter: int capacidade (Capacidade da mesa)
    @Parameter: String numero (Numero da mesa)
    
    @Return none
    */
    public void adicionarMesa(int capacidade, String numero) {
        if(quantidadeAtual < quantidadeMaxima){
            Mesa mesa = new Mesa(numero, capacidade);
            mesas[quantidadeAtual+1] = mesa;
            quantidadeAtual++;
            return;
        }
        return;
    }
    
    /*
    @Brief Remove uma mesa do vetor de mesas
    
    @Parameter: String numero (Numero da mesa)
    
    @Return none
    */
    public void removerMesa(String numero) {
        for(int i = 0; i < quantidadeAtual; i++){
            if(mesas[i].getNumeroMesa().equals(numero)){
                for(int j = i; j < quantidadeAtual; j++){
                    mesas[j] = mesas[j+1];
                }
                quantidadeAtual--;
                return;
            }
        }
        return;
    }
    
    /*
    @Brief: Verificar disponibilidade de uma mesa se utilizando do método verificarDisponibilidadeDataHorarioNome(LocalDate data, LocalTime hora, String nomeCliente) e getCapacidadeMaxima() da classe Mesa
    
    @Parameter: int capacidade (Capacidade da mesa)
    @Parameter: LocalDate data (Data para verificação)
    @Parameter: LocalTime hora (Horário inicial para verificação)
    
    @Return Mesa
    */
    //Chamador metodos de verificacao de disponibilidade da classe Mesa
    public Mesa verificarDisponibilidade(int capacidade, LocalDate data, LocalTime hora) {
        for(int i = 0; i < quantidadeMaxima; i++){
            if(mesas[i].verificarDisponibilidadeDataHorarioNome(data, hora, null) && mesas[i].getCapacidadeMaxima() >= capacidade){
                return mesas[i];
            }
        }
        return null;
    }
    
    /*
    @Brief: Verificar reserva de uma mesa se utilizando do método verificarDisponibilidadeDataHorarioNome(LocalDate data, LocalTime hora, String nomeCliente) e getCapacidadeMaxima() da classe Mesa
    
    @Parameter: int capacidade (Capacidade da mesa)
    @Parameter: LocalDate data (Data para verificação)
    @Parameter: LocalTime hora (Horário inicial para verificação)
    @Parameter: String nome (Nome do cliente)
    
    @Return Mesa
    */
    public Mesa verificarReserva(int capacidade, LocalDate data, LocalTime hora, String nome){
        for(int i = 0; i < quantidadeMaxima; i++){
            if(mesas[i].verificarDisponibilidadeDataHorarioNome(data, hora, nome) == false && mesas[i].getCapacidadeMaxima() >= capacidade){
                return mesas[i];
            }
        }
        return null;
    }
    
    /*
    @Brief: Se utilizar do método verificarDisponibilidade(int capacidade, LocalDate data, LocalTime hora) para encontrar uma mesa e depois do método adicionarReserva(LocalDate data, LocalDate hora, String nome) da classe Mesa para criar uma reserva
    
    @Parameter: LocalDate data (Data para reserva)
    @Parameter: LocalTime hora (Horario Inicial para reserva)
    @Parameter: String nome (Nome do cliente)
    @Parameter: int quantidadePessoas (Quantidade de pessoas na mesa)
    
    @Return none
    */
    public void reservarMesa(LocalDate data, LocalTime hora, String nome, int quantidadePessoas) {
        Mesa mesa = verificarDisponibilidade(quantidadePessoas, data, hora);
        if(mesa != null){
            mesa.adicionarReserva(data, hora, nome);
        }
    }
    
    /*
    @Brief: Se utilizar do método verificarReserva(int capacidade, LocalDate data, LocalTime hora, String nome) para encontrar uma mesa e depois do método cancelarReserva(LocalDate data, LocalDate hora, String nome) da classe Mesa para remover uma reserva
    
    @Parameter: LocalDate data (Data para reserva)
    @Parameter: LocalTime hora (Horario Inicial para reserva)
    @Parameter: String nome (Nome do cliente)
    @Parameter: int quantidadePessoas (Quantidade de pessoas na mesa)
    
    @Return none
    */
    public void cancelarReserva(LocalDate data, LocalTime hora, String nome, int quantidadePessoas) {
        Mesa mesa = verificarReserva(quantidadePessoas, data, hora, nome);
        if(mesa != null){
            mesa.cancelarReserva(data, hora, nome);
        }
    }
    
}
