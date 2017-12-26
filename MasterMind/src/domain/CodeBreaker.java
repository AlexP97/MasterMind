package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import utils.Funciones;
import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public final class CodeBreaker extends Jugador implements Serializable{
    ArrayList<ArrayList<Integer> > compatibles;
    ArrayList<ArrayList<Integer> > noUsados;
    HashMap<ArrayList<Integer>, Integer> combinaciones;
         
    boolean primeraTirada = true;
    
    /**
     *
     * @param i posición de aux que se está modificando
     * @param aux lista que es un código que posiblemente adivine el patrón
     */
    protected void conjunt(int i, ArrayList<Integer> aux) {
            if(i == super.getNFichas()) {
                    ArrayList<Integer> añadir = (ArrayList<Integer>) aux.clone();
                    compatibles.add(añadir);
            }
            else {
                for(int j = 0; j < super.getNColores(); j++) {
                    aux.set(i,j+1);
                    conjunt(i+1, aux); 
                }
            }
    }
    
    /**
     *
     * @param i posición de aux que se está modificando
     * @param aux posible lista de pegs para dar la pista al CodeBreaker
     */
    protected void creaCombinaciones(int i, ArrayList<Integer> aux){
        if(i == super.getNFichas()){
            ArrayList<Integer> añadir = (ArrayList<Integer>) aux.clone();
            Funciones.ordenar(añadir);
            if(!combinaciones.containsKey(añadir)) combinaciones.put(añadir,0);
        }
        else{
            for(int j = 2; j >= 0; j--){
                aux.set(i,j);
                creaCombinaciones(i+1,aux);
            }
        }
    }
    
    /**
     *
     * @param IA si el CodeBreaker es IA o un jugador real
     * @param nfichas número de fichas de la partida actual
     * @param ncolores número de colores de la partida actual
     */
    public CodeBreaker(boolean IA, int nfichas, int ncolores) {
        super(nfichas,ncolores);
        this.compatibles = new ArrayList<>();
        this.noUsados = new ArrayList<>();
        this.combinaciones = new HashMap<>();
        
        if(IA)
            super.setIA();
        if(this.esIA()){
            ArrayList<Integer> aux = new ArrayList<>();
            ArrayList<Integer> aux2 = new ArrayList<>();
            for(int i = 0; i < super.getNFichas(); i++) {
                aux.add(1);
                aux2.add(1);
            }
            conjunt(0,aux);
            noUsados = (ArrayList<ArrayList<Integer>>) compatibles.clone();
            creaCombinaciones(0,aux2);
            ArrayList<Integer> imposible = new ArrayList<>();
            for(int i = 0; i < super.getNFichas(); i++){
                if(i == ((super.getNFichas())-1)) imposible.add(1);
                else imposible.add(2);
            }
            combinaciones.remove(imposible);
        }
    }
    
    /**
     *
     * @param a lista de int a convertir en lista de CodePeg
     * @return devuelve la lista de codepegs igual a la lista de enteros
     */
    protected ArrayList<CodePeg> convert(ArrayList<Integer> a) {
        ArrayList<CodePeg> cambioCodePeg = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            cambioCodePeg.add(new CodePeg(a.get(i),i+1,getNFichas(),getNColores()));
        }
        return cambioCodePeg;
    }

    /**
     *
     * @param tirada una de las listas a comparar
     * @param solucio segunda de las listas a comparar
     * @param code código que tiene que dar como resultado de comparar tirada y solucio
     * @return devuelve si el codigo de pista obtenido al comparar tirada y solucio es igual a code
     */
    protected boolean compare(ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio, ArrayList<Integer> code){
        int nblancas = 0;
        int nnegras = 0;
        ArrayList<CodePeg> cambioCode = convert(code);
        ArrayList<Integer> aux = super.donaSolucio(cambioCode, tirada);
        Funciones.ordenar(aux);
        for(int i = 0; i < aux.size(); i++) {
            if(solucio.get(i).getColour() != aux.get(i))
                return false;
        }
        return true;
    }
    
    /**
     *
     * @param candidat código candidato a ser el mejor intento
     * @param descartat código que posiblemente quede descartado si intentamos adivinar el patrón con candidat
     * @return el código de colores que daría CodeMaker si candidat fuera un intento y descartat el patrón
     */
    protected ArrayList<Integer> miraSolucio(ArrayList<Integer> candidat, ArrayList<Integer> descartat){
        ArrayList<CodePeg> cambioCodePeg = convert(candidat);
        ArrayList<CodePeg> cambioCodePeg2 = convert(descartat);
        return donaSolucio(cambioCodePeg, cambioCodePeg2);
    }
    
    public int compruebaMaximo(HashMap<ArrayList<Integer>, Integer> hm) {
        int count = -1;
        Iterator it = hm.keySet().iterator();
        while(it.hasNext()) {
            ArrayList<Integer> key = (ArrayList<Integer>) it.next();
            Integer val = hm.get(key);
            if(val > count)
                count = val;
        }
        return count;
    }
    
    public Pair<Pair<Boolean,Integer>,Integer> esSolucion(int count, int min, int i, Integer indice, boolean compatible) {
        Pair<Boolean, Integer> p = new Pair<>();
        Pair<Pair<Boolean,Integer>,Integer> sol = new Pair<>();
        int m = -1;
        boolean comp = (compatibles.contains(noUsados.get(i)));
        if(count < min) {
            p.setRight(i);
            m = count;
            if(comp)
                p.setLeft(true);
            else
                p.setLeft(false);
        }
        if(count == min && !compatible && comp) {
            m = count;
            p.setRight(i);
            p.setLeft(comp);
        }
        sol.setLeft(p);
        sol.setRight(m);
        return sol;
    }
    
    /**
     *
     * @return el mejor intento para el actual turno
     */
    protected ArrayList<Integer> millorOpcio() {
        int min = Integer.MAX_VALUE;
        int indice = 0;
        boolean compatible = false;
        for(int i = 0; i < noUsados.size(); i++){
            //algoritmo de posibilidades
            HashMap<ArrayList<Integer>, Integer> combinacionesAux = (HashMap<ArrayList<Integer>, Integer>) combinaciones.clone();
            for(int j = 0; j < compatibles.size(); j++) {
                ArrayList<Integer> aux = miraSolucio(noUsados.get(i), compatibles.get(j));
                Integer value = combinacionesAux.get(aux);
                combinacionesAux.put(aux,value+1);
            }
            int count = compruebaMaximo(combinacionesAux);
            Pair<Pair<Boolean,Integer>,Integer> p = esSolucion(count, min, i, indice, compatible);      
            if(p.getRight() != -1) {
                min = p.getRight();
                compatible = p.getLeft().getLeft();
                indice = p.getLeft().getRight();
            }
        }
        return noUsados.get(indice);
    }
    
    
    
    
    public void eliminaCompatibles(ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio) {
        for(int i = 0; i < compatibles.size(); i++){
                    if(!compare(tirada,solucio,compatibles.get(i))){
                        compatibles.remove(i);
                        i--;
                    }
                }     
    }
    
    public ArrayList<Integer> primeraTirada() {
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(1);
        for(int i = 1; i < super.getNFichas(); i++) {
            if(i == 1)
                aux.add(1);
            else
                aux.add(2);
        }
        return aux;
        
    }
   
    /**
     *
     * @param s si el CodeBreaker es IA o un jugador real
     * @param tirada el intento de este turno mirando la pista del turno anterior
     * @param solucio pista a la tirada del turno anterior
     * @return intento de adivinar el patrón para el turno actual
     */
    public ArrayList<Integer> jugar(String s, ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            if(!primeraTirada){
                eliminaCompatibles(tirada,solucio);
                linea = millorOpcio();
            }
            else{
                ArrayList<Integer> aux = primeraTirada();
                primeraTirada = false;
                compatibles.remove(aux);
                return aux;
            }
        }
        return linea;
    }
}
