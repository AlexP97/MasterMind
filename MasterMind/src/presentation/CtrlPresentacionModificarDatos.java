package presentation;

import domain.CtrlDominioJugador;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacionModificarDatos {
    private final CtrlDominioJugador CDj;
    
    /**
     *
     * @param CDj el controlador de dominio de la clase Jugador
     */
    public CtrlPresentacionModificarDatos(CtrlDominioJugador CDj){
        this.CDj = CDj;
    }
    
    /**
     *
     * @param user el nuevo nombre de usuario
     * @return un booleano con si se ha podido modificar y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean,String> modificarUsuario(String user){
        Pair<Boolean, String> p = CDj.setName(user);
        return p;
    }
    
    /**
     *
     * @param pass la nueva contraseña
     * @return un booleano con si se ha podido modificar y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean,String> modificarContraseña(String pass){
        Pair<Boolean, String> p = CDj.setPassword(pass);
        return p;
    }
    
    /**
     *
     * @return un booleano con si se ha podido eliminar y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean,String> eliminar(){
        Pair<Boolean,String> p = CDj.elimina();
        return p;
    }
}
