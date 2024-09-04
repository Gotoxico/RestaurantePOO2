/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurante.poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import restaurante.poo.ReservaMesa;

/**
 *
 * @author rodri
 */
public class RestaurantePoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        private ArrayList<Mesa> mesas;
        private ArrayList<Garcom> garcoms;
        private Queue <Cliente> fila = new LinkedList<>();
        private ReservaMesa reserva;
        
        //Classe Mesa
        public void adicionarMesa(){
            
        }
        
        public void removerMesa(){
            
        }
        
        //Classe ReservaMesa
        public void reservarMesa(LocalDate data, LocalTime hora, int quantidade){
            reserva.reservarMesa(data, hora, quantidade);
        }
        
        public void cancelarReservaMesa(LocalDate data, LocalTime hora, int quantidade){
            reserva.cancelarReserva(data, hora, quantidade);
        }
        
        //Classe Garcom
        public void adicionarGarcom(){
            
        }
        
        //Classe Menu
        public void adicionarItemMenu(){
            
        }
        
        public void alterarPrecoItemMenu(){
            
        }
        
        //Pedido
        public void adicionarPedido(){
            
        }
        
        
        //Pagamento pedido
        public void pagar(){
            
        }
    }
    
}
