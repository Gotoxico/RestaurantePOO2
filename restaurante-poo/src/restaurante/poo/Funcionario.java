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