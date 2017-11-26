/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author aleja
 */
public class CtrlPersistencia {
    private final CtrlPersistenciaJugador CPmj;
    private final CtrlPersistenciaGame CPmp;
    private final CtrlPersistenciaRanking CPmr;
           
    
    public CtrlPersistencia(){
        CPmj = new CtrlPersistenciaJugador();
        CPmp = new CtrlPersistenciaGame();
        CPmr = new CtrlPersistenciaRanking();
    }
    
    public CtrlPersistenciaJugador getCtrlPersistenciaJugador() {
        return CPmj;
    }
    
    public CtrlPersistenciaGame getCtrlPersistenciaPartida() {
        return CPmp;
    }
    
    public CtrlPersistenciaRanking getCtrlPersistenciaRanking() {
        return CPmr;
    }
}
