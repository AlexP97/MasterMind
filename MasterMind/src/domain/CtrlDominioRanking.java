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
 * @author Martínez Martínez, Daniel
 */
public class CtrlDominioRanking {
    CtrlPersistenciaRanking CPr;
    Ranking r;
    
    /**
     *
     * @param CPr el controlador de persistencia de la clase Ranking
     */
    public CtrlDominioRanking(CtrlPersistenciaRanking CPr) {
        this.CPr = CPr;
        this.r = Ranking.getInstance();
        ArrayList<Pair<String, Integer>> ran = CPr.read("data/ranking/info");
        if (ran != null) this.r.cargarRanking(ran);
    }  
    
    /**
     *
     * @return una lista de pares que tienen un nombre de usuario y una puntuación ordenados por puntuación
     */
    public ArrayList<Pair<String, Integer>> muestraRanking() {
        return r.muestraRanking();
    }
    
    /**
     *
     * @param nombre el nombre de usuario del candidato a entrar en el ranking
     * @param puntos la cantidad de puntos del candidato a entrar en el ranking
     * @return un par con un booleano que es cierto si se ha entrado en el ranking, y en qué posición se ha entrado
     */
    public Pair<Boolean,Integer> actualizaRanking(String nombre, int puntos){
        Pair<Boolean,Integer> p = r.actualizaRanking(nombre, puntos);
        CPr.write(this.r.muestraRanking(), "data/ranking/info");
        return p;
    }
}
