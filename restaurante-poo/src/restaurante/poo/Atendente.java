/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import Controlador.Restaurante;
import java.util.Scanner;
import principal.Principal2;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 *
 * @author rodri
 */
public class Atendente extends Funcionario implements ObserverQueue{
    Restaurante restaurante;
    private final OutputInterface output;
    private static Scanner sc = new Scanner(System.in);   
    
    public Atendente(double salario, String nome, String email, Restaurante restaurante, OutputInterface outputInterface) {
        super(salario, nome, email);
        this.restaurante = restaurante;
        this.output = outputInterface;
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
    
    /**
     * 
     * @Parameter pessoa Cliente 
     * 
     * @Brief: Cria um novo cliente quando é notificado de uma pessoa na fila de pessoas do restaurante e adiciona-o ao arraylist de clientes do restaurante
     */
    @Override
    public void update(Pessoa pessoa) {
        ClienteRestaurante cliente = new ClienteRestaurante(pessoa.getNome(), pessoa.getSobrenome(), pessoa.getTelefone());
        restaurante.adicionarCliente(cliente);
    }
}
