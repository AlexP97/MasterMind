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
public class Pair {
    private final String left;
    private final int right;

    public Pair(String left, int right) {
      this.left = left;
      this.right = right;
    }
    
    public Pair(Pair p){
        this.left = p.getLeft();
        this.right = p.getRight();
    }

    public String getLeft() {
        return left;
    }
    
    public int getRight() {
        return right;
    }
    
}
