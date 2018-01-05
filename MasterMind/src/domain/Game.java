package domain;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Martínez Martínez, Daniel
 */
public class Game implements Serializable{
    
    String id;
    String difficulty;
    String userName;
    int points;
    String mode;
    Jugador IA;
    int turn;
    int totalTurns;
    ArrayList<ArrayList<Integer>> logJugadasB;
    ArrayList<ArrayList<Integer>> logJugadasM;
    ArrayList<CodePeg> codeIni;
    ArrayList<CodePeg> codeBAnt;
    ArrayList<KeyPeg> codeMAnt;
    CodeMaker codeM;
    CodeBreaker codeB;
    int numero;
    int rango;
    
    public Game () {
        this.id = "";
        this.difficulty = "";
        this.mode = "";
        this.userName = "";
        this.points = 120;
        this.IA = null;
        this.turn = 0;
        this.codeIni = null;
        this.logJugadasB = new ArrayList<ArrayList<Integer>>();
        this.logJugadasM = new ArrayList<ArrayList<Integer>>();
    }
    
    /**
     *
     * @return el id de la partida
     */
    public String getId() {
        return this.id;
    }
    
    /**
     *
     * @return la dificultad de la partida
     */
    public String getDifficulty(){
        return this.difficulty;
    }
    
    /**
     *
     * @return los puntos de la partida
     */
    public int getPoints() {
        return this.points;
    }
    
    /**
     *
     * @return el modo de juego (CodeBreaker o CodeMaker)
     */
    public String getMode() {
        return this.mode;
    }

    /**
     *
     * @return el turno actual de la partida
     */
    public int getTurn() {
        return this.turn;
    }
    
    /**
     *
     * @return devuelve todas las filas de la partida en el momento en el que se guardó
     */
    public ArrayList<ArrayList<Integer>> getJugadasCodeB (){
        return this.logJugadasB;
    }
    
    /**
     *
     * @return devuelve todas las filas de la partida en el momento en el que se guardó
     */
    public ArrayList<ArrayList<Integer>> getJugadasCodeM (){
        return this.logJugadasM;
    }
    
    /**
     *
     * @return el patrón a adivinar
     */
    public ArrayList<Integer> getCodeIni() {
        return codeToInt(codeIni);
    }
    
    /**
     *
     * @return devuelve el id, dificultad, modo, número de fichas y rango de colores de la partida actual
     */
    public ArrayList<String> getStatsPartida() {
        ArrayList<String> a = new ArrayList<String>();
        a.add(this.mode);
        a.add(Integer.toString(numero));
        a.add(Integer.toString(rango));
        a.add(Integer.toString(totalTurns));
        a.add(Integer.toString(turn));
        return a;
    }
    
