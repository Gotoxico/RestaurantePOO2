/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;
import java.util.ArrayList;
import java.util.List;  //interface?

/**
 * Classe que representa um pedido feito em um restaurante
 * Um pedido pode conter vários itens do menu, um garçom responsável, um valor total e um status de entrega;
 * 
 * @author renna
 */
public class Pedido {       
    private List<ItemMenu> itensPedidos;  //implementar gorjeta por garçom?
    private Garcom garcomResponsavel;  //trocar para gerencia, ou incluir. Talvez
    private double valorPedido;
    //Adcionar COMANDA????
    
    /**
     * @Brief: construtor para criar um novo pedido 
     * @Brief: inicializa a lista de itens do pedido e define o garçom responsável
     * 
     * @Parameter: mesa a mesa onde o pedido será feito
     */
    public Pedido(Mesa mesa){
        this.itensPedidos = new ArrayList<>();
        this.garcomResponsavel = mesa.getGarcomResponsavel();
        this.valorPedido = 0.0;
    }
    
    /**
     * @Brief: Adiciona um item ao pedido 
     * 
     * 
     * @Parameter: novoItem O item do menu que será adicionado ao pedido
     */
    public void adicionarItem(ItemMenu item, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            itensPedidos.add(item);
            valorPedido += item.getPreco();
        }                   
    }
    
      /**
     * Remove um item do pedido e atualiza o valor total do pedido.
     * 
     * @param nomeDoItem O nome do item a ser removido.
     * @return True se o item foi removido com sucesso, false caso contrário.
     */
    public boolean removerItem(String nomeDoItem) {
        for (int i = 0; i < itensPedidos.size(); i++) {
            ItemMenu item = itensPedidos.get(i);
            if (item.getNome().equals(nomeDoItem) && !item.isEntregueStatus()) {
                itensPedidos.remove(i);
                valorPedido -= item.getPreco();  // Atualiza o valor do pedido ao remover o item
                return true;
            }
        }
        return false;
    }
//
//     /**
//     * @Brief: Obtém a mesa associada ao pedido
//     * 
//     * @Return: A mesa onde o pedido foi feito
//     */
//    public Mesa getMesa() {
//        return mesa;
//    }
//    
//    /**
//     * @Brief: Define a mesa associada ao pedido
//     * 
//     * @Parameter: mesa a nova mesa onde o pedido será associado
//     */
//    public void setMesa(Mesa mesa) {
//        this.mesa = mesa;
//    }
    
    /**
     * @Brief: obtém a lista de itens no pedido
     * 
     * @Return: A lista de itens do pedido
     */
    public List<ItemMenu> getItensPedidos() {
        return itensPedidos;
    }
    
    /**
     * @Brief: Define a lista de itens no pedido
     * 
     * @Parameter: itensPedidos a nova lista de itens do pedido
     */
    private void setItensPedidos(List<ItemMenu> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
    
    /**
     * @Brief: Obtém o garçom responsável pelo pedido
     * 
     * @Return: O garçom responsável
     */
    public Garcom getGarcomResponsavel() {
        return garcomResponsavel;
    }
    
    /**
     * @Brief: Define o garçom responsável pelo pedido
     * 
     * @Parameter: garcomResponsavel o novo garçom responsável pelo pedido
     */
    public void setGarcomResponsavel(Garcom garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
    }
    
     /**
     * @Brief: Obtém valor total do pedido
     * 
     * @eturn: double valor do pedido
     */
    public double getValorPedido(){
        return valorPedido;
    }
}

