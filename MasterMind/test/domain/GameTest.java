/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistence.GamePersistencia;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Game.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Game instance = new Game();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDifficulty method, of class Game.
     */
    @Test
    public void testGetDifficulty() {
        System.out.println("getDifficulty");
        Game instance = new Game();
        String expResult = "";
        String result = instance.getDifficulty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPoints method, of class Game.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        Game instance = new Game();
        int expResult = 120;
        int result = instance.getPoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCargado method, of class Game.
     */
    @Test
    public void testGetCargado() {
        System.out.println("getCargado");
        Game instance = new Game();
        boolean expResult = true;
        instance.setCargado(expResult);
        boolean result = instance.getCargado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPlayer method, of class Game.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        Game instance = new Game();
        Jugador expResult = new Jugador();
        expResult.register("dani", "1213");
        instance.setPlayer(expResult);
        Jugador result = instance.getPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMode method, of class Game.
     */
    @Test
    public void testGetMode() {
        System.out.println("getMode");
        Game instance = new Game();
        String expResult = "";
        String result = instance.getMode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCargado method, of class Game.
     */
    @Test
    public void testSetCargado() {
        System.out.println("setCargado");
        boolean b = false;
        Game instance = new Game();
        instance.setCargado(b);
        boolean result = instance.getCargado();
        assertEquals(b, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setGameP method, of class Game.
     */
    @Test
    public void testSetGameP() {
        System.out.println("setGameP");
        GamePersistencia gamePer = null;
        Game instance = new Game();
        instance.setGameP(gamePer);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCB method, of class Game.
     */
    @Test
    public void testSetCB() {
        System.out.println("setCB");
        CodeBreaker cb = null;
        Game instance = new Game();
        instance.setCB(cb);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPlayer method, of class Game.
     */
    @Test
    public void testSetPlayer() {
        System.out.println("setPlayer");
        Game instance = new Game();
        Jugador expResult = new Jugador();
        expResult.register("dani", "1213");
        instance.setPlayer(expResult);
        Jugador result = instance.getPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of SaveGame method, of class Game.
     */
    @Test
    public void testSaveGame() {
        System.out.println("SaveGame");
        Game instance = new Game();
        instance.SaveGame();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of finishGame method, of class Game.
     */
    @Test
    public void testFinishGame() {
        System.out.println("finishGame");
        boolean ganado = false;
        Game instance = new Game();
        Jugador j = new Jugador();
        j.register("dani", "1213");
        instance.setPlayer(j);
        instance.finishGame(ganado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of baja_Puntuacion method, of class Game.
     */
    @Test
    public void testBaja_Puntuacion() {
        System.out.println("baja_Puntuacion");
        Game instance = new Game();
        instance.baja_Puntuacion();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of juega method, of class Game.
     */
    @Test
    public void testJuega() {
        System.out.println("juega");
        Jugador playerN = null;
        String ident = "";
        String dif = "";
        String mod = "";
        int num = 0;
        int ran = 0;
        Game instance = new Game();
        // Como los parametros estan vacios, game no podra crear la partida, de modo que no dara ningun error.
        instance.juega(playerN, ident, dif, mod, num, ran);
        
    }

    /**
     * Test of MostrarOutput method, of class Game.
     */
    @Test
    public void testMostrarOutput() {
        System.out.println("MostrarOutput");
        Game instance = new Game();
        instance.MostrarOutput();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of comenzarPartida method, of class Game.
     */
    @Test
    public void testComenzarPartida() {
        System.out.println("comenzarPartida");
        Game instance = new Game();
        instance.comenzarPartida();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
