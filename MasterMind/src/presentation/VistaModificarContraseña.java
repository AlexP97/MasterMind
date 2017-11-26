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
public class VistaModificarContraseña extends VistaGenerica{
    
    @Override
    public void obtenerDatos(ArrayList<String> datos){
        System.out.println("Introduce tu nueva contraseña");
        String pass = input.nextLine();
        datos.add(pass);
    }

    @Override
    public void mostrarVista() {
        
    }

    @Override
    public int getOpciones() {
        return 1;
    }
}
