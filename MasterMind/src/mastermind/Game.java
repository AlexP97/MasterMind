/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 *
 * @author kasthan
 */
public class Game {
    
    private final String id;
    private final String difficulty;
    private final String mode;
    private final int points;
    
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
    
    public void SaveGame(String idP, String dif, String mod, int puntos, int round, Casilla[] codeIni, Round[] rondAnt) {
        
    }
    
}
