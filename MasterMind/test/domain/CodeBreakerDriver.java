package domain;

import java.util.ArrayList;

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
        testConjunt();
        testCreaCombinaciones();
        testConstructor();
        testConvert();
        testCompare();
        testMiraSolucio();
        testMiraDescartes();
        testMillorOpcio();
        testJugar();
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
    }
    
    public void testConstructor() {
        boolean b = false;
        int nf = 2;
        int nc = 3;
        CodeBreaker p = new CodeBreaker(b, nf, nc);
    }
    
    private void testConvert() {
        ArrayList<CodePeg> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a = codebreaker.convert(b);
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
    }
    
    private void testMiraSolucio() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++){
            a.add(1);
            b.add(1);
        }
        ArrayList<Integer> c = codebreaker.miraSolucio(a,b);
             
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
    }
    
    private void testMillorOpcio() {
        ArrayList<Integer> a = codebreaker.millorOpcio();
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
    }     
}
