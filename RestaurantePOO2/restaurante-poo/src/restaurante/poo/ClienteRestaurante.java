/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import restaurante.poo.Cartao.Cartao;
import java.time.LocalDate;

/**
 * Classe que representa um cliente do restaurante
 * Armazena informações do cliente como nome, sobrenome, telefone e cartão
 * 
 * @author Gabrielly
 */
public class ClienteRestaurante {
    private String nomeCliente;
    private String sobrenomeCliente;
    private String telefoneCliente;
    private Cartao c;
    
    /**
     * @Brief: Construtor da classe ClienteRestaurante
     * 
     * @Parameter: nomeCliente       Nome do cliente
     * @Parameter: sobrenomeCliente  Sobrenome do cliente
     * @Parameter: telefoneCliente   Telefone do cliente
     */
    public ClienteRestaurante(String nomeCliente, String sobrenomeCliente, String telefoneCliente) {
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.telefoneCliente = telefoneCliente;
    }

    /**
     * @Brief: Obtém o nome do cliente
     * 
     * @Return: Nome do cliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    /**
     * @Brief: Define o nome do cliente
     * 
     * @Parameter: nomeCliente   Novo nome do cliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    /**
     * @Brief: Obtém o telefone do cliente
     * 
     * @Return: Telefone do cliente
     */
    public String getTelefoneCliente() {
        return telefoneCliente;
    }
    
     /**
     * @Brief: Define o sobrenome do cliente
     * 
     * @Parameter: sobrenomeCliente Novo sobrenome do cliente
     */
    public void setSobrenomeCliente(String sobrenomeCliente) {
        this.sobrenomeCliente = sobrenomeCliente;
    }
    
    /**
     * @Brief: Obtém o sobrenome do cliente
     * 
     * @Return: Sobrenome do cliente
     */
    public String getSobrenomeCliente() {
        return sobrenomeCliente;
    }
    
    /**
     * @Brief: Define o telefone do cliente
     * 
     * @Parameter: telefoneCliente Novo telefone do cliente
     */
    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    
    /**
     * @Brief: Cria um cartão para o cliente se ele não tiver um
     * 
     * @Parameter: sobrenome         Sobrenome no cartão
     * @Parameter: numeroCartao      Número do cartão
     * @Parameter: codigoVerificao   Código de verificação do cartão
     * @Parameter: dataVencimento    Data de vencimento do cartão
     */
    public void criarCartao(String sobrenome, String numeroCartao, String codigoVerificao, LocalDate dataVencimento){
        if(c == null){
            c = new Cartao(nomeCliente, sobrenome, Integer.parseInt(numeroCartao), Integer.parseInt(codigoVerificao), dataVencimento);
        }
    }
    
    /**
     * @Brief: Obtém o cartão do cliente, se ele existir
     * 
     * @Return: O cartão do cliente ou null se o cliente não tiver um cartão
     */
    public Cartao getCartao(){
        if(c != null){
            return c;
        }
        return null;
    }
}
