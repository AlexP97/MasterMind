/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author dissi
 */
public class CtrlPersistenciaGame {
    
    private GamePersistencia gameP;
    
    public CtrlPersistenciaGame() {
        
        gameP = new GamePersistencia();
        
    }
    
    public boolean crearPartida(String userName, String id, String dif, String mod, int num, int ran) {
        
        return gameP.CrearPartida(userName, id, dif, mod, num, ran);
        
    }
    
}
