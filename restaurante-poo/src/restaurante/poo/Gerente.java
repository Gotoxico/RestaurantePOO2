/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.util.Scanner;
import principal.Principal2;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 *
 * @author rodri
 */
public class Gerente extends Funcionario{
    private final OutputInterface output;
    private static Scanner sc = new Scanner(System.in);   
    
    /**
     * 
     * @param salario
     * @param nome
     * @param email 
     */
    public Gerente(double salario, String nome, String email, OutputInterface outputInterface) {
        super(salario, nome, email);
        this.output = outputInterface;
    }
    
    @Override
    /**
     * @Brief: Reimplementa método abstrato da classe abstrata Funcionario
     * 
     * @Return: Valor do desconto
     */
    double calcDescontosPrevidencia(){
        return (this.salario/100) * 12;
    }
    
    /**
     * @Brief: Reimplementa método abstrato da classe abstrata Funcionario
     * 
     * @Return: Valor do desconto
     */
    @Override
    double calcDescontosPlanoSaude(){
        return (this.salario/100) * 10;
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
    
}
