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
public class VistaCargarPartida extends VistaGenerica{
    
    public VistaCargarPartida(){
        super();
    }
    
    public void obtenerDatos(ArrayList<String> datos, ArrayList<String> partidas){
        datos = new ArrayList<>();//aqui habra que pedir el id de la partida
        System.out.println("");
        datos.add(input.nextLine());
    }

    @Override
    void mostrarVista() {

    }

    @Override
    int getOpciones() {
        return 1;
    }

    @Override
    void obtenerDatos(ArrayList<String> datos) {
        
    }
}
