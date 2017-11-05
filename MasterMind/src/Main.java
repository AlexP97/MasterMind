
import presentation.CtrlPresentacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Main {
    private static CtrlPresentacion CP;
    
    public static void main(String[] args){
        CP = new CtrlPresentacion();    
        CP.iniciarMastermind();
    }
}
