package domain;

import java.util.ArrayList;
import java.util.Scanner;
import persistence.GamePersistencia;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class MasterMind {

    /**
     *
     * @param jugador el jugador que está jugando
     * @return si el jugador ha hecho login con éxito
     */
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
    
    /**
     *
     * @param jugador el jugador que está jugando
     * @return si el jugador se ha registrado con éxito
     */
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
    
    /**
     *
     * @param jugador el jugador que está jugando
     */
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
        GamePersistencia gameP = new GamePersistencia();
        gameP.CrearPartida(jugador,id,dif,mod, num, ran);
    }
    
    /**
     *
     * @param jugador el jugador que está jugando
     */
    protected static void cargarPartida(Jugador jugador){
        GamePersistencia gameP = new GamePersistencia();
        gameP.LoadGame(jugador);
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
     * @param jugador el jugador que está jugando
     */
    protected static void cambiaNombre(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nuevo nombre de usuario");
        String name = input.nextLine();
        String s = jugador.setName(name);
        System.out.println(s);
    }
    
    /**
     *
     * @param jugador el jugador que está jugando
     */
    protected static void cambiaContraseña(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nueva contraseña");
        String password = input.nextLine();
        String s = jugador.setPassword(password);
        System.out.println(s);
    }
    
    /**
     *
     * @param jugador el jugador que está jugando
     * @return si el usuario se ha eliminado o no
     */
    protected static boolean eliminaUsuario(Jugador jugador){
        Scanner input = new Scanner(System.in);
        System.out.println("El jugador va a ser eliminado de forma definitiva, ¿estás seguro?");
        System.out.println("Escribe si o no");
        String respuesta = input.nextLine();
        if(respuesta.equals("si")){
            String s = jugador.elimina();
            System.out.println(s);
            return true;
        }
        else if(respuesta.equals("no")) System.out.println("Se ha cancelado la eliminación del usuario");
        else System.out.println("Entrada no válida");
        return false;
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
                        if(modificar.equals("usuario")){
                            cambiaNombre(jugador);
                        }
                        else if(modificar.equals("contrasena")){
                            cambiaContraseña(jugador);
                        }
                        else if(modificar.equals("eliminar")){
                            if (eliminaUsuario(jugador)) estado = 0;
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
