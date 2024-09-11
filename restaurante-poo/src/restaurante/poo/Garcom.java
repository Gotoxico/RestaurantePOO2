/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.util.ArrayList;

/**
 *
 * @author juniortraj
 */
public class Garcom extends Usuario { //Herança
    
    private String registroGarcom;
    private double salarioBaseGarcom;
    private double gorjetaGarcom;
    private ArrayList<Mesa> mesasResponsavel;

    //Construtor
    public Garcom(String nome, String email, String registroGarcom, double salarioBaseGarcom, double gorjetaGarcom){
    
        super(nome, email);
        this.registroGarcom = registroGarcom;
        this.salarioBaseGarcom = salarioBaseGarcom;
        this.gorjetaGarcom = gorjetaGarcom;
        this.mesasResponsavel = new ArrayList<>();
    }

    //Métodos getters e setters
    public String getRegistroGarcom() {
        return registroGarcom;
    }

    public void setRegistroGarcom(String registroGarcom) {
        this.registroGarcom = registroGarcom;
    }
    
    public double getSalarioBaseGarcom() {
        return salarioBaseGarcom;
    }

    public void setSalarioBaseGarcom(double salarioBaseGarcom) {
        this.salarioBaseGarcom = salarioBaseGarcom;
    }
    
    public double getGorjetaGarcom() {
        return gorjetaGarcom;
    }

    public void setGorjetaGarcom(double gorjetaGarcom) {
        this.gorjetaGarcom = gorjetaGarcom;
    }
    
    public ArrayList<Mesa> getMesasResposavel(){
        return mesasResponsavel;
    }
    
    public void setMesasResponsavel(ArrayList<Mesa> mesasResponsavel){
        this.mesasResponsavel = mesasResponsavel;
    }

    //Métodos relacionados à mesa
    public void adicionarMesa(Mesa mesa) {
        mesasResponsavel.add(mesa);
    }
    
    public void removerMesa(Mesa mesa) {
        mesasResponsavel.remove(mesa);
    }
    
    //Métodos relacionados à pedidos e salário
    public void registrarPedido(double valorPedido){
        double gorjeta = valorPedido * (10/100);
        gorjetaGarcom += gorjeta;
    }
    
    public double salarioFinalGarcom(){
        return salarioBaseGarcom + gorjetaGarcom;
    }
}
