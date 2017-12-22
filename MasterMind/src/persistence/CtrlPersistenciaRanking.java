/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Ranking;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author User
 */
public class CtrlPersistenciaRanking extends CtrlPersistencia{
    RankingPersistencia rP;
    
    public CtrlPersistenciaRanking(){
        rP = new RankingPersistencia();
    }
    
    public ArrayList<Pair<String, Integer>> getRanking(){
        return rP.getRanking();
    }
    
    public Pair <Boolean, String> write(Ranking ranking, String path){
        return super.write(ranking,path);
    }
    
    public Ranking read(String path){
        return (Ranking)super.read(path);
    }
}
