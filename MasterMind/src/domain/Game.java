package domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import persistence.GamePersistencia;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public class Game implements Serializable{
    
    String id;
    String difficulty;
    int points;
    String mode;
    Jugador player;
    Jugador IA;
    int turn;
    int totalTurns;
    String[] output;
    ArrayList<CodePeg> codeIni;
    ArrayList<CodePeg> codeBAnt;
    ArrayList<KeyPeg> codeMAnt;
    CodeMaker codeM;
    CodeBreaker codeB;
    boolean gameSaved;
    boolean cargado;
    boolean acierto;
    int numero;
    int rango;
    boolean jugando;
    GamePersistencia gameP;
    
    public Game () {
        this.id = null;
        this.difficulty = null;
        this.points = 150;
        this.player = null;
        this.IA = null;
        this.turn = 0;
        this.output = null;
        this.codeIni = null;
        this.gameSaved = false;
        this.cargado = false;
        this.jugando = false;
    }
    
    /**
     *
     * @return el id de la partida
     */
    public String getId() {
        return this.id;
    }
    
    /**
     *
     * @return la dificultad de la partida
     */
    public String getDifficulty(){
        return this.difficulty;
    }
    
    /**
     *
     * @return los puntos de la partida
     */
    public int getPoints() {
        return this.points;
    }
    
    public boolean getCargado() {
        return this.cargado;
    }
    
    public Jugador getPlayer() {
        return this.player;
    }
    
    public String getMode() {
        return this.mode;
    }
    
    public void setCargado(boolean b) {
        this.cargado = b;
    }
    
    public void setGameP(GamePersistencia gamePer){
        this.gameP = gamePer;
    }
    
    public void setCB(CodeBreaker cb){
        this.codeB = cb;
    }
    
    private ArrayList<CodePeg> conversorCode (ArrayList<Integer> arrayList) {
        
        ArrayList<CodePeg> lista = new ArrayList<CodePeg>();
        for (int i = 0; i < numero; ++i) {
            
            CodePeg codeP = new CodePeg(arrayList.get(i), i+1, numero, rango);
            lista.add(codeP);
            
        }
        return lista;
    }
    
    private ArrayList<KeyPeg> conversorKey (ArrayList<Integer> arrayList) {
        
        ArrayList<KeyPeg> lista = new ArrayList<KeyPeg>();
        for (int i = 0; i < numero; ++i) {
            
            KeyPeg codeP = new KeyPeg(arrayList.get(i), i+1, numero);
            lista.add(codeP);
            
        }
        return lista;
    }
    
    public void SaveGame() {
                
        boolean b = gameP.SaveGame(player.getName(), id);
        boolean b2 = true;
        
        if (mode.equals("codemaker")){

            b2 = gameP.SaveCodeB(player.getName(), id);
            
        }
        
        if (b && b2) {
            gameSaved = true;
            System.out.println("Se ha guardado la partida." + "\n");
        }
        else {
            gameSaved = false;
            return;
        }
        
    }
    
    /**
     *
     * @param ganado si el jugador ha ganado o no
     */
    public void finishGame(boolean ganado) {
        
        if (ganado) {
            if (mode.equals("codemaker")) System.out.print("¡La IA ha acertado la combinación!" + "\n");
            else {
                System.out.print("¡Has ganado la partida!" + "\n" + "Tu puntuación es: "+ points + "\n");
                Ranking ranking = Ranking.getInstance();
                ranking.actualizaRanking(player.getName(), points);
            }
        }
        else {
            System.out.print("Game Over..." + "\n" + "El código correcto era:");
            for(int i = 0; i < codeIni.size(); i++) {
                System.out.print(" " + codeIni.get(i).getColour());
            }
            System.out.println();
        }
        
    }
    
    public void baja_Puntuacion(){
        if (this.difficulty == null) return;
        else if (this.difficulty.equals("facil")) points -= 15;
        else if (this.difficulty.equals("medio")) this.points -= 10;
        else this.points -= 5;
    }
    
    private boolean SetAtributos(Jugador playerN, String ident, String dif, String mod, int num, int ran){
        
        if (cargado) {
            if (mode.equals("codemaker")) {
                this.codeM = new CodeMaker(false, numero, rango);
            }
            else if (mode.equals("codebreaker")) {
                this.codeM = new CodeMaker(true, numero, rango);
                this.codeB = new CodeBreaker(false, numero, rango);
            }   
        }
        else {
            this.id = ident;
            if (dif.equals("facil")) this.totalTurns = 12;
            else if (dif.equals("medio")) this.totalTurns = 10;
            else if (dif.equals("dificil")) this.totalTurns = 8;
            else {
                System.out.print("Esta dificultad no existe" + "\n");
                return false;
            }
            if (output == null) this.output = new String[totalTurns+1];
            this.output[0] = "--------------";
            this.difficulty = dif;
            this.player = playerN;
            this.mode = mod;
            this.points = 150;
            this.turn = 1;
            this.codeBAnt = new ArrayList<CodePeg>();
            this.codeMAnt = new ArrayList<KeyPeg>();
            this.numero = num;
            this.rango = ran;

            if (mode.equals("codemaker")) {
                this.codeM = new CodeMaker(false, numero, rango);
                this.codeIni = conversorCode(codeM.dona_patro("Player"));
            }
            else if (mode.equals("codebreaker")) {
                this.codeB = new CodeBreaker(false, numero, rango);
                this.codeM = new CodeMaker(true, numero, rango);
                this.codeIni = conversorCode(codeM.dona_patro("IA"));
            }
            else {
                    System.out.print("Este modo de juego no existe" + "\n");
                    return false;
            }
        }
        return true;
    }
    
    private String GenerarLinea( ArrayList<KeyPeg> outputM, ArrayList<CodePeg> outputB){
        
        String linea = "";
        
        for (int i = 0; i < outputB.size(); ++i) {
            int color = outputB.get(i).getColour();
            linea += Integer.toString(color) + " ";
        }

        linea += " ";

        for (int i = 0; i < outputM.size(); ++i) {
            int color = outputM.get(i).getColour();
            if (color != 2) acierto = false;
            linea += Integer.toString(color);
        }
        
        return linea;
        
    }
    
    /**
     *
     * @param playerN jugador que juega la partida
     * @param ident identificador de la partida
     * @param dif dificultad de la partida
     * @param mod modo de la partida
     * @param num número de fichas para la partida
     * @param ran rango de colores para la partida
     */
    public void juega(Jugador playerN, String ident, String dif, String mod, int num, int ran) {
                
        boolean primerTurnoCargado = cargado;

        boolean b = SetAtributos(playerN, ident, dif, mod, num, ran);
        if (!b) return;

        while (turn <= totalTurns){

            acierto = true;

            ArrayList<Integer> outputM = new ArrayList<Integer>();
            ArrayList<Integer> outputB = new ArrayList<Integer>();

            outputM.add(-1);
            outputM.add(-2);

            outputB.add(-1);
            outputB.add(-2);

            if (mode.equals("codemaker")) {
                if (!primerTurnoCargado) {
                    outputB = codeB.jugar("IA", codeBAnt, codeMAnt);
                    codeBAnt = conversorCode(outputB);
                }
                while (outputM.contains(-1) || outputM.contains(-2) || outputB.size() != numero) {
                    outputM = codeM.jugar("Player", codeBAnt, codeIni);
                    if (outputM.contains(-1)) {
                        SaveGame();
                        if (this.gameSaved) return;
                    }
                    else if (outputM.contains(-2)) return; 
                }
                codeMAnt = conversorKey(outputM);
            }
            else if (mode.equals("codebreaker")) {
                while (outputB.contains(-1) || outputB.contains(-2) || outputB.size() != numero) {
                    outputB = codeB.jugar("Player", codeBAnt, codeMAnt);
                    if (outputB.contains(-1)) {
                        SaveGame();
                        if (this.gameSaved) return;
                    }
                    else if (outputB.contains(-2)) return; 
                }
                codeBAnt = conversorCode(outputB);
                outputM = codeM.jugar("IA", codeBAnt, codeIni);
                codeMAnt = conversorKey(outputM);
            }

            primerTurnoCargado = false;

            String linea = GenerarLinea(codeMAnt, codeBAnt);

            output[turn] = linea;

            if(mode.equals("codemaker")) {
            
                System.out.print("Codigo a adivinar: ");
                for (int i = 0; i < codeIni.size(); ++i) {
                    System.out.print(codeIni.get(i).getColour() + " ");
                }
                System.out.println();

            }
            
            for (int i = 0; i <= turn; ++i) {

                    System.out.print(output[i] + "\n");

            }

            System.out.println("--------------");

            if (acierto) {
                finishGame(true);
                return;
            }
            ++turn;
            baja_Puntuacion();
        }

        finishGame(false);        
    }
    
    public void MostrarOutput() {
        
        if(mode.equals("codemaker")) {
            
            System.out.print("Codigo a adivinar: ");
            for (int i = 0; i < codeIni.size(); ++i) {
                System.out.print(codeIni.get(i).getColour() + " ");
            }
            System.out.println();
          
        }
        for (int i = 0; i < turn; ++i) {

            System.out.print(output[i] + "\n");

        }
        
    }
    
    public void comenzarPartida() {
        
        juega(player, id, difficulty, mode, numero, rango);
        
    }
    
}
