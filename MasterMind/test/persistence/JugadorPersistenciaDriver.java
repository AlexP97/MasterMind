/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import utils.Pair;

/**
 *
 * @author usuario
 */
public class JugadorPersistenciaDriver {
    JugadorPersistencia jugador;
    
    public JugadorPersistenciaDriver() {
        jugador = new JugadorPersistencia();
        testRegister();
        testLogin();
    }
    
    public void testRegister() {
        Pair<Boolean, String> p = jugador.register("Juan", "456");
    }
    
    public void testLogin() {
        Pair<Boolean, String> p = jugador.login("Juan", "456");
    }
}
