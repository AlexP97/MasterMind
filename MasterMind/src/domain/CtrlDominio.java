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
    
    private final CtrlDominioJugador CDmj;
    private final CtrlDominioPartida CDmp;
    private final CtrlDominioRanking CDmr;
           
    
    public CtrlDominio(){
        CDmj = new CtrlDominioJugador();
        CDmp = new CtrlDominioPartida();
        CDmr = new CtrlDominioRanking();
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
