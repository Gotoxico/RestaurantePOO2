/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.time.LocalDate;

/**
 *
 * @author Gabrielly
 */
public class ClienteRestaurante {
    private String nomeCliente;
    private String sobrenomeCliente;
    private String telefoneCliente;
    private Cartao c;
    
    //construtor
    public ClienteRestaurante(String nomeCliente, String sobrenomeCliente, String telefoneCliente) {
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.telefoneCliente = telefoneCliente;
    }

    //getters e setters
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setSobrenomeCliente(String sobrenomeCliente) {
        this.sobrenomeCliente = sobrenomeCliente;
    }

    public String getSobrenomeCliente() {
        return sobrenomeCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    
    public void criarCartao(String sobrenome, String numeroCartao, String codigoVerificao, LocalDate dataVencimento){
        if(c == null){
            c = new Cartao(nomeCliente, sobrenome, Integer.parseInt(numeroCartao), Integer.parseInt(codigoVerificao), dataVencimento);
        }
    }
    
    public Cartao getCartao(){
        if(c != null){
            return c;
        }
        return null;
    }
}
