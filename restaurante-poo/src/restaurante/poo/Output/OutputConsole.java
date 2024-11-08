/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Output;

/**
 * A classe OutputConsole implementa a interface OutputInterface para exibir mensagens no console
 * 
 * @author rodri
 */
public class OutputConsole implements OutputInterface{
    /**
     * @Brief: Exibe uma mensagem no console
     * 
     * @Parameter: message a mensagem que sera exibida
     */
    @Override
    public void display(String message){
        System.out.println(message);
    }
}
