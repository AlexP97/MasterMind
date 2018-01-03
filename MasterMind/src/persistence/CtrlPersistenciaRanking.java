/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Ranking;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public class CtrlPersistenciaRanking extends CtrlPersistencia{
    
    /**
     *
     * @param ranking el objeto que se quiere escribir
     * @param path la ruta del objetoque se quiere escribir
     * @return un booleano con si se ha podido escribir y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean, String> write(Ranking ranking, String path){
        return super.write(ranking,path);
    }
    
    /**
     *
     * @param path la ruta del objeto que se quiere leer
     * @return el objeto que se quiere leer
     */
    public ArrayList read(String path){
        return (ArrayList)super.read(path);
    }
}
