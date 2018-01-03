package domain;

import java.io.Serializable;
import utils.Pair;
import java.util.ArrayList;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class Ranking implements Serializable{
    private static Ranking INSTANCE = null;
    private static ArrayList<Pair<String, Integer>> ranking;
    
    private Ranking(){}
    
    /**
     *
     * @return la única instancia de Ranking
     */
    public static Ranking getInstance(){
        if(INSTANCE == null) INSTANCE = new Ranking();
        if(ranking == null) ranking = new ArrayList();
        return INSTANCE;
    }
    /**
     *
     * @return el ranking
     */
    public ArrayList<Pair<String, Integer>> muestraRanking(){
        if(ranking == null) ranking = new ArrayList();
        return ranking;
    }
    
    public void cargarRanking(ArrayList<Pair<String, Integer>> r) {
        this.ranking = r;
    }
    
    /**
     *
     * @param nombre el nombre del jugador que puede entrar en el ranking
     * @param puntos los puntos del jugador que puede entrar en el ranking
     * @return 
     */
    public Pair<Boolean,Integer> actualizaRanking(String nombre, int puntos){
        if(ranking == null) ranking = new ArrayList();
        Pair<Boolean,Integer> entradoPosicion = new Pair(false,"");
        Pair<String, Integer> p = new Pair(nombre,puntos);
        Pair aux;
        if(ranking.isEmpty()){
            entradoPosicion.setLeft(true);
            entradoPosicion.setRight(1);
            ranking.add(p);
        }
        else if(ranking.size() < 8) {
            entradoPosicion.setLeft(true);
            int i;
            boolean b = false;
            for(i= 0; i < ranking.size() && !b; i++) {
                b = ranking.get(i).getRight() < puntos;
            }
            if(b) {
                entradoPosicion.setRight(i);
                for(int j = i-1; j < ranking.size(); j++) {
                    aux = new Pair(ranking.get(j));
                    ranking.set(j,p);
                    p = new Pair(aux);
                }
            }
            if(!b) entradoPosicion.setRight(i+1);
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
                entradoPosicion.setLeft(false);
            }
        }
        return entradoPosicion;
    }
}