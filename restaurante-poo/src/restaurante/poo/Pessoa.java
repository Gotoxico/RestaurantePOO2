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
     * @Brief: Construtor da classe Pessoa
     * @Parameter: nome
     * @Parameter: sobrenome
     * @Parameter: telefone 
     */
    public Pessoa() {
        this.nome = Gerador.geradorAleatorioNome();
        this.sobrenome = Gerador.geradorAleatorioSobrenomes();
        this.telefone = Gerador.geradorAleatorioTelefone();
    }
    
    /**
     * @Brief: Retorna o nome da pessoa
     * @Return: String representando o nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @Brief: Retorna o sobrenome da pessoa
     * @Return: String representando o sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @Brief: Retorna o telefone da pessoa
     * @Return: String representando o telefone
     */
    public String getTelefone() {
        return telefone;
    }
    
}
