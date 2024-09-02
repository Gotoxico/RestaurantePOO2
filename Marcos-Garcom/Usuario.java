/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarestaurante;

/**
 *
 * @author juniortraj
 */
public class Usuario {
    private String nome; 
    private String email;
    
    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmailGarcom(String email) {
        this.email = email;
    }
    
}
