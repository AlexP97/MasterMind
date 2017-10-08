/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 *
 * @author Usuario
 */
public class KeyPeg extends Casilla {
    private final int colourKey;
    private final int position;
    
    public KeyPeg(int col, int pos){
        if(!colourValid(col) || !posValid(pos)) 
            throw new IllegalArgumentException("Invalid argument");
        this.colourKey = col;
        this.position = pos;
    }
    public boolean colourValid(int col){
        return (col == 0 || col == 1 || col == 2);
    }
    public boolean posValid(int pos){
        return (pos == 1 || pos == 2 || pos == 3 || pos == 4);
    }
    public int getColour(){
        return this.colourKey;
    }
    public int getPosition(){
        return this.position;
    }
}