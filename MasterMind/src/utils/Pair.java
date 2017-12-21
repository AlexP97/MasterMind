package utils;

import java.io.Serializable;


/**
 *
 * @author Espejo Saldaña, Adrián
 * @param <F>
 * @param <S>
 */
public class Pair<F,S> implements Serializable{
    private F left;
    private S right;
    
    public Pair() {
        left = null;
        right = null;
    }

    /**
     *
     * @param left primer atributo del par
     * @param right segundo atributo del par
     */
    public Pair(F left, S right) {
      this.left = left;
      this.right = right;
    }
    
    /**
     *
     * @param p par que se quiere copiar
     */
    public Pair(Pair p){
        this.left = (F) p.getLeft();
        this.right = (S) p.getRight();
    }

    /**
     *
     * @return devuelve el primer atributo del par
     */
    public F getLeft() {
        return left;
    }
    
    /**
     *
     * @return devuelve el segundo atributo del par
     */
    public S getRight() {
        return right;
    }
    
    /**
     *
     * @param valor valor que se quiere dar al primer atributo del par
     */
    public void setLeft(F valor) {
        left = valor;
    }
    
    /**
     *
     * @param valor valor que se quiere dar al segundo atributo del par
     */
    public void setRight(S valor) {
        right = valor;
    }
    
}
