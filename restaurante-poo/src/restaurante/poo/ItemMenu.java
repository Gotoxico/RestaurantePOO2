/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

/**
 * Classe que representa um item do menu de um restaurante
 * Com informações sobre o nome, descrição e preço do item
 * 
 * @author pabloc
 */
public class ItemMenu {
    private String nome;
    private String descricao;
    private double preco;
    private boolean entregueStatus;

    /**
     * @Brief: Construtor da classe ItemMenu.
     * 
     * @Parameter: nome       Nome do item do menu
     * @Parameter: descricao  Descrição do item do menu
     * @Parameter: preco      Preço do item do menu
     */
    public ItemMenu(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * @Brief: Obtem o nome do item do menu
     * 
     * @Return: Nome do item
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @Brief: define o nome do item do menu
     * 
     * @Parameter: nome Novo nome do item
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @Brief: obtem a descrição do item do menu
     * 
     * @Return: Descrição do item
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * @Brief: Define a descrição do item do menu
     * 
     * @Parameter: descricao Nova descrição do item
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * @Brief: Obtem o preço do item do menu
     * 
     * @Return: Preço do item
     */
    public double getPreco() {
        return preco;
    }
    
    /**
     * @Brief: Define o preço do item do menu
     * 
     * @Parameter:  preco novo preço do item
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isEntregueStatus() {
        return entregueStatus;
    }

    public void setEntregueStatus(boolean entregueStatus) {
        this.entregueStatus = entregueStatus;
    }
    
    /**
     * Retorna uma representação em string do item do menu, incluindo nome, descrição e preço
     * 
     * @Return: String representando o item do menu
     */
    @Override
    public String toString() {
        return "ItemMenu{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
