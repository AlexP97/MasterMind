/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.CtrlPersistenciaJugador;
import utils.Pair;

/**
 *
 * @author Daniel
 */
public class CtrlDominioJugador {
    
    private final CtrlPersistenciaJugador CPmj;
 
    public CtrlDominioJugador(CtrlPersistenciaJugador c) {
        CPmj = c;
    }
    
    public Pair<Boolean, String> login(String s1, String s2) {
        Pair<Boolean, String> p = CPmj.login(s1,s2);
        if(p.getLeft()) {
            Jugador j = new Jugador();
            j.login(s1, s2);
        }
       return p;
    }
    
    public Pair<Boolean, String> register(String s1, String s2) {
        Pair<Boolean, String> p = CPmj.register(s1, s2);
        if(p.getLeft()) {
            Jugador j = new Jugador();
            j.register(s1,s2);
        }
        return p;
    }
}
