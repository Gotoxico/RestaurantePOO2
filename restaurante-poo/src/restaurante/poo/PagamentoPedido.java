package restaurante.poo;

import java.util.UUID;

public class PagamentoPedido {
    private String idPagamento;
    private Pedido pedido;
    private double valorTotal;
    private boolean pago;
    private String formaPagamento;

    public PagamentoPedido(Pedido pedido, String formaPagamento){   //Construir um constructor nulo?
        this.idPagamento = UUID.randomUUID().toString();
        this.pedido = pedido;
        this.formaPagamento = formaPagamento;
        this.valorTotal = calcularTotalPedido();
        this.pago = false;
    }

    private double calcularTotalPedido() {
        double total = 0.0;
        for(ItemMenu item : pedido.getItensPedidos()){      //Alterar essa lógica para calcular preços, ou incluir novas dinamicas
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public boolean realizarPagamento(){
        if(!pago){
            this.pago = true;
            System.out.println("Pagamento de R$" + valorTotal + " realizado com sucesso.");
            return true;
        }else{
            System.out.println("O pagamento já foi realizado.");
            return false;
        }
    }

    public boolean estaPago(){
        return pago;
    }

    public String getIdPagamento(){
        return idPagamento;
    }

    public Pedido getPedido(){
        return pedido;
    }

    public double getValorTotal(){
        return valorTotal;
    }

    public String getFormaPagamento(){
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString(){
        return "PagamentoPedido:\n" +
               "idPagamento = " + idPagamento + "\n" +
               "Valor Total = " + valorTotal + "\n" +
               "Pago = " + pago + "\n" +
               "Forma de Pagamento = " + formaPagamento + "\n";
    }
}
