/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import persistence.CtrlPersistenciaJugador;
import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public class CtrlDominioJugador {
    
    private final CtrlPersistenciaJugador CPmj;
    private Jugador j;

    public CtrlDominioJugador(CtrlPersistenciaJugador c) {
        CPmj = c;
        j = new Jugador();
    }
    
    public Pair<Boolean, String> login(String s1, String s2) {
        Pair<Boolean, String> p = CPmj.login(s1,s2);
        if(p.getLeft()) {
            j.login(s1, s2);
        }
       return p;
    }
    
    public Pair<Boolean, String> register(String s1, String s2) {
        Pair<Boolean, String> p = CPmj.register(s1, s2);
        if(p.getLeft()) {
            j.register(s1,s2);
        }
        return p;
    }
    
    public Pair<Boolean, String> elimina() {
        Pair<Boolean, String> p = CPmj.elimina(j.getName());
        return p;
    }
    
    public Pair<Boolean, String> setName(String n) {
        Pair<Boolean, String> p = CPmj.setName(j.getName(), n, j.getPassword());
        if(p.getLeft())
            j.setName(n);
        return p;
    }
    
    public Pair<Boolean, String> setPassword(String c) {
        Pair<Boolean, String> p = CPmj.setPassword(j.getName(), c);
        if(p.getLeft())
            j.setPassword(c);
        return p;
    }
    
    public String getName() {
        return j.getName();
    }

    public String[] obtenerPartidas() {
        return CPmj.obtenerPartidas(j.getName());
    }
    
}
