/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Observador;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/** Classe abstrata necessária para a implementação do padrão Observador
 * Toda classe observada deve extender dessa clase
 * Ela inclui métodos para adicionar, remover e notificar os
 * observadores desse sujeito
 * @author renna
 */
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    
    /**
     * @Brief: Adciona observadores ao sujeito
     * 
     * @Parameter: obs observador do sujeito
     */
    public void addObserver(Observer obs){
        observers.add(obs);
    }
    
     /**
     * @Brief: Remove observador especificado do sujeito
     * 
     * @Parameter: obs observador do sujeito
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
     /**
     * @Brief: Notifica todos os observadores do sujeito e chama função update para cada um
     * 
     * @Parameter: obs observador do sujeito
     */
    public void notifyObserver(){
        Iterator<Observer> it = observers.iterator();
        
        while(it.hasNext()) {
          Observer obs= it.next();
          obs.update(this); 
    }
  }
}
