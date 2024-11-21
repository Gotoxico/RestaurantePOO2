package restaurante.poo.Pagamentos;
//Classe PagamentoPedido: Classe para gerenciar pagamentos de pedidos
import restaurante.poo.Output.OutputInterface;

/**
 * Classe que implementa o pagamento parcelado por crédito
 * Permite que o valor do pagamento seja parcelado no cartão de crédito
 */
public class PagamentoParcelado implements MetodoPagamento {
    private int vezes;
    private OutputInterface output;

    /**
     * Construtor para inicializar o número de parcelas
     * @param vezes Número de parcelas
     * @param output Interface para exibir informações de saída
     */
    public PagamentoParcelado(int vezes, OutputInterface output) {
        this.vezes = vezes;
        this.output = output;
    }

    @Override
    public boolean pagar(double valor) {
        double valorParcelado = valor / vezes;
        output.display("Pagamento realizado com sucesso! Parcelado em " + vezes + " vezes de R$ " + valorParcelado);
        return true;
    }
}
