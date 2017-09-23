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
public class AVL {

  public No raiz;
  public int COUNTIF = 0;

  public AVL() {
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
      COUNTIF++;
      if (valor == r.valor) {
        A = 1;
      } else if (valor < r.valor) {
        COUNTIF++;
        if (r.esquerda == null) {
          COUNTIF++;
          r.esquerda = no;
          no.pai = r;
          A = 1;
          
        } else {
          COUNTIF++;
          COUNTIF++;
          r = r.esquerda;
          
        }
        
      } else {
        COUNTIF++;
        COUNTIF++;
        if (r.direita == null) {
          COUNTIF++;
          r.direita = no;
          no.pai = r;
          A = 1;
          
        } else {
          COUNTIF++;
          COUNTIF++;
          r = r.direita;
          
        }
        
      }
    }
    verificarBalanceamento(no);
  }

  public boolean consulta(int valor) {
    No r = raiz;
    while (true) {
      COUNTIF++;
      if (r == null) {
        
        return false;
      }
      COUNTIF++;
      if (valor == r.valor) {
        
        return true;
      } else if (valor > r.valor) {
        COUNTIF++;
        r = r.direita;
      } else {
        COUNTIF++;
        COUNTIF++;
        r = r.esquerda;
      }
    }
  }

  private int altura(No atual) {
    COUNTIF++;
    if (atual == null) {
      return -1;
    }
    COUNTIF++;
    if (atual.esquerda == null && atual.direita == null) {
      
      return 0;
    } else if (atual.esquerda == null) {
      COUNTIF++;
      return 1 + altura(atual.direita);
    } else if (atual.direita == null) {
      COUNTIF++;
      COUNTIF++;
      return 1 + altura(atual.esquerda);
    } else {
      COUNTIF++;
      COUNTIF++;
      COUNTIF++;
      return 1 + Math.max(altura(atual.esquerda), altura(atual.direita));
    }
  }

  public void verificarBalanceamento(No atual) {
    atual.balanceamento = altura(atual.direita) - altura(atual.esquerda);
    COUNTIF++;
    if (atual.balanceamento == -2) {
      COUNTIF++;
      if (altura(atual.esquerda.esquerda) >= altura(atual.esquerda.direita)) {
        
        atual = rotacaoDireita(atual);
      } else {
        
        atual = duplaRotacaoEsquerdaDireita(atual);
      }
    } else if (atual.balanceamento == 2) {
      COUNTIF++;
      if (altura(atual.direita.direita) >= altura(atual.direita.esquerda)) {
        COUNTIF++;
        atual = rotacaoEsquerda(atual);
      } else {
        COUNTIF++;
        COUNTIF++;
        atual = duplaRotacaoDireitaEsquerda(atual);
      }
    }
    COUNTIF++;
    if (atual.pai != null) {
      
      verificarBalanceamento(atual.pai);
    }
  }

  public No rotacaoEsquerda(No inicial) {

    No direita = inicial.direita;
    direita.pai = inicial.pai;

    inicial.direita = (direita.esquerda);
    COUNTIF++;
    if (inicial.direita != null) {
      
      inicial.direita.pai = (inicial);
    }
    direita.esquerda = (inicial);
    inicial.pai = (direita);
    COUNTIF++;
    if (direita.pai != null) {
      COUNTIF++;
      if (direita.pai.direita == inicial) {
        
        direita.pai.direita = (direita);
      } else if (direita.pai.esquerda == inicial) {
        COUNTIF++;
        direita.pai.esquerda = (direita);
      }
    }

    inicial.balanceamento = altura(inicial.direita) - altura(inicial.esquerda);
    direita.balanceamento = altura(direita.direita) - altura(direita.esquerda);

    return direita;
  }

  public No rotacaoDireita(No inicial) {

    No esquerda = inicial.esquerda;
    esquerda.pai = (inicial.pai);
    inicial.esquerda = (esquerda.direita);
    COUNTIF++;
    if (inicial.esquerda != null) {
      inicial.esquerda.pai = (inicial);
    }
    esquerda.direita = (inicial);
    inicial.pai = (esquerda);

    COUNTIF++;
    if (esquerda.pai != null) {
      COUNTIF++;
      if (esquerda.pai.direita == inicial) {
        esquerda.pai.direita = (esquerda);
      } else if (esquerda.pai.esquerda == inicial) {
        COUNTIF++;
        esquerda.pai.esquerda = (esquerda);
      }
    }

    inicial.balanceamento = altura(inicial.direita) - altura(inicial.esquerda);
    esquerda.balanceamento = altura(esquerda.direita) - altura(esquerda.esquerda);

    return esquerda;
  }

  public No duplaRotacaoEsquerdaDireita(No inicial) {
    inicial.esquerda = (rotacaoEsquerda(inicial.esquerda));
    return rotacaoDireita(inicial);
  }

  public No duplaRotacaoDireitaEsquerda(No inicial) {
    inicial.direita = (rotacaoDireita(inicial.direita));
    return rotacaoEsquerda(inicial);
  }
}
