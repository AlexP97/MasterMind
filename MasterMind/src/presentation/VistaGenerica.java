/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Pair;

/**
 *
 * @author User
 */
public abstract class VistaGenerica {
    protected Scanner input = new Scanner(System.in);
    abstract void mostrarVista();
    abstract int getOpciones();
    abstract void obtenerDatos(ArrayList<String> datos);
    void mostrarRanking(ArrayList<Pair<String, Integer>> ranking){ }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public void mostrarError(String error){
        System.out.println("Error: "+error);
    }
    
    public int obtenerOpcion(){
        int opcion = -1;
        while(opcion < 0 && opcion > this.getOpciones()){
            mostrarVista();
            opcion = Integer.parseInt(input.nextLine());
        }
        return opcion;
    }

}
