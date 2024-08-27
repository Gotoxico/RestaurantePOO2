/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Restaurante;

import Restaurante.Mesa;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author rodri
 */
public class ReservaMesa {
    private int quantidadeAtual, quantidadeMaxima; 
    Mesa mesas[];

    public ReservaMesa() {
        quantidadeAtual = 0;
        quantidadeMaxima = Integer.MAX_VALUE;
        mesas = new Mesa[quantidadeMAxima];
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
    
    public void adicionarMesa(int capacidade, int numero) {
        if(quantidadeAtual < quantidadeMaxima){
            Mesa mesa = new Mesa(capacidade, numero);
            mesas[quantidadeAtual+1] = mesa;
            quantidadeAtual++;
            return;
        }
        return;
    }
   
    public mesa[] verificarDisponibilidade(int capacidade, LocalDate data, LocalTime hora) {
        for(int i = 0; i < quantidadeMaxima; i++){
            if(mesas[i].verificarDisponibilidadeDataHorario(data, hora) && mesas[i].getCapacidade >= capacidade){
                return mesas[i];
            }
        }
        return null;
    }
    
    public void reservarMesa(LocalDate data, LocalTime hora, int quantidadePessoas) {
        if(verificarDisponibilidade(quantidadePessoas, data, hora) != null){
            Mesa mesa = verificarDisponibilidade(quantidadePessoas, data, hora);
            mesa.reservar(data, hora);
        }
    }
}
