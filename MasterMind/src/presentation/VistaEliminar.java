/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.ArrayList;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class VistaEliminar extends VistaGenerica{
    
    @Override
    public void obtenerDatos(ArrayList<String> datos){
        System.out.println("El jugador va a ser eliminado de forma definitiva, ¿estás seguro?");
        System.out.println("1 - Sí");
        System.out.println("2 - No");
        String respuesta = input.nextLine();
        datos.add(respuesta);
    }

    @Override
    public void mostrarVista() {
        
    }

    @Override
    public int getOpciones() {
        return 1;
    }
}
