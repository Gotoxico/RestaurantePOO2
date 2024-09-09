/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

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
        quantidadeMaxima = quantidadeMaxima;
        mesas = new Mesa[quantidadeMaxima];
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        quantidadeMaxima = quantidadeMaxima;
        mesas = new Mesa[quantidadeMaxima];
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }
    
    public void adicionarMesa(int capacidade, String numero) {
        if(quantidadeAtual < quantidadeMaxima){
            Mesa mesa = new Mesa(numero, capacidade);
            mesas[quantidadeAtual+1] = mesa;
            quantidadeAtual++;
            return;
        }
        return;
    }
   
    //Chamador metodos de verificacao de disponibilidade da classe Mesa
    public Mesa verificarDisponibilidade(int capacidade, LocalDate data, LocalTime hora) {
        for(int i = 0; i < quantidadeMaxima; i++){
            if(mesas[i].verificarDisponibilidadeDataHorario(data, hora) && mesas[i].getCapacidadeMaxima() >= capacidade){
    
                return mesas[i];
            }
        }
        return null;
    }
    
    //Chamador metodos de verificacao de reservas da classe Mesa
    public Mesa verificarReserva(int capacidade, LocalDate data, LocalTime hora) {
        for(int i = 0; i < quantidadeMaxima; i++){
            if(mesas[i].verificarDisponibilidadeDataHorario(data, hora) && mesas[i].getCapacidadeMaxima() >= capacidade){
                return mesas[i];
            }
        }
        return null;
    }
    
    //Chamador metodos para reservar mesa da classe Mesa
    public void reservarMesa(LocalDate data, LocalTime hora, int quantidadePessoas) {
        if(verificarDisponibilidade(quantidadePessoas, data, hora) != null){
            Mesa mesa = verificarDisponibilidade(quantidadePessoas, data, hora);
            mesa.adicionarReserva(data, hora);
        }
    }
    
    //Chamador metodos para cancelar mesa da classe Mesa
    public void cancelarReserva(LocalDate data, LocalTime hora, int quantidadePessoas) {
        if(verificarReserva(quantidadePessoas, data, hora) != null){
            Mesa mesa = verificarReserva(quantidadeAtual, data, hora);
            mesa.cancelarReserva(data, hora);
        }
    }
    
}
