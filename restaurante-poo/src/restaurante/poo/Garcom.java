/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import UISegregation.Editor;
import java.util.ArrayList;
import java.util.Scanner;
import principal.Principal;
import restaurante.poo.Observador.Observer;
import restaurante.poo.Observador.Subject;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;


/**
 *
 * @author rodri
 */
public class Garcom extends Funcionario implements Observer, Editor{
    private String registroGarcom;
    private double gorjetaGarcom;
    private ArrayList<Mesa> mesasResponsavel;
    private final OutputInterface output;
    private static Scanner sc = new Scanner(System.in);    
    
    /**
     * @Brief: Construtor da classe Garcom
     * 
     * @Parameter: nome              Nome do garçom
     * @Parameter: email             E-mail do garçom
     * @Parameter: registroGarcom    Registro do garçom
     * @Parameter: salarioBaseGarcom Salário base do garçom
     * @Parameter: gorjetaGarcom     Valor inicial das gorjetas do garçom
     */
    public Garcom(String nome, String email, String registroGarcom, double salario, double gorjetaGarcom, OutputInterface outputInterface){
        super(salario, nome, email);
        this.output = outputInterface;        
        this.registroGarcom = registroGarcom;
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
        return salario + gorjetaGarcom;
    }
    
    @Override
    /**
     * @Brief: Reimplementa método abstrato da classe abstrata Funcionario
     * 
     * @Return: Valor do desconto
     */
    double calcDescontosPrevidencia(){
        return (this.salario/100) * 7.5;
    }
    
    /**
     * @Brief: Reimplementa método abstrato da classe abstrata Funcionario
     * 
     * @Return: Valor do desconto
     */
    @Override
    double calcDescontosPlanoSaude(){
        return (this.salario/100) * 0;
    }
    
    /**
     * @Brief: Reimplementa método abstrato da classe abstrata Funcionario
     * 
     * @Return: Valor do desconto
     */
    @Override
    double calcOutrosDescontos(){
        return (this.salario/100) * 10;
    }
    
    public void update(Subject s){  //Fechar Comanda + liberar mesa()
        if( s instanceof Mesa){
            Mesa mesa =  (Mesa) s;
            mesa.fecharComanda();
            mesa.liberarMesa();                       
        }
    }
    
    @Override
    public void visualizarConteudo(Principal principal){
        output.display("Digite opcao desejada: ");
        output.display("1 - Imprimir Menu: ");
        output.display("2 - Trocar usuario: ");
        int opc = sc.nextInt();
        while (true){
            switch (opc){
                case 1:
                    principal.imprimirMenu();
                    break;
                    
                case 2:
                    //Sair
            }     
        }
    }
    
    @Override
    public void editarConteudo(Principal principal){
        output.display("Digite opcao desejada: ");
        output.display("1 - Cadastrar Pedido: ");
        output.display("2 - Trocar usuario: ");
        int opc = sc.nextInt();
        while (true){
            switch (opc){
                case 1:
                    principal.cadastrarPedido();
                    break;
                    
                case 2:
                    //Sair
            }     
        }
    }
    
}
