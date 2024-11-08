/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

/**
 * 
 * Classe que representa um usuário no sistema, com informações básicas como nome e email
 * 
 * @author juniortraj
 */
public class Usuario {
    private String nome; 
    private String email;
    
    /**
     * @Brief: Construtor para criar um novo usuário com o nome e email especificados
     * 
     * @Parameter: nome O nome do usuário
     * @Parameter: email O email do usuário
     */
    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    
    /**
     * @Brief: Obtém o nome do usuário
     * 
     * @Return: o nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * @Brief: Define o nome do usuário
     * 
     * @Parameter: nome o novo nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @Brief: Obtém o email do usuário
     * 
     * @Return: O email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * @Brief: Define o email do usuário
     * 
     * @Parameter: email o novo email do usuário
     */
    public void setEmailGarcom(String email) {
        this.email = email;
    }
}
