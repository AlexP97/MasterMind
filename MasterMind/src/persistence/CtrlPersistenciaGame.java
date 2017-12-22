/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Game;
import utils.Pair;

/**
 *
 * @author dissi
 */
public class CtrlPersistenciaGame extends CtrlPersistencia{
    
    private GamePersistencia gameP;
    
    public CtrlPersistenciaGame() {
        
        gameP = new GamePersistencia();
        
    }
    
    public boolean crearPartida(String userName, String id) {
        
        return gameP.CheckAvailability(id, userName);
        
    }
    
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return gameP.eliminarPartida(userName, id);
    }
    
    public Pair <Boolean, String> write(Game object, String path){
        return super.write(object, path);
    }
    
    public Game read (String path) {
        return (Game)super.read(path);
    }
    
}
