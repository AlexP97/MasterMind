/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Ranking {
    private ArrayList<Pair> ranking;
    
    public Ranking() throws IOException{
            File info = new File("ranking/info.txt");
            if(info.exists()) {
                String linea;
                FileReader f = new FileReader("ranking/info.txt");
                BufferedReader b = new BufferedReader(f);
                linea = b.readLine();
                b.close();
                String palabra[] = linea.split(" ");
                for(int i = 0; i < (ranking.size() * 2); i += 2){
                    Pair p = new Pair(palabra[i], Integer.parseInt(palabra[i+1]));
                        ranking.add(i/2,p);
                }
            }    
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
        Pair aux;
        if(ranking.size() < 10) {
            int i = 0;
            boolean b = false;
            for(i= 0; i < ranking.size() && !b; i++)
                b = ranking.get(i).getRight() < puntos;
            if(b) {
                for(int j = i; j < ranking.size(); j++) {
                    aux = new Pair(ranking.get(j));
                    ranking.remove(j);
                    ranking.add(j,p);
                    p = new Pair(aux);
                }
            }
            
            ranking.add(p);
        }
        else{
            for(int i = 0; i < ranking.size(); i++){
                if(ranking.get(i).getRight() < puntos){
                    for(int j = i; j < ranking.size(); j++) {
                        aux = new Pair(ranking.get(j));
                        ranking.remove(j);
                        ranking.add(j,p);
                        p = new Pair(aux);
                    }
                    System.out.print("¡Te has colocado en " + i+1 + "a posición!" + "\n");
                    return;
                }
            }
            System.out.print("No has entrado en el ranking" + "\n");
        }
    }
}