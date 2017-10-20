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
public final class CodePeg extends Casilla {
    private final int colourCode;
    private final int position;
    
    public CodePeg(int col, int pos){
        if(!colourValid(col) || !posValid(pos)) 
            throw new IllegalArgumentException("Invalid argument");
        this.colourCode = col;
        this.position = pos;
    }
    @Override
    public boolean colourValid(int col){    //1 naranja, 2 rojo, 3 azul, 4 verde, 5 amarillo, 6 lila
        return (col == 1 || col == 2 || col == 3 || col == 4 || col == 5 || col == 6);
    }
    @Override
    public boolean posValid(int pos){
        return (pos == 1 || pos == 2 || pos == 3 || pos == 4);
    }
    public int getColour(){
        return this.colourCode;
    }
    public int getPosition(){
        return this.position;
    }
}
