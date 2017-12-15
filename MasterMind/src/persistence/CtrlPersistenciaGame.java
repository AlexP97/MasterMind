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
public class CtrlPersistenciaGame {
    
    private GamePersistencia gameP;
    
    public CtrlPersistenciaGame() {
        
        gameP = new GamePersistencia();
        
    }
    
    public Pair<Boolean, String> crearPartida(String userName, String id, String dif, String mod, int num, int ran) {
        
        return gameP.CrearPartida(userName, id, dif, mod, num, ran);
        
    }
    
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return gameP.eliminarPartida(userName, id);
    }
    
    public Pair <Boolean, String> write(byte[] b, String s){
        return gameP.write(b,s);
    }
    
}
