package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    
    public Pair <Boolean, String> write(byte[] b, String s){
        Pair <Boolean,String> p = new Pair<Boolean,String>(true, "La partida se ha guardado correctamente");
        
        File file = new File(s);
        if (file.exists() && !file.isDirectory()) file.delete();
                
        FileOutputStream out;
        try {
            out = new FileOutputStream(s);
            try {
                
                out.write(b);
                out.close();
            
            } catch (IOException ex) {
               p.setLeft(false);
               p.setRight("No se ha podido guardar la partida.");
            }
            
        } catch (FileNotFoundException ex) {
            p.setLeft(false);
            p.setRight("No se ha podido guardar la partida.");
        }
        
        return p;
    }
    
    public byte[] read(String path){
        try {
            Path p = Paths.get(path);
            if (p == null) return null;
            else return Files.readAllBytes(p);
        } catch (IOException ex) {
            return null;
        }
    }
}
