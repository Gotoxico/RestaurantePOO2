/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Output;

import restaurante.poo.Output.OutputConsole;

/**
 *
 * @author rodri
 */
public class OutputFactory {
    public static OutputInterface getTipoOutput(String tipoOutput){
        if(tipoOutput.equals("console")){
            return new OutputConsole();
        }
        return null;
    }
}
