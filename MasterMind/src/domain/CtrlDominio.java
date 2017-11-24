/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.CtrlPersistencia;
import persistence.CtrlPersistenciaJugador;

/**
 *
 * @author Daniel
 */
public class CtrlDominio {
    
    private final CtrlPersistencia CP;
    private final CtrlDominioJugador CDmj;
    private final CtrlDominioPartida CDmp;
    private final CtrlDominioRanking CDmr;
    private final CtrlPersistenciaJugador CPj;
    private final CtrlPersistenciaPartida CPp;
    private final CtrlPersistenciaRanking CPr;
    
           
    
    public CtrlDominio(){
        
        CP = new CtrlPersistencia();
        CPj = CP.getCtrlPersistenciaJugador();
        CPp = CP.getCtrlPersistenciaPartida();
        CPr = CP.getCtrlPersistenciaRanking();
        CDmj = new CtrlDominioJugador(CPj);
        CDmp = new CtrlDominioPartida(CPp);
        CDmr = new CtrlDominioRanking(CPr);
        
        
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
