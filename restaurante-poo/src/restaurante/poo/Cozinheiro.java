/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import UISegregation.Visualizador;
import java.util.Scanner;
import principal.Principal;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 *
 * @author rodri
 */
public class Cozinheiro extends Funcionario implements Visualizador{
    private String Funcao;
    private final OutputInterface output;
    private static Scanner sc = new Scanner(System.in);    
    /**
     * 
     * @param Funcao
     * @param salario
     * @param nome
     * @param email 
     */
    public Cozinheiro(String Funcao, double salario, String nome, String email, OutputInterface outputInterface, String tipoOutput) {
        super(salario, nome, email);
        this.Funcao = Funcao;
        this.output = outputInterface;
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
    
}
