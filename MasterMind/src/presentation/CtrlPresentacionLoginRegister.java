package presentation;

import domain.CtrlDominioJugador;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacionLoginRegister {
    private final CtrlDominioJugador CDj;
    private final CtrlPresentacion CP;
    
    /**
     *
     * @param CDj el controlador de dominio de la clase Jugador
     * @param CP el controlador de la capa de presentación
     */
    public CtrlPresentacionLoginRegister(CtrlDominioJugador CDj, CtrlPresentacion CP){
        this.CDj = CDj;
        this.CP = CP;
    }
    
    public void loginRegister() {
        VistaPresentacion Vp = new VistaPresentacion();
        Vp.setCP(CP);
        Vp.setVisible(true);
    }
    
    /**
     *
     * @param user el nombre de usuario del jugador
     * @param password la contraseña del jugador
     * @return un booleano con si se ha podido hacer login y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean,String> login(String user, String password){
        Pair<Boolean, String> p = CDj.login(user,password);
        return p;
    }

    /**
     *
     * @param user el nombre deseado
     * @param password la contraseña deseada
     * @return un booleano con si se ha podido registrar y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean,String> register(String user, String password){
        Pair<Boolean, String> p = CDj.register(user,password);
        return p;
    }
}

