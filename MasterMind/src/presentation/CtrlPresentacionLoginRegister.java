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
public class CtrlPresentacionLoginRegister {
    private VistaLoginRegister Vlr;
    private CtrlDominioJugador CDj;
    
    public CtrlPresentacionLoginRegister(VistaLoginRegister Vlr, CtrlDominioJugador CDj){
        this.Vlr = Vlr;
        this.CDj = CDj;
    }
    public void loginRegister(){
        int opcion = -1;
        while(opcion != 0){
            System.out.print("Bienvenido a MasterMind." + "\n");
            opcion = Vlr.obtenerOpcion();
            switch(opcion){
                case 0: break;
                case 1: 
            }
        }
    }
}

