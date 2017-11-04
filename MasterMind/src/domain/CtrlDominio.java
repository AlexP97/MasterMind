/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Daniel
 */
public class CtrlDominio {
    
    private CtrlDominioJugador CDmj;
    private CtrlDominioPartida CDmp;
    private CtrlDominioRanking CDmr;
           
    
    public CtrlDominio(){
        CDmj = new CtrlDominioJugador();
        CDmp = new CtrlDominioPartida();
        CDmr = new CtrlDominioRanking();
    }
    
    public void inicializarDominio() {
        
    }
    
    public CtrlDominioJugador getCtrlDominioJugador() {
        return CDmj;
    }
    
    public CtrlDominioPartida getCtrlDominioPartida() {
        return CDmp;
    }
    
    public CtrlDominioRanking getCtrlDominioRanking() {
        return CDmr;
    }
}
