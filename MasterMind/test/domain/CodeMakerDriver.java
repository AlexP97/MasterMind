/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class CodeMakerDriver {
    CodeMaker codemaker;
    CodePegStub codePeg;
    JugadorStub jugador;
    
    public CodeMakerDriver(){
        jugador = new JugadorStub();
        codemaker = new CodeMaker(true,jugador.getNFichas(),jugador.getNColores());
        codePeg = new CodePegStub();
        testConstructor();
        testDonaPatro();
        testJugar();
    }
    
    public void testConstructor() {
        boolean b = false;
        int nf = 2;
        int nc = 3;
        CodeMaker cd = new CodeMaker(b, nf, nc);
    }
     
    public void testDonaPatro() {
        ArrayList<Integer> a = codemaker.dona_patro("IA");  
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
    }
}
