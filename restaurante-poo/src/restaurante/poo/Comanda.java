package restaurante.poo;

import java.util.ArrayList;
import java.util.List;

import restaurante.poo.Output.OutputConsole;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 * Classe que representa uma comanda de um cliente no restaurante.
 * A comanda armazena os itens do pedido e o valor total.
 * Está associada a uma mesa
 * 
 * @author renna
 */
public class Comanda {
    private final OutputInterface output;
    private String numeroComanda;
    private Mesa mesaAssociada;                         // Mesa associada à comanda
    private Pedido pedido;                              // Lista de pedidos feitos para essa mesa
    private double valorTotal;                          // Valor total da conta da mesa
    private double valorQuitado;
    private boolean aberta;                             // Flag para saber se a comanda está aberta ou fechada
//    private boolean pago;


    /**
     * Construtor da comanda
     * 
     * @param numeroComanda Número da comanda
     * @param mesaAssociada Mesa associada à comanda
     * @param cliente Cliente responsável pela comanda
     */
    public Comanda(String numeroComanda, Mesa mesaAssociada) {
        this.output = OutputFactory.getInstance().getTipoOutput(null);
        this.numeroComanda = numeroComanda;
        this.mesaAssociada = mesaAssociada;
        this.pedido = new Pedido(mesaAssociada);
        this.valorTotal = 0.0;
        this.valorQuitado = 0.0;
        this.aberta = false;
//      this.pago = false;
    }

    /**
     * Remove um item do pedido da comanda
     * 
     * @param item Item do pedido a ser removido
     */
    public void removerItemPedido(ItemMenu item) {
        if(pedido.removerItem(item.getNome())){
            output.display("Remoção do" + item.getNome() + "na comanda "+numeroComanda+" feito com sucesso");
        }else{
            output.display("Não foi possível fazer a remoção do" + item.getNome() + "na comanda "+numeroComanda);
        }
    }
    
    /**
    * Transfere os itens de um pedido para a comanda.
    * 
    * @param pedidoTransferido O pedido contendo os itens a serem transferidos para a comanda.
    * 
    * @Nota: Se o pedido recebido não contiver itens, nenhum item será transferido para a comanda.
    */
    public void adicionarPedido(Pedido pedidoTransferido) {
        // Verifica se o pedido transferido não está vazio
        if (pedidoTransferido != null && !pedidoTransferido.getItensPedidos().isEmpty()) {
            // Passa por todos os itens do pedido recebido e transfere para a comanda
            for (ItemMenu item : pedidoTransferido.getItensPedidos()) {
                this.pedido.adicionarItem(item,1);
            }
            output.display("Itens transferidos para a comanda.");
        } else {
            output.display("Não há itens para transferir.");
        }
    }
    
    /**
     * Método que calcula o valor total da comanda.
     * O valor total é baseado no valor dos itens do pedido associado a comanda.
     */
    private void calcularValorComanda() {
        // Atribui o valor do pedido ao valor total da comanda
        this.valorTotal = this.pedido.getValorPedido();
        output.display("Valor total da comanda (" + numeroComanda + "): R$ " + valorTotal);
     }
    
    public double valorParaPagar(){
        return valorTotal - valorQuitado;
    }
        
    /**
     * Marca a comanda como paga
     */
    public void pagar() {
        this.pago = true;
    }

    // Getters e Setters
    public String getNumeroComanda() {
        return numeroComanda;
    }

    public void setNumeroComanda(String numeroComanda) {
        this.numeroComanda = numeroComanda;
    }

    public Mesa getMesaAssociada() {
        return mesaAssociada;
    }

    public void setMesaAssociada(Mesa mesaAssociada) {
        this.mesaAssociada = mesaAssociada;
    }

//    public ClienteRestaurante getCliente() {;
//        return cliente;
//    }
//
//    public void setCliente(ClienteRestaurante cliente) {
//        this.cliente = cliente;
//    }

    public Pedido Pedido() {
        return pedido;
    }

    public void setItensPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getTotal() {
        return valorTotal;
    }

    public void setTotal(double total) {
        this.valorTotal = total;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

}
