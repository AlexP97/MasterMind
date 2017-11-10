/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Usuario
 */
public class CodePegDriver {
    CodePeg codePeg;
    
    public void testColourValid() {
        System.out.println("colourValid");
        boolean result = codePeg.colourValid(1,4);
    }
    
    public void testPosValid() {
        System.out.println("posValid");
        boolean result = codePeg.posValid(1,4);
    }

    public void testGetColour() {
        System.out.println("getColour");
        int result = codePeg.getColour();
    }

    public void testGetPosition() {
        System.out.println("getPosition");
        int result = codePeg.getPosition();
    }
}
