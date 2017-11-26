/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class VistaMenu extends VistaGenerica {
    final int nOpciones = 5;
    
    public VistaMenu(){
        super();
    }
    
    @Override
    public void mostrarVista(){
        System.out.println("0 - Volver atrás");
        System.out.println("1 - Crear partida");
        System.out.println("2 - Cargar partida");
        System.out.println("3 - Ranking");
        System.out.println("4 - Modificar datos de usuario");
    }
    
    @Override
    public int getOpciones(){
        return this.nOpciones;
    }   
    
    @Override
    public void obtenerDatos(ArrayList<String> datos){
       
    }
    
    @Override
    public void mostrarRanking(ArrayList<Pair<String, Integer>> ranking){
        for(int i = 0; i < ranking.size(); i++){
            System.out.print(i+1 + ": " + ranking.get(i).getLeft() + " " + ranking.get(i).getRight() + "\n");
        }
    }
}
