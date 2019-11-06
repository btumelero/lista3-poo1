/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 *
 * @author darolt
 */
public class Pessoa {
  // 
  private String cpf;

  public void setCpf(String cpf) {
    if (validaCpf(cpf)==true) {
      this.cpf = cpf;
    } else {
      System.out.println("O CPF a seguir é inválido!");
    }
    this.cpf = cpf;
  }
  
  public String getCpf() {
    return cpf;
  }
  
  Pessoa(int idade) {
    // idade da pessoa no momento do registro
    this. idade = idade;
  }
  
  public int getIdade() {
    return idade;
  }
  
  public void envelhece(int anos) {
    if (idade+anos > IDADE_MAX) {
      idade = IDADE_MAX;
      vivo = false;
    } else {
      idade = idade + anos;  
    }
  }
  
  public boolean validaCpf(String cpf) {
    int digito, cont=0;
    char letra;
    int[] vetorCpf = {0,0,0,0,0,0,0,0,0,0,0};
    for (int c=0; c<14; c++) {
      if (c==3 || c==7 || c==11) {
        continue;
      } else {
        letra = cpf.charAt(c);
        vetorCpf[cont] = Character.getNumericValue(letra);
        cont++;
      }
    }
    for (int j=10; j<=11; j++) {
      digito=0;
      for (int i=j; i>=2; i--) {
        digito = digito + (vetorCpf[j-i]*i);
      }
      digito = digito % 11;
      if (digito==0 || digito==1) {
        if (vetorCpf[j-1]!=0) {
          return false;
        }
      } 
      else {
        if (vetorCpf[j-1]!=11-digito) {
          return false;
        }
      }
    }
    return true;
  }
  
  private int idade;
  private boolean vivo = true;
  private int IDADE_MAX = 100;
  
}
