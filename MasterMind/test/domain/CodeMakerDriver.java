package domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public class CodeMakerDriver {
    CodeMaker codemaker;
    CodePegStub codePeg;
    JugadorStub jugador;
    
    public CodeMakerDriver(){
        jugador = new JugadorStub();
        codemaker = new CodeMaker(true,jugador.getNFichas(),jugador.getNColores());
        codePeg = new CodePegStub();
        boolean salir = false;
        while(!salir) {
            Scanner input = new Scanner(System.in);
            System.out.println("Escoge que operación quieres probar(introduce el numero) o introduce -1 para salir:");
            System.out.println("1- Constructor.");
            System.out.println("2- Dar patrón.");
            System.out.println("3- Jugar.");
            String test = input.nextLine();
            if(test.equals("1"))
                testConstructor();
            else if(test.equals("2"))
                testDonaPatro();
            else if(test.equals("3"))
                testJugar();
            else if(test.equals("-1"))
                salir = true;
            else
                System.out.println("El valor introducido no es válido");
        }
    }
    
    public void testConstructor() {
        boolean b = false;
        int nf = 2;
        int nc = 3;
        CodeMaker cd = new CodeMaker(b, nf, nc);
        System.out.println("Se ha realizado correctamente.");
    }
     
    public void testDonaPatro() {
        ArrayList<Integer> a = codemaker.dona_patro("IA"); 
        System.out.println("Se ha realizado correctamente.");
    }
    
    public void testJugar() {
        CodePeg cp = codePeg.create();
        ArrayList<CodePeg> a = new ArrayList<>();
        ArrayList<CodePeg> b = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++) {
            a.add(cp);
            b.add(cp);
        }
        ArrayList<Integer> c = codemaker.jugar("IA", a, b);
        System.out.println("Se ha realizado correctamente.");
    }
}
