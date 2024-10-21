/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;
import java.time.LocalDate;

/**
 *
 * @author rodri
 */
public class ProxyAutenticacaoCartoes implements ProxyAutenticacaoCartoesInterface{
    private PagamentoPedido pagamento;

    public ProxyAutenticacaoCartoes() {
    }

    public ProxyAutenticacaoCartoes(PagamentoPedido pagamento) {
        this.pagamento = pagamento;
    }
    
    public boolean checarCodigo(String codigo){
        if(codigo.length() == 3 || codigo.length() == 4){
            return true;
        }
        return false;
    }
    
    public boolean checarNome(String nome, String sobrenome, String nomeCartao, String sobrenomeCartao){
        if(nome.equals(nomeCartao) && sobrenome.equals(sobrenomeCartao)){
            return true;
        }
        return false;
    }
    
    public boolean checarData(LocalDate dataCartao){
        if(LocalDate.now().isBefore(dataCartao) || LocalDate.now().isEqual(dataCartao)){
            return true;
        }
        return false;
    }
}
