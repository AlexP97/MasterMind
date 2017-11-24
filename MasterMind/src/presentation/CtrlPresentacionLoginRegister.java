/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.CtrlDominioJugador;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Usuario
 */
public class CtrlPresentacionLoginRegister extends CtrlPresentacion {
    private final VistaGenerica Vg;
    private final CtrlDominioJugador CDj;
    
    public CtrlPresentacionLoginRegister(CtrlDominioJugador CDj){
        this.Vg = new VistaLoginRegister();
        this.CDj = CDj;
    }
    
    public boolean loginRegister(){
        int opcion = -1;
        Vg.mostrarMensaje("¡Bienvenido a Mastermind!");
        while(opcion != 0){
            opcion = Vg.obtenerOpcion();
            switch(opcion){
                case 0: return false;
                case 1: return login();
                case 2: return register();
            }
        }
        return false;
    }
    
    private boolean login(){
        ArrayList<String> datos = null;
        Vg.obtenerDatos(datos);
        Pair<Boolean, String> p = new Pair();
        if(datos != null) p = CDj.login(datos.get(0),datos.get(1));
        if(!p.getLeft()) Vg.mostrarError(p.getRight());
        else Vg.mostrarMensaje(p.getRight());
        return p.getLeft();
    }
    private boolean register(){
        ArrayList<String> datos = null;
        Vg.obtenerDatos(datos);
        Pair<Boolean, String> p = new Pair();
        if(datos != null) p = CDj.register(datos.get(0),datos.get(1));
        if(!p.getLeft()) Vg.mostrarError(p.getRight());
        else Vg.mostrarMensaje(p.getRight());
        return p.getLeft();
    }
}

