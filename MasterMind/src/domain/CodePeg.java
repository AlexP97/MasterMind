package domain;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class CodePeg extends Casilla {
    private final int colourCode;
    private final int position;
    
    /**
     *
     * @param col color del CodePeg
     * @param pos posición del CodePeg
     * @param total total de fichas
     * @param rango rango de colores
     * @throws IllegalArgumentException si el color no está dentro del rango o la posición no es válida
     */
    public CodePeg(int col, int pos, int total, int rango) throws IllegalArgumentException{
        if(!colourValid(col,rango) || !posValid(pos,total)) 
            throw new IllegalArgumentException("Invalid argument");
        this.colourCode = col;
        this.position = pos;
    }

    /**
     *
     * @param col color del CodePeg
     * @param rango rango de colores
     * @return si el color está dentro del rango válido
     */
    @Override
    public boolean colourValid(int col,int rango){
        return (col > 0 && col <= rango);
    }

    /**
     *
     * @param pos posición del CodePeg
     * @param total total de fichas
     * @return si la posición es válida
     */
    @Override
    public boolean posValid(int pos,int total){
        return (pos > 0 && pos <= total);
    }

    /**
     *
     * @return el color del CodePeg
     */
    public int getColour(){
        return this.colourCode;
    }

    /**
     *
     * @return la posición del CodePeg
     */
    public int getPosition(){
        return this.position;
    }
}
