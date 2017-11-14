package domain;

import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class RankingDriver {
    Ranking ranking;
    String nombre = "ajfafjlkagjlkglaglkj";
    Integer puntos = 10000;

    public RankingDriver() {
        this.ranking = Ranking.getInstance();
        testMuestraRanking();
        testActualizaRanking();
    }

    public void testMuestraRanking() {
        ArrayList<Pair<String, Integer>> result = ranking.muestraRanking();
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i).getLeft()+' '+result.get(i).getRight());
    }

    public void testActualizaRanking() {
        ranking.actualizaRanking(nombre, puntos);
        ArrayList<Pair<String, Integer>> result = ranking.muestraRanking();
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i).getLeft()+' '+result.get(i).getRight());
    }
}
