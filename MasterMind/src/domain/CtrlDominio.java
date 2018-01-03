package domain;

import persistence.CtrlPersistenciaGame;
import persistence.CtrlPersistenciaJugador;
import persistence.CtrlPersistenciaRanking;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public class CtrlDominio {
    
    private final CtrlDominioJugador CDmj;
    private final CtrlDominioPartida CDmp;
    private final CtrlDominioRanking CDmr;
    private final CtrlPersistenciaJugador CPj;
    private final CtrlPersistenciaGame CPg;
    private final CtrlPersistenciaRanking CPr;
    
           
    
    public CtrlDominio(){
        
        CPj = new CtrlPersistenciaJugador();
        CPg = new CtrlPersistenciaGame();
        CPr = new CtrlPersistenciaRanking();
        CDmj = new CtrlDominioJugador(CPj);
        CDmp = new CtrlDominioPartida(CPg);
        CDmr = new CtrlDominioRanking(CPr);
        
    }
    
    /**
     *
     * @return el controlador de dominio de la clase Jugador
     */
    public CtrlDominioJugador getCtrlDominioJugador() {
        return CDmj;
    }
    
    /**
     *
     * @return el controlador de dominio de la clase Game
     */
    public CtrlDominioPartida getCtrlDominioPartida() {
        return CDmp;
    }
    
    /**
     *
     * @return el controlador de dominio de la clase Ranking
     */
    public CtrlDominioRanking getCtrlDominioRanking() {
        return CDmr;
    }
    
}
