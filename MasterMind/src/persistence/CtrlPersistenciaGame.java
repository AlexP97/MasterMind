/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import domain.Game;
import utils.Pair;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public class CtrlPersistenciaGame extends CtrlPersistencia{
    
    private GamePersistencia gameP;
    
    public CtrlPersistenciaGame() {
        
        gameP = new GamePersistencia();
        
    }
    
    /**
     *
     * @param userName el nombre del usuario que quiere crear la partida
     * @param id el id deseado para la partida
     * @return si el id deseado está disponible
     */
    public boolean crearPartida(String userName, String id) {
        
        return gameP.CheckAvailability(id, userName);
        
    }
    
    /**
     *
     * @param userName el nombre del usuario que quiere crear la partida
     * @param id el id deseado para la partida
     * @return un booleano con si se ha podido eliminar la partida y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return gameP.eliminarPartida(userName, id);
    }
    
    /**
     *
     * @param object el objeto que se quiere escribir
     * @param path la ruta del objetoque se quiere escribir
     * @return un booleano con si se ha podido escribir y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean, String> write(Game object, String path){
        return super.write(object, path);
    }
    
    /**
     *
     * @param path la ruta del objeto que se quiere leer
     * @return el objeto que se quiere leer
     */
    public Game read (String path) {
        return (Game)super.read(path);
    }
    
}
