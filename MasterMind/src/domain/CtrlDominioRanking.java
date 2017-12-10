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
        this.r = Ranking.getInstance();
        r.setRanking(this.getRanking());
        this.CPr = CPr;
        r.setRanking(CPr.getRanking());
    }
    
    public ArrayList<Pair<String, Integer>> muestraRanking() {
        return r.muestraRanking();
    }
    public void actualizaRanking(String nombre, int puntos){
        r.actualizaRanking(nombre, puntos);
        CPr.actualizaRanking(r.muestraRanking());
    }
    public final ArrayList<Pair<String, Integer>> getRanking(){
        CtrlPersistenciaRanking ctrlPR = new CtrlPersistenciaRanking();
        return ctrlPR.getRanking();
    }
}
