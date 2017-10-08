/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kasthan
 */
public class Game {
    
    private final String id;
    private final String difficulty;
    private final String mode;
    private final int points;
    
    public Game (String idG, String dif, String mod, int puntos){
        this.id = idG;
        this.difficulty = dif;
        this.mode = mod;
        this.points = puntos;
    }
    
    public Game (String idG, String dif, String mod){
        this.id = idG;
        this.difficulty = dif;
        this.mode = mod;
        this.points = 0;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getDifficulty(){
        return this.difficulty;
    }
    
    public String getMode() {
        return this.mode;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void SaveGame(String idP, String userName, String dif, String mod, int puntos, int round, Casilla[] codeIni, Round[] rondAnt) {
        
        try {
            
            FileWriter fileName = new FileWriter("games/"+idP+".txt");
            PrintWriter pw = new PrintWriter(fileName);
            
            pw.println(idP);
            pw.println(userName);
            pw.println(dif);
            pw.println(mod);
            pw.println(puntos);
            pw.println(round);
            
            for (int i = 0; i < codeIni.length; ++i) {
                
                
                
            }
            
            for (int i = 0; i < rondAnt.length; ++i) {
                
                
                
            }
            
            pw.close();
            
            out.println("Partida guardada");
            
        } catch (IOException ex) {
            
            out.println("No se ha podido guardar la partida");
            
        }
        
        
    }
    
}
