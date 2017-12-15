package domain;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import persistence.GamePersistencia;
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
    String[] output;
    ArrayList<CodePeg> codeIni;
    ArrayList<CodePeg> codeBAnt;
    ArrayList<KeyPeg> codeMAnt;
    CodeMaker codeM;
    CodeBreaker codeB;
    boolean gameSaved;
    boolean cargado;
    boolean acierto;
    int numero;
    int rango;
    boolean jugando;
    GamePersistencia gameP;
    
    public Game () {
        this.id = "";
        this.difficulty = "";
        this.mode = "";
        this.userName = "";
        this.points = 120;
        this.IA = null;
        this.turn = 0;
        this.output = null;
        this.codeIni = null;
        this.gameSaved = false;
        this.cargado = false;
        this.jugando = false;
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
     * @return si la partida ha cargado
     */
    public boolean getCargado() {
        return this.cargado;
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
     * @param b asigna si se ha cargado la partida
     */
    public void setCargado(boolean b) {
        this.cargado = b;
    }
    
    /**
     *
     * @param gamePer asigna el GamePersistencia que se encargará de interaccionar con el sistema de ficheros
     */
    public void setGameP(GamePersistencia gamePer){
        this.gameP = gamePer;
    }
    
    /**
     *
     * @param cb asigna el CodeBreaker de la partida
     */
    public void setCB(CodeBreaker cb){
        this.codeB = cb;
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
    
    public Pair<Boolean,String> setCodIni(ArrayList<Integer> cods){
        
        this.codeIni = conversorCode(cods);
        System.out.println(cods);
        return new Pair(true, "Codigo inicial aplicado");
        
    }
    
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
     * @param ganado si el jugador ha ganado o no
     * @return 
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
        else if (this.difficulty.equals("facil")) points -= 15;
        else if (this.difficulty.equals("medio")) this.points -= 12;
        else this.points -= 10;
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
        
        if (cargado) {
            if (mode.equals("Codemaker")) {
                this.codeM = new CodeMaker(false, numero, rango);
            }
            else if (mode.equals("Codebreaker")) {
                this.codeM = new CodeMaker(true, numero, rango);
                this.codeB = new CodeBreaker(false, numero, rango);
            }   
        }
        else {
            this.id = ident;
            
            if (dif.equals("Facil")) this.totalTurns = 12;
            else if (dif.equals("Medio")) this.totalTurns = 10;
            else if (dif.equals("Dificil")) this.totalTurns = 8;
            
            if (output == null) this.output = new String[totalTurns+1];
            this.output[0] = "--------------";
            this.difficulty = dif;
            this.mode = mod;
            this.userName = userN;
            this.points = 120;
            this.turn = 1;
            this.codeBAnt = new ArrayList<CodePeg>();
            this.codeMAnt = new ArrayList<KeyPeg>();
            this.numero = num;
            this.rango = ran;

            if (mode.equals("Codemaker")) {
                this.codeM = new CodeMaker(false, numero, rango);
            }
            else if (mode.equals("Codebreaker")) {
                this.codeB = new CodeBreaker(false, numero, rango);
                this.codeM = new CodeMaker(true, numero, rango);
                this.codeIni = conversorCode(this.codeM.dona_patro("IA"));
            }
        }
        return true;
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
    public Pair<Boolean, String> crearPartida(String userN, String ident, String dif, String mod, int num, int ran) {

        boolean b = SetAtributos(userN, ident, dif, mod, num, ran);
        if (!b) return new Pair(false, "No se han podido introducir los datos correctamente.");
        else return new Pair(true, "Partida creada.");
    }
    
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        
        ArrayList<Integer> outputM = new ArrayList<Integer>();
        outputM = codeM.jugar("IA", conversorCode(cods), codeIni);
        if (outputM.contains(1) || outputM.contains(0)) baja_Puntuacion();
        return outputM;
    }
}
