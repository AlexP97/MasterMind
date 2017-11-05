/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.CtrlDominioPartida;
import domain.CtrlDominioRanking;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CtrlPresentacionMenu extends CtrlPresentacion {
    private final VistaGenerica Vg;
    private final CtrlDominioPartida CDp;
    private final CtrlDominioRanking CDr;
    
    public CtrlPresentacionMenu(CtrlDominioPartida CDp, CtrlDominioRanking CDr){
        this.Vg = new VistaMenu();
        this.CDp = CDp;
        this.CDr = CDr;
    }
    
    public boolean crearCargarRanking(){
        int opcion = -1;
        while(opcion != 0){
            System.out.print("Bienvenido a MasterMind." + "\n");
            opcion = Vg.obtenerOpcion();
            switch(opcion){
                case 0: return false;
                case 1: return crearPartida();
                case 2: return cargarPartida();
                case 3: return muestraRanking();
            }
        }
        return false;
    }
    
    private boolean crearPartida(){
        ArrayList<String> datos = null;
        Vg.obtenerDatos(datos);
        boolean b = false;
        if(datos != null) CDp.crearPartida(datos.get(0),datos.get(1),datos.get(2));
        if(!b) Vg.mostrarError("No se ha podido crear partida correctamente");
        return b;
    }
    
    private boolean cargarPartida(){
        ArrayList<String> datos = null;
        Vg.obtenerDatos(datos);
        boolean b = false;
        if(datos != null) CDp.cargarPartida(datos.get(0),datos.get(1));
        if(!b) Vg.mostrarError("No se ha podido cargar partida correctamente");
        return b;
    }
    
    private boolean muestraRanking(){
        boolean b = CDr.muestraRanking();
        if(!b) Vg.mostrarError("No se ha podido mostrar el ranking correctamente");
        return b;
    }
}
