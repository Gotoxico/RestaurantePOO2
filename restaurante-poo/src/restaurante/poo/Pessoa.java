/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

/**
 *
 * @author rodri
 */
public class Pessoa {
    private String nome, sobrenome, telefone;
    
    /**
     * 
     * @param nome
     * @param sobrenome
     * @param telefone 
     */
    public Pessoa() {
        this.nome = Gerador.geradorAleatorioNome();
        this.sobrenome = Gerador.geradorAleatorioSobrenomes();
        this.telefone = Gerador.geradorAleatorioTelefone();
    }
    
    /**
     * 
     * @return 
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * 
     * @return 
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * 
     * @return 
     */
    public String getTelefone() {
        return telefone;
    }
    
}
