/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

import java.util.Scanner;

/**
 *
 * @author bruno.191196
 */
public class ContaBancaria {
  double saldo, limiteSaque, taxaSaque;
  String[] nomeCliente = new String[10];
  String[] cpfCliente = new String[10];
  String[] numero = new String[10];
  String[] tipo = new String[10];
  int pos=0;
  boolean cpfValido=false;
  Scanner scan = new Scanner(System.in);
  Pessoa pessoa = new Pessoa(2);
  
  void deposita(double valor) {
    System.out.println("Informe seu Nome:");
    nomeCliente[pos] = scan.next();
    while (cpfValido==false) {
      System.out.println("Informe seu CPF:");
      cpfCliente[pos] = scan.next();
      if (pessoa.validaCpf(cpfCliente[pos])==false) {
        System.out.println("O CPF informado é inválido, informe novamente:");
        cpfCliente[pos] = scan.next();
      } else {
        cpfValido=true;
      }
    }
    System.out.println("Informe o número da conta:");
    numero[pos] = scan.next();
    tipo[pos] = "Depósito";
    pos++;
    saldo = saldo + valor;
    modificaTaxaSaque();
  }
  
  void saque(double valor) {
    System.out.println("Informe seu Nome:");
    nomeCliente[pos] = scan.next();
    while (cpfValido==false) {
      System.out.println("Informe seu CPF:");
      cpfCliente[pos] = scan.next();
      if (pessoa.validaCpf(cpfCliente[pos])==false) {
        System.out.println("O CPF informado é inválido, informe novamente:");
        cpfCliente[pos] = scan.next();
      } else {
        cpfValido=true;
      }
    }
    System.out.println("Informe o número da conta:");
    numero[pos] = scan.next();
    tipo[pos] = "Saque";
    pos++;
    limiteSaque=saldo;
    if (valor>limiteSaque) {
      System.out.println("Não há saldo suficiente");
    } else {
      modificaTaxaSaque();
      saldo = saldo - valor - taxaSaque;
    }
  }
  
  void consultaHistorico() {
    for (int i=0; i<10; i++) {
      System.out.println(nomeCliente[i] + ", tipo: " + tipo[i] + " CPF: " + cpfCliente);
    }
  }
  
  void verSaldo() {
    System.out.println("Seu saldo é de " + saldo + " reais");
  }
  
  void modificaTaxaSaque() {
    if (saldo<=1000) {
      taxaSaque=3;
    }
    if (saldo>1000 && saldo<=10000) {
      taxaSaque=3.5;
    }
    if (saldo>10000) {
      taxaSaque=4;
    }
  }
}
