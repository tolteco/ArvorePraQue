/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

/**
 *
 * @author Maycon
 */
public class No {

  public int valor;
  public int balanceamento;
  public No direita;
  public No esquerda;
  public No pai;

  public No(int valor) {
    this.valor = valor;
    direita = null;
    esquerda = null;
    balanceamento = 0;
    pai = null;
  }
}
