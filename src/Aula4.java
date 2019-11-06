/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

import java.util.Scanner;

/**
 * Palavras reservadas para definir visibilidade:
 *             | Class | Package | Subclass | Subclass | World
 *             |       |         |(same pkg)|(diff pkg)| 
 * ————————————+———————+—————————+——————————+——————————+————————
 * public      |   +   |    +    |    +     |     +    |   +     
 * ————————————+———————+—————————+——————————+——————————+————————
 * protected   |   +   |    +    |    +     |     +    |         
 * ————————————+———————+—————————+——————————+——————————+————————
 * default     |   +   |    +    |    +     |          |    
 * ————————————+———————+—————————+——————————+——————————+————————
 * private     |   +   |         |          |          |    
 * 
 * @author darolt
 */
public class Aula4 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    String valor;
    Scanner scan = new Scanner(System.in);
    Pessoa pessoa = new Pessoa(2);
    // cpf é privado, não pode ser acessado fora da classe Pessoa
    // pessoa.cpf = "123.456.789-10";
    // usamos um Setter (método que atribui valores a atributos de um objeto)
    pessoa.setCpf("044.418.410-43");
    // usamos um Getter (método que retorna um atributo que normalmente é privado)
    System.out.println(pessoa.getCpf());
    
    //pessoa.idade = 10;
    pessoa.envelhece(10);
    pessoa.envelhece(150);
    
    valor = scan.next();
  }
  
}
