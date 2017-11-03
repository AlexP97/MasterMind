/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public final class CodeBreaker extends Jugador {
    ArrayList<ArrayList<Integer> > compatibles;
    ArrayList<ArrayList<Integer> > noUsados;
    ArrayList<ArrayList<Integer> > combinaciones;
    
    public void conjunt(int i, ArrayList<Integer> aux, ArrayList<Integer> pos) {
            if(i == 4) {
                    ArrayList<Integer> añadir = (ArrayList<Integer>) aux.clone();
                    compatibles.add(añadir);
            }
            else {
                for(int j = 0; j < pos.size(); j++) {
                    aux.set(i, pos.get(j));
                    conjunt(i+1, aux, pos); 
                }
            }
    }
    
    public CodeBreaker(boolean IA) {
        super();
        compatibles = new ArrayList<>();
        noUsados = new ArrayList<>();
        combinaciones = new ArrayList<>();
        if(IA)
            super.setIA();
        if(this.esIA()){
            ArrayList<Integer> aux = new ArrayList<>();
            for(int i = 0; i < 4; i++){
                aux.add(1);
            }
            ArrayList<Integer> pos = new ArrayList<>();
            for(int i = 0; i < 6; i++){
                pos.add(i+1);
            }
            conjunt(0,aux, pos);
            noUsados = (ArrayList<ArrayList<Integer>>) compatibles.clone();
        }
    }
    
    public ArrayList<CodePeg> convert(ArrayList<Integer> a) {
        ArrayList<CodePeg> cambioCodePeg = null;
        cambioCodePeg.add(new CodePeg(a.get(0),0));
        cambioCodePeg.add(new CodePeg(a.get(1),1));
        cambioCodePeg.add(new CodePeg(a.get(2),2));
        cambioCodePeg.add(new CodePeg(a.get(3),3));
        return cambioCodePeg;
    }
    //code es un posible codigo inconsistente
    public boolean compare(ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio, ArrayList<Integer> code){
        int nblancas = 0;
        int nnegras = 0;
        
        ArrayList<CodePeg> cambioCodePeg = convert(code);
        ArrayList<Integer> aux = super.donaSolucio(tirada, cambioCodePeg);
        for(int i = 0; i < aux.size(); i++){
            if(aux.get(i) == 2) nblancas++;
            else if(aux.get(i) == 1) nnegras++;
        }
        
        int blancasSolucio = 0;
        int negrasSolucio = 0;
        for(int i = 0; i < 4; i++){
            if (solucio.get(i).getColour() == 2) blancasSolucio++;
            else if(solucio.get(i).getColour() == 1) negrasSolucio++;
        }
        if(nblancas == blancasSolucio && nnegras == negrasSolucio) return true;
        return false;   
    }
    
    public ArrayList<Integer> miraSolucio(ArrayList<Integer> candidat, ArrayList<Integer> descartat){
        ArrayList<CodePeg> cambioCodePeg = convert(candidat);
        ArrayList<CodePeg> cambioCodePeg2 = convert(descartat);
        return donaSolucio(cambioCodePeg, cambioCodePeg2);
    }
    
    public boolean miraDescartes(ArrayList<Integer> candidat, ArrayList<Integer> descartat, ArrayList<Integer> combinacio) {
        ArrayList<Integer> aux = miraSolucio(candidat,descartat);
        return combinacio.equals(aux);
    }
   
    
    public ArrayList<Integer> jugar(String s, ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            ArrayList<Integer> aux = new ArrayList<>();
            aux.add(1);
            aux.add(1);
            aux.add(2);
            aux.add(2);
            if(!this.noUsados.contains(aux)){
                /*remove from S any code that would not give the same response if it (the guess) were the code
                	* A code is inconsistent if the answer from comparing 'tirada' and a
                        * code from 'S' is not the same as the answer from comparing
                        * 'tirada' and the secret code given by the game.               
                */
                int min = Integer.MAX_VALUE;
                int indice = 0;
                boolean compatible = false;
                for(int i = 0; i < this.noUsados.size(); i++){
                    //algoritmo de posibilidades
                    boolean comp = true;
                    if(!compare(tirada,solucio,compatibles.get(i))){
                        compatibles.remove(i);
                        comp = false;
                    }
                    int count = 0;
                    for(int j = 0; j < this.combinaciones.size(); j++) {
                        int max = 0;
                        for(int k = 0; k < noUsados.size(); k++) {
                            boolean b = miraDescartes(noUsados.get(i), noUsados.get(k), combinaciones.get(j));
                            if(b) max++;
                        }
                        if(max > count) count = max;
                    }
                    if(count < min) {
                        indice = i;
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
            else{
                compatibles.remove(aux);
                return aux;
            }
        }
        else {
            Scanner input = new Scanner(System.in);
            System.out.print("Introduce tu jugada poniendo cada ficha del 1 al 6 separada de un espacio:" + "\n");
            String jugada = input.nextLine();
            String fichas[] = jugada.split(" ");
            for(int i = 0; i < fichas.length; i++) {
                linea.add(Integer.parseInt(fichas[i]));
            }
        }
        return linea;
    }
}
