/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.util.Random;

/**
 *
 * @author rodri
 */
public class Gerador {
    private static final String[] nomes = {
        "Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena", "Igor", "Juliana", "Lucas", "Mariana", "Nicolas", "Patricia", "Rafael", "Sofia", "Tiago", "Vanessa", "Wesley", "Yara"
    };
    
    private static final String[] sobrenomes = {
        "Silva", "Santos", "Oliveira", "Souze", "Pereira", "Lima", "Carvalho", "Costa", "Ferreira", "Almeida", "Ribeiro", "Martins", "Barbosa", "Rocha", "Mendes", "Gomes", "Nunes", "Teixeira", "Araujo", "Cardoso"
    };
    
    /**
     * @Brief: Escolhedor aleatorio de nomes num vetor
     * @return: Nome
     */
    public static String geradorAleatorioNome(){
        Random random = new Random();
        return nomes[random.nextInt(nomes.length)];
    }
    
    /**
     * @Brief: Escolhedor aleatorio de sobrenomes num vetor
     * @return: Sobrenome
     */
    public static String geradorAleatorioSobrenomes(){
        Random random = new Random();
        return sobrenomes[random.nextInt(sobrenomes.length)];
    }
    
    /**
     * @Brief: Gera aleatoriamente um numero de telefone
     * @return: Numero telefone
     */
    public static String geradorAleatorioTelefone(){
        Random random = new Random();
        int codigoArea = 10 + random.nextInt(90);
        int primeiroDigito = 9;
        int restoDigitos = 10000000 + random.nextInt(90000000);
        return String.format("%02d%d%08d", codigoArea, primeiroDigito, restoDigitos);
    }
}
