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
public class VistaCrearPartida extends VistaGenerica {
    
    public VistaCrearPartida(){
        super();
    }
    
    @Override
    public void obtenerDatos(ArrayList<String> datos){
        System.out.print("Escribe el id de la partida" + "\n");
        datos.add(input.nextLine());
        System.out.print("Escribe la dificultad de la partida (facil, medio o dificil)" + "\n");
        datos.add(input.nextLine());
        System.out.print("Escribe el modo de la partida (codebreaker o codemaker)" + "\n");
        datos.add(input.nextLine());
    }

    @Override
    void mostrarVista() {

    }

    @Override
    int getOpciones() {
        return 1;
    }
}
