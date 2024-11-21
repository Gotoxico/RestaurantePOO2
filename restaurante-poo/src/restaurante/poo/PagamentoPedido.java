package restaurante.poo;
//Classe PagamentoPedido: Classe para gerenciar pagamentos de pedidos
import restaurante.poo.Output.OutputConsole;
import restaurante.poo.Output.OutputInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
//Métodos de pagamentos
import restaurante.poo.Pagamentos.PagamentoDinheiro;
import restaurante.poo.Pagamentos.PagamentoDebito;
import restaurante.poo.Pagamentos.PagamentoCredito;
import restaurante.poo.Pagamentos.PagamentoParcelado;
import restaurante.poo.Pagamentos.PagamentoPix;
import restaurante.poo.Pagamentos.MetodoPagamento;

/**
 * Classe que gerencia o pagamento de pedidos em um restaurante.
 * Permite adicionar gorjetas, dividir a conta e usar diferentes métodos de pagamento.
 */
public class PagamentoPedido {
    private final OutputInterface output;
    private String idPagamento;
    private Comanda comanda;
    private ClienteRestaurante cliente;
    private boolean pago;
    private double valorAPagar;
    private double gorjeta;
    private List<MetodoPagamento> metodosPagamento;

    /**
     * Construtor da classe PagamentoPedido.
     * @param comanda Comanda associada ao pedido.
     * @param cliente Cliente que realizou o pedido.
     */
    public PagamentoPedido(Comanda comanda, ClienteRestaurante cliente) {
        this.output = new OutputConsole();
        this.idPagamento = UUID.randomUUID().toString();
        this.comanda = comanda;
        this.cliente = cliente;
        this.pago = false;
        this.valorAPagar = comanda.getValorTotal();
        this.metodosPagamento = new ArrayList<>();
    }

    /**
     * Adiciona 10% do valor do pedido como gorjeta do garçom
     */
    public void calcularGorjetaGarcom() {
        this.gorjeta = valorAPagar * 0.10;
        this.valorAPagar += gorjeta;
        output.display("Gorjeta de 10% (R$ " + String.format("%.2f", gorjeta) + ") adicionada ao total.");
    }

    /**
     * Define o método de pagamento do pedido
     * @param metodoPagamento Objeto que implementa o método de pagamento.
     */
    public void definirMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodosPagamento.add(metodoPagamento);
    }

    /**
     * Realiza o pagamento do pedido, com ou sem divisão
     */
    public void realizarPagamento() {
        Scanner scanner = new Scanner(System.in);
        output.display("Deseja dividir a conta? (sim / nao)");
        String dividirConta = scanner.nextLine().toLowerCase();

        if (dividirConta.equals("sim")) {
            output.display("Quantas pessoas irá dividir a conta?");
            int qtdPessoas = scanner.nextInt();
            double valorPorPessoa = valorAPagar / qtdPessoas;
            scanner.nextLine(); //Limpa o buffer

            for (int i = 0; i < qtdPessoas; i++) {
                output.display("Pessoa " + (i + 1) + ", escolha seu método de pagamento: 1)- Dinheiro, 2)- Débito, 3)- Crédito ou  4)- Pix");
                int escolha = scanner.nextInt();
                scanner.nextLine();

                MetodoPagamento metodo = criarMetodoPagamento(escolha, scanner, valorPorPessoa);
                if (metodo != null) {
                    definirMetodoPagamento(metodo);
                    metodo.pagar(valorPorPessoa);
                }
            }
        } else {
            output.display("Escolha o método de pagamento: 1)- Dinheiro, 2)- Débito, 3)- Crédito ou 4)-Pix");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            MetodoPagamento metodo = criarMetodoPagamento(escolha, scanner, valorAPagar);
            if (metodo != null) {
                definirMetodoPagamento(metodo);
                pago = metodo.pagar(valorAPagar);
            }
        }

        if (pago) {
            output.display("Pagamento concluído, muito obrigado pela presensença! ID do pagamento: " + idPagamento);
        } else {
            output.display("Pagamento não realizado! Por favor, Tente novamente.");
        }
    }

    /**
     * Cria um objeto de método de pagamento com base na escolha do usuário.
     * @param escolha Tipo de pagamento escolhido.
     * @param scanner Scanner para entrada de dados adicionais.
     * @param valor Valor a ser pago.
     * @return Objeto que implementa MetodoPagamento.
     */
    private MetodoPagamento criarMetodoPagamento(int escolha, Scanner scanner, double valor) {
        switch (escolha) {
            case 1:
                return new PagamentoDinheiro(valor, scanner, output);
            case 2:
                return new PagamentoDebito(output);
            case 3:
                output.display("Deseja parcelar no crédito? (sim / nao)");
                String parcelar = scanner.nextLine().toLowerCase();
                if (parcelar.equals("sim")) {
                    output.display("Em quantas vezes será parcelado?");
                    int vezes = scanner.nextInt();
                    scanner.nextLine();
                    return new PagamentoParcelado(vezes, output);
                }
                return new PagamentoCredito(output);
            case 4:
                return new PagamentoPix(output);
            default:
                output.display("Opção inválida");
                return null;
        }
    }
}
