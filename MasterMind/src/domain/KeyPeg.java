/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class KeyPeg extends Casilla {
    private final int colourKey;
    private final int position;
    
    public KeyPeg(int col, int pos,int total) throws IllegalArgumentException {
        if(!colourValid(col,2) || !posValid(pos,total)) 
            throw new IllegalArgumentException("Invalid argument");
        this.colourKey = col;
        this.position = pos;
    }
    @Override
    public boolean colourValid(int col, int rango){    //0 nada, 1 blanco (color bien posición mal), 2 negro (color y posición bien)
        return (col >= 0 && col <= rango);
    }
    @Override
    public boolean posValid(int pos, int total){
        return (pos > 0 && pos <= total);
    }
    public int getColour(){
        return this.colourKey;
    }
    public int getPosition(){
        return this.position;
    }
}
