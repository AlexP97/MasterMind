/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import utils.Pair;

/**
 *
 * @author aleja
 */
public class CtrlPersistenciaJugador {
    
    public CtrlPersistenciaJugador() {
    

    }
    
    public Pair<Boolean, String> login(String s1, String s2) {
        JugadorPersistencia j = new JugadorPersistencia();
        return j.login(s1, s2);
    }
    
    public Pair<Boolean, String> register(String s1, String s2) {
        JugadorPersistencia j = new JugadorPersistencia();
        return j.register(s1,s2);
    }
    
    public Pair<Boolean, String> elimina(String n) {
        JugadorPersistencia j = new JugadorPersistencia();
        return j.elimina(n);
    }
    
    public Pair<Boolean, String> setName(String n1, String n2, String c) {
        JugadorPersistencia j = new JugadorPersistencia();
        return j.setName(n1,n2,c);
    }
    
    public Pair<Boolean, String> setPassword(String n, String c) {
        JugadorPersistencia j = new JugadorPersistencia();
        return j.setPassword(n,c);
    }
}