package restaurante.poo.Persistencia;

import java.util.List;
import java.util.ArrayList;
import restaurante.poo.Funcionario;

/**
 * Classe que gerencia a lista de funcionários com uma estratégia de persistência.
 * Pode utilizar diferentes estratégias, como arquivos binários, para salvar e carregar os funcionários.
 * Permite adicionar funcionários, realizar buscas e configurar a estratégia de persistência.
 * A implementação padrão usa a persistência em arquivos binários via StrategyArcBin.
 * 
 * @autor renna
 */
public class DataBaseFuncionarios {
    private List<Funcionario> lista_Funcionarios;
    private StrategyFuncionario strategy;

    /**
     * Construtor padrão. Inicializa a lista de funcionários e define a estratégia de persistência como StrategyArcBin.
     * Ao iniciar, carrega os funcionários salvos no arquivo binário (se existirem).
     */
    public DataBaseFuncionarios(){
        this.lista_Funcionarios = new ArrayList<>();
        this.strategy = new StrategyArcBin(); // Define a estratégia padrão para arquivos binários
        carregarFuncionarios(); // Carrega funcionários do arquivo binário
    }

    /**
     * Adiciona um funcionário à lista e o salva usando a estratégia de persistência configurada.
     * Verifica se um funcionário com o mesmo email já existe antes de adicionar.
     * 
     * @Parameter: f O funcionário a ser adicionado.
     * @return true se o funcionário foi adicionado, false se já existia um funcionário com o mesmo email.
     */
    public boolean addFuncionario(Funcionario f){
        if (!strategy.existe(f.getEmail())) {
            lista_Funcionarios.add(f);
            strategy.salvar(f); // Salva automaticamente ao adicionar
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca um funcionário na lista pelo email.
     * 
     * @Parameter: email O email do funcionário a ser buscado.
     * @return O funcionário correspondente ao email ou null se não encontrado.
     */
    public Funcionario buscaPorEmail(String email){
        for (Funcionario f : lista_Funcionarios){
            if(f.getEmail().equals(email)){
                return f;
            }
        }
        return null;
    }
    
    /**
     * Busca um funcionário na lista pelo nome.
     * 
     * @Parameter: nome O nome do funcionário a ser buscado.
     * @return O funcionário correspondente ao nome ou null se não encontrado.
     */
    public Funcionario buscaPorNome(String nome){
        for (Funcionario f : lista_Funcionarios){
            if(f.getNome().equals(nome)){
                return f;
            }
        }
        return null;
    }

    /**
     * Define a estratégia de persistência a ser utilizada.
     * Pode ser configurada para diferentes formas de armazenamento, como banco de dados, arquivos binários, etc.
     * 
     * @Parameter: strategy A nova estratégia de persistência.
     */
    public void setStrategy(StrategyFuncionario strategy){
        this.strategy = strategy;
    }

    /**
     * Retorna a lista de funcionários atualmente armazenada.
     * 
     * @return A lista de funcionários.
     */
    public List<Funcionario> getLista_Funcionarios() {
        return lista_Funcionarios;
    }

    /**
     * Substitui a lista atual de funcionários por uma nova lista.
     * 
     * @Parameter: lista_Funcionarios A nova lista de funcionários.
     */
    public void setLista_Funcionarios(List<Funcionario> lista_Funcionarios) {
        this.lista_Funcionarios = lista_Funcionarios;
    }

    /**
     * Carrega os funcionários usando a estratégia de persistência configurada.
     * Se a estratégia de persistência for `StrategyArcBin`, carrega os funcionários do arquivo binário.
     */
    public void carregarFuncionarios() {
        if (strategy instanceof StrategyArcBin) {
            lista_Funcionarios = ((StrategyArcBin) strategy).carregarTodos();
        }
    }
}
