/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.CtrlDominioJugador;
import domain.CtrlDominioPartida;
import domain.CtrlDominioRanking;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacionMenu extends CtrlPresentacion {
    private final VistaGenerica Vg;
    private final CtrlDominioPartida CDp;
    private final CtrlDominioRanking CDr;
    private final CtrlDominioJugador CDj;
    
    public CtrlPresentacionMenu(CtrlDominioPartida CDp, CtrlDominioRanking CDr, CtrlDominioJugador CDj){
        this.Vg = new VistaMenu();
        this.CDp = CDp;
        this.CDr = CDr;
        this.CDj = CDj;
    }
    
    public boolean crearCargarRankingModificar(){
        int opcion = -1;
        while(opcion != 0){
            opcion = Vg.obtenerOpcion();
            switch(opcion){
                case 0: return false;
                case 1: return crearPartida();
                case 2: return cargarPartida();
                case 3: return muestraRanking();
                case 4: return modificarDatos();
            }
        }
        return false;
    }
    
    private boolean crearPartida(){
        VistaCrearPartida Vcrear = new VistaCrearPartida();
        ArrayList<String> datos = null;
        Vcrear.obtenerDatos(datos);
        boolean b = false;
        if(datos != null) CDp.crearPartida(datos.get(0),datos.get(1),datos.get(2));
        if(!b) Vg.mostrarError("No se ha podido crear partida correctamente");
        return b;
    }
    
    private boolean cargarPartida(){
        VistaCargarPartida Vcargar = new VistaCargarPartida();
        ArrayList<String> datos = new ArrayList<>();
        Vcargar.obtenerDatos(datos);
        boolean b = false;
        
        if(!b) Vg.mostrarError("No se ha podido cargar partida correctamente");
        return b;
    }
    
    private boolean muestraRanking(){
        ArrayList<Pair<String, Integer>> ranking = CDr.muestraRanking();
        if(ranking.isEmpty()){
            Vg.mostrarMensaje("El ranking está vacío");
        }
        else{
            Vg.mostrarRanking(ranking);
        }
        return true;
    }

    private boolean modificarDatos() {
        CtrlPresentacionModificarDatos CPmd = new CtrlPresentacionModificarDatos(CDj);
        return CPmd.modificarDatos();
    }
}
