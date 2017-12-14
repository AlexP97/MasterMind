/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
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
        
        Pair<Boolean,String> p = CPG.crearPartida(userName, id, dif, mod, num, ran);
        if (p.getLeft())
        return game.crearPartida(userName, id, dif, mod, num, ran);
        else return p;
        
    }
    
    public String getId() {
        return game.getId();
    }
    
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return CPG.eliminarPartida(userName, id);
    }
    
    public Pair <Boolean, String> setCodIni(ArrayList<Integer> cods){
        return game.setCodIni(cods);
    }
    
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        return game.jugadaCodeB(cods);
    }
    
    public Pair <Boolean,Integer> finishGame(boolean b){
        return game.finishGame(b);
    }
}
