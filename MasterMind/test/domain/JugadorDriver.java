package domain;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public final class JugadorDriver {
    CodePegStub codePeg;
    
    public JugadorDriver(){
        codePeg = new CodePegStub();
        boolean salir = false;
        while(!salir) {
            Scanner input = new Scanner(System.in);
            System.out.println("¿Qué método quieres probar?");
            System.out.println("1- Register.");
            System.out.println("2- Login.");
            System.out.println("3- Mirar el nombre.");
            System.out.println("4- Mirar la contraseña.");
            System.out.println("5- Mirar número de colores.");
            System.out.println("6- Mirar número de fichas.");
            System.out.println("7- Poner si el jugador es IA o no.");
            System.out.println("8- Mirar si el jugador es IA o no.");
            System.out.println("9- Probar la función de dar solución.");
            System.out.println("10- Cambiar el nombre.");
            System.out.println("11- Cambiar la contraseña.");
            System.out.println("12- Eliminar jugador.");
            System.out.println("Escribe salir para probar otra clase.");
            
            String test = input.nextLine();
            if(test.equals("1"))
                testRegister();
            else if(test.equals("2"))
                testLogin();
            else if(test.equals("3"))
                testGetName();
            else if(test.equals("4"))
                testGetPassword();
            else if(test.equals("5"))
                getNColores();
            else if(test.equals("6"))
                getNFichas();
            else if(test.equals("7"))
                testSetIA();
            else if(test.equals("8"))
                testEsIA();
            else if(test.equals("9"))
                testDonaSolucio();
            else if(test.equals("10"))
                testSetName();
            else if(test.equals("11"))
                testSetPassword();
            else if(test.equals("12"))
                testElimina();
            else if(test.equals("salir"))
                salir = true;
            else
                System.out.println("Entrada no válida");
        }
    }
    
    public void testRegister() {
        Jugador jugador = new Jugador();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario");
        String usuario = input.nextLine();
        System.out.println("Introduce la contraseña");
        String contraseña = input.nextLine();
        Pair<Boolean, String> p = jugador.register(usuario, contraseña);
        System.out.println(p.getRight());
        jugador.elimina();
    }
    
    public void testLogin() {
        Jugador jugador = new Jugador();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario");
        String usuario = input.nextLine();
        System.out.println("Introduce la contraseña");
        String contraseña = input.nextLine();
        Pair<Boolean, String> p = jugador.register(usuario, contraseña);
        Pair<Boolean, String> p2 = jugador.login(usuario, contraseña);
        System.out.println(p2.getRight());
        jugador.elimina();
    }
    
    public void testGetName() {
        Jugador jugador = new Jugador();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        String n = jugador.getName();
        System.out.println("Tu nombre es "+n+".");
        jugador.elimina();
    }
    
    public void testGetPassword() {
        Jugador jugador = new Jugador();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        String c = jugador.getPassword();
        System.out.println("Tu contraseña es "+c+".");
        jugador.elimina();
    }
    
    public void getNColores() {
        Jugador jugador = new Jugador(4,5);
        int n = jugador.getNColores();
        System.out.println("El número de colores es "+n);
    }
    
    public void getNFichas() {
        Jugador jugador = new Jugador(4,5);
        int n = jugador.getNFichas();
        System.out.println("El número de fichas es "+n);
    }
    
    public void testSetIA() {
        Jugador jugador = new Jugador();
        jugador.setIA();
        System.out.println("Este jugador ahora es una IA.");
    }
    
    public void testEsIA() {
        Jugador jugador = new Jugador();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        Boolean b = jugador.esIA();
        if(!b) 
            System.out.println("El jugador es humano.");
        else
            System.out.println("El jugador es una máquina.");
        jugador.elimina();          
        
    }
    
    public void testSetName() {
        Jugador jugador = new Jugador();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nuevo nombre de usuario.");
        String s = input.nextLine();
        jugador.setName(s);
        System.out.println("Has cambiado correctamente de nombre.");
        jugador.elimina();
    }
    
    public void testSetPassword() {
        Jugador jugador = new Jugador();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu nueva contraseña.");
        String s = input.nextLine();
        jugador.setPassword(s);
        System.out.println("Has cambiado correctamente de contraseña.");
        jugador.elimina();
    }
    
    public void testElimina() {
        Jugador jugador = new Jugador();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        jugador.elimina();
        System.out.println("El jugador ha sido eliminado correctamente.");
    }
    
    public void testDonaSolucio() {
        Jugador jugador = new Jugador(4,5);
        CodePeg cp = codePeg.create();
        ArrayList<CodePeg> a = new ArrayList<>();
        ArrayList<CodePeg> b = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++) {
            a.add(cp);
            b.add(cp);
        }
        ArrayList<Integer> c = jugador.donaSolucio(a, b);
        System.out.println("Se ha dado una solucón correctamente.");
    }
            
    
}
