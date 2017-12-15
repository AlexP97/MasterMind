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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Pair;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public class GamePersistencia implements Serializable{
    
    public Pair <Boolean, String> write(byte[] b, String s) {
        
        Pair <Boolean,String> p = new Pair<Boolean,String>(true, "La partida se ha guardado correctamente");
        
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
    
    /**
     *
     * @param dirName es el directorio donde buscar los archivos
     * @return el listado de archivos de ese directorio
     */
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
     * @param userName el jugador de la partida
     * @param ident el identificador de la partida
     * @param dif la dificultad de la partida
     * @param mod el modo de la partida
     * @param num el número de fichas de la partida
     * @param ran el rango de colores de la partida
     */
    public Pair<Boolean, String> CrearPartida(String userName, String ident, String dif, String mod, int num, int ran){
        
        if (!userName.equals("") && !ident.equals("") && CheckAvailability(ident, userName)){ 
            return new Pair(true, "La partida es correcta");
        }
        else {
            return new Pair(false, "No se ha podido crear la partida");
        }
    }   
    
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return new Pair(false, "Aun no está implementado.");
    }
    
}
