/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author User
 */
public class RankingStub {
    
    public ArrayList<Pair<String, Integer>> muestraRanking(){
        ArrayList<Pair<String,Integer>> ranking = new ArrayList<>();
        Pair p = new Pair("adri",120);
        Pair p2 = new Pair("alex",100);
        Pair p3 = new Pair("dani",50);
        ranking.add(p);
        ranking.add(p2);
        ranking.add(p3);
        return ranking;
    }
}
