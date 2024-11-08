/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Cartao;
import java.time.LocalDate;
import restaurante.poo.PagamentoPedido;

/**
 * Classe ProxyAutenticacaoCartoes que implementa a interface ProxyAutenticacaoCartoesInterface
 * Essa classe verifica a autenticidade de informações de cartões de pagamento
 * 
 * Incluem a validação do código de segurança, a verificação do nome do titular e a verificação da data de validade do cartão
 * 
 * @author rodri
 */
public class ProxyAutenticacaoCartoes implements ProxyAutenticacaoCartoesInterface{
    private PagamentoPedido pagamento;

    /**
     * @Brief: Construtor padrão da classe ProxyAutenticacaoCartoes
     */
    public ProxyAutenticacaoCartoes() {
    }

    /**
     * @Brief: Construtor que inicializa a classe com uma instância de PagamentoPedido
     * 
     * @Parameter: pagamento Instância de PagamentoPedido associada ao proxy de autenticação
     */
    public ProxyAutenticacaoCartoes(PagamentoPedido pagamento) {
        this.pagamento = pagamento;
    }
    
    /**
     * @Brief: Verifica se o código de segurança do cartão tem o tamanho correto 
     * 
     * @Parameter: codigo Código de segurança do cartão como string
     * @Return: true se o código tem 3 ou 4 dígitos; false caso contrário
     */
    public boolean checarCodigo(String codigo){
        if(codigo.length() == 3 || codigo.length() == 4){
            return true;
        }
        return false;
    }
    
    /**
     * @Brief: verifica se o nome e sobrenome fornecidos correspondem ao nome e sobrenome no cartão
     * 
     * @Parameter: nome Nome do cliente
     * @Parameter: sobrenome Sobrenome do cliente
     * @Parameter: nomeCartao Nome do titular no cartão
     * @Parameter: sobrenomeCartao Sobrenome do titular no cartão
     * @Return: true se o nome e sobrenome coincidem com os do cartão e false caso contrário
     */
    public boolean checarNome(String nome, String sobrenome, String nomeCartao, String sobrenomeCartao){
        if(nome.equals(nomeCartao) && sobrenome.equals(sobrenomeCartao)){
            return true;
        }
        return false;
    }
    
    /**
     * @Brief: verifica se a data de validade do cartão ainda é válida
     * 
     * @Parameter: dataCartao Data de validade do cartão
     * @Return: true se a data de validade é hoje ou uma data futura; false se estiver expirada
     */
    public boolean checarData(LocalDate dataCartao){
        if(LocalDate.now().isBefore(dataCartao) || LocalDate.now().isEqual(dataCartao)){
            return true;
        }
        return false;
    }
}
