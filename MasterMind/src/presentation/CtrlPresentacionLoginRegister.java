/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.CtrlDominioJugador;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacionLoginRegister {
    private final VistaGenerica Vg;
    private final CtrlDominioJugador CDj;
    private final CtrlPresentacion CP;
    
    public CtrlPresentacionLoginRegister(CtrlDominioJugador CDj, CtrlPresentacion CP){
        this.Vg = new VistaLoginRegister();
        this.CDj = CDj;
        this.CP = CP;
    }
    
    public void loginRegister() {
        VistaPresentacion Vp = new VistaPresentacion();
        Vp.setCP(CP);
        Vp.setVisible(true);
    }
    
    public Pair<Boolean,String> login(String user, String password){
        Pair<Boolean, String> p = CDj.login(user,password);
        return p;
    }
    public Pair<Boolean,String> register(String user, String password){
        Pair<Boolean, String> p = CDj.register(user,password);
        return p;
    }
}

