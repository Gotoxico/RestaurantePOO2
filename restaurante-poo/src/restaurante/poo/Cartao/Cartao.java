/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Cartao;
import java.time.LocalDate;

/**
 * Classe que representa um cartão de crédito ou débito, contendo informações básicas como nome, número, código de segurança e data de vencimento
 * 
 * @author rodri
 */
public class Cartao {
    private String nome, sobrenome;
    private int numero, codigo;
    private LocalDate vencimento;

    /**
     * @Brief: Construtor da classe Cartao
     * 
     * @Parameter: nome nome do titular do cartão
     * @Parameter: sobrenome sobrenome do titular do cartão
     * @Parameter: numero numero do cartão
     * @Parameter: codigo codigo de segurança do cartão
     * @Parameter: vencimento data de vencimento do cartão
     */
    public Cartao(String nome, String sobrenome, int numero, int codigo, LocalDate vencimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
        this.codigo = codigo;
        this.vencimento = vencimento;
    }

    /**
     * @Brief: Obtém o nome do titular do cartão
     * 
     * @Return: O nome do titular
     */
    public String getNome() {
        return nome;
    }

    /**
     * @Brief: Obtém o sobrenome do titular do cartão
     * 
     * @Return: O sobrenome do titular
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @Brief: Obtém o número do cartão
     * 
     * @Return: O número do cartão
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @Brief: obtém o código de segurança do cartão 
     * 
     * @Return: O código de segurança
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @Brief: Obtém a data de vencimento do cartão
     * 
     * @Return: A data de vencimento do cartão
     */
    public LocalDate getVencimento() {
        return vencimento;
    }

    /**
     * @Brief: Define o nome do titular do cartão
     * 
     * @Parameter: nome O nome do titular
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @Brief: Define o sobrenome do titular do cartão
     * 
     * @Parameter: sobrenome o sobrenome do titular
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @Brief: Define o número do cartão
     * 
     * @Parameter: numero O número do cartão
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @Brief: Define o código de segurança do cartão
     * 
     * @Parameter: codigo O código de segurança
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @Brief: Define a data de vencimento do cartão
     * 
     * @Parameter: vencimento a data de vencimento
     */
    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }
}
