package persistence;

import java.util.Scanner;
import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public final class JugadorPersistenciaDriver {
    JugadorPersistencia jugador;
    
    public JugadorPersistenciaDriver() {
        boolean salir = false;
        while(!salir) {
            Scanner input = new Scanner(System.in);
            System.out.println("Escoge que operación quieres probar(introduce el numero) o introduce -1 para salir:");
            System.out.println("1- Register.");
            System.out.println("2- Login.");
            System.out.println("3- Cambiar el nombre.");
            System.out.println("4- Cambiar la contraseña.");
            System.out.println("5- Eliminar jugador.");
            String test = input.nextLine();
            if(test.equals("1")) 
                testRegister();
            else if(test.equals("2"))
                testLogin();
            else if(test.equals("3"))
                testSetName();
            else if(test.equals("4"))
                testSetPassword();
            else if(test.equals("5"))
                testElimina();
            else if(test.equals("-1"))
                salir = true;
            else
                System.out.println("El valor introducido no es válido");
        }
    }
    
    public void testRegister() {
        jugador = new JugadorPersistencia();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario.");
        String n = input.nextLine();
        System.out.println("Introduce la contraseña.");
        String c = input.nextLine();
        Pair<Boolean, String> p = jugador.register(n, c);
        System.out.println(p.getRight());
        jugador.elimina(n);
    }
    
    public void testLogin() {
        jugador = new JugadorPersistencia();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario.");
        String n = input.nextLine();
        System.out.println("Introduce la contraseña.");
        String c = input.nextLine();
        Pair<Boolean, String> p = jugador.register(n, c);
        Pair<Boolean, String> p2 = jugador.login(n, c);
        System.out.println(p2.getRight());
        jugador.elimina(n);
        
    }
    
    public void testSetName() {
        jugador = new JugadorPersistencia();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nuevo nombre de usuario.");
        String n = input.nextLine();
        Boolean b = jugador.setName("Dummy", n, "123");
        if(b) {
            System.out.println("Se ha cambiado de nombre correctamente.");
            jugador.elimina(n);
        }
        else {
            System.out.println("No se ha podido cambiar de nombre.");
            jugador.elimina("Dummy");
        }
        
               
    }
    
    public void testSetPassword() {
        jugador = new JugadorPersistencia();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la nueva contraseña.");
        String c = input.nextLine();
        Boolean b = jugador.setPassword("Dummy", c);
        if(b) 
            System.out.println("Se ha cambiado la contraseña correctamente.");
        else 
            System.out.println("No se ha podido cambiar de contraseña.");
        jugador.elimina("Dummy");
    }
    
    public void testElimina() {
        jugador = new JugadorPersistencia();
        Pair<Boolean, String> p = jugador.register("Dummy", "123");
        jugador.elimina("Dummy");
        System.out.println("El jugador ha sido eliminado correctamente.");
    }
    
}
