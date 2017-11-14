/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import utils.Pair;
import java.util.ArrayList;
import persistence.RankingPersistencia;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class Ranking {
    private static final Ranking INSTANCE = new Ranking();
    private static ArrayList<Pair<String, Integer>> ranking;
    
    private Ranking(){}
    
    public static Ranking getInstance(){
        RankingPersistencia rp = new RankingPersistencia();
        ranking = rp.getRanking();
        return INSTANCE;
    }
    
    public ArrayList<Pair<String, Integer>> muestraRanking(){
        return ranking;
    }
    
    public void actualizaRanking(String nombre, int puntos){
        Pair<String, Integer> p = new Pair(nombre,puntos);
        Pair aux;
        if(ranking.size() < 10) {
            int i;
            boolean b = false;
            for(i= 0; i < ranking.size() && !b; i++) {
                b = ranking.get(i).getRight() < puntos;
            }
            if(b) {
                for(int j = i-1; j < ranking.size(); j++) {
                    aux = new Pair(ranking.get(j));
                    ranking.set(j,p);
                    p = new Pair(aux);
                }
            }
            ranking.add(p);
        }
        else{
            boolean b = false;
            for(int i = 0; i < ranking.size() && !b; i++){
                if(ranking.get(i).getRight() < puntos){
                    b = true;
                    for(int j = i; j < ranking.size(); j++) {
                        aux = new Pair(ranking.get(j));
                        ranking.set(j,p);
                        p = new Pair(aux);
                    }
                    System.out.print("¡Te has colocado en " + i+1 + "a posición!" + "\n");
                }
            }
            if(!b) {
                System.out.print("No has entrado en el ranking" + "\n");
                return;
            }
            
        }
        RankingPersistencia rp = new RankingPersistencia();
        rp.actualizaRanking(ranking);
    }
    
}