    private ArrayList<Integer> codeToInt(ArrayList<CodePeg> array){
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < array.size(); ++i){
            a.add(array.get(i).getColour());
        }
        return a;
    }
    /**
     *
     * @param arrayList es el ArrayList<Integer> que se quiere traducir
     * @return el arrayList traducido a ArrayList<CodePeg>
     */
    private ArrayList<CodePeg> conversorCode (ArrayList<Integer> arrayList) {
        
        ArrayList<CodePeg> lista = new ArrayList<CodePeg>();
        for (int i = 0; i < numero; ++i) {
            
            CodePeg codeP = new CodePeg(arrayList.get(i), i+1, numero, rango);
            lista.add(codeP);
            
        }
        return lista;
    }
    
    /**
     *
     * @param arrayList es el ArrayList<Integer> que se quiere traducir
     * @return el arrayList traducido a ArrayList<KeyPeg>
     */
    private ArrayList<KeyPeg> conversorKey (ArrayList<Integer> arrayList) {
        
        ArrayList<KeyPeg> lista = new ArrayList<KeyPeg>();
        for (int i = 0; i < numero; ++i) {
            
            KeyPeg codeP = new KeyPeg(arrayList.get(i), i+1, numero);
            lista.add(codeP);
            
        }
        return lista;
    }
    
    /**
     *
     * @param cods el patrón a adivinar por el codebreaker
     * @return un booleano con si se ha podido elegir el patrón y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean,String> setCodIni(ArrayList<Integer> cods){
        
        this.codeIni = conversorCode(cods);
        System.out.println(cods);
        return new Pair(true, "Codigo inicial aplicado");
        
    }
    
    /**
     *
     * @return un array de bytes con el objeto de la partida
     */
    public byte[] SaveGame() {
           
        byte[] gameBytes = null;
        
        if (!userName.equals("")){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = null;
            try {
                
                out = new ObjectOutputStream(bos);   
                out.writeObject(this);
                out.flush();
                gameBytes = bos.toByteArray();
                bos.close();
                
            } catch (IOException ex) {
              // ignore close exception
            }
        }
        
        return gameBytes;
    }
    
    /**
     *
     * @param ganado si se ha ganado la partida
     * @return un booleano con si se ha podido acabar la partida y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean,Integer> finishGame(boolean ganado) {
        
        Pair<Boolean,Integer> p = new Pair();
        if (ganado) {
            if (mode.equals("Codemaker")) System.out.print("¡La IA ha acertado la combinación!" + "\n");
            else {
                System.out.print("¡Has ganado la partida!" + "\n" + "Tu puntuación es: "+ points + "\n");
                p.setLeft(true);
                p.setRight(points);
            }
        }
        else {
            p.setLeft(false);
            if (codeIni != null) {
                System.out.print("Game Over..." + "\n" + "El código correcto era:");
                for(int i = 0; i < codeIni.size(); i++) {
                    System.out.print(" " + codeIni.get(i).getColour());
                }
            }
            else System.out.print("Game Over...");
            System.out.println();
        }
        return p;
        
    }
    
    public void baja_Puntuacion(){
        if (this.difficulty == null) return;
        else if (this.difficulty.equals("Facil")) points -= 10;
        else if (this.difficulty.equals("Medio")) this.points -= 15;
        else this.points -= 25;
    }
    
    /**
     *
     * @param playerN jugador que juega la partida
     * @param ident identificador de la partida
     * @param dif dificultad de la partida
     * @param mod modo de la partida
     * @param num número de fichas para la partida
     * @param ran rango de colores para la partida
     */
    private boolean SetAtributos(String userN, String ident, String dif, String mod, int num, int ran){
        
        this.id = ident;

        if (dif.equals("Facil")){
            this.totalTurns = 12;
            this.points = 120;
        }
        else if (dif.equals("Medio")){
            this.totalTurns = 10;
            this.points = 150;
        }
        else if (dif.equals("Dificil")){
            this.totalTurns = 8;
            this.points = 200;
        }

        this.difficulty = dif;
        this.mode = mod;
        this.userName = userN;
        this.turn = 1;
        this.codeBAnt = new ArrayList<CodePeg>();
        this.codeMAnt = new ArrayList<KeyPeg>();
        this.logJugadasB = new ArrayList<ArrayList<Integer>>();
        this.logJugadasM = new ArrayList<ArrayList<Integer>>();
        this.numero = num;
        this.rango = ran;

        if (mode.equals("Codemaker")) {
            this.codeM = new CodeMaker(false, numero, rango);
            this.codeB = new CodeBreaker(true, numero, rango);
        }
        else if (mode.equals("Codebreaker")) {
            this.codeB = new CodeBreaker(false, numero, rango);
            this.codeM = new CodeMaker(true, numero, rango);
            this.codeIni = conversorCode(this.codeM.dona_patro("IA"));
        }
        return true;
    }
    
    /**
     *
     * @param userN jugador que juega la partida
     * @param ident identificador de la partida
     * @param dif dificultad de la partida
     * @param mod modo de la partida
     * @param num número de fichas para la partida
     * @param ran rango de colores para la partida
     * @return un booleano con si se ha podido crear la partida y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> crearPartida(String userN, String ident, String dif, String mod, int num, int ran) {

        boolean b = SetAtributos(userN, ident, dif, mod, num, ran);
        if (!b) return new Pair(false, "No se han podido introducir los datos correctamente.");
        else return new Pair(true, "Partida creada.");
    }
    
    /**
     *
     * @param cods pista del codemaker
     * @return devuelve la jugada del codebreaker de el turno actual
     */
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        
        if (cods.size() > 0) codeMAnt = conversorKey(cods);
        ArrayList<Integer> outputB = codeB.jugar("IA", codeBAnt, codeMAnt);
        if (outputB.contains(1) || outputB.contains(0)) baja_Puntuacion();
        codeBAnt = conversorCode(outputB);
        logJugadasB.add(outputB);
        return outputB;
    }
    
    /**
     *
     * @param cods intento de adivinar el patrón del codebreaker
     * @return devuelve la jugada del codemaker de el turno actual
     */
    public ArrayList<Integer> jugadaCodeM(ArrayList<Integer> cods){
        
        ArrayList<Integer> outputM = codeM.jugar("IA", conversorCode(cods), codeIni);
        if (outputM.contains(1) || outputM.contains(0)) baja_Puntuacion();
        codeBAnt = conversorCode(cods);
        ++turn;
        logJugadasB.add(cods);
        logJugadasM.add(outputM);
        return outputM;
    }
    
    /**
     *
     * @param cods la pista dada por el codemaker
     * @return cierto si la pista está bien dada
     */
    public boolean validarJugadaCodeM(ArrayList<Integer> cods){
        boolean b = codeM.validarPista(codeBAnt, codeIni, cods);
        if (b) {
            codeMAnt = conversorKey(cods);
            ++turn;
            logJugadasM.add(cods);
        }
        return b;
    }

    public int getPuntuacion() {
        return points; 
    }
}
