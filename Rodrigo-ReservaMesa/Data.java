/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Restaurante;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Data {
    private LocalDate data;
    private ArrayList<Horario> horarios;
    private LocalTime horarioInicio, horarioFinal;

    public Data() {
    }

    public Data(LocalDate data, LocalTime horarioInicio, LocalTime horarioFinal) {
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.horarios = new ArrayList<>();
        int horas = horarioInicio.getHour();
        int minutos = horarioInicio.getMinute();
        int totalMinutos = (60*horas)+minutos;
        
        LocalTime diferenca = horarioFinal.minusMinutes(totalMinutos);
        
        int horasDiferenca = diferenca.getHour();
        int minutosDiferenca = diferenca.getMinute();
        int totalMinutosDiferenca = (60*horasDiferenca)+minutosDiferenca;
        
        int contadorMinutos = 0;
        
        while(contadorMinutos != totalMinutosDiferenca+15){
            Horario h = new Horario(horarioInicio.plusMinutes(contadorMinutos), false);
            horarios.add(h);
            contadorMinutos = contadorMinutos + 15;
        }
        
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        if(this.horarioInicio != null){
            if(this.horarioInicio.isBefore(horarioInicio)){
                int horas = horarioInicio.getHour();
                int minutos = horarioInicio.getMinute();
                int totalMinutos = (horas*60) + minutos;
                
                LocalTime diferenca = this.horarioInicio.minusMinutes(totalMinutos);
                
                int horasDiferenca = diferenca.getHour();
                int minutosDiferenca = diferenca.getMinute();
                int totalMinutosDiferenca = (horasDiferenca*60) + minutosDiferenca;
                
                int contadorMinutos = totalMinutosDiferenca + 15;
                
                while(contadorMinutos != 0){
                    horarios.remove(0);
                    contadorMinutos = contadorMinutos - 15;
                }
                
                this.horarioInicio = horarioInicio;
            }
            
            else{
                int horas = this.horarioInicio.getHour();
                int minutos = this.horarioInicio.getMinute();
                int totalMinutos = (horas*60) + minutos;
                
                LocalTime diferenca = horarioInicio.minusMinutes(totalMinutos);
                
                int horasDiferenca = diferenca.getHour();
                int minutosDiferenca = diferenca.getMinute();
                int totalMinutosDiferenca = (horasDiferenca*60) + minutosDiferenca;
                
                int contadorMinutos = totalMinutosDiferenca + 15;
                
                while(contadorMinutos != 0){
                    Horario h = new Horario(horarioInicio.plusMinutes(contadorMinutos - 15), false);
                    horarios.add(0, h);
                    contadorMinutos = contadorMinutos - 15;
                }
                
                this.horarioInicio = horarioInicio;
            }
        }
        
        else{
            if(this.horarioFinal != null){
                this.horarioInicio = horarioInicio;
                this.horarios = new ArrayList<>();
                int horas = horarioInicio.getHour();
                int minutos = horarioInicio.getMinute();
                int totalMinutos = (60*horas)+minutos;

                LocalTime diferenca = horarioFinal.minusMinutes(totalMinutos);

                int horasDiferenca = diferenca.getHour();
                int minutosDiferenca = diferenca.getMinute();
                int totalMinutosDiferenca = (60*horasDiferenca)+minutosDiferenca;

                int contadorMinutos = 0;

                while(contadorMinutos != totalMinutosDiferenca+15){
                    Horario h = new Horario(horarioInicio.plusMinutes(contadorMinutos), false);
                    horarios.add(h);
                    contadorMinutos = contadorMinutos + 15;
                }
            }
            else{
                this.horarioInicio = horarioInicio;
            }
        }
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        if(this.horarioFinal != null){
            if(this.horarioFinal.isBefore(horarioFinal)){
                int horas = horarioFinal.getHour();
                int minutos = horarioFinal.getMinute();
                int totalMinutos = (horas*60) + minutos;
                
                LocalTime diferenca = this.horarioFinal.minusMinutes(totalMinutos);
                
                int horasDiferenca = diferenca.getHour();
                int minutosDiferenca = diferenca.getMinute();
                int totalMinutosDiferenca = (horasDiferenca*60) + minutosDiferenca;
                
                int contadorMinutos = totalMinutosDiferenca + 15;
                
                while(contadorMinutos != 0){
                    Horario h = new Horario(horarioFinal.plusMinutes(contadorMinutos - 15), false);
                    horarios.add(horarios.size(), h);
                    contadorMinutos = contadorMinutos - 15;
                }
                
                this.horarioFinal = horarioFinal;
            }
            
            else{
                int horas = this.horarioFinal.getHour();
                int minutos = this.horarioFinal.getMinute();
                int totalMinutos = (horas*60) + minutos;
                
                LocalTime diferenca = horarioFinal.minusMinutes(totalMinutos);
                
                int horasDiferenca = diferenca.getHour();
                int minutosDiferenca = diferenca.getMinute();
                int totalMinutosDiferenca = (horasDiferenca*60) + minutosDiferenca;
                
                int contadorMinutos = totalMinutosDiferenca + 15;
                
                while(contadorMinutos != 0){
                    horarios.remove(horarios.size());
                    contadorMinutos = contadorMinutos - 15;
                }
                
                this.horarioFinal = horarioFinal;
            }
        }
        
        else{
            if(this.horarioInicio != null){
                this.horarioFinal = horarioFinal;
                this.horarios = new ArrayList<>();
                int horas = horarioInicio.getHour();
                int minutos = horarioInicio.getMinute();
                int totalMinutos = (60*horas)+minutos;

                LocalTime diferenca = horarioFinal.minusMinutes(totalMinutos);

                int horasDiferenca = diferenca.getHour();
                int minutosDiferenca = diferenca.getMinute();
                int totalMinutosDiferenca = (60*horasDiferenca)+minutosDiferenca;

                int contadorMinutos = 0;

                while(contadorMinutos != totalMinutosDiferenca+15){
                    Horario h = new Horario(this.horarioInicio.plusMinutes(contadorMinutos), false);
                    horarios.add(h);
                    contadorMinutos = contadorMinutos + 15;
                }
            }
            else{
                this.horarioFinal = horarioFinal;
            }
        }    
    }
    
    public void inserirReserva(LocalTime horario){
        for(Horario hora : horarios){
            if(hora.getHorario().equals(horario) && hora.isDisponibilidade() == false){
                int i = 0;
                while(i != 135){
                    int proximoIndex = horarios.indexOf(hora) + (i/15);
                    if(proximoIndex < horarios.size()){
                        horarios.get(proximoIndex).setDisponibilidade(true);
                    }
                    i = i + 15;
                }
            }
        }
    }
    
    public void cancelarReserva(LocalTime horario){
        for(Horario hora : horarios){
            if(hora.getHorario().equals(horario) && hora.isDisponibilidade()){
                int i = 0;
                while(i != 135){
                    int proximoIndex = horarios.indexOf(hora) + (i/15);
                    if(proximoIndex < horarios.size()){
                        horarios.get(proximoIndex).setDisponibilidade(false);
                    }
                    i = i + 15;
                }
            }
        }
    }
}
