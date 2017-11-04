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
public class CtrlDominioPartida {
    
    private Game game;
    
    public CtrlDominioPartida() {
        
        game = new Game();
        
    }
    
    public boolean cargarPartida(String userName, String pass) {
        
        return game.LoadGame(userName, pass);
    }
    
    public boolean crearPartida(String s1, String s2, String s3) {
        
        return false;
    }
}
