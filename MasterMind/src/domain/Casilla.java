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
public abstract class Casilla {
    
    abstract boolean colourValid(int col, int rango);
    abstract boolean posValid(int pos, int total);
    
    public Casilla(){
    }
}
