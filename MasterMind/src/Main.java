
import presentation.CtrlPresentacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class Main {
    private static CtrlPresentacion CP;
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater (
            new Runnable(){
                @Override
                public void run(){
                    CP = new CtrlPresentacion();    
                    CP.iniciarMasterMind();
                }
            });
    }
}
