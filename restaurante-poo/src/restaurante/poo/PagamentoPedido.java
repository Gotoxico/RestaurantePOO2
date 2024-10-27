package restaurante.poo;

import restaurante.poo.Cartao.ProxyAutenticacaoCartoes;
import restaurante.poo.Cartao.Cartao;
import java.util.UUID;
import restaurante.poo.Output.OutputConsole;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

public class PagamentoPedido {
    private OutputInterface output;
    private String idPagamento;
    private Pedido pedido;
    private double valorTotal;
    private boolean pago;
    private String formaPagamento;
    private ProxyAutenticacaoCartoes proxy;

    public PagamentoPedido(String tipoOutput, Pedido pedido, String formaPagamento){   //Construir um constructor nulo?
        this.output = OutputFactory.getTipoOutput(tipoOutput);
        this.idPagamento = UUID.randomUUID().toString();
        this.pedido = pedido;
        this.formaPagamento = formaPagamento;
        this.valorTotal = calcularTotalPedido();
        this.pago = false;
    }

    private double calcularTotalPedido() {
        double total = 0.0;
        for(ItemMenu item : pedido.getItensPedidos()){      //Alterar essa lógica para calcular preços, ou incluir novas dinamicas
            
            total += item.getPreco();
        }
        return total;
    }

    public boolean realizarPagamento(){
        if(!pago){
            if(formaPagamento.equals("cartao")){
                if(pedido.getMesa().getClienteResponsavel().getCartao() != null){
                    Cartao c = pedido.getMesa().getClienteResponsavel().getCartao();
                    boolean a = proxy.checarCodigo(String.valueOf(c.getCodigo()));
                    boolean b = proxy.checarNome(pedido.getMesa().getClienteResponsavel().getNomeCliente() , pedido.getMesa().getClienteResponsavel().getSobrenomeCliente(), c.getNome(), c.getSobrenome());
                    boolean d = proxy.checarData(c.getVencimento());
                    
                    if(a && b && d){
                        this.pago = true;
                        return true;
                    }
                }
            }
            this.pago = true;
            if(output instanceof OutputConsole){
                System.out.println("Pagamento de R$" + valorTotal + " realizado com sucesso.");
            }
            return true;
        }else{
            if(output instanceof OutputConsole){
                System.out.println("O pagamento já foi realizado.");
            }
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
