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
public class CodeBreakerDriver {
    CodeBreaker codebreaker;
    CodePegStub codePeg;
    KeyPegStub keyPeg;
    JugadorStub jugador;
    
    private void testConjunt() {
        
    }
    
    private void testCreaCombinaciones() {
        //adri
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++){
            a.add(1);
        }
        codebreaker.creaCombinaciones(0,a);
    }
    
    public void testOrdenar(){
        //adri
        ArrayList<Integer> a = new ArrayList<>();
        codebreaker.ordenar(a);
    }
    
    public void testConstructor() {
        
    }
    
    private void testConvert() {
        //adri
        ArrayList<CodePeg> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a = codebreaker.convert(b);
    }
    
    private void testCompare() {
        //adri
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
        
    }
       
    private void testMiraDescartes() {
        
    }
    
    private void testMillorOpcio() {
        
    }
    
    private void testJugar() {
        
    }
    
            
            
           
}
