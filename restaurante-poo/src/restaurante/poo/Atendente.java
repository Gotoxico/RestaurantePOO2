/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import Controlador.Restaurante;

/**
 *
 * @author rodri
 */
public class Atendente extends Funcionario implements ObserverQueue{
    Restaurante restaurante;
    public Atendente(double salario, String nome, String email, Restaurante restaurante) {
        super(salario, nome, email);
        this.restaurante = restaurante;
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
     * @param pessoa 
     * 
     * @Brief: Cria um novo cliente quando é notificado de uma pessoa na fila de pessoas do restaurante e adiciona-o ao arraylist de clientes do restaurante
     */
    @Override
    public void update(Pessoa pessoa) {
        ClienteRestaurante cliente = new ClienteRestaurante(pessoa.getNome(), pessoa.getSobrenome(), pessoa.getTelefone());
        restaurante.adicionarCliente(cliente);
    }
    
}
