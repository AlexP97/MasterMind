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

    protected static boolean login(Jugador jugador){
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
    
    protected static boolean register(Jugador jugador){
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
    
    protected static void crearPartida(Jugador jugador){
        Scanner input = new Scanner(System.in);
        int estado = 0;
        String id = null;
        String dif = null;
        String mod = null;
        int num = 0;
        int ran = 0;
        boolean partidaCreada = false;
        while(!partidaCreada){
            switch(estado){
                case 0: System.out.print("Escribe el id de la partida" + "\n");
                        id = input.nextLine();
                        estado++;
                        break;
                case 1: System.out.print("Escribe la dificultad de la partida (facil, medio o dificil)" + "\n");
                        dif = input.nextLine();
                        if(dif.equals("facil") || dif.equals("medio") || dif.equals("dificil")) estado++; 
                        else System.out.println("Dificultad no válida");
                        break;
                case 2: System.out.print("Escribe el modo de la partida (codebreaker o codemaker)" + "\n");
                        mod = input.nextLine();
                        if(mod.equals("codebreaker") || mod.equals("codemaker")) estado++;
                        else System.out.println("Modo no válido");
                        break;
                case 3: System.out.print("Escribe el número de fichas con las que quieres jugar del 1 al 9" + "\n");
                        num = Integer.parseInt(input.nextLine());
                        if (num > 0 && num < 10) estado++;
                        else System.out.println("Número de fichas no válido");
                        break;
                case 4: System.out.print("Escribe el número máximo que quieres que tenga la ficha del 1 al 9" + "\n");
                        ran = Integer.parseInt(input.nextLine());
                        if (ran > 0 && ran < 10){
                            estado++;
                            partidaCreada = true;
                        }
                        else System.out.println("Rango no válido");
                        break;
            }
        } 
        Game game = new Game();
        game.juega(jugador,id,dif,mod, num, ran);
    }
    
    protected static void cargarPartida(Jugador jugador){
        Game game = new Game();
        game.LoadGame(jugador);
        if (game.cargado) game.comenzarPartida();
    }
    
    protected static void muestraRanking(){
        Ranking ranking = Ranking.getInstance();
        ArrayList<Pair<String, Integer>> output = ranking.muestraRanking();
        for(int i = 0; i < output.size(); i++){
            System.out.println(output.get(i).getLeft()+' '+output.get(i).getRight());
        }
        if(output.isEmpty()) System.out.println("El ranking está vacío.");
    }
    
    protected static void cambiaNombre(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nuevo nombre de usuario");
        String name = input.nextLine();
        jugador.setName(name);
    }
    
    protected static void cambiaContraseña(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nueva contraseña");
        String password = input.nextLine();
        jugador.setPassword(password);
    }
    
    protected static void eliminaUsuario(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.println("El jugador va a ser eliminado de forma definitiva, ¿estás seguro?");
        System.out.println("Escribe si o no");
        String respuesta = input.nextLine();
        if(respuesta.equals("si")) jugador.elimina();
        else if(respuesta.equals("no")) return;
        else eliminaUsuario(jugador);
    }
    
    public static void main(String[] args) {
        Jugador jugador = new Jugador();
        int estado = 0;
        boolean fin = false;
        System.out.print("Bienvenido a MasterMind." + "\n");
        while(!fin){           
            Scanner input = new Scanner(System.in);   
            switch (estado){
                case 0: //MENU DE INICIO/REGISTRO
                    estado = 1;
                    System.out.print("Escribe login para iniciar sesión, register para registrarte o salir para finalizar el juego." + "\n");
                    String start = input.nextLine();
                    if(start.equals("login")){
                        if(!login(jugador)) estado = 0;
                    }
                    else if(start.equals("register")){
                        if(!register(jugador)) estado = 0;
                    }
                    else if(start.equals("salir")) {
                        fin = true;
                        estado = 2;
                    }
                    else{
                        System.out.print("Entrada no válida" + "\n");
                        estado = 0;
                    }
                    break;
                case 1: //MENU DE CREAR/CARGAR/VER RANKING
                    System.out.print("Escribe crear para jugar una partida nueva, cargar para jugar una partida ya empezada, ranking para ver los records de puntuación, modificar para modificar tus datos o salir para volver al menú anterior." + "\n");
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
                    else if (jugar.equals("modificar")){
                        System.out.println("Escribe usuario para modificar tu nombre de usuario, contrasena para modificar tu contraseña, eliminar para darte de baja o salir para volver al menú anterior");
                        String modificar = input.nextLine();
                        System.out.println(modificar);
                        if(modificar.equals("usuario")){
                            cambiaNombre(jugador);
                        }
                        else if(modificar.equals("contrasena")){
                            cambiaContraseña(jugador);
                        }
                        else if(modificar.equals("eliminar")){
                            eliminaUsuario(jugador);
                            estado = 0;
                        }
                        else if(modificar.equals("salir")) estado = 1;
                        else{
                                System.out.print("Entrada no válida" + "\n");
                        }
                    }
                    else if (jugar.equals("salir")) estado = 0;
                    else{
                        System.out.print("Entrada no válida" + "\n");
                    }
                case 2:
                    break;
            }      
        }
    }
}
