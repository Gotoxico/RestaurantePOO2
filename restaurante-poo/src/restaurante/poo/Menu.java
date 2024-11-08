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
 * Classe que representa o menu de um restaurante
 * Contém informações sobre o restaurante, o menu, e os itens disponíveis, bem como métodos para manipular e exibir esses itens
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
    
   /**
     * @Brief: Construtor da classe Menu
     * 
     * @Parameter:  outputFactory          Fábrica para instanciar o tipo de saída (padrão de projeto)
     * @Parameter:  tipoOutput             Tipo de saída utilizado para exibição
     * @Parameter:  nomeRestaurante        Nome do restaurante
     * @Parameter:  nomeMenu               Nome do menu
     * @Parameter:  descricaoMenu          Descrição do menu
     * @Parameter:  horarioDisponibilidade Horário em que o menu está disponível
     */
    public Menu(OutputFactory outputFactory, String tipoOutput, String nomeRestaurante, String nomeMenu, String descricaoMenu, String horarioDisponibilidade) {
        this.output = outputFactory.getInstance().getTipoOutput(tipoOutput);
        this.nomeRestaurante = nomeRestaurante;
        this.nomeMenu = nomeMenu;
        this.descricaoMenu = descricaoMenu;
        this.horarioDisponibilidade = horarioDisponibilidade;
        this.itensMenu = new ArrayList<>();
    }
    
    /**
     * @Brief: obtem o nome do restaurante
     * 
     * @Return: Nome do restaurante
     */
    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    /**
     * @Brief: Define o nome do restaurante
     * 
     * @Parameter: nomeRestaurante Novo nome do restaurante
     */
    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    /**
     * @Brief: Obtem o nome do menu
     * 
     * @Return: Nome do menu
     */
    public String getNomeMenu() {
        return nomeMenu;
    }
    
    /**
     * @Brief: Define o nome do menu
     * 
     * @Parameter: nomeMenu novo nome do menu
     */
    public void setNomeMenu(String nomeMenu) {
        this.nomeMenu = nomeMenu;
    }
    
    /**
     * @Brief: Obtem a descrição do menu
     * 
     * @Return: Descrição do menu
     */
    public String getDescricaoMenu() {
        return descricaoMenu;
    }
    
    /**
     * @Brief: define a descrição do menu
     * 
     * @Parameter: descricaoMenu Nova descrição do menu
     */
    public void setDescricaoMenu(String descricaoMenu) {
        this.descricaoMenu = descricaoMenu;
    }
    
    /**
     * @Brief: Obtem o horário de disponibilidade do menu
     * 
     * @Return: Horário de disponibilidade
     */
    public String getHorarioDisponibilidade() {
        return horarioDisponibilidade;
    }
    
    /**
     * @Brief: Define o horário de disponibilidade do menu
     * 
     * @Parameter: horarioDisponibilidade Novo horário de disponibilidade
     */
    public void setHorarioDisponibilidade(String horarioDisponibilidade) {
        this.horarioDisponibilidade = horarioDisponibilidade;
    }
    
    /**
     * @Brief: Obtem a lista de itens do menu
     * 
     * @Return: Lista de itens do menu
     */
    public List<ItemMenu> getItensMenu() {
        return itensMenu;
    }
    
    /**
     * @Brief: Define a lista de itens do menu
     * 
     * @Parameter: itensMenu Nova lista de itens do menu
     */
    public void setItensMenu(List<ItemMenu> itensMenu) {
        this.itensMenu = itensMenu;
    }
    
    /**
     * @Brief: Adiciona um item ao menu
     * 
     * @Parameter: item Item a ser adicionado ao menu
     */
    public void adicionarItem(ItemMenu item) {
        this.itensMenu.add(item); //método utilizado
    }
    
    /**
     * @Brief: Remove um item do menu com base no nome e no preço
     * 
     * @Parameter: nomeItem Nome do item que sera removido
     * @Parameter: preco    Preço do item que sera removido
     */
    public void removerItem(String nomeItem, double preco) {
        for(ItemMenu item : itensMenu){
            if(item.getNome().equals(nomeItem) && item.getPreco() == preco){
                itensMenu.remove(item);
            }
        }
    }
    
    /**
     * @Brief: Atualiza um item existente no menu
     * 
     * @Parameter: itemAtualizado Item com as novas informações para atualização
     */
    public void atualizarItem(ItemMenu itemAtualizado) {
    for (int i = 0; i < itensMenu.size(); i++) {
        ItemMenu item = itensMenu.get(i);
        if (item.getNome().equals(itemAtualizado.getNome())) {
            //Atualiza o item com os novos valores //método utilizado
            itensMenu.set(i, itemAtualizado);
            output.display("Item atualizado com sucesso!");
            return;
        }
    }
    output.display("Item não encontrado no menu.");
}
    /**
     * @Brief: lista todos os itens no menu
     * 
     * @return: lista de todos os itens do menu
     */
    public List<ItemMenu> listarItens() {
        return this.itensMenu; //método utilizado
    }
    
    /**
     * @Brief: Busca um item no menu pelo nome
     * 
     * @Parameter: nome Nome do item a ser buscado
     * @Return: Item encontrado ou null se não encontrado
     */
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
    
    /**
     * @Brief: obtem o número total de itens no menu
     * 
     * @Return: total de itens no menu
     */
    public int obterTotalItens() {
        return this.itensMenu.size(); //método utilizado
    }
}
