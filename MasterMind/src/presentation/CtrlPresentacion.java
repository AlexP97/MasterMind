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
import exception.ExceptionAcabaPrograma;

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
    
    public CtrlPresentacion() {
        CD = new CtrlDominio();
        CDj = CD.getCtrlDominioJugador();
        CDp = CD.getCtrlDominioPartida();
        CDr = CD.getCtrlDominioRanking();
    }
    
    private void iniciarRegistroLogin() throws ExceptionAcabaPrograma {
        CPlr = new CtrlPresentacionLoginRegister(CDj);
        while(CPlr.loginRegister()){
            iniciarCrearCargarRanking();
        }
    }
    
    private void iniciarCrearCargarRanking(){
        CPm = new CtrlPresentacionMenu(CDp,CDr,CDj);
        while(CPm.crearCargarRankingModificar()){
            
        }
    }
    
    public void iniciarMasterMind(){
        boolean continua = true;
        while(continua){
            try{
                iniciarRegistroLogin();
            }
            catch(ExceptionAcabaPrograma ex){
                continua = false;
                System.out.println(ex.getMessage());
            }
        }
    }
}
