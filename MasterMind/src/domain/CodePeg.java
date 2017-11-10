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
public final class CodePeg extends Casilla {
    private final int colourCode;
    private final int position;
    
    public CodePeg(int col, int pos, int total, int rango) throws IllegalArgumentException{
        if(!colourValid(col,rango) || !posValid(pos,total)) 
            throw new IllegalArgumentException("Invalid argument");
        this.colourCode = col;
        this.position = pos;
    }
    @Override
    public boolean colourValid(int col,int rango){
        return (col > 0 && col <= rango);
    }
    @Override
    public boolean posValid(int pos,int total){
        return (pos > 0 && pos <= total);
    }
    public int getColour(){
        return this.colourCode;
    }
    public int getPosition(){
        return this.position;
    }
}
