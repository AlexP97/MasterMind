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
    private final CtrlDominioPartida CDp;
    private final CtrlDominioRanking CDr;
    private final CtrlDominioJugador CDj;
    private final CtrlPresentacion CP;
    
    public CtrlPresentacionMenu(CtrlDominioPartida CDp, CtrlDominioRanking CDr, CtrlDominioJugador CDj, CtrlPresentacion CP){
        this.CDp = CDp;
        this.CDr = CDr;
        this.CDj = CDj;
        this.CP = CP;
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
        ArrayList<String> partidas = CDj.obtenerPartidas();
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
