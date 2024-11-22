package restaurante.poo;

/**
 * Interface que define comportamento de um registro de consumo, implementado 
 * pela comanda
 * @author renna
 */
public interface RegistroConsumo {
    public void adicionarPedido(Pedido pedidoTransferido);
    
    public void removerItemPedido(ItemMenu item);
    
    public double valorParaPagar();
    
    public void pagar(double valor);
    
    public void fecharComanda();
    
    public String getNumeroComanda();
}