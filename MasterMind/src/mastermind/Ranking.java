/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Ranking {
    private ArrayList<Pair> ranking;
    
    public Ranking() {
        try {
            File dir = new File("ranking");
            dir.mkdir();
            File info = new File("ranking/info.txt");
            ranking = new ArrayList<>();
            if(info.exists() && info.length() != 0) {
                String linea;
                FileReader f = new FileReader("ranking/info.txt");
                BufferedReader b = new BufferedReader(f);
                linea = b.readLine();
                b.close();
                String palabra[] = linea.split(" ");
                for(int i = 0; i < palabra.length; i += 2){
                    Pair p = new Pair(palabra[i], Integer.parseInt(palabra[i+1]));
                    ranking.add(i/2,p);
                }
            }
            else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(info));
                bw.close();
            } 
        } catch (IOException ex) {
                System.out.println("Error creando el ranking");
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
                    System.out.print("¡Te has colocado en " + i+1 + "a posición!" + "\n");
                }
            }
            if(!b) {
                System.out.print("No has entrado en el ranking" + "\n");
                return;
            }
            
        }
        System.out.println(ranking.get(0).getRight());
        try{
            File info = new File("ranking/info.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(info));
            for(int i = 0; i < ranking.size(); i++) {
                if(i == 0)
                    bw.write(ranking.get(i).getLeft()+" "+String.valueOf(ranking.get(i).getRight()));
                else
                    bw.write(" "+ranking.get(i).getLeft()+" "+String.valueOf(ranking.get(i).getRight()));
        }
        bw.close();
        } catch (IOException ex) {
            System.out.println("Error actualiizando el ranking");
        }    
    }
}
