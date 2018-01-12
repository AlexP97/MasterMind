/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

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
    
    /**
     *
     * @param s1 el nombre de usuario del jugador
     * @param s2 la contraseña del jugador
     * @return un booleano con si se ha podido hacer login y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> login(String s1, String s2) {
        return j.login(s1, s2);
    }
    
    /**
     *
     * @param s1 el nombre deseado
     * @param s2 la contraseña deseada
     * @return un booleano con si se ha podido registrar y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> register(String s1, String s2) {
        return j.register(s1,s2);
    }
    
    /**
     *
     * @param n el nombre del usuario que se quiere eliminar
     * @return un booleano con si se ha podido eliminar y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> elimina(String n) {
        return j.elimina(n);
    }
    
    /**
     *
     * @param n1 el nombre anterior
     * @param n2 el nombre que se quiere asignar
     * @param c la contraseña del usuario
     * @return un booleano con si se ha podido asignar el nombre y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> setName(String n1, String n2, String c) {
        return j.setName(n1,n2,c);
    }
    
    /**
     *
     * @param n el nombre del usuario que quiere asignar una contraseña
     * @param c la contraseña elegida
     * @return un booleano con si se ha podido asignar la contraseña y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> setPassword(String n, String c) {
        return j.setPassword(n,c);
    }

    /**
     *
     * @param n el nombre del usuario que quiere ver sus partidas guardadas
     * @return una lista de las partidas guardadas por el usuario
     */
    public String[] obtenerPartidas(String n) {
       return j.obtenerPartidas(n);
    }
}
