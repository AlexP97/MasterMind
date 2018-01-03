/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import persistence.CtrlPersistenciaGame;
import utils.Pair;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public class CtrlDominioPartida {
    
    private Game game;
    private final CtrlPersistenciaGame CPG;
    
    public CtrlDominioPartida() {
        
        game = new Game();
        CPG = null;
        
    }
    
    /**
     *
     * @param cpg el controlador de persistencia de la clase Game
     */
    public CtrlDominioPartida(CtrlPersistenciaGame cpg) {
        
        game = new Game();
        CPG = cpg;
        
    }
    
    /**
     *
     * @param userName el nombre de usuario del jugador que quiere cargar una partida
     * @param id el id de la partida que se quiere cargar
     * @return un booleano con si se ha podido hacer cargar la partida y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean,String> loadGame(String userName, String id) {
        
        Pair<Boolean,String> p = null;
        game = CPG.read("data/players/"+userName+"/games/"+id);
        if (game == null) p = new Pair(false, "No se ha podido cargar la partida");
        else p = new Pair(true, "Partida cargada correctamente");
        return p;
    }
    
    /**
     *
     * @param userName el nombre de usuario del jugador que crea la partida
     * @param id el id deseado de la partida
     * @param dif la dificultad de la partida
     * @param mod el modo de la partida (codebreaker o codemaker)
     * @param num el número de fichas deseado
     * @param ran el rango de colores deseado
     * @return un booleano con si se ha podido crear la partida y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> crearPartida(String userName, String id, String dif, String mod, int num, int ran) {
        
        if (CPG.crearPartida(userName, id))
        return game.crearPartida(userName, id, dif, mod, num, ran);
        else return new Pair (false, "No se ha podido crear la partida, el id ya está en uso.");
        
    }
    
    /**
     *
     * @return el id de la partida actual
     */
    public String getId() {
        return game.getId();
    }
    
    /**
     *
     * @param userName el nombre del usuario que intenta borrar la partida
     * @param id el id de la partida que se está borrando
     * @return un booleano con si se ha podido eliminar la partida y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return CPG.eliminarPartida(userName, id);
    }
    
    /**
     *
     * @param cods posible pista del codemaker
     * @return cierto si la pista del codemaker está bien dada, falso de lo contrario
     */
    public boolean validarJugadaCodeM (ArrayList<Integer> cods){
        return game.validarJugadaCodeM(cods);
    }
    
    /**
     *
     * @return el patrón a adivinar
     */
    public ArrayList<Integer> getCodeIni() {
        return game.getCodeIni();
    }
    
    /**
     *
     * @param cods el patrón a adivinar por el codebreaker
     * @return un booleano con si se ha podido elegir el patrón y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean, String> setCodIni(ArrayList<Integer> cods){
        return game.setCodIni(cods);
    }
    
    /**
     *
     * @param cods pista del codemaker
     * @return devuelve la jugada del codebreaker de el turno actual
     */
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        return game.jugadaCodeB(cods);
    }
    
    /**
     *
     * @return devuelve todas las filas de la partida en el momento en el que se guardó
     */
    public ArrayList<ArrayList<Integer>> getJugadasCodeB(){
        return game.getJugadasCodeB();
    }
    
    /**
     *
     * @param cods intento de adivinar el patrón del codebreaker
     * @return devuelve la jugada del codemaker de el turno actual
     */
    public ArrayList<Integer> jugadaCodeM(ArrayList<Integer> cods){
        return game.jugadaCodeM(cods);
    }
    
    /**
     *
     * @return devuelve todas las filas de la partida en el momento en el que se guardó
     */
    public ArrayList<ArrayList<Integer>> getJugadasCodeM(){
        return game.getJugadasCodeM();
    }
    
    /**
     *
     * @return devuelve el id, dificultad, modo, número de fichas y rango de colores de la partida actual
     */
    public ArrayList<String> getStatsPartida() {
        return game.getStatsPartida();
    }
    
    /**
     *
     * @param b si se ha ganado la partida
     * @return un booleano con si se ha podido acabar la partida y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean,Integer> finishGame(boolean b){
        return game.finishGame(b);
    }
    
    /**
     *
     * @param userName el nombre del usuario que intenta guardar la partida
     * @return un booleano con si se ha podido guardar la partida y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean,String> saveGame(String userName){
        Pair <Boolean,String> p;
        p = CPG.write(game, "data/players/"+userName+"/games/"+game.getId());
        return p;
    }
}
