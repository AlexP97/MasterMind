/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Pair;

/**
 *
 * @author Usuario
 */
public class RankingTest {
    Ranking classRanking;
    ArrayList<Pair<String, Integer>> ranking;
    String nombre;
    Integer puntos;
    
    @Before
    public void setUp() {
        classRanking = Ranking.getInstance();
        ranking = classRanking.muestraRanking();
        nombre = "lkfjaklgjalgkjglkjaggok";
        puntos = Integer.MAX_VALUE;
    }


    /**
     * Test of muestraRanking method, of class Ranking.
     */
    @Test
    public void testMuestraRanking() {
        System.out.println("muestraRanking");
        ArrayList<Pair<String, Integer>> result = classRanking.muestraRanking();
    }

    /**
     * Test of actualizaRanking method, of class Ranking.
     */
    @Test
    public void testActualizaRanking() {
        System.out.println("actualizaRanking");
        classRanking.actualizaRanking(nombre, puntos);
        ArrayList<Pair<String, Integer>> result = classRanking.muestraRanking();
        assertEquals(nombre,result.get(0).getLeft());
        assertEquals(puntos,result.get(0).getRight());
    }
}
