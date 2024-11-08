/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Output;

import restaurante.poo.Output.OutputConsole;

/**
 * A classe OutputFactory é uma fábrica para criar instâncias de diferentes tipos de saida
 * 
 * Utiliza o padrão Singleton para garantir que apenas uma instância da fábrica seja criada
 * 
 * @author rodri
 */
public class OutputFactory {
    private static OutputFactory instance;
    
    private OutputFactory(){
        
    }
    
    /**
     * @Brief: Retorna a instância única de OutputFactory
     * 
     * @Return: A instância única de OutputFactory
     */
    public static OutputFactory getInstance(){
        if(instance == null){
            instance = new OutputFactory();
        }
        return instance;
    }
    
    /**
     * @Brief: Retorna uma instância de OutputInterface com base no tipo de saida especificado
     * 
     * @Parameter: tipoOutput o tipo de saída desejado
     * @Return: Uma instância de OutputInterface correspondente ao tipo especificado ou null se o tipo não for suportado
     */
    public static OutputInterface getTipoOutput(String tipoOutput){
        if(tipoOutput.equals("console")){
            return new OutputConsole();
        }
        return null;
    }
}
