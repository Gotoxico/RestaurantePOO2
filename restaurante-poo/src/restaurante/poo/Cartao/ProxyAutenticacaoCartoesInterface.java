/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante.poo.Cartao;

import java.time.LocalDate;

/**
 *
 * @author rodri
 */
public interface ProxyAutenticacaoCartoesInterface {
    boolean checarCodigo(String codigo);
    boolean checarNome(String nome, String sobrenome, String nomeCartao, String sobrenomeCartao);
    public boolean checarData(LocalDate dataCartao);
}
