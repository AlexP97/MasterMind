package domain;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class KeyPegDriver {
    KeyPeg keyPeg;
    
    public KeyPegDriver(){
        keyPeg = new KeyPeg(1,1,1);
        testColourValid();
        testPosValid();
        testGetColour();
        testGetPosition();
    }
    
    public void testColourValid() {
        boolean result = keyPeg.colourValid(1,4);
    }
    
    public void testPosValid() {
        boolean result = keyPeg.posValid(1,4);
    }

    public void testGetColour() {
        int result = keyPeg.getColour();
    }

    public void testGetPosition() {
        int result = keyPeg.getPosition();
    }
}