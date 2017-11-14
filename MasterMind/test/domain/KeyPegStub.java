package domain;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class KeyPegStub {
    
    public KeyPeg create(){
        return new KeyPeg(1,1,4);
    }
    
    public int getColour(){
        return 1;
    }
    
    public int getPosition(){
        return 1;
    }
}
