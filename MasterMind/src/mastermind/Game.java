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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kasthan
 */
public class Game {
    
    private final String id;
    private final String difficulty;
    private final int points;
    
    public Game (String idG, String dif, int puntos){
        this.id = idG;
        this.difficulty = dif;
        this.points = puntos;
    }
    
    public Game (String idG, String dif){
        this.id = idG;
        this.difficulty = dif;
        this.points = 0;
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
