/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.CodeBreaker;
import domain.Game;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public final class GamePersistenciaDriver {
    
    GamePersistencia gameP;
    
    public GamePersistenciaDriver() {
        gameP = new GamePersistencia();
        Scanner input = new Scanner(System.in);
        String metodo = "prueba";
        while(!metodo.equals("salir")){
            System.out.println("¿Qué método quieres probar?");
            System.out.println("1- Asigna un Game a la clase de persistencia.");
            System.out.println("2- Asigna un jugador CodeBreaker a la clase de persistencia");
            System.out.println("3- Guarda partida");
            System.out.println("4- Guarda el CodeBreaker");
            System.out.println("5- Muestra todas las partidas guardadas del jugador asignado");
            System.out.println("6- Busca si el jugador asignado ya tiene una partida con un identificador específico");
            System.out.println("Escribe salir para probar otra clase");
            metodo = input.nextLine();
            if(metodo.equals("1")) testSetGame();
            else if(metodo.equals("2")) testSetCB();
            else if(metodo.equals("3")) testSaveGame();
            else if(metodo.equals("4")) testSaveCodeB();
            else if(metodo.equals("5")) testFinder();
            else if(metodo.equals("6")) testCheckAvailability();
            else if(!metodo.equals("prueba")) System.out.println("Entrada no válida");
        }      
    }
    
    public void testSetGame(){
        Game game = new Game();
        gameP.setGame(game);
        System.out.println("Se ha realizado correctamente");
    }
    
    public void testSetCB(){
        CodeBreaker cb = new CodeBreaker(false, 2, 2);
        gameP.setCB(cb);
        System.out.println("Se ha realizado correctamente");
    }
    
    public boolean testSaveGame(){
        testSetGame();
        System.out.println("Se ha realizado correctamente");
        return gameP.SaveGame("dani", "1213");
    }
    
    public boolean testSaveCodeB(){
        testSetGame();
        testSetCB();
        System.out.println("Se ha realizado correctamente");
        return gameP.SaveCodeB("dani", "1213");  
    }
    
    public void testFinder(){
        System.out.println("Se ha realizado correctamente");
        File[] listOfFiles = gameP.finder("data/players/dani/games/");
        if (listOfFiles != null){
            for (int i = 0; i < listOfFiles.length; i++) {

                String fileNameWithOutExt = listOfFiles[i].getName();
                fileNameWithOutExt = fileNameWithOutExt.substring(0, fileNameWithOutExt.length()-4);
                Integer num = i + 1;
                System.out.println(num.toString() + " - " + fileNameWithOutExt);

            } 
        }
    }
    
    public void testCheckAvailability() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un identificador de partida");
        String id = input.nextLine();
        System.out.println("Introduce el nombre del jugador");
        String nombre = input.nextLine();
        boolean b = gameP.CheckAvailability(id, nombre);
        if(b) System.out.println("Está disponible");
        else System.out.println("No está disponible");
    }

}
