package restaurante.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import restaurante.poo.Output.OutputConsole;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe que representa uma comanda de um cliente no restaurante.
 * A comanda armazena os itens do pedido e o valor total.
 * Está associada a uma mesa.
 * 
 * @author renna
 */
public class Comanda implements RegistroConsumo{
    private final OutputInterface output;
    private static final AtomicInteger contadorComanda = new AtomicInteger(0);  // Contador sequencial para IDs únicos
    private String numeroComanda;
    private Mesa mesaAssociada;                         // Mesa associada à comanda
    private Pedido pedido;                              // Lista de pedidos feitos para essa mesa
    private double valorTotal;                          // Valor total da conta da mesa
    private double valorQuitado;
    private boolean aberta;                             // Flag para saber se a comanda está aberta ou fechada
    private boolean pago;
   


    /**
     * @Brief: Construtor da comanda.
     * @Brief: Inicializa uma comanda com um número e uma mesa associada.
     * @Brief: A comanda começa aberta e o valor total e quitado são inicializados como zero.
     * 
     * @Parameter: mesaAssociada Mesa associada à comanda
     */
    public Comanda(Mesa mesaAssociada) {
        this.output = OutputFactory.getInstance().getTipoOutput("console");;
        this.numeroComanda = gerarIdComanda();
        this.mesaAssociada = mesaAssociada;
        this.pedido = new Pedido();
        this.valorTotal = 0.0;
        this.valorQuitado = 0.0;
        this.aberta = true;     // Comanda inicia aberta
        this.pago = false;
    }

    /**
     * @Brief: Remove um item do pedido da comanda
     * 
     * @Parameter: item Item do pedido a ser removido
     */
    public void removerItemPedido(ItemMenu item) {
        if(pedido.removerItem(item.getNome())) {
            output.display("Remoção do " + item.getNome() + " na comanda " + numeroComanda + " feita com sucesso");
        } else {
            output.display("Não foi possível remover o " + item.getNome() + " na comanda " + numeroComanda);
        }
    }
    
    /**
     * @Brief: Transfere os itens de um pedido para a comanda.
     * @Brief: Se o pedido transferido contiver itens, estes serão adicionados à comanda
     * 
     * @Parameter: pedidoTransferido O pedido contendo os itens a serem transferidos para a comanda
     */
    public void adicionarPedido(Pedido pedidoTransferido) {
        if(!aberta) {
            output.display("Comanda já foi fechada!");
        }
        if (pedidoTransferido != null && !pedidoTransferido.getItensPedidos().isEmpty()) {
            // Passa por todos os itens do pedido recebido e transfere para a comanda
            for (ItemMenu item : pedidoTransferido.getItensPedidos()) {
                this.pedido.adicionarItem(item, 1);
                this.pago = false;
            }
            output.display("Itens transferidos para a comanda.");
        } else {
            output.display("Não há itens para transferir.");
        }
    }
    
    /**
     * @Brief: Calcula o valor total da comanda com base nos itens do pedido
     * @Brief: O valor total é atualizado e exibido
     */
    private void calcularValorComanda() {
        // Atribui o valor do pedido ao valor total da comanda        
        this.valorTotal =  this.pedido.getValorPedido();       //10% do garçom
        output.display("Valor total da comanda (" + numeroComanda + "): R$ " + valorTotal);      
    }
    
    /**
     * @Brief: Retorna o valor que ainda falta ser pago na comanda
     * 
     * @return O valor restante para pagamento
     */
    public double valorParaPagar() {
        return getValorTotal() - valorQuitado;
    }
    
    /**
     * @Brief: Realiza o pagamento de uma parte ou total da comanda
     * @Brief: Atualiza o valor quitado e verifica se o pagamento está completo
     * 
     * @Parameter: valor O valor a ser pago
     */
    public void pagar(double valor) {
        double valorRestante = valorParaPagar();
        if(!pago) {
            if(valorRestante < valor) {
                output.display("Alerta: Pagamento a mais!");
            } else {
                valorQuitado += valor;
                if(valorRestante == 0) {
                    output.display("Comanda foi paga");
                    this.pago = true;
                    return;
                }
                output.display("Valor restante da comanda: R$ " + valorRestante);
            }
        }
    }

