package restaurante.poo;

import restaurante.poo.Cartao.ProxyAutenticacaoCartoes;
import restaurante.poo.Cartao.Cartao;
import java.util.UUID;
import restaurante.poo.Output.OutputConsole;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

/**
 * Classe que representa o processo de pagamento de um pedido
 * Gerencia o valor total, a forma de pagamento e a autenticação pra pagamentos com cartão
 */
public class PagamentoPedido {
    private final OutputInterface output;
    private String idPagamento;
    private Comanda comanda;
    private ClienteRestaurante cliente;
    private boolean pago;
    private String formaPagamento;
    private ProxyAutenticacaoCartoes proxy;
    private double valorAPagar; // Considere esse no lugar de total

    /**
     * @Brief: Construtor para inicializar um pagamento com base em um pedido e uma forma de pagamento
     * @Brief: Gera um ID único para o pagamento e calcula o valor total do pedido
     * 
     * @Parameter: tipoOutput Tipo de saída para exibir mensagens
     * @Parameter: pedido Pedido associado ao pagamento
     * @Parameter: formaPagamento Forma de pagamento escolhida pelo cliente
     */
    public PagamentoPedido(String tipoOutput, Comanda comanda, String formaPagamento, ClienteRestaurante cliente, Double valorAPagar){  
        this.output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
        this.idPagamento = UUID.randomUUID().toString();
        this.comanda = comanda;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.valorAPagar = valorAPagar;
        this.pago = comanda.isPago();
    }

    /**
     * @Brief: Realiza o pagamento do pedido, com verificação de autenticidade caso seja realizado com cartão
     * @Brief: Exibe uma mensagem de confirmação em caso de sucesso
     * 
     * @Return: true se o pagamento for realizado com sucesso, false caso contrário
     */
    public boolean realizarPagamento(){ // implementar mudanças para rachar conta, e considerar os 10%
        if(!pago){
            if(formaPagamento.equals("cartao")){
                if(cliente.getCartao() != null){   
                    Cartao c = cliente.getCartao();
                    boolean a = proxy.checarCodigo(String.valueOf(c.getCodigo()));
                    boolean b = proxy.checarNome(cliente.getNomeCliente() , cliente.getSobrenomeCliente(), c.getNome(), c.getSobrenome());
                    boolean d = proxy.checarData(c.getVencimento());
                    
                    if(a && b && d){
                        this.pago = true;
                        return true;
                    }
                }
            }
            this.pago = true;
            output.display("Pagamento de R$" + comanda.getValorTotal() + " realizado com sucesso."); 
            return true;
        }else{
            output.display("O pagamento já foi realizado.");
            return false;
        }
    }

    /**
     * @Brief: verifica se o pedido já foi pago
     * 
     * @Return: true se o pedido estiver pago, false caso contrário
     */
    public boolean estaPago(){
        return pago;
    }

    /**
     * @Brief: Obtém o ID único do pagamento
     * 
     * @Return: ID do pagamento
     */
    public String getIdPagamento(){
        return idPagamento;
    }

    /**
     * @Brief: Obtém o pedido associado a este pagamento
     * 
     * @Return: Comanda associada
     */
    public Comanda getComanda(){
        return comanda;
    }

    /**
     * @Brief: obtém o valor total do pagamento
     * 
     * @Return: Valor total do pedido
     */
    public double getValorAPagar(){
        return valorAPagar;
    }

    /**
     * @Brief: obtém a forma de pagamento utilizada
     * 
     * @Return: Forma de pagamento 
     */
    public String getFormaPagamento(){
        return formaPagamento;
    }

    /**
     * @Brief: Define a forma de pagamento a ser utilizada
     * 
     * @Parameter: formaPagamento Nova forma de pagamento
     */
    public void setFormaPagamento(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }
    
    /**
     * @Brief: retorna uma representação textual do pagamento
     * 
     * @Return: String contendo os detalhes do pagamento
     */
    @Override
    public String toString(){
        return "PagamentoPedido:\n" +
               "idPagamento = " + idPagamento + "\n" +
               "Valor Pago = " + valorAPagar + "\n" +
               "Pago = " + pago + "\n" +
               "Forma de Pagamento = " + formaPagamento + "\n";
    }

    public ClienteRestaurante getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRestaurante cliente) {
        this.cliente = cliente;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public ProxyAutenticacaoCartoes getProxy() {
        return proxy;
    }

    public void setProxy(ProxyAutenticacaoCartoes proxy) {
        this.proxy = proxy;
    }
    
    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }
    
    
}
