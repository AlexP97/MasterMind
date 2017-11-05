/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.CtrlDominioJugador;
import java.util.ArrayList;

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
        while(opcion != 0){
            Vg.mostrarMensaje("¡Bienvenido a Mastermind!");
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
        //aqui llamar a controlador dominio para el login
        boolean b = false;
        if(datos != null) b = CDj.login(datos.get(0),datos.get(1));
        if(!b) Vg.mostrarError("No se ha podido iniciar sesión correctamente");
        return b;
    }
    private boolean register(){
        ArrayList<String> datos = null;
        Vg.obtenerDatos(datos);
        //aqui llamar a controlador dominio para el register
        boolean b = false;
        if(datos != null) b = CDj.register(datos.get(0),datos.get(1));
        if(!b) Vg.mostrarError("No se ha podido registrar correctamente");
        return b;
    }
}

