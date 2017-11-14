/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author usuario
 */
public class JugadorDriver {
    Jugador jugador;
    CodePegStub codePeg;
    
    public JugadorDriver(){
        jugador = new Jugador(4,5);
        codePeg = new CodePegStub();
        testConstructor();
        testConstructor2();
        testRegister();
        testLogin();
        testGetName();
        testGetPassword();
        getNColores();
        getNFichas();
        testSetIA();
        testEsIA();
        testDonaSolucio();
        testSetName();
        testSetPassword();
        testElimina();
    }
    
    public void testConstructor() {
        Jugador j = new Jugador();
    }
    
    public void testConstructor2() {
        Jugador j = new Jugador(3,4);
    }
    
    public void testRegister() {
        Pair<Boolean, String> p = jugador.register("Juan", "456");
    }
    
    public void testLogin() {
        Pair<Boolean, String> p = jugador.login("Juan", "456");
    }
    
    public void testGetName() {
        String n = jugador.getName();
    }
    
    public void testGetPassword() {
        String c = jugador.getPassword();
    }
    
    public void getNColores() {
        int n = jugador.getNColores();
    }
    
    public void getNFichas() {
        int n = jugador.getNFichas();
    }
    
    public void testSetIA() {
        jugador.setIA();
    }
    
    public void testEsIA() {
        Boolean b = jugador.esIA();
    }
    
    public void testSetName() {
        String s = "Roberto";
        jugador.setName(s);
    }
    
    public void testSetPassword() {
        String s = "1234";
        jugador.setPassword(s);
    }
    
    public void testElimina() {
        jugador.elimina();
    }
    
    public void testDonaSolucio() {
        CodePeg cp = codePeg.create();
        ArrayList<CodePeg> a = new ArrayList<>();
        ArrayList<CodePeg> b = new ArrayList<>();
        for(int i = 0; i < jugador.getNFichas(); i++) {
            a.add(cp);
            b.add(cp);
        }
        ArrayList<Integer> c = jugador.donaSolucio(a, b);
    }
            
    
}
