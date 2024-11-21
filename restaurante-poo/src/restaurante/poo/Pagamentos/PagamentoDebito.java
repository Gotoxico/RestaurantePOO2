package restaurante.poo.Pagamentos;
//Classe PagamentoPedido: Classe para gerenciar pagamentos de pedidos
import restaurante.poo.Output.OutputInterface;

/**
 * Classe que implementa o pagamento de débito
 * Simula o pagamento através de cartão de débito
 */
public class PagamentoDebito implements MetodoPagamento {
    private OutputInterface output;

    /**
     * Construtor para inicializar a interface de saída
     * @param output Interface para exibir informações de saída
     */
    public PagamentoDebito(OutputInterface output) {
        this.output = output;
    }

    @Override
    public boolean pagar(double valor) {
        output.display("Pagamento via débito realizado com sucesso! Valor realizado R$ " + valor);
        return true;
    }
}
