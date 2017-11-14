/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Martínez Martínez, Daniel
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
    
    public String getId() {
        return this.id;
    }
    
    public String getDifficulty(){
        return this.difficulty;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    private ArrayList<CodePeg> conversorCode (ArrayList<Integer> arrayList) {
        
        ArrayList<CodePeg> lista = new ArrayList<CodePeg>();
        for (int i = 0; i < numero; ++i) {
            
            if (arrayList.get(i) != -1 && arrayList.get(i) != -2) {
                CodePeg codeP = new CodePeg(arrayList.get(i), i+1, numero, rango);
                lista.add(codeP);
            }
            else {
                acierto = false;
                if (arrayList.get(i) == -1) SaveGame();
                else gameSaved = true;
                return null;
            }
            
        }
        return lista;
    }
    
    private ArrayList<KeyPeg> conversorKey (ArrayList<Integer> arrayList) {
        
        ArrayList<KeyPeg> lista = new ArrayList<KeyPeg>();
        for (int i = 0; i < numero; ++i) {
            
            if (arrayList.get(i) != -1 && arrayList.get(i) != -2) {
                KeyPeg codeP = new KeyPeg(arrayList.get(i), i+1, numero);
                lista.add(codeP);
            }
            else {
                acierto = false;
                if (arrayList.get(i) == -1) SaveGame();
                else gameSaved = true;
                return null;
            }
            
        }
        return lista;
    }
    
    private boolean CheckAvailability(String ident, String userName) {
        
        boolean available = true;
        
        File folder = new File("players/"+userName+"/games/");
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
        
        if (jugando){
            try {

                if (cargado) {
                    File file = new File("players/"+player.getName()+"/games/"+id+".txt");
                    file.delete();
                }
                FileWriter fileName = new FileWriter("players/"+player.getName()+"/games/"+id+".txt");
                PrintWriter pw = new PrintWriter(fileName);

                pw.println(id);
                pw.println(difficulty);
                pw.println(mode);
                pw.println(points);
                pw.println(turn);
                pw.println(totalTurns);
                pw.println(numero);
                pw.println(rango);
                for (int i = 0; i < codeMAnt.size(); ++i) {

                    pw.println(codeMAnt.get(i).getColour());

                }
                for (int i = 0; i < codeBAnt.size(); ++i) {

                    pw.println(codeBAnt.get(i).getColour());

                }

                for (int i = 0; i < codeIni.size(); ++i) {

                    pw.println(codeIni.get(i).getColour());

                }

                for (int i = 0; i < turn; ++i) {

                    pw.println(output[i]);

                }

                pw.close();

                if (mode.equals("codemaker")){

                    FileOutputStream fout = new FileOutputStream("players/"+player.getName()+"/games/"+id+"CB");
                    ObjectOutputStream oos = new ObjectOutputStream(fout);
                    oos.writeObject(codeB);    
                    oos.close();

                    out.println("Partida guardada." + "\n");
                    this.gameSaved = true;
                }
                else {
                    out.println("Partida guardada." + "\n");
                    this.gameSaved = true;
                }

            } catch (IOException ex) {

                out.println("No se ha podido guardar la partida." + "\n");
                File file = new File("players/"+player.getName()+"/games/"+id+".txt");
                file.delete();

            }
        }
    }
    
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
                this.codeB = new CodeBreaker(true, numero, rango);
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
    
    public void juega(Jugador playerN, String ident, String dif, String mod, int num, int ran) {
        
        if (playerN != null && !ident.equals("") && CheckAvailability(ident, playerN.getName()) || cargado){
            boolean primerTurnoCargado = cargado;

            boolean b = SetAtributos(playerN, ident, dif, mod, num, ran);
            if (!b) return;
            
            jugando = true;
            
            while (turn <= totalTurns){
                                
                acierto = true;
                
                ArrayList<KeyPeg> outputM = codeMAnt;
                ArrayList<CodePeg> outputB = codeBAnt;
                
                if (mode.equals("codemaker")) {
                    if (!primerTurnoCargado) {
                        outputB = conversorCode(codeB.jugar("IA", codeBAnt, codeMAnt));
                        codeBAnt = outputB;
                    }
                    outputM = conversorKey(codeM.jugar("Player", outputB, codeIni));
                    codeMAnt = outputM;
                    if (this.gameSaved) return;
                }
                else if (mode.equals("codebreaker")) {
                    outputB = conversorCode(codeB.jugar("Player", codeBAnt, codeMAnt));
                    codeBAnt = outputB;
                    if (this.gameSaved) return;
                    outputM = conversorKey(codeM.jugar("IA", outputB, codeIni));
                    codeMAnt = outputM;
                }
                
                primerTurnoCargado = false;
                
                if (this.gameSaved) return;
                
                String linea = GenerarLinea(outputM, outputB);
                
                output[turn] = linea;
                
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
        else {
            System.out.print("No se ha podido crear la partida. Este id ya está en uso." + "\n");
            return;
        }
    }
    
    public File[] finder( String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() { 
                 public boolean accept(File dir, String filename)
                      { return filename.endsWith(".txt"); }
        } );

    }
    
    public void comenzarPartida() {
        
        juega(player, id, difficulty, mode, numero, rango);
        
    }
    
    public void LoadGame(Jugador playerP){
        
        if (playerP != null) {
            File[] listOfFiles = finder("players/"+playerP.getName()+"/games/");

            if (listOfFiles != null){
                for (int i = 0; i < listOfFiles.length; i++) {

                    String fileNameWithOutExt = listOfFiles[i].getName().replaceFirst("[.][^.]+$", "");
                    Integer num = i + 1;
                    System.out.println(num.toString() + " - " + fileNameWithOutExt);

                }

                //Leer datos de la partida y cargar el Game

                cargado = false;

                while (!cargado){            
                    try {

                        System.out.print("Introduce el número de la partida o -1 para salir." + "\n");

                        Scanner input = new Scanner(System.in);

                        int num = Integer.parseInt(input.nextLine());

                        if (num > listOfFiles.length) {
                            System.out.print("Esta partida no existe. Introduce otro número." + "\n");
                        }
                        else if (num == -1) return;
                        else {
                            input = new Scanner(listOfFiles[num-1]);

                            this.player = playerP;

                            String line = input.nextLine();
                            this.id = line;

                            line = input.nextLine();
                            this.difficulty = line;

                            line = input.nextLine();
                            this.mode = line;

                            line = input.nextLine();
                            this.points = Integer.parseInt(line);

                            line = input.nextLine();
                            this.turn = Integer.parseInt(line);

                            line = input.nextLine();
                            this.totalTurns = Integer.parseInt(line);

                            line = input.nextLine();
                            this.numero = Integer.parseInt(line);

                            line = input.nextLine();
                            this.rango = Integer.parseInt(line);

                            codeMAnt = new ArrayList<KeyPeg>();

                            for (int i = 0; i < numero; ++i) {

                                line = input.nextLine(); 
                                KeyPeg code = new KeyPeg(Integer.parseInt(line), i+1, numero);
                                codeMAnt.add(code);

                            }

                            codeBAnt = new ArrayList<CodePeg>();

                            for (int i = 0; i < numero; ++i) {

                                line = input.nextLine(); 
                                CodePeg code = new CodePeg(Integer.parseInt(line), i+1, numero, rango);
                                codeBAnt.add(code);

                            }

                            this.output = new String[totalTurns+1];

                            codeIni = new ArrayList<CodePeg>();

                            for (int i = 0; i < numero; ++i) {

                                line = input.nextLine(); 
                                CodePeg code = new CodePeg(Integer.parseInt(line), i+1, numero, rango);
                                codeIni.add(code);

                            }

                            for (int i = 0; i < turn; ++i) {

                                line = input.nextLine();
                                output[i] = line;

                            }
                            input.close();

                            if (mode.equals("codemaker")){

                                FileInputStream fout = new FileInputStream("players/"+player.getName()+"/games/"+id+"CB");
                                ObjectInputStream oos = new ObjectInputStream(fout);
                                codeB = (CodeBreaker) oos.readObject();
                                oos.close();

                            }
                            cargado = true;
                            System.out.print("Partida cargada!" + "\n");

                            for (int i = 0; i < turn; ++i) {

                                System.out.print(output[i] + "\n");

                            }

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
    
    
}
