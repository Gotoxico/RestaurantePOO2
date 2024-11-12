package restaurante.poo.Persistencia;
/**
 * Interface que define a estratégia de persistência para salvar comandas
 * A persistência pode envolver o armazenamento, recuperação e verificação da existência de comandas.
 * Essa interface pode ser implementada de diferentes maneiras, como em um banco de dados, arquivos locais ou outros mecanismos de persistência.
 * 
 * @author renna
 */
public interface PersistenciaStrategy {

    /**
     * Salva um documento emitido de acordo com a estratégia de persistência implementada.
     * O método pode ser utilizado para armazenar o documento em um banco de dados, arquivo, etc.
     * 
     * @param documento O documento a ser salvo.
     */
    void salvar();

    
    /**
     * Verifica se um documento com o ID especificado existe.
     * O método pode ser utilizado para verificar a existência de um documento antes de tentar recuperá-lo ou atualizá-lo.
     * 
     * @param documentoId O ID do documento a ser verificado.
     * @return true se o documento existe, false caso contrário.
     */
    boolean existe(String comadaID);
    
    
}