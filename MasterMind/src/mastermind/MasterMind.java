/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author Usuario
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        System.out.print("Bienvenido a MasterMind." + "\n");
        Boolean entrado = false; 
        Scanner input = new Scanner(System.in);
        while(!entrado){
            System.out.print("Escribe login para iniciar sesión, o register para registrarte." + "\n");
            String start = input.nextLine();
            if(start.equals("login")){
                System.out.print("Introduce el nombre de usuario:" + "\n");
                String usuario = input.nextLine();
                System.out.print("Introduce la contraseña:" + "\n");
                String contraseña = input.nextLine();
                /*
                Jugador jugador = new Jugador();
                jugador.login(usuario,contraseña);
                */
                entrado = true;
            }
            else if(start.equals("register")){
                System.out.print("Introduce el nombre de usuario:" + "\n");
                String usuario = input.nextLine();
                System.out.print("Introduce la contraseña:" + "\n");
                String contraseña = input.nextLine();
                /*
                Jugador jugador = new Jugador();
                jugador.register(usuario,contraseña);
                */
                entrado = true;
            }
            else System.out.print("Entrada no válida" + "\n");
        }
        entrado = false;
        while(!entrado){
            System.out.print("Escribe crear para jugar una partida nueva, cargar para jugar una partida ya empezada o ranking para ver los records de puntuación." + "\n");
            String jugar = input.nextLine();
            if(jugar.equals("crear")){
                System.out.print("Introduce el id para la nueva partida:" + "\n");
                String idPartida = input.nextLine();
                System.out.print("Introduce la dificultad (puede ser fácil, medio o difícil):" + "\n");
                String dificultad = input.nextLine();
                Game game = new Game(idPartida,dificultad);
                entrado = true;
            }
            else if (jugar.equals("cargar")){
                System.out.print("Partida guardadas:" + "\n");  //aqui habria un bolcado de los posibles ids
                
                System.out.print("Introduce el id de la partida guardada:" + "\n");
                //comprobacion de que el id es posible, y si no vuelta a empezar
                entrado = true;
            }
            else System.out.print("Entrada no válida" + "\n");
        }
        Game game = new Game("1", "1");  

      
    }
    
}
