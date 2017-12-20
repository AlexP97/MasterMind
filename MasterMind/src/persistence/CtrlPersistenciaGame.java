/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

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
    
    @Override
    public Pair <Boolean, String> write(byte[] serial, String path){
        return gameP.write(serial,path);
    }
    
    @Override
    public byte[] read (String path, String s2) {
        return gameP.read(path);
    }
    
}