    /**
     * @Brief: Fecha a comanda, impedindo novas alterações (como adicionar itens)
     */
    public void fecharComanda() {
        this.aberta = false;
    }

    // Getters e Setters
    
    /**
     * @Brief: Retorna o número da comanda
     * 
     * @return O número da comanda
     */
    public String getNumeroComanda() {
        return numeroComanda;
    }

      /**
     * @Brief: Gera um ID único para a comanda
     * @Brief: O ID é gerado a partir de um contador sequencial que incrementa a cada nova comanda criada
     * 
     * @return O ID gerado para a comanda
     */
    public static String gerarIdComanda() {
        // Incrementa o contador e retorna o ID como uma string
        return "COM-" + contadorComanda.incrementAndGet();
    }

    /**
     * @Brief: Retorna a mesa associada a comanda
     * 
     * @return A mesa associada
     */
    public Mesa getMesaAssociada() {
        return mesaAssociada;
    }

    /**
     * @Brief: Define a mesa associada à comanda
     * 
     * @Parameter: mesaAssociada A mesa associada
     */
    public void setMesaAssociada(Mesa mesaAssociada) {
        this.mesaAssociada = mesaAssociada;
    }

    /**
     * @Brief: Retorna o pedido associado à comanda
     * 
     * @return O pedido associado
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @Brief: Retorna o valor total da comanda
     * @Brief: O valor é calculado a partir dos itens do pedido
     * 
     * @return O valor total da comanda
     */
    public double getValorTotal() {
        calcularValorComanda();
        return valorTotal;
    }

    /**
     * @Brief: Define o valor total da comanda
     * 
     * @Parameter: valorTotal O valor total da comanda
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @Brief: Retorna o valor já pago da comanda
     * 
     * @return O valor já pago
     */
    public double getValorQuitado() {
        return valorQuitado;
    }

    /**
     * @Brief: Retorna se a comanda está aberta ou fechada
     * 
     * @return true se a comanda estiver aberta, false caso contrário
     */
    public boolean isAberta() {
        return aberta;
    }

    /**
     * @Brief: Retorna se a comanda foi paga ou não
     * 
     * @return true se a comanda foi paga, false caso contrário
     */
    public boolean isPago() {
        return pago;
    }
    
    /**
    * Método que emula a impressão da comanda de um cliente no restaurante
    * 
    * Este método gera uma string formatada contendo todos os detalhes relacionados à comanda,
    * como o número da comanda, mesa associada, status de pagamento, valor total, valor quitado,
    * valor restante, e os itens do pedido
    * 
    * A string gerada pode ser usada para exibir a comanda de forma legível para o cliente ou para
    * registros internos
    * 
    * @return Uma string formatada representando a comanda, incluindo todos os itens do pedido
    *         e o estado atual da comanda (valor total, quitado e restante)
    */
    public String imprimirComanda(){
        StringBuilder sb = new StringBuilder();

        sb.append("Comanda: ").append(this.numeroComanda).append("\n")
          .append("Mesa: ").append(this.mesaAssociada.getNumeroMesa()).append("\n")
          .append("Status: ").append(this.aberta ? "Aberta" : "Fechada").append("\n")
          .append("Valor Total: R$ ").append(String.format("%.2f", getValorTotal())).append("\n")
          .append("Itens do Pedido: \n");

        // Exibe todos os itens do pedido
        for (ItemMenu item : pedido.getItensPedidos()) {
            sb.append(" - ").append(item.getNome()).append(" (R$ ").append(String.format("%.2f", item.getPreco())).append(")\n");
        }

        // Mensagem final
        if (pago) {
            sb.append("\nComanda Paga.");
        } else {
            sb.append("\nComanda não paga.");
        }

        return sb.toString();
        }
    
    /**
    * @Brief: Adiciona um item diretamente ao pedido da comanda.
    * @Brief: O item será adicionado com uma quantidade especificada.
    * 
    * @Parameter: item O item do menu a ser adicionado ao pedido.
    * @Parameter: quantidade A quantidade do item a ser adicionada.
    */
    public void adicionarItem(ItemMenu item) {
        if (!aberta) {
            output.display("Comanda já foi fechada!");
            return;
        }
        
        this.pedido.adicionarItem(item, 1);
        this.pago = false;
        output.display("Item " + item.getNome() + " adicionado ao pedido da comanda " + numeroComanda + ".");
    }
}
