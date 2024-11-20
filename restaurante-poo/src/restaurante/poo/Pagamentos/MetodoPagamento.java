package restaurante.poo.pagamento;
//Classe PagamentoPedido: Classe para gerenciar pagamentos de pedidos.

/**
 * Interface que define o contrato para os métodos de pagamento
 * Todos os métodos de pagamento devem implementar o comportamento de realizar o pagamento
 */
public interface MetodoPagamento {
    /**
     * Método que realiza o pagamento
     * @param valor Valor a ser pago
     * @return Retorna true se o pagamento foi realizado com sucesso, caso contrário, false
     */
    boolean pagar(double valor);
}
