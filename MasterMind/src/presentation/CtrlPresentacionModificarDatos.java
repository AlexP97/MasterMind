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
public class CtrlPresentacionModificarDatos {
    private final CtrlDominioJugador CDj;
    
    public CtrlPresentacionModificarDatos(CtrlDominioJugador CDj){
        this.CDj = CDj;
    }
    
    public Pair<Boolean,String> modificarUsuario(String user){
        Pair<Boolean, String> p = CDj.setName(user);
        return p;
    }
    public Pair<Boolean,String> modificarContraseña(String pass){
        Pair<Boolean, String> p = CDj.setPassword(pass);
        return p;
    }
    public Pair<Boolean,String> eliminar(){
        Pair<Boolean,String> p = CDj.elimina();
        return p;
    }
}
