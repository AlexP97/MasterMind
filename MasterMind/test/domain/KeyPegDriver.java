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