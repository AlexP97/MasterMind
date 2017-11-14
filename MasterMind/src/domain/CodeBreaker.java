/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Funciones;

/**
 *
 * @author usuario
 */
public final class CodeBreaker extends Jugador implements Serializable{
    ArrayList<ArrayList<Integer> > compatibles;
    ArrayList<ArrayList<Integer> > noUsados;
    ArrayList<ArrayList<Integer> > combinaciones;
         
    boolean primeraOpcio = true;
    
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
    
    protected void creaCombinaciones(int i, ArrayList<Integer> aux){
        if(i == super.getNFichas()){
            ArrayList<Integer> añadir = (ArrayList<Integer>) aux.clone();
            Funciones.ordenar(añadir);
            if(!combinaciones.contains(añadir)) combinaciones.add(añadir);
        }
        else{
            for(int j = 2; j >= 0; j--){
                aux.set(i,j);
                creaCombinaciones(i+1,aux);
            }
        }
    }
    
    public CodeBreaker(boolean IA, int nfichas, int ncolores) {
        super(nfichas,ncolores);
        this.compatibles = new ArrayList<>();
        this.noUsados = new ArrayList<>();
        this.combinaciones = new ArrayList<>();
        
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
    
    protected ArrayList<CodePeg> convert(ArrayList<Integer> a) {
        ArrayList<CodePeg> cambioCodePeg = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            cambioCodePeg.add(new CodePeg(a.get(i),i+1,getNFichas(),getNColores()));
        }
        return cambioCodePeg;
    }
    //code es un posible codigo inconsistente
    protected boolean compare(ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio, ArrayList<Integer> code){
        int nblancas = 0;
        int nnegras = 0;
        ArrayList<CodePeg> cambioCodePeg = convert(code);
        ArrayList<Integer> aux = super.donaSolucio(cambioCodePeg, tirada);
        for(int i = 0; i < aux.size(); i++){
            if(aux.get(i) == 2) nblancas++;
            else if(aux.get(i) == 1) nnegras++;
        }
        
        int blancasSolucio = 0;
        int negrasSolucio = 0;
        for(int i = 0; i < solucio.size(); i++){
            if (solucio.get(i).getColour() == 2) blancasSolucio++;
            else if(solucio.get(i).getColour() == 1) negrasSolucio++;
        }
        if(nblancas == blancasSolucio && nnegras == negrasSolucio) return true;
        return false;   
    }
    
    protected ArrayList<Integer> miraSolucio(ArrayList<Integer> candidat, ArrayList<Integer> descartat){
        ArrayList<CodePeg> cambioCodePeg = convert(candidat);
        ArrayList<CodePeg> cambioCodePeg2 = convert(descartat);
        return donaSolucio(cambioCodePeg, cambioCodePeg2);
    }
    
    protected boolean miraDescartes(ArrayList<Integer> candidat, ArrayList<Integer> descartat, ArrayList<Integer> combinacio) {
        ArrayList<Integer> aux = miraSolucio(candidat,descartat);
        return combinacio.equals(aux);
    }
    
    protected ArrayList<Integer> millorOpcio() {
        int min = Integer.MAX_VALUE;
        int indice = 0;
        boolean compatible = false;
        for(int i = 0; i < noUsados.size(); i++){
            //algoritmo de posibilidades
            
            int count = 0;
            for(int j = 0; j < combinaciones.size(); j++) {
                int max = 0;
                for(int k = 0; k < compatibles.size(); k++) {
                    boolean b = miraDescartes(noUsados.get(i), compatibles.get(k), combinaciones.get(j));
                    if(b) max++;
                }
                if(max > count) count = max;
            }
                    
            boolean comp = (compatibles.contains(noUsados.get(i)));
            if(count < min) {
                indice = i;
                min = count;
                if(comp)
                    compatible = true;
                }
                if(count == min && !compatible && comp) {
                    indice = i;
                    compatible = comp;
                }
        }
        return noUsados.get(indice);
    }
   
    
    public ArrayList<Integer> jugar(String s, ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            ArrayList<Integer> aux = millorOpcio();
            
            if(!primeraOpcio){
                /*remove from S any code that would not give the same response if it (the guess) were the code
                	* A code is inconsistent if the answer from comparing 'tirada' and a
                        * code from 'S' is not the same as the answer from comparing
                        * 'tirada' and the secret code given by the game.               
                */
                
                for(int i = 0; i < compatibles.size(); i++){
                    if(!compare(tirada,solucio,compatibles.get(i))){
                        compatibles.remove(i);
                        i--;
                    }
                }            
                linea = millorOpcio();
                return linea;
            }
            else{
                primeraOpcio = false;
                compatibles.remove(aux);
                return aux;
            }
        }
        else {
            boolean jugadaHecha = false;
            boolean guardar = false;
            while (!jugadaHecha && !guardar){
                Scanner input = new Scanner(System.in);
                System.out.println("Introduce tu jugada poniendo "+super.getNFichas()+" fichas, poniendo cada ficha del 1 al "+super.getNColores()+" separada de un espacio."
                        + "\n(Introduce -1 para guardar partida, -2 para salir de la partida sin guardar):\n");
                String jugada = input.nextLine();
                String fichas[] = jugada.split(" ");
                if(fichas[0].equals("-1")) {
                    guardar = true;
                    linea.add(-1);
                }
                else if(fichas[0].equals("-2")) {
                    guardar = true;
                    linea.add(-2);
                }
                if(!guardar) {
                    boolean fichasNoValid = false;
                    if(fichas.length != super.getNFichas())
                        fichasNoValid = true;
                    for(int i = 0; i < fichas.length && !fichasNoValid; i++) {
                        int num = Integer.parseInt(fichas[i]);
                        if (num >= 1 && num <= super.getNColores()) linea.add(num);
                    }
                    if(linea.size() == fichas.length) jugadaHecha = true;
                    if(fichasNoValid) 
                        System.out.println("El número de fichas introducido es incorrecto.");
                    if (!jugadaHecha) 
                        System.out.println("Has introducido un valor incorrecto.");
                }
            }
        }
        return linea;
    }
}
