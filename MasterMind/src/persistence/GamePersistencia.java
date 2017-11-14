/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.CodeBreaker;
import domain.Game;
import domain.Jugador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class GamePersistencia implements Serializable{
    
    Game game;
    CodeBreaker cb;
    
    /**
     *
     * @param gameC la partida a guardar
     * @param codeB el CodeBreaker de la partida a guardar
     */
    public GamePersistencia(Game gameC, CodeBreaker codeB){
        
        this.game = gameC;
        this.cb = codeB;
        
    }
    
    public GamePersistencia(){
        
        this.game = new Game();
        this.cb = null;
        
    }
    
    /**
     *
     * @param gameS la partida a guardar
     */
    public void setGame(Game gameS){
        this.game = gameS;
    }
    
    /**
     *
     * @param codeB el CodeBreaker de la partida a guardar
     */
    public void setCB(CodeBreaker codeB){
        this.cb = codeB;
    }
    
    public boolean SaveGame(String username, String id){
                        
        try {

            if (game.getCargado()) {
                File file = new File("data/players/"+username+"/games/"+id+"Game");
                file.delete();
            }
            FileOutputStream fout = new FileOutputStream("data/players/"+username+"/games/"+id+"Game");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(game);
            oos.close();

            return true;

        } catch (IOException ex) {

            File file = new File("data/players/"+username+"/games/"+id+"Game");
            file.delete();
            out.println("No se ha podido guardar la partida." + "\n");
            return false;

        }
    }
        
    /**
     *
     * @param username el nombre de usuario
     * @param id el id de la partida
     * @return si se ha guardado la partida correctamente
     */
    public boolean SaveCodeB(String username, String id){
                                
        try {

            if (game.getCargado()) {
                File file = new File("data/players/"+username+"/games/"+id+"CB");
                file.delete();
            }
            FileOutputStream fout = new FileOutputStream("data/players/"+username+"/games/"+id+"CB");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(cb);    
            oos.close();

            return true;

        } catch (IOException ex) {

            out.println("No se ha podido guardar la partida." + "\n");
            File file = new File("data/players/"+username+"/games/"+id+"CB");
            file.delete();
            return false;

        }
    }    
    
    public File[] finder( String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() { 
                 public boolean accept(File dir, String filename)
                      { return filename.endsWith("Game"); }
        } );

    }
    
    /**
     *
     * @param playerP el jugador que intenta cargar partida
     */
    public void LoadGame(Jugador playerP){
        
        if (playerP != null) {
            File[] listOfFiles = finder("data/players/"+playerP.getName()+"/games/");

            if (listOfFiles != null){
                for (int i = 0; i < listOfFiles.length; i++) {

                    String fileNameWithOutExt = listOfFiles[i].getName();
                    fileNameWithOutExt = fileNameWithOutExt.substring(0, fileNameWithOutExt.length()-4);
                    Integer num = i + 1;
                    System.out.println(num.toString() + " - " + fileNameWithOutExt);

                }

                //Leer datos de la partida y cargar el Game

                boolean cargado = false;

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

                            FileInputStream fout = new FileInputStream(listOfFiles[num-1]);
                            ObjectInputStream oos = new ObjectInputStream(fout);
                            game = (Game) oos.readObject();
                            oos.close();

                            if (game.getMode().equals("codemaker")){

                                FileInputStream foutCB = new FileInputStream("data/players/"+playerP.getName()+"/games/"+game.getId()+"CB");
                                ObjectInputStream oosCB = new ObjectInputStream(foutCB);
                                cb = (CodeBreaker) oosCB.readObject();
                                oosCB.close();
                                game.setCB(cb);

                            }
                            cargado = true;
                            
                            game.setCargado(true);
                            
                            System.out.print("Partida cargada!" + "\n");

                            game.MostrarOutput();
                            
                            game.setGameP(this);
                            
                            game.comenzarPartida();

                        }

                    } catch (Exception ex) {
                        System.out.print("No se ha podido cargar la partida." + "\n");
                        return;
                    }
                }
            }
            else {
                System.out.print("No hay ninguna partida guardada." + "\n");
                return;
            }
        }
    }
    
    /**
     *
     * @param ident el identificador de la partida
     * @param userName el nombre de usuario del jugador
     * @return si el jugador puede crear una partida con ese identificador
     */
    public boolean CheckAvailability(String ident, String userName) {
        
        boolean available = true;
        
        File folder = new File("data/players/"+userName+"/games/");
        File[] listOfFiles = folder.listFiles();
        
        if (listOfFiles != null){
            for (int i = 0; i < listOfFiles.length && available; i++) {

                String fileName = listOfFiles[i].getName().replaceFirst("[.][^.]+$", "");
                ident += "Game";
                if (fileName.equals(ident)) available = false;

            }
        }
        
        return available;
        
    }
    
    /**
     *
     * @param playerN el jugador de la partida
     * @param ident el identificador de la partida
     * @param dif la dificultad de la partida
     * @param mod el modo de la partida
     * @param num el número de fichas de la partida
     * @param ran el rango de colores de la partida
     */
    public void CrearPartida(Jugador playerN, String ident, String dif, String mod, int num, int ran){
        
        if (playerN != null && !ident.equals("") && CheckAvailability(ident, playerN.getName())){
            
            game.setGameP(this);
            
            if (mod.equals("codemaker")) {
                this.cb = new CodeBreaker(true, num, ran);
                game.setCB(cb);
            }
            
            game.juega(playerN, ident, dif, mod, num, ran);
            
        }
        else {
            System.out.print("No se ha podido crear la partida. Este id ya está en uso." + "\n");
            return;
        }
    }
    
}
