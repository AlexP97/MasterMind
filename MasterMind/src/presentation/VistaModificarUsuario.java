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
public class VistaModificarUsuario extends VistaGenerica{
    
    @Override
    public void obtenerDatos(ArrayList<String> datos){
        System.out.println("Introduce tu nuevo nombre de usuario");
        String name = input.nextLine();
        datos.add(name);
    }

    @Override
    public void mostrarVista() {
        
    }

    @Override
    public int getOpciones() {
        return 1;
    }
}
