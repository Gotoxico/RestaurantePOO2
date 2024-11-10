/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe que define constantes de horário para o restaurante
 * 
 * @author renna
 */
public class Constantes {
    /**
     * Hora de início do funcionamento do restaurante (17:00)
     */
    public static final LocalTime HORARIO_INICIO = LocalTime.of(17, 0);  
    
    /**
     * Hora do encerramento do funcionamento do restaurante (23:00)
     */
    public static final LocalTime HORARIO_TERMINO = LocalTime.of(23, 0); 
    
    public static final double SALARIO_MINIMO = 1412;
}
