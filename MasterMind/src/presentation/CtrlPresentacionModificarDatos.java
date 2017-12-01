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
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacionModificarDatos {
    private final VistaGenerica Vg;
    private final CtrlDominioJugador CDj;
    
    public CtrlPresentacionModificarDatos(CtrlDominioJugador CDj){
        this.Vg = new VistaModificarDatos();
        this.CDj = CDj;
    }
    
    public boolean modificarDatos(){
        int opcion = -1;
        while(opcion != 0){
            opcion = Vg.obtenerOpcion();
            switch(opcion){
                case 0: return false;
                case 1: return modificarUsuario();
                case 2: return modificarContraseña();
                case 3: return eliminar();
            }
        }
        return false;
    }
    public boolean modificarUsuario(){
        VistaModificarUsuario Vmu = new VistaModificarUsuario();
        ArrayList<String> datos = new ArrayList<>();
        Vmu.obtenerDatos(datos);        
        Pair<Boolean, String> p = new Pair();
        p = CDj.setName(datos.get(0));
        if(!p.getLeft()) Vg.mostrarError(p.getRight());
        else Vg.mostrarMensaje(p.getRight());
        return p.getLeft();
    }
    public boolean modificarContraseña(){
        VistaModificarContraseña Vmc = new VistaModificarContraseña();
        ArrayList<String> datos = new ArrayList<>();
        Vmc.obtenerDatos(datos);
        Pair<Boolean, String> p = new Pair();
        p = CDj.setPassword(datos.get(0));
        if(!p.getLeft()) Vg.mostrarError(p.getRight());
        else Vg.mostrarMensaje(p.getRight());
        return p.getLeft();
    }
    public boolean eliminar(){
        VistaEliminar Ve = new VistaEliminar();
        ArrayList<String> datos = new ArrayList<>();
        Ve.obtenerDatos(datos);
        if(datos.get(0).equals("1")){
            Pair<Boolean, String> p = new Pair();
            p = CDj.elimina();
            if(!p.getLeft()) Vg.mostrarError(p.getRight());
            else Vg.mostrarMensaje(p.getRight());
            return p.getLeft();
        }
        else if (datos.get(0).equals("2")) Vg.mostrarMensaje("Se ha cancelado la eliminación del usuario");
        return true;
    }
}
