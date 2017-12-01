/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author User
 */
public class CtrlPersistenciaRanking {
    RankingPersistencia rP;
    
    public CtrlPersistenciaRanking(){
        rP = new RankingPersistencia();
    }
    
    public ArrayList<Pair<String, Integer>> getRanking(){
        return rP.getRanking();
    }
    public void actualizaRanking(ArrayList<Pair<String, Integer>> ranking){
        rP.actualizaRanking(ranking);
    }
}
