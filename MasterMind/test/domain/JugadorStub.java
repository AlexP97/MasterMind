package domain;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public class JugadorStub {
    
    public Jugador create(){
        return new Jugador();
    }
    
    public int getNFichas(){
        return 4;
    }
    
    public int getNColores(){
        return 6;
    }
}
