package presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class KeyListenerPers implements KeyListener {
    private final javax.swing.JButton jButton;
    private final int keyPressed;
    
    /**
     *
     * @param jButton el botón que se debe pulsar
     * @param keyPressed la tecla que debe pulsar el botón
     */
    public KeyListenerPers(javax.swing.JButton jButton, int keyPressed){
        this.jButton = jButton;
        this.keyPressed = keyPressed;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     *
     * @param e el evento de teclado
     */
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
