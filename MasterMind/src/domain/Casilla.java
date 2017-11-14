package domain;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public abstract class Casilla {
    
    abstract boolean colourValid(int col, int rango);
    abstract boolean posValid(int pos, int total);
    
    public Casilla(){
    }
}
