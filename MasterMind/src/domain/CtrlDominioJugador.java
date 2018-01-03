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
 * @author Pérez Ortiz, Alejandro
 */
public class CtrlDominioJugador {
    
    private final CtrlPersistenciaJugador CPmj;
    private Jugador j;

    /**
     *
     * @param c el controlador de persistencia de la clase Jugador
     */
    public CtrlDominioJugador(CtrlPersistenciaJugador c) {
        CPmj = c;
        j = new Jugador();
    }
    
    /**
     *
     * @param s1 el nombre de usuario del jugador
     * @param s2 la contraseña del jugador
     * @return un booleano con si se ha podido hacer login y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> login(String s1, String s2) {
        Pair<Boolean, String> p = CPmj.login(s1,s2);
        if(p.getLeft()) {
            j.login(s1, s2);
        }
       return p;
    }
    
    /**
     *
     * @param s1 el nombre deseado
     * @param s2 la contraseña deseada
     * @return un booleano con si se ha podido registrar y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> register(String s1, String s2) {
        Pair<Boolean, String> p = CPmj.register(s1, s2);
        if(p.getLeft()) {
            j.register(s1,s2);
        }
        return p;
    }
    
    /**
     *
     * @return un booleano con si se ha podido eliminar el usuario y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> elimina() {
        Pair<Boolean, String> p = CPmj.elimina(j.getName());
        return p;
    }
    
    /**
     *
     * @param n el nombre que se quiere asignar al usuario
     * @return un booleano con si se ha podido asignar el nombre de usuario y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> setName(String n) {
        Pair<Boolean, String> p = CPmj.setName(j.getName(), n, j.getPassword());
        if(p.getLeft())
            j.setName(n);
        return p;
    }
    
    /**
     *
     * @param c la contraseña que se quiere asignar al usuario
     * @return un booleano con si se ha podido asignar la contraseña y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> setPassword(String c) {
        Pair<Boolean, String> p = CPmj.setPassword(j.getName(), c);
        if(p.getLeft())
            j.setPassword(c);
        return p;
    }
    
    /**
     *
     * @return el nombre del jugador actual
     */
    public String getName() {
        return j.getName();
    }

    /**
     *
     * @return una lista con las partidas guardadas
     */
    public String[] obtenerPartidas() {
        return CPmj.obtenerPartidas(j.getName());
    }
    
}
