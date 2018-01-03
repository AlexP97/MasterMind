package presentation;

import domain.CtrlDominioRanking;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacionRanking {
    private final CtrlDominioRanking CDr;
    
    /**
     *
     * @param CDr el controlador de dominio de la clase Ranking
     */
    public CtrlPresentacionRanking(CtrlDominioRanking CDr){
        this.CDr = CDr;
    }
    
    /**
     *
     * @return una lista de pares que tienen un nombre de usuario y una puntuación ordenados por puntuación
     */
    public ArrayList<Pair<String, Integer>> mostrarRanking(){
        return CDr.muestraRanking();
    }
    
    /**
     *
     * @param nombre el nombre de usuario del candidato a entrar en el ranking
     * @param puntos la cantidad de puntos del candidato a entrar en el ranking
     * @return un par con un booleano que es cierto si se ha entrado en el ranking, y en qué posición se ha entrado
     */
    public Pair<Boolean,Integer> actualizaRanking(String nombre, int puntos){
        return CDr.actualizaRanking(nombre, puntos);
    }
}
