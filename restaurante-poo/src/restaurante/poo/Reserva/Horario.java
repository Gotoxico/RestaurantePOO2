/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo.Reserva;

import java.time.LocalTime;

/**
 * Classe Horario representa um horário de reserva em um restaurante
 * Cada instância de Horario contém informações sobre o horário reservado, o nome do cliente associado e a disponibilidade do horario
 * 
 * @author rodri
 */
public class Horario {
    private LocalTime horario;
    private String nome;
    private boolean disponibilidade;

    public Horario() {
    }

    /**
     * @Brief: Construtor que permite inicializar todos os atributos da classe
     * 
     * @Parameter: horario          Horário da reserva
     * @Parameter: nome             Nome do cliente associado
     * @Parameter: disponibilidade  Status de disponibilidade do horário
     */
    public Horario(LocalTime horario, String nome, boolean disponibilidade) {
        this.horario = horario;
        this.nome = nome;
        this.disponibilidade = disponibilidade;
    }

    /**
     * @Return: o horário da reserva
     */
    public LocalTime getHorario() {
        return horario;
    }

    /**
     * @Brief: Define o horário da reserva
     * 
     * @Parameter: horario Novo horário a ser definido
     */
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    /**
     * @Return: o nome do cliente associado à reserva
     */
    public String getNome() {
        return nome;
    }

    /**
     * @Brief: Define o nome do cliente associado à reserva
     * 
     * @Parameter: nome Nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @Return: true se o horário estiver disponível e caso contrário false
     */
    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    /**
     * @Brief: Define o status de disponibilidade do horario
     * 
     * @Parameter: disponibilidade Novo status de disponibilidade
     */
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
}
