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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        ByteArrayInputStream bis = new ByteArrayInputStream(CPG.read("data/players/"+userName+"/games/"+id));
        ObjectInput in = null;
        try {
                
            in = new ObjectInputStream(bis);
            
            try {

                game = (Game)in.readObject();

            } catch (ClassNotFoundException ex) {
                p = new Pair<Boolean,String>(false, "No se ha podido cargar la partida");
            } 
        }catch (IOException ex) {
            p = new Pair<Boolean,String>(false, "No se ha podido cargar la partida");
        } finally {
          try {
            if (in != null) {
              in.close();
              p = new Pair<Boolean,String>(true, "Se ha cargado la partida correctamente");
            }
          } catch (IOException ex) {
            p = new Pair<Boolean,String>(false, "No se ha podido cargar la partida");
          }
        }
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
    
    public Pair <Boolean, String> setCodIni(ArrayList<Integer> cods){
        return game.setCodIni(cods);
    }
    
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        return game.jugadaCodeB(cods);
    }
    
    public ArrayList<Integer> jugadaCodeM(ArrayList<Integer> cods){
        return game.jugadaCodeM(cods);
    }
    
    public Pair <Boolean,Integer> finishGame(boolean b){
        return game.finishGame(b);
    }
    
    public Pair <Boolean,String> saveGame(String userName){
        Pair <Boolean,String> p = new Pair<Boolean,String>();
        byte[] b = game.SaveGame();
        if (b != null) {
            p = CPG.write(b, "data/players/"+userName+"/games/"+game.getId());
        }
        else {
            p.setLeft(false);
            p.setRight("No se ha podido guardar la partida.");
        }
        return p;
    }
}
