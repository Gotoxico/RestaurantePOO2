/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Cartao;
import java.time.LocalDate;

/**
 *
 * @author rodri
 */
public class Cartao {
    private String nome, sobrenome;
    private int numero, codigo;
    private LocalDate vencimento;

    public Cartao(String nome, String sobrenome, int numero, int codigo, LocalDate vencimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
        this.codigo = codigo;
        this.vencimento = vencimento;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getNumero() {
        return numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }
}
