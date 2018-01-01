/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JScrollPane;

/**
 *
 * @author Usuario
 */
public class WindowListener implements ComponentListener {
    private final javax.swing.JScrollPane jScrollPane;
    
    public WindowListener(javax.swing.JScrollPane jScrollPane){
        this.jScrollPane = jScrollPane;
    }
    
    @Override
    public void componentResized(ComponentEvent ce) {
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
        
    }

    @Override
    public void componentShown(ComponentEvent ce) {
        
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        
    }
    
}
