/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kasthan
 */
public class Game {
    
    String id;
    String difficulty;
    int points;
    String mode;
    Jugador player;
    Jugador IA;
    int turn;
    int totalTurns;
    int puntos;
    String[] output;
    CodePeg[] codeIni;
    CodeMaker codeM;
    CodeBreaker codeB;
    
    public Game (String idG, String dif, int puntos){
        this.id = idG;
        this.difficulty = dif;
        this.points = puntos;
        this.player = null;
        this.IA = null;
        this.turn = 0;
        this.output = null;
        this.codeIni = null;
    }
    
    public Game (String idG, String dif){
        this.id = idG;
        this.difficulty = dif;
        this.points = 0;
        this.player = null;
        this.IA = null;
        this.turn = 0;
        this.output = null;
        this.codeIni = null;
    }
    
    public Game () {
        this.id = null;
        this.difficulty = null;
        this.points = 0;
        this.player = null;
        this.IA = null;
        this.turn = 0;
        this.output = null;
        this.codeIni = null;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getDifficulty(){
        return this.difficulty;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    private boolean CheckAvailability(String ident, String userName) {
        
        boolean available = true;
        
        File folder = new File("players/"+userName);
        File[] listOfFiles = folder.listFiles();
        
        if (listOfFiles != null){
            for (int i = 0; i < listOfFiles.length && available; i++) {

                String fileName = listOfFiles[i].getName().replaceFirst("[.][^.]+$", "");
                if (fileName.equals(ident)) available = false;

            }
        }
        
        return available;
        
    }
    
    public void SaveGame() {
        
        try {
            
            FileWriter fileName = new FileWriter("players/"+player.getName()+"/games/"+id+".txt");
            PrintWriter pw = new PrintWriter(fileName);
            
            pw.println(id);
            pw.println(difficulty);
            pw.println(mode);
            pw.println(puntos);
            pw.println(turn);
            pw.println(totalTurns);
            
            for (int i = 0; i < 4; ++i) {
                
                pw.println(codeIni[i].getColour());
                
            }
            
            for (int i = 0; i < turn; ++i) {
                
                pw.println(output[i]);
                
            }
            
            pw.close();
            
            out.println("Partida guardada." + "\n");
            
        } catch (IOException ex) {
            
            out.println("No se ha podido guardar la partida." + "\n");
            
        }
        
        
    }
    
    public void finishGame(boolean ganado) {
        
        if (ganado) {
            if (mode.equals("codemaker")) System.out.print("¡La IA ha acertado la combinación!" + "\n");
            else System.out.print("¡Has ganado la partida!" + "\n");
        }
        else {
            System.out.print("Game Over..." + "\n");
        }
        
    }
    
    public void juega(Jugador playerN, String ident, String dif, String mod) {
        
        if (CheckAvailability(ident, playerN.getName())){
            
            this.codeIni = new CodePeg[4];
            this.id = ident;
            if (dif.equals("facil")) this.totalTurns = 12;
            else if (dif.equals("medio")) this.totalTurns = 10;
            else if (dif.equals("dificil")) this.totalTurns = 8;
            else {
                System.out.print("Esta dificultad no existe" + "\n");
                return;
            }
            if (output == null) this.output = new String[totalTurns];
            this.difficulty = dif;
            this.player = playerN;
            this.mode = mod;
            this.codeM = new CodeMaker();
            this.codeB = new CodeBreaker();
            this.codeIni[0] = new CodePeg(2,1);
            this.codeIni[1] = new CodePeg(2,2);
            this.codeIni[2] = new CodePeg(2,3);
            this.codeIni[3] = new CodePeg(2,4);
            
            while (turn <= totalTurns){
                
                output[turn] = "";
                
                boolean acierto = true;
                
                ArrayList<Integer> outputM = null;
                ArrayList<Integer> outputB = null;
                
                if (mod.equals("codemaker")) {
                    outputB = codeB.jugar("IA");
                    outputM = codeM.jugar("Player");
                }
                else if (mod.equals("codebreaker")) {
                    outputB = codeB.jugar("Player");
                    outputM = codeM.jugar("IA");
                }
                else {
                    System.out.print("Esta modo de juego no existe" + "\n");
                    return;
                }
                
                String linea = "";
                
                for (int i = 0; i < outputB.size(); ++i) {
                    if (outputB.get(i) == -1) SaveGame(); 
                    else {
                        linea += outputB.get(i).toString() + " ";
                    }
                }
                
                linea += " ";
                
                for (int i = 0; i < outputM.size(); ++i) {
                    if (outputM.get(i) == -1) SaveGame(); 
                    else {
                        if (outputM.get(i) != 1) acierto = false;
                        linea += outputM.get(i).toString();
                    }
                }
                
                output[turn] = linea;
                                
                for (int i = 0; i <= turn; ++i) {
                    
                    System.out.print(output[i] + "\n");
                    
                }
                
                if (acierto) {
                    finishGame(true);
                    return;
                }
                ++turn;
            }
            
            finishGame(false);
            
        }
        else {
            System.out.print("No se ha podido crear la partida. Este id ya está en uso." + "\n");
        }
    }
    
    public void LoadGame(Jugador playerP){
        
        File folder = new File("players/"+playerP.getName()+"/games/");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null){
            for (int i = 0; i < listOfFiles.length; i++) {

                String fileNameWithOutExt = listOfFiles[i].getName().replaceFirst("[.][^.]+$", "");
                Integer num = i + 1;
                System.out.println(num.toString() + " - " + fileNameWithOutExt);

            }
        
            //Leer datos de la partida y cargar el Game

            Boolean cargado = false;

            while (!cargado){            
                try {
                    
                    System.out.print("Introduce el número de la partida." + "\n");

                    Scanner input = new Scanner(System.in);

                    int num = Integer.parseInt(input.nextLine());

                    if (num - 1 >= listOfFiles.length) {
                        System.out.print("Esta partida no existe. Introduce otro número." + "\n");
                    }
                    else {
                        input = new Scanner(listOfFiles[num-1]);
                        
                        this.codeIni = new CodePeg[4];
                        
                        this.player = playerP;
                        System.out.print("Player cargado" + "\n");
                        
                        String line = input.nextLine();
                        this.id = line;
                        System.out.print("Id cargado" + "\n");
                        
                        line = input.nextLine();
                        this.difficulty = line;
                        System.out.print("Diff cargado" + "\n");
                        
                        line = input.nextLine();
                        this.mode = line;
                        System.out.print("mode cargado" + "\n");
                        
                        line = input.nextLine();
                        this.puntos = Integer.parseInt(line);
                        System.out.print("Puntos cargado" + "\n");
                        
                        line = input.nextLine();
                        this.turn = Integer.parseInt(line);
                        System.out.print("turn cargado" + "\n");
                        
                        line = input.nextLine();
                        this.totalTurns = Integer.parseInt(line);
                        System.out.print("totalturns cargado" + "\n");
                        
                        this.output = new String[totalTurns];
                                                               
                        for (int i = 0; i < 4; ++i) {

                            line = input.nextLine(); 
                            codeIni[i] = new CodePeg(Integer.parseInt(line), i+1);

                        }
                        System.out.print("Codeini cargado" + "\n");

                        for (int i = 0; i < turn; ++i) {

                            line = input.nextLine();
                            output[i] = line;

                        }
                        System.out.print("Output cargado" + "\n");
                        input.close();
                        cargado = true;
                        System.out.print("Partida cargada!" + "\n");
                        
                        for (int i = 0; i < turn; ++i) {
                    
                            System.out.print(output[i] + "\n");
                    
                        }
                        
                        juega(player, id, difficulty, mode);
                    }

                } catch (Exception ex) {
                    System.out.print("No se ha podido cargar la partida." + "\n");
                }
            }
        }
        else {
            System.out.print("No hay ninguna partida guardada." + "\n");
        }
        
    }
    
}
