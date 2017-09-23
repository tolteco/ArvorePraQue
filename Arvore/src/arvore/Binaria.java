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
public class Binaria {

  public No raiz;
  public int COUNTIF = 0;

  public Binaria() {
    raiz = null;
  }

  public void insere(int valor) {
    No no = new No(valor);
    No r = raiz;
    int A = 0;

    if (raiz == null) {
      raiz = no;
      A = 1;
    }
    COUNTIF++;

    while (A == 0) {
      if (valor == r.valor) {
        A = 1;
        COUNTIF++;
      } else if (valor < r.valor) {
        if (r.esquerda == null) {
          r.esquerda = no;
          A = 1;
          COUNTIF++;
        } else {
          r = r.esquerda;
          COUNTIF++;
        }
        COUNTIF++;
      } else {
        if (r.direita == null) {
          r.direita = no;
          A = 1;
          COUNTIF++;
        } else {
          r = r.direita;
          COUNTIF++;
        }
        COUNTIF++;
      }
    }
  }

  public boolean consulta(int valor) {
    No r = raiz;
    while (true) {
      if (r == null) {
        COUNTIF++;
        return false;
      }
      if (valor == r.valor) {
        COUNTIF++;
        return true;
      } else if (valor > r.valor) {
        COUNTIF++;
        r = r.direita;
      } else {
        COUNTIF++;
        r = r.esquerda;
      }
    }
  }
}
