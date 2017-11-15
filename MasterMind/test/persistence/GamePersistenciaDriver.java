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
    
    public boolean testSaveCodeP(){
        
        testSetGame();
        testSetCB();
        return gameP.SaveGame("dani", "1213");
        
    }
    
    public File[] testFinder(){
        
        return gameP.finder("data/players/dani/games/");
        
    }
    
    public void testLoadGame() {
        
        Jugador j = new Jugador();
        j.register("dani", "1213");
        gameP.LoadGame(j);
        
    }
    
    public boolean testCheckAvailability() {
        
        return gameP.CheckAvailability("ident", "dani");
        
    }
    public void testCrearPartida(){
        
        Jugador j = new Jugador();
        j.register("dani", "1213");
        gameP.CrearPartida(j, "ident", "facil", "codemaker", 3, 3);
        
    }
}
