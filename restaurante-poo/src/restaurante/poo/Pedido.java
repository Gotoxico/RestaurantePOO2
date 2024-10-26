/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;
import java.util.ArrayList;
import java.util.List;  //interface?

/**
 *
 * @author renna
 */
public class Pedido {
    private Mesa mesa; 
    private PagamentoPedido pagamento;
    private List<ItemMenu> itensPedidos;  //implementar gorjeta por garçom?
    private Garcom garcomResponsavel;  //trocar para gerencia, ou incluir. Talvez
    
    public Pedido(Mesa mesa){
        this.mesa = mesa;
        this.itensPedidos = new ArrayList<>();
        this.garcomResponsavel = mesa.getGarcomResponsavel();
        this.pagamento = null;              //alterar essa parte, revisar cooperação entre classes.
    }
    
    public void addPedido(ItemMenu novoItem){
        itensPedidos.add(novoItem);
    }
    
    public void removerItem(ItemMenu itemRemover){  //Checkar funcionalidade
        itensPedidos.removeIf(item -> item.getNome().equals(itemRemover.getNome()));
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<ItemMenu> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemMenu> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public Garcom getGarcomResponsavel() {
        return garcomResponsavel;
    }

    public void setGarcomResponsavel(Garcom garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
    }

}
