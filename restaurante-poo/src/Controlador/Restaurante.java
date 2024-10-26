/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import restaurante.poo.Reserva.ReservaMesa;
import restaurante.poo.ClienteRestaurante;
import restaurante.poo.Garcom;
import restaurante.poo.Mesa;
/**
 *
 * @author rodri
 */
public class Restaurante {
    private ArrayList<Mesa> mesas;
        private ArrayList<Garcom> garcoms;
        private Queue <ClienteRestaurante> fila = new LinkedList<>();
        private ReservaMesa reserva;
        private ClienteRestaurante clientes[];
        private int max;
        private int cont = 0;
        
        //Classe Mesa
        public void adicionarMesa(){
            
        }
        
        public void removerMesa(){
            
        }
        
        //Classe ReservaMesa
        public void reservarMesa(LocalDate data, LocalTime hora, String nome, int quantidade){
            reserva.reservarMesa(data, hora, nome, quantidade);
        }
        
        public void cancelarReservaMesa(LocalDate data, LocalTime hora, String nome, int quantidade){
            reserva.cancelarReserva(data, hora, nome, quantidade);
        }

        //Classe ClienteRestaurante (Gabrielly)
        public void criarCliente(ClienteRestaurante c){
            if(cont<max){
                clientes[cont] = c;
                cont++;
            }
        }
        
        //Classe Garcom (Marcos)
        public void adicionarGarcom(Garcom garcom){
            this.garcoms.add(garcom);
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
