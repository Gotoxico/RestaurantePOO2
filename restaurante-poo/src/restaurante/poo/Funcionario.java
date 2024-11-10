/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.poo;

/**
 *
 * @author renna
 */
abstract class Funcionario {

  double salario;
  private String nome, email;

  public Funcionario(double salario, String nome, String email) {
    this.salario = salario;
    this.nome = nome;
    this.email = email;
  }

    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
  abstract double calcDescontosPrevidencia();
  abstract double calcDescontosPlanoSaude();
  abstract double calcOutrosDescontos();

  public double calcSalarioLiquido() { // template method
    double prev = calcDescontosPrevidencia();
    double saude = calcDescontosPlanoSaude();
    double outros = calcOutrosDescontos();
    return salario - prev - saude - outros;
  }
}