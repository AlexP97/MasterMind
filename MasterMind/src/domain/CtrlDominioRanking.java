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
 * @author Daniel
 */
public class CtrlDominioRanking {
    
    public CtrlDominioRanking() {
        
    }
    
    public ArrayList<Pair<String, Integer>> muestraRanking() {
        Ranking r = Ranking.getInstance();
        return r.muestraRanking();
    }
}
