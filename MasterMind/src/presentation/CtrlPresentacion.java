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
    private CtrlPresentacionMenu CPm;
    private CtrlPresentacionGame CPg;
    
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
        CPm = new CtrlPresentacionMenu(CDp,CDr,CDj,this);
        return CPm.modificarNombre(user);
    }
    
    public Pair <Boolean,String> modificaContraseña(String pass){
        CPm = new CtrlPresentacionMenu(CDp,CDr,CDj,this);
        return CPm.modificarPass(pass);
    }
    
    public Pair <Boolean,String> eliminar(){
        CPm = new CtrlPresentacionMenu(CDp,CDr,CDj,this);
        return CPm.eliminaPerfil();
    }
    
    public Pair <Boolean,String> crearPartida(String userName, String id, String dif, String mod, int num, int ran){
        CPg = new CtrlPresentacionGame(CDp);
        return CPg.crearPartida(userName,id,dif,mod,num,ran);
    }
    
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        CPg = new CtrlPresentacionGame(CDp);
        return CPg.eliminarPartida(userName, id);
    }
    
    public Pair <Boolean, String> setCodIni(ArrayList<Integer> cods){
        CPg = new CtrlPresentacionGame(CDp);
        return CPg.setCodIni(cods);
    }
    
    public ArrayList<Pair<String, Integer>> muestraRanking(){
        CPm = new CtrlPresentacionMenu(CDp,CDr,CDj,this);
        return CPm.mostrarRanking();
    }
    
    private void iniciarRegistroLogin() {
        CPlr = new CtrlPresentacionLoginRegister(CDj,this);
        CPlr.loginRegister();
    }
    
    public void iniciarMasterMind(){
        iniciarRegistroLogin();
    }
}
