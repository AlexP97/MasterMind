/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Ranking {
    private ArrayList<Pair> ranking;
    
    public Ranking(){
        
    }
    
    public void muestraRanking(){
        if(ranking.isEmpty()){
            System.out.print("El ranking está vacío" + "\n");
            return;
        }
        for(int i = 0; i < ranking.size(); i++){
            System.out.print(i+1 + ": " + ranking.get(i).getLeft() + " " + ranking.get(i).getRight() + "\n");
        }
    }
    
    public void actualizaRanking(String nombre, int puntos){
        Pair p = new Pair(nombre,puntos);
        if(ranking.size() < 10) ranking.add(p);
        else{
            for(int i = 0; i < ranking.size(); i++){
                if(ranking.get(i).getRight() < puntos){
                    ranking.remove(i);
                    ranking.add(i,p);
                    System.out.print("¡Te has colocado en " + i+1 + "a posición!" + "\n");
                    return;
                }
            }
            System.out.print("No has entrado en el ranking" + "\n");
        }
    }
}
