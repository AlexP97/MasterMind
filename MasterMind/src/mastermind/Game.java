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
    Jugador player;
    Jugador IA;
    int turn;
    int totalTurns;
    String[] output;
    CodePeg[] codeIni = new CodePeg[4];
    
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
    
    private void SetCode(int i) {
        
        if (i == 1){
            System.out.print("Introduce la combinación de colores separándolos con un "
                    + "espacio. Ejemplo: 1-2-3-4" + "\n");
            
            Scanner input = new Scanner(System.in);
            
            String codIni = input.next();
            
            String casillas[] = codIni.split("-");
            
            for (int x = 0; x < 4; ++x){
                
                int n = Integer.parseInt(casillas[x]);
                if (codeIni[x].colourValid(n)) {
                    codeIni[x] = new CodePeg(n, x);
                }
            
            }
        }
        else {
            
            Random r = new Random();
            
            for (int x = 0; x < 4; ++x) {
                
                codeIni[x] = new CodePeg(r.nextInt(9), x);
                
            }
            
        }
        
    }
    
    public void Play(String ident, String userName, String dif, String mod, Jugador playerN, Jugador IAN) {
        
        if (CheckAvailability(ident, userName)){
            
            this.id = ident;
            if (dif == "Facil") this.totalTurns = 12;
            else if (dif == "Medio") this.totalTurns = 10;
            else if (dif == "Dificil") this.totalTurns = 8;
            else {
                System.out.print("Esta dificultad no esxiste" + "\n");
                return;
            }
            this.difficulty = dif;
            this.player = playerN;
            this.IA = IAN;
            
            while (turn <= totalTurns){
                
                String outputP = null;
                String outputIA = null;
                
                if (mod == "Codemaker") {
                    if (turn == 0) SetCode(1);
                    else {
                        outputP = player.Jugar(mod);
                        outputIA = IA.Jugar("Codebreaker");
                    }
                }
                else if (mod == "Codebreaker") {
                    if (turn == 0) SetCode(2);
                    else {
                        outputP = player.Jugar(mod);
                        outputIA = IA.Jugar("Codemaker");
                    }
                }
                else {
                    System.out.print("Esta modo de juego no esxiste" + "\n");
                    return;
                }
                
                output[turn] = outputP + " " + outputIA;
                
                for (int i = 0; i <= turn; ++i) {
                    
                    System.out.print(output[i] + "\n");
                    
                }
                
                ++turn;
            }
            
        }
        else {
            System.out.print("No se ha podido crear la partida. Este id ya está en uso." + "\n");
        }
    }
    
    public void LoadGame(String userName){
        
        File folder = new File("players/"+userName);
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


                        
                        while (input.hasNextLine()) {
                            String line = input.nextLine();
                            System.out.println(line);
                        }
                        input.close();
                        cargado = true;
                        System.out.print("Partida cargada!." + "\n");
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
    
    public void SaveGame(String idP, String userName, String dif, String mod, int puntos, int round, ArrayList<Casilla> codeIni, ArrayList<Round> rondAnt) {
        
        try {
            
            FileWriter fileName = new FileWriter("players/"+userName+"/"+idP+".txt");
            PrintWriter pw = new PrintWriter(fileName);
            
            pw.println(idP);
            pw.println(userName);
            pw.println(dif);
            pw.println(mod);
            pw.println(puntos);
            pw.println(round);
            
            for (int i = 0; i < codeIni.size(); ++i) {
                
                
                
            }
            
            for (int i = 0; i < rondAnt.size(); ++i) {
                
                
                
            }
            
            pw.close();
            
            out.println("Partida guardada." + "\n");
            
        } catch (IOException ex) {
            
            out.println("No se ha podido guardar la partida." + "\n");
            
        }
        
        
    }
    
}
