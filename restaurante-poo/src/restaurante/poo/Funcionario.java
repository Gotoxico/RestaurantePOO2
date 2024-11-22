/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

/**
 * Classe abstrata Funcionario que representa um funcionário com atributos básicos como salário, nome e e-mail.
 * A classe define métodos abstratos para calcular descontos e utiliza o padrão de projeto Template Method
 * para calcular o salário líquido, permitindo que subclasses especifiquem diferentes tipos de descontos.
 * 
 * O padrão Template Method é implementado através do método calcSalarioLiquido(), que fornece um esqueleto para o
 * cálculo do salário líquido. Esse método chama métodos abstratos que devem ser implementados por subclasses para
 * fornecer os valores específicos dos descontos de acordo com cada tipo de funcionário.
 * 
 * O uso do Template Method permite que subclasses de Funcionario especifiquem detalhes de desconto específicos sem
 * alterar o método de cálculo do salário líquido. 
 * @author rennan
 */
public abstract class Funcionario {

  // Atributos privados para salário, nome e e-mail do funcionário
  protected double salario;
  protected String nome;
  protected String email;

  /**
     * @Brief: Construtor da classe Funcionario
     * 
     * @Parameter: salario O salário base do funcionário
     * @Parameter: nome O nome do funcionário
     * @Parameter: email O e-mail do funcionário
     */
  public Funcionario(double salario, String nome, String email) {
    this.salario = salario;
    this.nome = nome;
    this.email = email;
  }

  // Métodos get e set para os atributos

  /**
     * @Brief: Retorna o salário do funcionário
     * @Return: Salário do funcionário
     */
  public double getSalario() {
      return salario;
  }

  /**
     * @Brief: Retorna o nome do funcionário
     * @Return: Nome do funcionário
     */
  public String getNome() {
      return nome;
  }

  /**
     * @Brief: Retorna o e-mail do funcionário
     * @Return: E-mail do funcionário
     */
  public String getEmail() {
      return email;
  }

  /**
     * @Brief: Define o salário do funcionário
     * @Parameter: salario Novo salário do funcionário
     */
  public void setSalario(double salario) {
      this.salario = salario;
  }

  /**
     * @Brief: Define o nome do funcionário
     * @Parameter: nome Novo nome do funcionário
     */
  public void setNome(String nome) {
      this.nome = nome;
  }

  /**
     * @Brief: Define o e-mail do funcionário
     * @Parameter: email Novo e-mail do funcionário
     */
  public void setEmail(String email) {
      this.email = email;
  }

  /**
   * Método abstrato que calcula os descontos previdenciários
   * Este método deve ser implementado por subclasses para definir a lógica específica do desconto previdenciário
   * @Return: Valor do desconto previdenciário
   */
  abstract double calcDescontosPrevidencia();

  /**
   * Método abstrato que calcula os descontos referentes ao plano de saúde
   * Este método deve ser implementado por subclasses para definir a lógica específica do desconto de plano de saúde
   * 
   * @Return: Valor do desconto do plano de saúde
   */
  abstract double calcDescontosPlanoSaude();

  /**
   * Método abstrato que calcula outros descontos aplicáveis ao funcionário
   * Este método deve ser implementado por subclasses para definir outros descontos específicos
   * 
   * @Return: Valor de outros descontos
   */
  abstract double calcOutrosDescontos();

  /**
   * Método que calcula o salário líquido do funcionário aplicando o Template Method
   * O cálculo do salário líquido segue o seguinte fluxo:
   * 1. Calcula o desconto previdenciário
   * 2. Calcula o desconto do plano de saúde
   * 3. Calcula outros descontos
   * 4. Subtrai todos os descontos do salário base
   * 
   * @Return: Salário líquido após aplicação de todos os descontos
   */
  public double calcSalarioLiquido() {
    double prev = calcDescontosPrevidencia();
    double saude = calcDescontosPlanoSaude();
    double outros = calcOutrosDescontos();
    return salario - prev - saude - outros;
  }
}
