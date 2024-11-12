package restaurante.poo.Persistencia;

import java.io.*;
import restaurante.poo.Funcionario;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe que implementa arquivos binários para salvar, carregar e verificar as informações dos funcionários.
 * Utiliza o padrão Strategy para definir uma estratégia de persistência de dados.
 * @see Funcionario
 * @see StrategyFuncionario
 * @author ren
 */
public class StrategyArcBin implements StrategyFuncionario {
    private static final String FILE_PATH = "funcionarios.bin";

    /**
     * Salva as informações de um funcionário no arquivo binário.
     * @param funcionario O funcionário a ser salvo no arquivo.
     */
    @Override
    public void salvar(Funcionario funcionario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
            oos.writeObject(funcionario);
        } catch (IOException e) {
            System.err.println("Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    /**
     * Verifica se existe um funcionário no arquivo binário com o e-mail especificado.
     * 
     * O método percorre o arquivo binário, lendo cada objeto de funcionário e 
     * comparando o e-mail.
     * 
     * @param email O e-mail do funcionário a ser verificado.
     * @return true se o funcionário com o e-mail existe, false caso contrário.
     */
    @Override
    public boolean existe(String email) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            while (true) {
                Funcionario funcionario = (Funcionario) ois.readObject();
                if (funcionario.getEmail().equals(email)) {
                    return true;
                }
            }
        } catch (EOFException e) {
            return false; // Fim do arquivo, funcionário não encontrado
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao verificar funcionário: " + e.getMessage());
        }
        return false;
    }

    /**
     * Carrega todos os funcionários salvos no arquivo binário.
     * 
     * Este método percorre o arquivo binário, deserializando e carregando todos 
     * os objetos de funcionários em uma lista.
     * 
     * @return Uma lista contendo todos os funcionários carregados do arquivo.
     */
    public List<Funcionario> carregarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            while (true) {
                Funcionario funcionario = (Funcionario) ois.readObject();
                funcionarios.add(funcionario);
            }
        } catch (EOFException e) {
            // Fim do arquivo, todos os funcionários foram carregados
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar funcionários: " + e.getMessage());
        }
        return funcionarios;
    }
}
