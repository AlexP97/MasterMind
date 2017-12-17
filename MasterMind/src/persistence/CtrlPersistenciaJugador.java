/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public class CtrlPersistenciaJugador {
    JugadorPersistencia j;
    
    public CtrlPersistenciaJugador() {
        j = new JugadorPersistencia();
    }
    
    public Pair<Boolean, String> login(String s1, String s2) {
        return j.login(s1, s2);
    }
    
    public Pair<Boolean, String> register(String s1, String s2) {
        return j.register(s1,s2);
    }
    
    public Pair<Boolean, String> elimina(String n) {
        return j.elimina(n);
    }
    
    public Pair<Boolean, String> setName(String n1, String n2, String c) {
        return j.setName(n1,n2,c);
    }
    
    public Pair<Boolean, String> setPassword(String n, String c) {
        return j.setPassword(n,c);
    }

    public String[] obtenerPartidas(String n) {
       return j.obtenerPartidas(n);
    }
}
