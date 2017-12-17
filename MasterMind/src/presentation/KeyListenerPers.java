/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Usuario
 */
public class KeyListenerPers implements KeyListener {
    private final javax.swing.JButton jButton;
    private final int keyPressed;
    
    public KeyListenerPers(javax.swing.JButton jButton, int keyPressed){
        this.jButton = jButton;
        this.keyPressed = keyPressed;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == keyPressed){
            jButton.doClick();
        } 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
