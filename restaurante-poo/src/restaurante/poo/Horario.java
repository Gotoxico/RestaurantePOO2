/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.time.LocalTime;

/**
 *
 * @author rodri
 */
public class Horario {
    private LocalTime horario;
    private boolean disponibilidade;

    public Horario() {
    }

    public Horario(LocalTime horario, boolean disponibilidade) {
        this.horario = horario;
        this.disponibilidade = disponibilidade;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
}
