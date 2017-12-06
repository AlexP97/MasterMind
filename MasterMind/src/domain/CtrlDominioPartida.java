/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.CtrlPersistenciaGame;

/**
 *
 * @author Daniel
 */
public class CtrlDominioPartida {
    
    private final Game game;
    private final CtrlPersistenciaGame CPG;
    
    public CtrlDominioPartida() {
        
        game = new Game();
        CPG = null;
        
    }
    
    public CtrlDominioPartida(CtrlPersistenciaGame cpg) {
        
        game = new Game();
        CPG = cpg;
        
    }
    
    public boolean cargarPartida(String userName, String pass) {
        
        //return game.LoadGame(userName, pass);
        return false;
    }
    
    public boolean crearPartida(String userName, String id, String dif, String mod, int num, int ran) {
        
        return CPG.crearPartida(userName, id, dif, mod, num, ran);
        
    }
}
