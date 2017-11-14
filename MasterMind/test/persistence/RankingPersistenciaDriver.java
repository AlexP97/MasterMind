package persistence;

import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class RankingPersistenciaDriver {
    RankingPersistencia rp;
    
    public RankingPersistenciaDriver(){
        rp = new RankingPersistencia();
        testGetRanking();
        testActualizaRanking();
    }
    public void testGetRanking(){
        ArrayList<Pair<String, Integer>> ranking = rp.getRanking();
    }
    public void testActualizaRanking(){
        ArrayList<Pair<String, Integer>> ranking = new ArrayList();
        ranking.add(new Pair("fagagag",2));
        rp.actualizaRanking(ranking);
    }
}
