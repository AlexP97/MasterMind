/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Funciones {
    public static ArrayList<Integer> creaArray(int... args){
        ArrayList<Integer> aux = new ArrayList<>();
        for(int arg : args){
            aux.add(arg);
        }
        return aux;
    }
    
    public static void ordenar(ArrayList<Integer> aux){
        int temp;
        for(int i = 1; i < aux.size(); i++){
            for(int j = i; j > 0; j--){
                if(aux.get(j) > aux.get(j-1)){
                    temp = aux.get(j);
                    aux.set(j,aux.get(j-1));
                    aux.set(j-1,temp);
                }
            }
        }
    }
}
