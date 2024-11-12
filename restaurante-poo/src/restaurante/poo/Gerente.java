/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import UISegregation.Administrador;
import java.util.Scanner;
import principal.Principal;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 *
 * @author rodri
 */
public class Gerente extends Funcionario implements Administrador{
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
        output.display("1 - Cadastrar Reserva: ");
        output.display("2 - Verificar Disponibilidade: ");
        output.display("3 - Verificar Reserva: ");
        output.display("4 - Cancelar Reserva: ");
        output.display("5 - Cadastrar Mesa: ");
        output.display("6 - Remover Mesa: ");
        output.display("7 - Cadastrar Item Menu: ");
        output.display("8 - Remover Item Menu: ");
        output.display("9 - Trocar Usuario: ");
        int opc = sc.nextInt();
        while (true){
            switch (opc){
                case 1:
                    principal.cadastrarReserva();
                    break;
                    
                case 2:
                    principal.verificarDisponibilidade();
                    break;
                    
                case 3:
                    principal.verificarReserva();
                    break;
                    
                case 4:
                    principal.cancelarReserva();
                    break;
                    
                case 5:
                    principal.cadastrarMesa();
                    break;
                    
                case 6:
                    principal.removerMesa();
                    break;
                    
                case 7:
                    principal.cadastrarItemMenu();
                    break;
                    
                case 8:
                    principal.removerItemMenu();
                    break;
                    
                case 9:
                    //Sair
            }     
        }  
    }
    
    @Override
    public void manejarUsuarios(Principal principal){
        output.display("Digite opcao desejada: ");
        output.display("1 - Cadastrar Garçom: ");
        output.display("2 - Trocar usuario: ");
        int opc = sc.nextInt();
        while (true){
            switch (opc){
                case 1:
                    principal.cadastrarGarcom();
                    break;
                    
                case 2:
                    //Sair
            }     
        }
        
    }
}