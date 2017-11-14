package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class RankingPersistencia {
    
    /**
     *
     * @return el ranking guardado
     */
    public ArrayList<Pair<String, Integer>> getRanking(){
        ArrayList<Pair<String, Integer>> ranking = new ArrayList<>();
        try {
            File dir = new File("data/ranking");
            dir.mkdir();
            File info = new File("data/ranking/info.txt");
            if(info.exists() && info.length() != 0) {
                String linea;
                FileReader f = new FileReader("data/ranking/info.txt");
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
        return ranking;
    }
    
    /**
     *
     * @param ranking el ranking que se ha de guardar
     */
    public void actualizaRanking(ArrayList<Pair<String, Integer>> ranking){
        try{
            File info = new File("data/ranking/info.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(info));
            for(int i = 0; i < ranking.size(); i++) {
                if(i == 0)
                    bw.write(ranking.get(i).getLeft()+" "+String.valueOf(ranking.get(i).getRight()));
                else
                    bw.write(" "+ranking.get(i).getLeft()+" "+String.valueOf(ranking.get(i).getRight()));
        }
        bw.close();
        } catch (IOException ex) {
            System.out.println("Error actualizando el ranking");
        }
    }
}
