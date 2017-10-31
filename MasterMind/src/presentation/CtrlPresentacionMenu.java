/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CtrlPresentacionMenu {
    private VistaGenerica Vg;
    private CtrlDominioPartida CDp;
    private CtrlDominioRanking CDr;
    
    public CtrlPresentacionMenu(VistaGenerica Vg, CtrlDominioPartida CDp, CtrlDominioRanking CDr){
        this.Vg = Vg;
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
        boolean b = CDp.crearPartida(datos.get(0),datos.get(1),datos.get(2));
        if(!b) Vg.mostrarError("No se ha podido crear partida correctamente");
        return b;
    }
    
    private boolean cargarPartida(){
        
        boolean b = CDp.cargarPartida();
        if(!b) Vg.mostrarError("No se ha podido cargar partida correctamente");
        return b;
    }
    
    private boolean muestraRanking(){
        boolean b = CDr.muestraRanking();
        if(!b) Vg.mostrarError("No se ha podido mostrar el ranking correctamente");
        return b;
    }
}
