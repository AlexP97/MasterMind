/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Usuario
 */
public class Pair<F,S> {
    private final F left;
    private final S right;

    public Pair(F left, S right) {
      this.left = left;
      this.right = right;
    }
    
    public Pair(Pair p){
        this.left = (F) p.getLeft();
        this.right = (S) p.getRight();
    }

    public F getLeft() {
        return left;
    }
    
    public S getRight() {
        return right;
    }
    
}
