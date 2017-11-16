/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.CodeBreaker;
import domain.Game;
import domain.Jugador;
import java.io.File;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public class GamePersistenciaDriver {
    
    GamePersistencia gameP;
    
    public GamePersistenciaDriver() {
        
        gameP = new GamePersistencia();
	testSetGame();
	testSetCB();
	testSaveGame();
	testSaveCodeB();
	testFinder();
	testCheckAvailability() ;
        
    }
    
    public void testSetGame(){
        Game game = new Game();
        gameP.setGame(game);
    }
    
    public void testSetCB(){
        CodeBreaker cb = new CodeBreaker(false, 2, 2);
        gameP.setCB(cb);
    }
    
    public boolean testSaveGame(){
        
        testSetGame();
        return gameP.SaveGame("dani", "1213");
        
    }
    
    public boolean testSaveCodeB(){
        
        testSetGame();
        testSetCB();
        return gameP.SaveCodeB("dani", "1213");
        
    }
    
    public File[] testFinder(){
        
        return gameP.finder("data/players/dani/games/");
        
    }
    
    public boolean testCheckAvailability() {
        
        return gameP.CheckAvailability("ident", "dani");
        
    }

}
