package domain;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class RankingDriver {
    Ranking ranking;
    String nombre;
    Integer puntos;

    public RankingDriver() {
        Scanner input = new Scanner(System.in);
        this.ranking = Ranking.getInstance();
        System.out.println("Introduce un nombre de usuario");
        nombre = input.nextLine();
        System.out.println("Introduce unos puntos");
        puntos = Integer.parseInt(input.nextLine());
        String metodo = "prueba";
        while(!metodo.equals("salir")){
            System.out.println("¿Qué método quieres probar?");
            System.out.println("1- Actualizar el ranking.");
            System.out.println("2- Muestra el ranking.");
            System.out.println("Escribe salir para probar otra clase");
            metodo = input.nextLine();
            if(metodo.equals("1")) testActualizaRanking();
            if(metodo.equals("2")) testMuestraRanking();
            if(!metodo.equals("prueba")) System.out.println("Entrada no válida");
        }
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
