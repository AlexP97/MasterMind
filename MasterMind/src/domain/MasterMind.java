/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Pair;

/**
 *
 * @author Usuario
 */
public class MasterMind {

    private static boolean login(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el nombre de usuario:" + "\n");
        String usuario = input.nextLine();
        System.out.print("Introduce la contraseña:" + "\n");
        String contraseña = input.nextLine();
        Pair<Boolean, String> p = new Pair();
        p = jugador.login(usuario,contraseña);
        System.out.println(p.getRight());
        return p.getLeft();
    }
    
    private static boolean register(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el nombre de usuario:" + "\n");
        String usuario = input.nextLine();
        System.out.print("Introduce la contraseña:" + "\n");
        String contraseña = input.nextLine();
        Pair<Boolean, String> p = new Pair();
        p = jugador.register(usuario,contraseña);
        System.out.println(p.getRight());
        return p.getLeft();
    }
    
    private static void crearPartida(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.print("Escribe el id de la partida" + "\n");
        String id = input.nextLine();
        System.out.print("Escribe la dificultad de la partida (facil, medio o dificil)" + "\n");
        String dif = input.nextLine();
        System.out.print("Escribe el modo de la partida (codebreaker o codemaker)" + "\n");
        String mod = input.nextLine();
        System.out.print("Escribe el número de fichas con las que quieres jugar" + "\n");
        String num = input.nextLine();
        System.out.print("Escribe el número máximo que quieres que tenga la ficha" + "\n");
        String ran = input.nextLine();
        Game game = new Game();
        game.juega(jugador,id,dif,mod, Integer.parseInt(num), Integer.parseInt(ran));
    }
    
    private static void cargarPartida(Jugador jugador){
        Game game = new Game();
        game.LoadGame(jugador);
    }
    
    private static void muestraRanking(){
        Ranking ranking = Ranking.getInstance();
        ArrayList<Pair<String, Integer>> output = ranking.muestraRanking();
        for(int i = 0; i < output.size(); i++){
            System.out.println(output.get(i).getLeft()+' '+output.get(i).getRight());
        }
    }
    
    public static void main(String[] args) {
        Jugador jugador = new Jugador();
        int estado = 0;
        while(true){           
            System.out.print("Bienvenido a MasterMind." + "\n");
            Scanner input = new Scanner(System.in);   
            switch (estado){
                case 0: //MENU DE INICIO/REGISTRO
                    estado = 1;
                    System.out.print("Escribe login para iniciar sesión, o register para registrarte." + "\n");
                    String start = input.nextLine();
                    if(start.equals("login")){
                        if(!login(jugador)) estado = 0;
                    }
                    else if(start.equals("register")){
                        if(!register(jugador)) estado = 0;
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
                        crearPartida(jugador);
                    }
                    else if (jugar.equals("cargar")){
                        cargarPartida(jugador);
                    }
                    else if (jugar.equals("ranking")){
                        muestraRanking();
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
