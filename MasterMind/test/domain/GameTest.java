package domain;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        String expResult = null;
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
        String expResult = null;
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
        int expResult = 150;
        int result = instance.getPoints();
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
        instance.juega(playerN, ident, dif, mod, num, ran);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of finder method, of class Game.
     */
    @Test
    public void testFinder() {
        System.out.println("finder");
        String dirName = "";
        Game instance = new Game();
        File[] expResult = null;
        File[] result = instance.finder(dirName);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of LoadGame method, of class Game.
     */
    @Test
    public void testLoadGame() {
        System.out.println("LoadGame");
        Jugador playerP = null;
        Game instance = new Game();
        instance.LoadGame(playerP);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
