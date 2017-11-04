/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Daniel
 */
public class CtrlDominioJugador {
 
    public CtrlDominioJugador() {
        
    }
    
    public boolean login(String s1, String s2) {
        Jugador j = new Jugador();
        return j.login(s1, s2);
    }
    
    public boolean register(String s1, String s2) {
        Jugador j = new Jugador();
        return j.register(s1,s2);
    }
}
