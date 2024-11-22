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
public class Cozinheiro extends Funcionario{
    private String Funcao;
    private final OutputInterface output;
    private static Scanner sc = new Scanner(System.in);    
    
    /**
     * @Brief: Construtor da classe Cozinheiro
     * 
     * @Parameter: Funcao Função desempenhada pelo cozinheiro
     * @Parameter: salario Salário do cozinheiro
     * @Parameter: nome Nome do cozinheiro
     * @Parameter: email Email do cozinheiro
     * @Parameter: outputInterface Interface de saída utilizada
     * @Parameter: tipoOutput Tipo de saída definida
     */
    public Cozinheiro(String Funcao, double salario, String nome, String email, OutputInterface outputInterface, String tipoOutput) {
        super(salario, nome, email);
        this.Funcao = Funcao;
        this.output = outputInterface;
    }

    /**
     * @Brief: Retorna a função do cozinheiro
     * @Return: String representando a função do cozinheiro
     */
    public String getFuncao() {
        return Funcao;
    }
    
    /**
     * @Brief: Define a função do cozinheiro
     * @Parameter: Funcao Nova função a ser atribuída ao cozinheiro
     */
    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }
    
    @Override
     /**
     * @Brief: Calcula os descontos de previdência
     * @Return: Valor do desconto de previdência
     */
    double calcDescontosPrevidencia(){
        return (this.salario/100) * 7.5;
    }
    
    /**
     * @Brief: Calcula os descontos do plano de saúde
     * @Return: Valor do desconto
     */
    @Override
    double calcDescontosPlanoSaude(){
        return (this.salario/100) * 0;
    }
    
    /**
     * @Brief: Calcula outros descontos
     * @Return: Valor do desconto
     */
    @Override
    double calcOutrosDescontos(){
        return (this.salario/100) * 10;
    }
    
}
