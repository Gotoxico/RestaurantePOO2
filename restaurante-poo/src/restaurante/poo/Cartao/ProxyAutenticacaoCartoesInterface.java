/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante.poo.Cartao;

import java.time.LocalDate;

/**
 * Interface ProxyAutenticacaoCartoesInterface define os métodos necessários para  autenticação e validação de cartões de pagamento
 * Inclui métodos para verificar o código de segurança, validar o nome do titulare verificar a data de validade do cartão
 * 
 * @author rodri
 */
public interface ProxyAutenticacaoCartoesInterface {
    /**
     * @Brief: Verifica se o código de segurança do cartão é valido
     * 
     * @Parameter: codigo Código de segurança do cartão.
     * @Return: true se o código de segurança é válido; false caso contrário.
     */
    boolean checarCodigo(String codigo);
    /**
     * @Brief: Verifica se o nome e sobrenome fornecidos correspondem aos do dono do cartão
     * 
     * @Parameter: nome Nome do cliente
     * @Parameter: sobrenome Sobrenome do cliente
     * @Parameter: nomeCartao nome do titular no cartão
     * @Parameter: sobrenomeCartao sobrenome do titular no cartão
     * @Return: true se o nome e sobrenome coincidem com os do titular no cartão; false caso contrário
     */
    boolean checarNome(String nome, String sobrenome, String nomeCartao, String sobrenomeCartao);
    /**
     * @Brief: Verifica se a data de validade do cartão ainda é válida
     * 
     * @Parameter: dataCartao Data de validade do cartão
     * @Return: true se a data de validade do cartão é hoje ou uma data futura; false se estiver expirada
     */
    public boolean checarData(LocalDate dataCartao);
}
