/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class CodePegTest {
    CodePeg codePeg;
    CodePeg codePegNoValid;
    
    @Before
    public void setUp() {
        codePeg = new CodePeg(1,1);
    }
    

    /**
     * Test of colourValid method, of class CodePeg.
     */
    @Test
    public void testColourValid() {
        System.out.println("colourValid");
        boolean expResult = true;
        boolean result = codePeg.colourValid(1);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of colourValid method, of class CodePeg.
     */
    @Test
    public void testColourNoValid() {
        System.out.println("colourNoValid");
        boolean expResult = false;
        boolean result = codePeg.colourValid(8);
        assertEquals(expResult, result);
    }

    /**
     * Test of posValid method, of class CodePeg.
     */
    @Test
    public void testPosValid() {
        System.out.println("posValid");
        boolean expResult = true;
        boolean result = codePeg.posValid(1);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of posValid method, of class CodePeg.
     */
    @Test
    public void testPosNoValid() {
        System.out.println("posNoValid");
        boolean expResult = false;
        boolean result = codePeg.posValid(8);
        assertEquals(expResult, result);
    }

    /**
     * Test of getColour method, of class CodePeg.
     */
    @Test
    public void testGetColour() {
        System.out.println("getColour");
        int expResult = 1;
        int result = codePeg.getColour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPosition method, of class CodePeg.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        int expResult = 1;
        int result = codePeg.getPosition();
        assertEquals(expResult, result);
    }
    /**
     * Test of creation method, of class KeyPeg.
     */
    @Test
    public void testCreateKegPegColourException() {
        System.out.println("createCodePegColourException");
        try{
            codePegNoValid = new CodePeg(8,1);
        } catch (IllegalArgumentException ex){
            return;
        }
        fail("La excepción no se ha lanzado");
    }

    /**
     * Test of creation method, of class KeyPeg.
     */
    @Test
    public void testCreateKegPegPositionException() {
        System.out.println("createCodePegPositionException");
        try{
            codePegNoValid = new CodePeg(1,8);
        } catch (IllegalArgumentException ex){
            return;
        }
        fail("La excepción no se ha lanzado");
    }
}
