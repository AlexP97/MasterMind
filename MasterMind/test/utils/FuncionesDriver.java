package utils;

import java.util.ArrayList;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class FuncionesDriver {
    
    public FuncionesDriver(){
        testOrdenar();
        testCreaArray();
    }
    
    public void testOrdenar(){
        ArrayList<Integer> a = new ArrayList<>();
        Funciones.ordenar(a);
    }
    
    public void testCreaArray(){
        ArrayList<Integer> a = Funciones.creaArray(1,1,1,1);
    }
}
