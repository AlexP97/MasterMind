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
import java.util.Arrays;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacionMenuBorrarPronto {
    private final CtrlDominioPartida CDp;
    private final CtrlDominioRanking CDr;
    private final CtrlDominioJugador CDj;

    
    public CtrlPresentacionMenuBorrarPronto(CtrlDominioPartida CDp, CtrlDominioRanking CDr, CtrlDominioJugador CDj){
        this.CDp = CDp;
        this.CDr = CDr;
        this.CDj = CDj;

    }
    
    private boolean crearPartida(){
        VistaCrearPartida Vcrear = new VistaCrearPartida();
        ArrayList<String> datos = new ArrayList<>();
        Vcrear.obtenerDatos(datos);
        Pair<Boolean, String> p = new Pair();
        p = CDp.crearPartida(CDj.getName(),datos.get(0),datos.get(1),datos.get(2),Integer.parseInt(datos.get(3)), Integer.parseInt(datos.get(4)));
        return p.getLeft();
    }
    
    private boolean cargarPartida(){
        VistaCargarPartida Vcargar = new VistaCargarPartida();
        ArrayList<String> partidas = new ArrayList<String>(Arrays.asList(CDj.obtenerPartidas()));
        ArrayList<String> datos = new ArrayList<>();
        Vcargar.obtenerDatos(datos,partidas);
        Pair<Boolean, String> p = new Pair();
        p = CDp.cargarPartida(CDj.getName(),datos.get(0));
        return p.getLeft();
    }
    
    public ArrayList<Pair<String, Integer>> mostrarRanking(){
        return CDr.muestraRanking();
    }

    public Pair<Boolean,String> modificarNombre(String user) {
        CtrlPresentacionModificarDatos CPmd = new CtrlPresentacionModificarDatos(CDj);
        return CPmd.modificarUsuario(user);
    }
    
    public Pair<Boolean,String> modificarPass(String pass) {
        CtrlPresentacionModificarDatos CPmd = new CtrlPresentacionModificarDatos(CDj);
        return CPmd.modificarContraseña(pass);
    }
    
    public Pair<Boolean,String> eliminaPerfil(){
        CtrlPresentacionModificarDatos CPmd = new CtrlPresentacionModificarDatos(CDj);
        return CPmd.eliminar();
    }
}
