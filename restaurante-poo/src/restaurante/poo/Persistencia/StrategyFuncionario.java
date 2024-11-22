package restaurante.poo.Persistencia;


import restaurante.poo.*;
/**
 * Interface que define a estratégia de persistência para salvar os dados dos funcionarios 
 * A persistência pode envolver o armazenamento, verificação da existência de comandas.
 * Essa interface pode ser implementada de diferentes maneiras, como em um banco de dados, arquivos locais ou outros mecanismos de persistência.
 * 
 * @author renna
 */
public interface StrategyFuncionario {

    /**
     * Salva um documento emitido de acordo com a estratégia de persistência implementada.
     * O método pode ser utilizado para armazenar as informações do funcionario em um banco de dados, arquivo, etc.
     * 
     * @Parameter: funcionario O documento a ser salvo.
     */
    void salvar(Funcionario funcionario);
    
    /**
     * Verifica se um documento com o ID especificado existe.
     * O método pode ser utilizado para verificar a existência de um documento antes de tentar recuperá-lo ou atualizá-lo.
     * 
     * @Parameter: documentoId O ID do documento a ser verificado.
     * @return true se o documento existe, false caso contrário.
     */
    boolean existe(String email);
    
    
}