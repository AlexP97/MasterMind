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

/**
 *
 * @author Usuario
 */
public class CtrlPresentacion {
    private final CtrlDominio CD;
    private final CtrlDominioJugador CDj;
    private final CtrlDominioPartida CDp;
    private final CtrlDominioRanking CDr;
    private CtrlPresentacionLoginRegister CPlr;
    private CtrlPresentacionMenu CPm;
    private final VistaLoginRegister Vlr;
    private final VistaMenu Vm;
    
    public CtrlPresentacion() {
        CD = new CtrlDominio();
        CDj = new CtrlDominioJugador();
        CDp = new CtrlDominioPartida();
        CDr = new CtrlDominioRanking();
        Vlr = new VistaLoginRegister();
        Vm = new VistaMenu();
    }
    public void iniciarPresentacion() {
        CD.inicializarDominio();
        // ...
    }
    
    public void iniciarRegistroLogin(){
        CPlr = new CtrlPresentacionLoginRegister(Vlr,CDj);
        if (CPlr.loginRegister()){
            iniciarCrearCargarRanking();
        }
    }
    
    public void iniciarCrearCargarRanking(){
        CPm = new CtrlPresentacionMenu(Vm,CDp,CDr);
        if(CPm.crearCargarRanking()){
            
        }
    }
    
    public void iniciarMastermind(){
        iniciarRegistroLogin();
    }
}
