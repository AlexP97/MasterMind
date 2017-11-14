package domain;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class CodePegDriver {
    CodePeg codePeg;
    
    public CodePegDriver(){
        codePeg = new CodePeg(1,1,1,1);
        testColourValid();
        testPosValid();
        testGetColour();
        testGetPosition();
    }
    
    public void testColourValid() {
        boolean result = codePeg.colourValid(1,4);
    }
    
    public void testPosValid() {
        boolean result = codePeg.posValid(1,4);
    }

    public void testGetColour() {
        int result = codePeg.getColour();
    }

    public void testGetPosition() {
        int result = codePeg.getPosition();
    }
}
