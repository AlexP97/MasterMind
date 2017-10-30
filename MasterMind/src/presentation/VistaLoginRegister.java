/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class VistaLoginRegister {
    protected Scanner input = new Scanner(System.in);
    
    public VistaLoginRegister(){
        
    }
    
    public void mostrarVista(){
        System.out.println("0 - Salir");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
    }
    //NO SE SI HACER UNA SUPERCLASE VISTA CON ESTAS FUNCIONES, Y QUE LAS SUBCLASES DE LOGINREGISTER Y MENU 
    //SE ENCARGUEN DEL I/O
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public void mostrarError(String error){
        System.out.println("Error: "+error);
    }
    
    public int obtenerOpcion(){
        int opcion = -1;
        while(opcion < 0){
            mostrarVista();
            opcion = Integer.parseInt(input.nextLine());
        }
        return opcion;
    }
}
