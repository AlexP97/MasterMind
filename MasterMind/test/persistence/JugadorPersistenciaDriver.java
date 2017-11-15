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
        testSetName();
        testSetPassword();
        testElimina();
    }
    
    public void testRegister() {
        Pair<Boolean, String> p = jugador.register("Juan", "456");
    }
    
    public void testLogin() {
        Pair<Boolean, String> p = jugador.login("Juan", "456");
    }
    
    public void testSetName() {
        Boolean b = jugador.setName("Juan", "Pepe", "456");
    }
    
    public void testSetPassword() {
        Boolean b = jugador.setPassword("Juan", "789");
    }
    
    public void testElimina() {
        jugador.elimina("Pepe");
    }
    
}
