/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante.poo;

/**
 *
 * @author rodri
 */
public interface SubjectQueue {
    void adicionarObserver(ObserverQueue observerQueue);
    void removerObserver(ObserverQueue observerQueue);
    void notifyObservers(Pessoa pessoa);
}
