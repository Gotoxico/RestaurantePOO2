package restaurante.poo.Pagamentos;
//Classe PagamentoPedido: Classe para gerenciar pagamentos de pedidos.
import restaurante.poo.Output.OutputInterface;
import java.util.Scanner;

/**
 * Classe que implementa o pagamento por dinheiro
 * Calcula o troco e verifica se o valor é suficiente
 */
public class PagamentoDinheiro implements MetodoPagamento {
    private double valorAPagar;
    private Scanner scanner;
    private OutputInterface output;

    /**
     * Construtor para inicializar o valor e o scanner
     * @param valor Valor a ser pago
     * @param scanner Scanner para entrada de dados
     * @param output Interface para exibir informações de saída
     */
    public PagamentoDinheiro(double valor, Scanner scanner, OutputInterface output) {
        this.valorAPagar = valor;
        this.scanner = scanner;
        this.output = output;
    }

    @Override
    public boolean pagar(double valor) {
        output.print("Digite o valor pago em dinheiro: ");
        double valorPago = scanner.nextDouble();
        
        if (valorPago < valor) {
            output.print("Valor insuficiente! Ainda faltam R$ " + (valor - valorPago));
            return false;
        }
        
        double troco = valorPago - valor;
        output.print("Pagamento efetuado! Troco: R$ " + troco);
        return true;
    }
}
