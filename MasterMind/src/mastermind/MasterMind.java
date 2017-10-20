/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        int estado = 0;
        while(true){           
            System.out.print("Bienvenido a MasterMind." + "\n");
            Scanner input = new Scanner(System.in);   
            Jugador jugador = new Jugador();
            switch (estado){
                case 0: //MENU DE INICIO/REGISTRO
                    estado = 1;
                    System.out.print("Escribe login para iniciar sesión, o register para registrarte." + "\n");
                    String start = input.nextLine();
                    if(start.equals("login")){
                        System.out.print("Introduce el nombre de usuario:" + "\n");
                        String usuario = input.nextLine();
                        System.out.print("Introduce la contraseña:" + "\n");
                        String contraseña = input.nextLine();
                    
                        Boolean b = jugador.login(usuario,contraseña);
                        if(!b) estado = 0;
                    }
                    else if(start.equals("register")){
                        System.out.print("Introduce el nombre de usuario:" + "\n");
                        String usuario = input.nextLine();
                        System.out.print("Introduce la contraseña:" + "\n");
                        String contraseña = input.nextLine();

                        jugador = new Jugador();
                        Boolean b = jugador.register(usuario,contraseña);
                        if(!b) estado = 0;
                    }
                    else{
                        System.out.print("Entrada no válida" + "\n");
                        estado = 0;
                    }
                    break;
                case 1: //MENU DE CREAR/CARGAR/VER RANKING
                    System.out.print("Escribe crear para jugar una partida nueva, cargar para jugar una partida ya empezada, ranking para ver los records de puntuación o salir para volver al menú anterior." + "\n");
                    String jugar = input.nextLine();
                    if(jugar.equals("crear")){
                        System.out.print("Escribe el id de la partida" + "\n");
                        String id = input.nextLine();
                        System.out.print("Escribe la dificultad de la partida (facil, medio o dificil)" + "\n");
                        String dif = input.nextLine();
                        System.out.print("Escribe el modo de la partida (codebreaker o codemaker)" + "\n");
                        String mod = input.nextLine();
                        Game game = new Game();
                        game.juega(jugador,id,dif,mod);
                    }
                    else if (jugar.equals("cargar")){
                        Game game = new Game();
                        game.LoadGame(jugador);
//                      game.continua();
                    }
                    else if (jugar.equals("ranking")){
                        Ranking ranking = new Ranking();
                        ranking.muestraRanking();
                    }
                    else if (jugar.equals("salir")) estado = 0;
                    else{
                        System.out.print("Entrada no válida" + "\n");
                    }
                    break;
                case 2:
                    break;
            }      
        }
    }
}
