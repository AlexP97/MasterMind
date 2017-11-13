/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author Usuario
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
