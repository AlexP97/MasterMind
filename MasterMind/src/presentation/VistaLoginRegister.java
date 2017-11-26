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
public class VistaLoginRegister extends VistaGenerica {
    final int nOpciones = 3;
    
    public VistaLoginRegister(){
        super();
    }
    
    @Override
    public void mostrarVista(){
        System.out.println("0 - Finalizar la ejecución del juego");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
    }
    
    @Override
    public int getOpciones(){
        return this.nOpciones;
    }   
    
    @Override
    public void obtenerDatos(ArrayList<String> datos){
        datos = new ArrayList<>();
        System.out.println("Introduce el nombre de usuario:");
        datos.add(input.nextLine());
        System.out.println("Introduce la contraseña:");
        datos.add(input.nextLine());
    }
}
