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
public class CtrlPersistenciaRanking extends CtrlPersistencia{
    RankingPersistencia rP;
    
    public CtrlPersistenciaRanking(){
        rP = new RankingPersistencia();
    }
    
    public ArrayList<Pair<String, Integer>> getRanking(){
        return rP.getRanking();
    }
    
    @Override
    public Pair <Boolean, String> write(byte[] ranking, String path){
        return rP.write(ranking,path);
    }
    
    @Override
    public byte[] read(String path, String s2){
        return rP.read(path);
    }
}
