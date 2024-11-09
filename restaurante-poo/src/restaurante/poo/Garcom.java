/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;
import java.util.ArrayList;

import restaurante.poo.Observador.Observer;
import restaurante.poo.Observador.Subject;

/**
 * Classe que representa um garçom no sistema de restaurante
 * Estende a classe Usuario e possui informações específicas como registro, salário, gorjeta e mesas responsáveis
 * 
 * @author juniortraj
 */
public class Garcom extends Usuario implements Observer { //Herança
    
    private String registroGarcom;
    private double salarioBaseGarcom;
    private double gorjetaGarcom;
    private ArrayList<Mesa> mesasResponsavel;

    /**
     * @Brief: Construtor da classe Garcom
     * 
     * @Parameter: nome              Nome do garçom
     * @Parameter: email             E-mail do garçom
     * @Parameter: registroGarcom    Registro do garçom
     * @Parameter: salarioBaseGarcom Salário base do garçom
     * @Parameter: gorjetaGarcom     Valor inicial das gorjetas do garçom
     */
    public Garcom(String nome, String email, String registroGarcom, double salarioBaseGarcom, double gorjetaGarcom){
    
        super(nome, email);
        this.registroGarcom = registroGarcom;
        this.salarioBaseGarcom = salarioBaseGarcom;
        this.gorjetaGarcom = gorjetaGarcom;
        this.mesasResponsavel = new ArrayList<>();
    }

    /**
     * @Brief: Coleta o registro do garçom
     * 
     * @Return: Registro do garçom
     */
    public String getRegistroGarcom() {
        return registroGarcom;
    }
    
    /**
     * @Brief: Cadastra o registro do garçom
     * 
     * @Parameter: registroGarcom Novo registro do garçom.
     */
    public void setRegistroGarcom(String registroGarcom) {
        this.registroGarcom = registroGarcom;
    }
    
    /**
     * @Brief: Coleta o salário base do garçom
     * 
     * @Return: Salário base do garçom
     */
    public double getSalarioBaseGarcom() {
        return salarioBaseGarcom;
    }
    
    /**
     * @Brief: Define o salário base do garçom
     * 
     * @Parameter: salarioBaseGarcom Novo salário base do garçom
     */
    public void setSalarioBaseGarcom(double salarioBaseGarcom) {
        this.salarioBaseGarcom = salarioBaseGarcom;
    }
    
    /**
     * @Brief: Coleta o valor acumulado de gorjetas do garçom
     * 
     * @Return: Valor das gorjetas do garçom
     */
    public double getGorjetaGarcom() {
        return gorjetaGarcom;
    }

    /**
     * @Brief: Define o valor das gorjetas do garçom
     * 
     * @Parameter: gorjetaGarcom Novo valor das gorjetas
     */
    public void setGorjetaGarcom(double gorjetaGarcom) {
        this.gorjetaGarcom = gorjetaGarcom;
    }
    
    /**
     * @Brief: Coleta a lista de mesas pelas quais o garçom é responsável
     * 
     * @Return: lista de mesas sob responsabilidade do garçom
     */
    public ArrayList<Mesa> getMesasResposavel(){
        return mesasResponsavel;
    }
    
    /**
     * @Brief: Define a lista de mesas pelas quais o garçom é responsável
     * 
     * @Parameter: mesasResponsavel Nova lista de mesas sob responsabilidade do garçom
     */
    public void setMesasResponsavel(ArrayList<Mesa> mesasResponsavel){
        this.mesasResponsavel = mesasResponsavel;
    }

    /**
     * @Brief: add uma mesa à lista de mesas sob responsabilidade do garçom
     * 
     * @Parameter: mesa Mesa a ser adicionada.
     */
    public void adicionarMesa(Mesa mesa) {
        mesasResponsavel.add(mesa);
    }
    
    /**
     * @Brief: Remove uma mesa da lista de mesas sob responsabilidade do garçom
     * 
     * @Parameter: mesa Mesa que sera removida
     */
    public void removerMesa(Mesa mesa) {
        mesasResponsavel.remove(mesa);
    }
    
    /**
     * @Brief: Registra um pedido e calcula a gorjeta com base no valor do pedido
     * 
     * @Parameter: valorPedido Valor do pedido
     */
    public void registrarPedido(double valorPedido){
        double gorjeta = valorPedido * (10/100);
        gorjetaGarcom += gorjeta;
    }
    
    /**
     * @Brief: Calcula o salário final do garçom
     * 
     * @Return: Salário final do garçom.
     */
    public double salarioFinalGarcom(){
        return salarioBaseGarcom + gorjetaGarcom;
    }
    
    public void update(Subject s){
        
    }
}
