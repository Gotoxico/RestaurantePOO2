package restaurante.poo.Pagamentos;
//Classe PagamentoPedido: Classe para gerenciar pagamentos de pedidos
import restaurante.poo.Output.OutputInterface;
import java.util.UUID;

/**
 * Classe que implementa o pagamento por Pix
 * Gera um código/ chave aleatória para realizar o pagamento
 */
public class PagamentoPix implements MetodoPagamento {
    private OutputInterface output;

    /**
     * Construtor para inicializar a interface de saída.
     * @param output Interface para exibir informações de saída.
     */
    public PagamentoPix(OutputInterface output) {
        this.output = output;
    }

    @Override
    public boolean pagar(double valor) {
        String codigoPix = UUID.randomUUID().toString();
        output.display("Código para pagamento via pix: " + codigoPix);
        return true;
    }
}
