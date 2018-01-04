package domain;

import java.util.ArrayList;
import java.util.Scanner;
import persistence.GamePersistencia;
import persistence.JugadorPersistencia;
import presentation.CtrlPresentacion;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class MasterMind {   
    static CtrlPresentacion CP;
    /**
     *
     * @return si el jugador ha hecho login con éxito
     */
    protected static boolean login(){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el nombre de usuario:" + "\n");
        String usuario = input.nextLine();
        System.out.print("Introduce la contraseña:" + "\n");
        String contraseña = input.nextLine();
        Pair<Boolean, String> p = CP.login(usuario, contraseña);
        System.out.println(p.getRight());
        return p.getLeft();
    }
    
    /**
     *
     * @return si el jugador se ha registrado con éxito
     */
    protected static boolean register(){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el nombre de usuario:" + "\n");
        String usuario = input.nextLine();
        System.out.print("Introduce la contraseña:" + "\n");
        String contraseña = input.nextLine();
        Pair<Boolean, String> p = CP.register(usuario,contraseña);
        System.out.println(p.getRight());
        return p.getLeft();
    }
    
    /**
     *
     */
    protected static void crearPartida(){
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
        CP.crearPartida(CP.getName(),id,dif,mod, num, ran);
    }
    
    /**
     *
     */
    protected static void cargarPartida(){
        String[] partidas = CP.obtenerPartidas();
        Scanner input = new Scanner(System.in);
        boolean cargado = false;
        String partida = "aux";
        while(!cargado && !partida.equals("salir")){
            System.out.println("Lista de partidas disponibles:");
            for(int i = 0; i < partidas.length; i++){
                System.out.println(partidas[i]);
            }
            System.out.println("Introduce el id de la partida que quieres cargar o escribe salir para volver atrás.");
            partida = input.nextLine();
            for(int i = 0; i < partidas.length && !partidas.equals("salir"); i++){
                if(partidas[i].equals(partida)) cargado = true;
            }
            if(!cargado && !partida.equals("salir")){
                System.out.println("Entrada no válida.");
            }
        }
        CP.loadGame(partida);
    }
    
    protected static void muestraRanking(){
        Ranking ranking = Ranking.getInstance();
        ArrayList<Pair<String, Integer>> output = ranking.muestraRanking();
        System.out.println("El ranking no incluye a los jugadores CodeMaker ni a la IA");
        for(int i = 0; i < output.size(); i++){
            System.out.println(output.get(i).getLeft()+' '+output.get(i).getRight());
        }
        if(output.isEmpty()) System.out.println("El ranking está vacío.");
    }
    
    /**
     *
     */
    protected static void cambiaNombre(){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nuevo nombre de usuario");
        String name = input.nextLine();
        Pair<Boolean,String> p = CP.modificaUsuario(name);
        System.out.println(p.getRight());
    }
    
    /**
     *
     */
    protected static void cambiaContraseña(){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nueva contraseña");
        String password = input.nextLine();
        Pair<Boolean,String> p = CP.modificaContraseña(password);
        System.out.println(p.getRight());
    }
    
    /**
     *
     * @return si el usuario se ha eliminado o no
     */
    protected static boolean eliminaUsuario(){
        Scanner input = new Scanner(System.in);
        System.out.println("El jugador va a ser eliminado de forma definitiva, ¿estás seguro?");
        System.out.println("Escribe si o no");
        String respuesta = input.nextLine();
        if(respuesta.equals("si")){
            Pair<Boolean,String> p = CP.eliminar();
        System.out.println(p.getRight());
            return true;
        }
        else if(respuesta.equals("no")) System.out.println("Se ha cancelado la eliminación del usuario");
        else System.out.println("Entrada no válida");
        return false;
    }
    
    public static void main(String[] args) {
        CP = new CtrlPresentacion();
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
                        if(!login()) estado = 0;
                    }
                    else if(start.equals("register")){
                        if(!register()) estado = 0;
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
                        crearPartida();
                    }
                    else if (jugar.equals("cargar")){
                        cargarPartida();
                    }
                    else if (jugar.equals("ranking")){
                        muestraRanking();
                    }
                    else if (jugar.equals("modificar")){
                        System.out.println("Escribe usuario para modificar tu nombre de usuario, contrasena para modificar tu contraseña, eliminar para darte de baja o salir para volver al menú anterior");
                        String modificar = input.nextLine();
                        if(modificar.equals("usuario")){
                            cambiaNombre();
                        }
                        else if(modificar.equals("contrasena")){
                            cambiaContraseña();
                        }
                        else if(modificar.equals("eliminar")){
                            if (eliminaUsuario()) estado = 0;
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
