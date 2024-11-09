/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

import java.util.ArrayList;
import java.util.List;
import restaurante.poo.Output.OutputConsole;
import restaurante.poo.Output.OutputFactory;
import restaurante.poo.Output.OutputInterface;

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
    private final OutputInterface output;
    
    //Construtor da classe cheio
    public Menu(OutputFactory outputFactory, String tipoOutput, String nomeRestaurante, String nomeMenu, String descricaoMenu, String horarioDisponibilidade) {
        this.output = outputFactory.getInstance().getTipoOutput(tipoOutput);
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

    public void removerItem(String nomeItem, double preco) {
        for(ItemMenu item : itensMenu){
            if(item.getNome().equals(nomeItem) && item.getPreco() == preco){
                itensMenu.remove(item);
            }
        }
    }
    
    
    
    //Outros métodos a serem utilizados
    public void atualizarItem(ItemMenu itemAtualizado) {
    for (int i = 0; i < itensMenu.size(); i++) {
        ItemMenu item = itensMenu.get(i);
        if (item.getNome().equals(itemAtualizado.getNome())) {
            //atualiza o item com os novos valores //método utilizado
            itensMenu.set(i, itemAtualizado);
            output.display("Item atualizado com sucesso!");
            return;
        }
    }
    output.display("Item não encontrado no menu.");
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
    
    public void exibirMenu() {
        for (ItemMenu item : itensMenu) {
            output.display(item.getNome()); //método utilizado
            output.display(item.getDescricao());
            output.display(String.valueOf(item.getPreco()));
        }
    }
    
    public int obterTotalItens() {
        return this.itensMenu.size(); //método utilizado
    }
}
