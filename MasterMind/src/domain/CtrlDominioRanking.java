/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import persistence.CtrlPersistenciaRanking;
import utils.Pair;

/**
 *
 * @author Daniel
 */
public class CtrlDominioRanking {
    CtrlPersistenciaRanking CPr;
    Ranking r;
    
    public CtrlDominioRanking(CtrlPersistenciaRanking CPr) {
        this.CPr = CPr;
        this.r = Ranking.getInstance();
        byte[] b = CPr.read("data/ranking/info", null);
        if (b != null){
            r.cargarRanking(b);
        }
    }  
    
    public ArrayList<Pair<String, Integer>> muestraRanking() {
        return r.muestraRanking();
    }
    public Pair<Boolean,Integer> actualizaRanking(String nombre, int puntos){
        Pair<Boolean,Integer> p = r.actualizaRanking(nombre, puntos);
        CPr.write(r.guardarRanking(), "data/ranking/info");
        return p;
    }
}
