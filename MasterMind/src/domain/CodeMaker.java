package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import utils.Funciones;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public final class CodeMaker extends Jugador implements Serializable{
    
    /**
     *
     * @param IA si el CodeMaker es IA o es jugador real
     * @param nfichas número de fichas de la partida actual
     * @param ncolores número de colores de la partida actual
     */
    public CodeMaker(boolean IA, int nfichas, int ncolores) {
       super(nfichas, ncolores);
       if(IA)
           super.setIA();
    }
    
    /**
     *
     * @param s s es "IA" si el CodeMaker es IA
     * @return el patrón que se deberá adivinar
     */
    public ArrayList<Integer> dona_patro(String s) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            for(int i = 0; i < super.getNFichas(); i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, super.getNColores() + 1);
                linea.add(randomNum);
            }
        }
        return linea;
    }
    
    /**
     *
     * @param s s es "IA" si el CodeMaker es IA
     * @param tirada intento de adivinar el patrón
     * @param solucio patrón de la partida
     * @return pegs que se devuelven para dar la pista al jugador CodeBreaker
     */
    public ArrayList<Integer> jugar(String s, ArrayList<CodePeg> tirada, ArrayList<CodePeg> solucio) {
        ArrayList<Integer> linea = null;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            linea = super.donaSolucio(tirada, solucio);
        }
        return linea;
    }
    
    public boolean validarPista(ArrayList<CodePeg> tirada, ArrayList<CodePeg> solucio, ArrayList<Integer> linea){
        
        boolean pistaCorrecta = true;
        if(linea.size() == super.getNFichas()) {
            ArrayList<Integer> pistaBuena = super.donaSolucio(tirada,solucio);
            Funciones.ordenar(linea);
            for(int i = 0; i < super.getNFichas(); i++) {
                if(pistaBuena.get(i) != linea.get(i))
                    pistaCorrecta = false;
            }
        }
        return pistaCorrecta;        
    }
    
}
