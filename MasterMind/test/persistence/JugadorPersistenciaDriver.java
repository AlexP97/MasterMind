package persistence;

import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
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
