/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import Controlador.Restaurante;
import UISegregation.Editor;
import java.util.Scanner;
import principal.Principal;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 *
 * @author rodri
 */
public class Atendente extends Funcionario implements ObserverQueue, Editor{
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
     * @param pessoa 
     * 
     * @Brief: Cria um novo cliente quando é notificado de uma pessoa na fila de pessoas do restaurante e adiciona-o ao arraylist de clientes do restaurante
     */
    @Override
    public void update(Pessoa pessoa) {
        ClienteRestaurante cliente = new ClienteRestaurante(pessoa.getNome(), pessoa.getSobrenome(), pessoa.getTelefone());
        restaurante.adicionarCliente(cliente);
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
        output.display("5 - Trocar usuario: ");
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
                    //Sair
            }     
        }
    }
    
}
