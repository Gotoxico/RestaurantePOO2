/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemarestaurante;

/**
 *
 * @author Gabrielly
 */
public class ClienteRestaurante {
    
    private String nomeCliente;
    private String telefoneCliente;
    
    //construtor
    public ClienteRestaurante(String nomeCliente, String telefoneCliente) {
        this.nomeCliente = nomeCliente;
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

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    
}
