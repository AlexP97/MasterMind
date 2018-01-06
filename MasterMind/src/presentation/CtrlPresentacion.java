package presentation;

import domain.CtrlDominio;
import domain.CtrlDominioJugador;
import domain.CtrlDominioPartida;
import domain.CtrlDominioRanking;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacion {
    private final CtrlDominio CD;
    private final CtrlDominioJugador CDj;
    private final CtrlDominioPartida CDp;
    private final CtrlDominioRanking CDr;
    private CtrlPresentacionLoginRegister CPlr;
    private CtrlPresentacionModificarDatos CPm;
    private CtrlPresentacionGame CPg;
    private CtrlPresentacionRanking CPr;
    
    public CtrlPresentacion() {
        CD = new CtrlDominio();
        CDj = CD.getCtrlDominioJugador();
        CDp = CD.getCtrlDominioPartida();
        CDr = CD.getCtrlDominioRanking();
    }
    
    /**
     *
     * @param user el nombre de usuario del jugador
     * @param pass la contraseña del jugador
     * @return un booleano con si se ha podido hacer login y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean,String> login(String user, String pass){
        CPlr = new CtrlPresentacionLoginRegister(CDj,this);
        return CPlr.login(user,pass);
    }
    
    /**
     *
     * @param user el nombre deseado
     * @param pass la contraseña deseada
     * @return un booleano con si se ha podido registrar y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean,String> register(String user, String pass){
        CPlr = new CtrlPresentacionLoginRegister(CDj,this);
        return CPlr.register(user,pass);
    }
    
    /**
     *
     * @return el nombre de usuario del jugador actual
     */
    public String getName(){
        return CDj.getName();
    }
    
    /**
     *
     * @return el id de la partida que se está jugando
     */
    public String getId(){
        return CDp.getId();
    }
    
    /**
     *
     * @return una lista con las partidas guardadas del jugador actual
     */
    public String[] obtenerPartidas() {
        return CDj.obtenerPartidas();
    }
    
    /**
     *
     * @param user el nuevo nombre de usuario
     * @return un booleano con si se ha podido modificar y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean,String> modificaUsuario(String user){
        CPm = new CtrlPresentacionModificarDatos(CDj);
        return CPm.modificarUsuario(user);
    }
    
    /**
     *
     * @param pass la nueva contraseña
     * @return un booleano con si se ha podido modificar y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean,String> modificaContraseña(String pass){
        CPm = new CtrlPresentacionModificarDatos(CDj);
        return CPm.modificarContraseña(pass);
    }
    
    /**
     *
     * @return un booleano con si se ha podido eliminar y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean,String> eliminar(){
        CPm = new CtrlPresentacionModificarDatos(CDj);
        return CPm.eliminar();
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
    public Pair <Boolean,String> crearPartida(String userName, String id, String dif, String mod, int num, int ran){
        CPg = new CtrlPresentacionGame(CDp);
        return CPg.crearPartida(userName,id,dif,mod,num,ran);
    }
    
    /**
     *
     * @param userName el nombre del usuario que intenta borrar la partida
     * @param id el id de la partida que se está borrando
     * @return un booleano con si se ha podido eliminar la partida y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return CPg.eliminarPartida(userName, id);
    }
    
    /**
     *
     * @param cods posible pista del codemaker
     * @return cierto si la pista del codemaker está bien dada, falso de lo contrario
     */
    public boolean validarJugadaCodeM (ArrayList<Integer> cods){
        return CPg.validarJugadaCodeM(cods);
    }
    
    /**
     *
     * @return el patrón a adivinar
     */
    public ArrayList<Integer> getCodeIni() {
        return CPg.getCodeIni();
    }
    
    /**
     *
     * @param cods el patrón a adivinar por el codebreaker
     * @return un booleano con si se ha podido elegir el patrón y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean, String> setCodIni(ArrayList<Integer> cods){
        return CPg.setCodIni(cods);
    }
    
    /**
     *
     * @return un booleano con si se ha podido guardar la partida y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean, String> saveGame(){
        return CPg.saveGame(getName());
    }
    
    /**
     *
     * @param id el id de la partida que se intenta cargar
     * @return un booleano con si se ha podido cargar la partida y un string con un mensaje de error si es necesario
     */
    public Pair<Boolean, String> loadGame(String id){
        CPg = new CtrlPresentacionGame(CDp);
        return CPg.loadGame(getName(), id);
    }
    
    /**
     *
     * @return devuelve el id, dificultad, modo, número de fichas y rango de colores de la partida actual
     */
    public ArrayList<String> getStatsPartida() {
        return CPg.getStatsPartida();
    }
    
    /**
     *
     * @param cods pista del codemaker
     * @return devuelve la jugada del codebreaker de el turno actual
     */
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        return CPg.jugadaCodeB(cods);
    }
    
    /**
     *
     * @return devuelve todas las filas de la partida en el momento en el que se guardó
     */
    public ArrayList<ArrayList<Integer>> getJugadasCodeB(){
        return CPg.getJugadasCodeB();
    }
    
    /**
     *
     * @param cods intento de adivinar el patrón del codebreaker
     * @return devuelve la jugada del codemaker de el turno actual
     */
    public ArrayList<Integer> jugadaCodeM(ArrayList<Integer> cods){
        return CPg.jugadaCodeM(cods);
    }
    
    /**
     *
     * @return devuelve todas las filas de la partida en el momento en el que se guardó
     */
    public ArrayList<ArrayList<Integer>> getJugadasCodeM(){
        return CPg.getJugadasCodeM();
    }
    
    /**
     *
     * @param b si se ha ganado la partida
     * @return un booleano con si se ha podido acabar la partida y un string con un mensaje de error si es necesario
     */
    public Pair <Boolean,Integer> finishGame(boolean b){
        return CPg.finishGame(b);
    }
    
    public void bajaPuntuacion(){
        CPg.bajaPuntuacion();
    }
    
    /**
     *
     * @return una lista de pares que tienen un nombre de usuario y una puntuación ordenados por puntuación
     */
    public ArrayList<Pair<String, Integer>> muestraRanking(){
        CPr = new CtrlPresentacionRanking(CDr);
        return CPr.mostrarRanking();
    }
    
    public int getPuntuacion(){
        return CPg.getPuntuacion();
    }
    
    /**
     *
     * @param nombre el nombre de usuario del candidato a entrar en el ranking
     * @param puntos la cantidad de puntos del candidato a entrar en el ranking
     * @return un par con un booleano que es cierto si se ha entrado en el ranking, y en qué posición se ha entrado
     */
    public Pair<Boolean, Integer> actualizaRanking(String nombre, int puntos){
        CPr = new CtrlPresentacionRanking(CDr);
        return CPr.actualizaRanking(nombre,puntos);
    }
    
    private void iniciarRegistroLogin() {
        CPlr = new CtrlPresentacionLoginRegister(CDj,this);
        CPlr.loginRegister();
    }
    
    public void iniciarMasterMind(){
        iniciarRegistroLogin();
    }
    
    public void setCodIni_old() {
        CPg.setCodIni_old();
    }
    
    public ArrayList<Integer> getJugadaCodeM_old() {
        return CPg.getJugadaCodeM_old();
    }
    
    public ArrayList<Integer> getJugadaCodeB_old() {
        return CPg.getJugadaCodeB_old();
    }
}
