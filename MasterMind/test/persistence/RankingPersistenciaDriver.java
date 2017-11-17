package persistence;

import domain.Ranking;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class RankingPersistenciaDriver {
    Ranking ranking;
    RankingPersistencia rp;
    String nombre;
    int puntos;
    
    public RankingPersistenciaDriver(){
        this.ranking = Ranking.getInstance();
        Scanner input = new Scanner(System.in);
        rp = new RankingPersistencia();
        String metodo = "prueba";
        while(!metodo.equals("salir")){
            System.out.println("¿Qué método quieres probar?");
            System.out.println("1- Actualizar el ranking.");
            System.out.println("2- Muestra el ranking.");
            System.out.println("Escribe salir para probar otra clase");
            metodo = input.nextLine();
            if(metodo.equals("1")) testActualizaRanking();
            else if(metodo.equals("2")) testGetRanking();
            else if(!metodo.equals("prueba")) System.out.println("Entrada no válida");
        }
    }
    public void testGetRanking(){
        ArrayList<Pair<String, Integer>> result = rp.getRanking();
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i).getLeft()+' '+result.get(i).getRight());
    }
    public void testActualizaRanking(){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un nombre de usuario");
        nombre = input.nextLine();
        System.out.println("Introduce unos puntos");
        puntos = Integer.parseInt(input.nextLine());
        ranking.actualizaRanking(nombre, puntos);
        ArrayList<Pair<String, Integer>> result = ranking.muestraRanking();
        rp.actualizaRanking(result);
        ArrayList<Pair<String, Integer>> result2 = rp.getRanking();
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i).getLeft()+' '+result.get(i).getRight());
    }
}
