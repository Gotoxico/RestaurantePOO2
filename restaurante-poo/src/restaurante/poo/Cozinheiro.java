/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

/**
 *
 * @author rodri
 */
public class Cozinheiro extends Funcionario{
    private String Funcao;
    
    /**
     * 
     * @param Funcao
     * @param salario
     * @param nome
     * @param email 
     */
    public Cozinheiro(String Funcao, double salario, String nome, String email) {
        super(salario, nome, email);
        this.Funcao = Funcao;
    }

    /**
     * 
     * @return: Função do Cozinheiro
     */
    public String getFuncao() {
        return Funcao;
    }
    
    /**
     * 
     * @param Funcao 
     */
    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
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
    
}
