package domain;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CodePegStub {
    
    public CodePeg create(){
        return new CodePeg(1,1,4,6);
    }
    
    public int getColour(){
        return 1;
    }
    
    public int getPosition(){
        return 1;
    }
}
