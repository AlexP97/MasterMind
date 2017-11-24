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
 * @author Usuario
 */
public class VistaMenu extends VistaGenerica {
    int nOpciones = 4;
    
    public VistaMenu(){
        super();
    }
    
    @Override
    public void mostrarVista(){
        System.out.println("0 - Salir");
        System.out.println("1 - Crear partida");
        System.out.println("2 - Cargar partida");
        System.out.println("3 - Ranking");
    }
    
    @Override
    public int getOpciones(){
        return this.nOpciones;
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
    public void mostrarRanking(ArrayList<Pair<String, Integer>> ranking){
        for(int i = 0; i < ranking.size(); i++){
            System.out.print(i+1 + ": " + ranking.get(i).getLeft() + " " + ranking.get(i).getRight() + "\n");
        }
    }
}
