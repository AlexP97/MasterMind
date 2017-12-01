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
 * @author Espejo Saldaña, Adrián
 */
public abstract class VistaGenerica {
    protected Scanner input;
    abstract void mostrarVista();
    abstract int getOpciones();
    abstract void obtenerDatos(ArrayList<String> datos);
    void mostrarRanking(ArrayList<Pair<String, Integer>> ranking){ }
    
    public VistaGenerica(){
        input = new Scanner(System.in);
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public void mostrarError(String error){
        System.out.println("Error: "+error);
    }
    
    public int obtenerOpcion(){
        int opcion = -1;
        while(opcion <= -1 || opcion >= this.getOpciones()){
            mostrarVista();
            opcion = Integer.parseInt(input.nextLine());
        }
        return opcion;
    }

}
