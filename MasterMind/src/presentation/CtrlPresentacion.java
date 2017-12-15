/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.CtrlDominio;
import domain.CtrlDominioJugador;
import domain.CtrlDominioPartida;
import domain.CtrlDominioRanking;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacion {
    private final CtrlDominio CD;
    private final CtrlDominioJugador CDj;
    private final CtrlDominioPartida CDp;
    private final CtrlDominioRanking CDr;
    private CtrlPresentacionLoginRegister CPlr;
    private CtrlPresentacionModificarDatos CPm;
    private CtrlPresentacionGame CPg;
    private CtrlPresentacionRanking CPr;
    
    public CtrlPresentacion() {
        CD = new CtrlDominio();
        CDj = CD.getCtrlDominioJugador();
        CDp = CD.getCtrlDominioPartida();
        CDr = CD.getCtrlDominioRanking();
    }
    
    public Pair <Boolean,String> login(String user, String pass){
        CPlr = new CtrlPresentacionLoginRegister(CDj,this);
        return CPlr.login(user,pass);
    }
    
    public Pair <Boolean,String> register(String user, String pass){
        CPlr = new CtrlPresentacionLoginRegister(CDj,this);
        return CPlr.register(user,pass);
    }
    
    public String getName(){
        return CDj.getName();
    }
    
    public String getId(){
        return CDp.getId();
    }
    
    public Pair <Boolean,String> modificaUsuario(String user){
        CPm = new CtrlPresentacionModificarDatos(CDj);
        return CPm.modificarUsuario(user);
    }
    
    public Pair <Boolean,String> modificaContraseña(String pass){
        CPm = new CtrlPresentacionModificarDatos(CDj);
        return CPm.modificarContraseña(pass);
    }
    
    public Pair <Boolean,String> eliminar(){
        CPm = new CtrlPresentacionModificarDatos(CDj);
        return CPm.eliminar();
    }
    
    public Pair <Boolean,String> crearPartida(String userName, String id, String dif, String mod, int num, int ran){
        CPg = new CtrlPresentacionGame(CDp);
        return CPg.crearPartida(userName,id,dif,mod,num,ran);
    }
    
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return CPg.eliminarPartida(userName, id);
    }
    
    public Pair <Boolean, String> setCodIni(ArrayList<Integer> cods){
        return CPg.setCodIni(cods);
    }
    
    public Pair <Boolean, String> saveGame(){
        return CPg.saveGame(getName());
    }
    
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        return CPg.jugadaCodeB(cods);
    }
    
    public Pair <Boolean,Integer> finishGame(boolean b){
        return CPg.finishGame(b);
    }
    
    public ArrayList<Pair<String, Integer>> muestraRanking(){
        CPr = new CtrlPresentacionRanking(CDr);
        return CPr.mostrarRanking();
    }
    
    public Pair<Boolean, Integer> actualizaRanking(String nombre, int puntos){
        CPr = new CtrlPresentacionRanking(CDr);
        return CPr.actualizaRanking(nombre,puntos);
    }
    
    private void iniciarRegistroLogin() {
        CPlr = new CtrlPresentacionLoginRegister(CDj,this);
        CPlr.loginRegister();
    }
    
    public void iniciarMasterMind(){
        iniciarRegistroLogin();
    }
}
