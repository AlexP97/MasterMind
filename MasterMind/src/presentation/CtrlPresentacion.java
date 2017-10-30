/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

/**
 *
 * @author Usuario
 */
public class CtrlPresentacion {
    private CtrlDominio CD;
    private CtrlDominioJugador CDj;
    private CtrlPresentacionLoginRegister CPlr;
    private CtrlPresentacionMenu CPm;
    private VistaLoginRegister Vmj;
    private VistaMenu Vm;
    
    public CtrlPresentacion() {
        CD = new CtrlDominio();
        CDj = new CtrlDominioJugador();
        Vmj = new VistaLoginRegister();
    }
    public void iniciarControlador() {
    // - ...
    }
    
    public void iniciarRegistroLogin(){
        CPlr = new CtrlPresentacionLoginRegister(Vmj,CDj);
        CPlr.loginRegister();
    }
    
    public void iniciarMastermind(){
        iniciarRegistroLogin();
    }
}
