/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Output;

/**
 *
 * @author rodri
 */
public class OutputConsole implements OutputInterface{
    @Override
    public void display(String message){
        System.out.println(message);
    }
}
