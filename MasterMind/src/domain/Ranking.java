package domain;

import utils.Pair;
import java.util.ArrayList;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class Ranking {
    private static final Ranking INSTANCE = new Ranking();
    private static ArrayList<Pair<String, Integer>> ranking;
    
    private Ranking(){}
    
    /**
     *
     * @return la única instancia de Ranking
     */
    public static Ranking getInstance(){
        return INSTANCE;
    }
    
    public void setRanking(ArrayList<Pair<String, Integer>> ranking){
        this.ranking = ranking;
    }
    /**
     *
     * @return el ranking
     */
    public ArrayList<Pair<String, Integer>> muestraRanking(){
        return ranking;
    }
    
    /**
     *
     * @param nombre el nombre del jugador que puede entrar en el ranking
     * @param puntos los puntos del jugador que puede entrar en el ranking
     * @return 
     */
    public Pair<Boolean,Integer> actualizaRanking(String nombre, int puntos){
        Pair<Boolean,Integer> entradoPosicion = new Pair();
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
                    entradoPosicion.setLeft(true);
                    entradoPosicion.setRight(i+1);
                }
            }
            if(!b) {
                System.out.print("No has entrado en el ranking" + "\n");
                entradoPosicion.setLeft(false);
            }
        }
        return entradoPosicion;
    }
}