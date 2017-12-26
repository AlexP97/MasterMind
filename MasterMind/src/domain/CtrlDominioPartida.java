/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import persistence.CtrlPersistenciaGame;
import utils.Pair;

/**
 *
 * @author Daniel
 */
public class CtrlDominioPartida {
    
    private Game game;
    private final CtrlPersistenciaGame CPG;
    
    public CtrlDominioPartida() {
        
        game = new Game();
        CPG = null;
        
    }
    
    public CtrlDominioPartida(CtrlPersistenciaGame cpg) {
        
        game = new Game();
        CPG = cpg;
        
    }
    
    public Pair<Boolean,String> loadGame(String userName, String id) {
        
        Pair<Boolean,String> p = null;
        game = CPG.read("data/players/"+userName+"/games/"+id);
        if (game == null) p = new Pair(false, "No se ha podido cargar la partida");
        else p = new Pair(true, "Partida cargada correctamente");
        return p;
    }
    
    public Pair<Boolean, String> crearPartida(String userName, String id, String dif, String mod, int num, int ran) {
        
        if (CPG.crearPartida(userName, id))
        return game.crearPartida(userName, id, dif, mod, num, ran);
        else return new Pair (false, "No se ha podido crear la partida, el id ya está en uso.");
        
    }
    
    public String getId() {
        return game.getId();
    }
    
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return CPG.eliminarPartida(userName, id);
    }
    
    public boolean validarJugadaCodeM (ArrayList<Integer> cods){
        return game.validarJugadaCodeM(cods);
    }
    
    public ArrayList<Integer> getCodeIni() {
        return game.getCodeIni();
    }
    
    public Pair <Boolean, String> setCodIni(ArrayList<Integer> cods){
        return game.setCodIni(cods);
    }
    
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        return game.jugadaCodeB(cods);
    }
    
    public ArrayList<ArrayList<Integer>> getJugadasCodeB(){
        return game.getJugadasCodeB();
    }
    
    public ArrayList<Integer> jugadaCodeM(ArrayList<Integer> cods){
        return game.jugadaCodeM(cods);
    }
    
    public ArrayList<ArrayList<Integer>> getJugadasCodeM(){
        return game.getJugadasCodeM();
    }
    
    public ArrayList<String> getStatsPartida() {
        return game.getStatsPartida();
    }
    
    public Pair <Boolean,Integer> finishGame(boolean b){
        return game.finishGame(b);
    }
    
    public Pair <Boolean,String> saveGame(String userName){
        Pair <Boolean,String> p;
        p = CPG.write(game, "data/players/"+userName+"/games/"+game.getId());
        return p;
    }
}
