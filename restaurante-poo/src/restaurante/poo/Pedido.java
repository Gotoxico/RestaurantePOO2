/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;
import java.util.ArrayList;
import java.util.List;  //interface?

/**
 * Classe que representa um pedido feito em uma mesa de restaurante
 * Um pedido pode conter vários itens do menu, um garçom responsável e está associado a uma mesa específica
 * 
 * @author renna
 */
public class Pedido {
    private Mesa mesa; 
    private PagamentoPedido pagamento;
    private List<ItemMenu> itensPedidos;  
    private Garcom garcomResponsavel;  
    
    /**
     * @Brief: construtor para criar um novo pedido associado a uma mesa específica
     * @Brief: inicializa a lista de itens do pedido e define o garçom responsável
     * 
     * @Parameter: mesa a mesa onde o pedido será feito
     */
    public Pedido(Mesa mesa){
        this.mesa = mesa;
        this.itensPedidos = new ArrayList<>();
        this.garcomResponsavel = mesa.getGarcomResponsavel();
        this.pagamento = null;              
    }
    
    /**
     * @Brief: Adiciona um item ao pedido
     * 
     * @Parameter: novoItem O item do menu que será adicionado ao pedido
     */
    public void addPedido(ItemMenu novoItem){
        itensPedidos.add(novoItem);
    }
    
    /**
     * @Brief: remove um item específico do pedido
     * 
     * @Parameter: itemRemover O item do menu a ser removido do pedido
     */
    public void removerItem(ItemMenu itemRemover){ 
        itensPedidos.removeIf(item -> item.getNome().equals(itemRemover.getNome()));
    }

    /**
     * @Brief: Obtém a mesa associada ao pedido
     * 
     * @Return: A mesa onde o pedido foi feito
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * @Brief: Define a mesa associada ao pedido
     * 
     * @Parameter: mesa a nova mesa onde o pedido será associado
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

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
    public void setItensPedidos(List<ItemMenu> itensPedidos) {
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

}
