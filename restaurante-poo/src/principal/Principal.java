/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import Controlador.Restaurante;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 *
 * @author rodri
 */
public class Principal {
    static String tipoOutput = "console";
    static OutputInterface output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
    static Restaurante restaurante = new Restaurante("Restaurante FCT", OutputFactory.getInstance(), tipoOutput, 30, "Menu Normal", "Menu pensado para as operações cotidianas do Restaurante FCT", "11:00 - 14:00 e 17:00 - 22:00");

    /**
     * @param args the command line arguments
     */
    /*
    Implementar menus em métodos para funcionamento da aplicação
    
    Qualquer tipo de output utilizar método output.display()
    */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
