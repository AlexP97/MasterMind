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
public class VistaModificarDatos extends VistaGenerica{
    final int nOpciones = 4;
    
    public VistaModificarDatos(){
        super();
    }
    
    @Override
    public void obtenerDatos(ArrayList<String> datos){
        
    }

    @Override
    void mostrarVista() {
        System.out.println("0 - Volver atrás");
        System.out.println("1 - Modificar nombre de usuario");
        System.out.println("2 - Modificar contraseña");
        System.out.println("3 - Eliminar mi usuario del juego");
    }

    @Override
    int getOpciones() {
        return this.nOpciones;
    }
}
