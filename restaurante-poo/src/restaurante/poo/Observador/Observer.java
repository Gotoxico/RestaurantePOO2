/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante.poo.Observador;

/** Classe utilizada para aplicar o padrão Observador no projeto
 * Define necessidade da função update.
 * Implementada por garçom e outros
 * @author renna
 */
public interface Observer {
    
    void update(Subject s);
}
