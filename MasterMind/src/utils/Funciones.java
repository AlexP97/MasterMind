package utils;

import java.util.ArrayList;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class Funciones {

    /**
     *
     * @param args int que van a formar parte de la lista, en orden
     * @return una lista con los parámetros que se le pasan
     */
    public static ArrayList<Integer> creaArray(int... args){
        ArrayList<Integer> aux = new ArrayList<>();
        for(int arg : args){
            aux.add(arg);
        }
        return aux;
    }
    
    /**
     *
     * @param aux lista a ordenar, que se devolverá ordenada
     */
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
