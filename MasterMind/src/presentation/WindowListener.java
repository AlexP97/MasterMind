package presentation;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JScrollPane;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class WindowListener implements ComponentListener {
    private final javax.swing.JScrollPane jScrollPane;
    
    /**
     *
     * @param jScrollPane el panel de scroll que se quiere visibilizar
     */
    public WindowListener(javax.swing.JScrollPane jScrollPane){
        this.jScrollPane = jScrollPane;
    }
    
    /**
     *
     * @param ce un evento de bajo nivel que indica que un componente se movió, cambió de tamaño o cambió la visibilidad
     */
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
