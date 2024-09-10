/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Junim
 */
public class Menu {

    

    private String nomeRestaurante;
    private String nomeMenu;
    private String descricaoMenu;
    private String horarioDisponibilidade;
    private List<ItemMenu> itensMenu;
    
    //Construtor da classe vazio
    public Menu() {
    }
    
    //Construtor da classe cheio
    public Menu(String nomeRestaurante, String nomeMenu, String descricaoMenu, String horarioDisponibilidade) {
        this.nomeRestaurante = nomeRestaurante;
        this.nomeMenu = nomeMenu;
        this.descricaoMenu = descricaoMenu;
        this.horarioDisponibilidade = horarioDisponibilidade;
        this.itensMenu = new ArrayList<>();
    }
    
    //Getters e Setters da classe
    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getNomeMenu() {
        return nomeMenu;
    }

    public void setNomeMenu(String nomeMenu) {
        this.nomeMenu = nomeMenu;
    }

    public String getDescricaoMenu() {
        return descricaoMenu;
    }

    public void setDescricaoMenu(String descricaoMenu) {
        this.descricaoMenu = descricaoMenu;
    }

    public String getHorarioDisponibilidade() {
        return horarioDisponibilidade;
    }

    public void setHorarioDisponibilidade(String horarioDisponibilidade) {
        this.horarioDisponibilidade = horarioDisponibilidade;
    }

    public List<ItemMenu> getItensMenu() {
        return itensMenu;
    }

    public void setItensMenu(List<ItemMenu> itensMenu) {
        this.itensMenu = itensMenu;
    }
    
    public void adicionarItem(ItemMenu item) {
        this.itensMenu.add(item); //método utilizado
    }

    public void removerItem(ItemMenu item) {
        this.itensMenu.remove(item); //método utilizado
    }
    
    
    //Outros métodos a serem utilizados
    public void atualizarItem(ItemMenu itemAtualizado) {
    for (int i = 0; i < itensMenu.size(); i++) {
        ItemMenu item = itensMenu.get(i);
        if (item.getNome().equals(itemAtualizado.getNome())) {
            //atualiza o item com os novos valores //método utilizado
            itensMenu.set(i, itemAtualizado);
            System.out.println("Item atualizado com sucesso!");
            return;
        }
    }
    System.out.println("Item não encontrado no menu.");
}

    public List<ItemMenu> listarItens() {
        return this.itensMenu; //método utilizado
    }
    
    public ItemMenu buscarItemPorNome(String nome) {
        for (ItemMenu item : itensMenu) {
            if (item.getNome().equals(nome)) {
                return item; //método utilizado
            }
        }
        return null;
    }
    
    public List<ItemMenu> filtrarItensPorCategoria(String categoria) {
        List<ItemMenu> itensFiltrados = new ArrayList<>();
        for (ItemMenu item : itensMenu) {
            if (item.getCategoria().equals(categoria)) {
                itensFiltrados.add(item); //método utilizado
            }
        }
        return itensFiltrados;
    }
    
    public void exibirMenu() {
        for (ItemMenu item : itensMenu) {
            System.out.println(item); //método utilizado
        }
    }
    
    public int obterTotalItens() {
        return this.itensMenu.size(); //método utilizado
    }
}
