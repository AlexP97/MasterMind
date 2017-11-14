package domain;

import java.io.Serializable;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class KeyPeg extends Casilla implements Serializable{
    private final int colourKey;
    private final int position;
    
    /**
     *
     * @param col color del KeyPeg
     * @param pos posición del KeyPeg
     * @param total total de fichas
     * @throws IllegalArgumentException si el color no está dentro del rango o la posición no es válida
     */
    public KeyPeg(int col, int pos,int total) throws IllegalArgumentException {
        if(!colourValid(col,2) || !posValid(pos,total)) 
            throw new IllegalArgumentException("Invalid argument");
        this.colourKey = col;
        this.position = pos;
    }

    /**
     *
     * @param col color del KeyPeg
     * @param rango rango de colores
     * @return
     */
    @Override
    public boolean colourValid(int col, int rango){    //0 nada, 1 blanco (color bien posición mal), 2 negro (color y posición bien)
        return (col >= 0 && col <= rango);
    }

    /**
     *
     * @param pos posición del KeyPeg
     * @param total total de fichas
     * @return
     */
    @Override
    public boolean posValid(int pos, int total){
        return (pos > 0 && pos <= total);
    }

    /**
     *
     * @return el color del KeyPeg
     */
    public int getColour(){
        return this.colourKey;
    }

    /**
     *
     * @return la posición del KeyPeg
     */
    public int getPosition(){
        return this.position;
    }
}
