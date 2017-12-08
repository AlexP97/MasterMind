/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.CtrlPersistenciaGame;
import utils.Pair;

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
    
    public Pair<Boolean,String> cargarPartida(String userName, String pass) {
        
        //return game.LoadGame(userName, pass);
        return new Pair(false, "Falta cargarla.");
    }
    
    public Pair<Boolean, String> crearPartida(String userName, String id, String dif, String mod, int num, int ran) {
        
        return CPG.crearPartida(userName, id, dif, mod, num, ran);
        
    }
}
