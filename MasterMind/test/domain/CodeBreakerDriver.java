package domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public final class CodeBreakerDriver {
    CodeBreaker codebreaker;
    CodePegStub codePeg;
    KeyPegStub keyPeg;
    JugadorStub jugador;
    
    public CodeBreakerDriver(){
        jugador = new JugadorStub();
        codebreaker = new CodeBreaker(true,jugador.getNFichas(),jugador.getNColores());
        keyPeg = new KeyPegStub();
        codePeg = new CodePegStub();
        boolean salir = false;
        while(!salir) {
            Scanner input = new Scanner(System.in);
            System.out.println("Escoge que operación quieres probar(introduce el numero) o introduce -1 para salir:");
            System.out.println("1- Crear conjunto de opciones.");
            System.out.println("2- Crear conjunto de pistas posibles.");
            System.out.println("3- Constructor.");
            System.out.println("4- Conversor.");
            System.out.println("5- Comparar.");
            System.out.println("6- Mirar solucion.");
            System.out.println("7- Mirar si se descarta una solución.");
            System.out.println("8- Mirar la mejor opción.");
            System.out.println("9- Mirar si funciona la función jugar.");
            String test = input.nextLine();
            if(test.equals("1"))
                testConjunt();
            else if(test.equals("2"))
                testCreaCombinaciones();
            else if(test.equals("3"))
                testConstructor();
            else if(test.equals("4"))
                testConvert();
            else if(test.equals("5"))
                testCompare();
            else if(test.equals("6"))
                testMiraSolucio();
            else if(test.equals("7"))
                testMiraDescartes();
            else if(test.equals("8"))
                testMillorOpcio();
            else if(test.equals("9"))
                testJugar();
            else if(test.equals("-1"))
                salir = true;
            else 
                System.out.println("El valor introducido no es válido");
        }
    }
    
    private void testConjunt() {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++){
            a.add(1);
        }
        codebreaker.conjunt(0,a);
    }
    
    private void testCreaCombinaciones() {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++){
            a.add(1);
        }
        codebreaker.creaCombinaciones(0,a);
        System.out.println("Se ha realizado correctamente.");
    }
    
    public void testConstructor() {
        boolean b = false;
        int nf = 2;
        int nc = 3;
        CodeBreaker p = new CodeBreaker(b, nf, nc);
        System.out.println("Se ha realizado correctamente.");
    }
    
    private void testConvert() {
        ArrayList<CodePeg> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a = codebreaker.convert(b);
        System.out.println("Se ha realizado correctamente.");
    }
    
    private void testCompare() {
        CodePeg cp = codePeg.create();
        ArrayList<CodePeg> a = new ArrayList<>();
        a.add(cp);
        a.add(cp);
        a.add(cp);
        a.add(cp);
        KeyPeg kp = keyPeg.create();
        ArrayList<KeyPeg> b = new ArrayList<>();
        b.add(kp);
        b.add(kp);
        b.add(kp);
        b.add(kp);
        ArrayList<Integer> c = new ArrayList();
        c.add(1);
        c.add(1);
        c.add(1);
        c.add(1);
        boolean ret = codebreaker.compare(a,b,c);
        System.out.println("Se ha realizado correctamente.");
    }
    
    private void testMiraSolucio() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++){
            a.add(1);
            b.add(1);
        }
        ArrayList<Integer> c = codebreaker.miraSolucio(a,b);
        System.out.println("Se ha realizado correctamente.");
             
    }
       
    private void testMiraDescartes() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++){
            a.add(1);
            b.add(1);
            c.add(2);
        }
        boolean d = codebreaker.miraDescartes(a,b,c);
        System.out.println("Se ha realizado correctamente.");
    }
    
    private void testMillorOpcio() {
        ArrayList<Integer> a = codebreaker.millorOpcio();
        System.out.println("Se ha realizado correctamente.");
    }
    
    private void testJugar() {
        CodePeg cp = codePeg.create();
        ArrayList<CodePeg> a = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++)
            a.add(cp);
        KeyPeg kp = keyPeg.create();
        ArrayList<KeyPeg> b = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++)
            b.add(kp);
        ArrayList<Integer> c = codebreaker.jugar("IA", a, b);
        System.out.println("Se ha realizado correctamente.");
    }     
}
