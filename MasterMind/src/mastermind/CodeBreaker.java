/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public final class CodeBreaker extends Jugador {
    ArrayList<ArrayList<Integer> > S;
    
    public void conjunt(int i, ArrayList<Integer> aux) {
            if(i == 4) {
                    S.add(aux);
            }
            else {
                for(int j = 1; j <= 6; j++) {
                    aux.set(i, j);
                    conjunt(i+1, aux);      
                }
            }
    }
    
    public CodeBreaker() {
        super();
        if(this.esIA()){
            ArrayList<Integer> aux = new ArrayList<>();
            for(int i = 0; i < 4; i++)
                aux.add(1);
            conjunt(0,aux);
        }
    }
    //code es un posible codigo inconsistente
    public boolean compare(ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio, ArrayList<Integer> code){
        int nblancas = 0;
        int nnegras = 0;
        
        ArrayList<Integer> aux = super.donaSolucio(tirada, code);
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
    
    public ArrayList<Integer> jugar(String s, ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            ArrayList<Integer> aux = new ArrayList<>();
            aux.add(1);
            aux.add(1);
            aux.add(2);
            aux.add(2);
            if(!this.S.contains(aux)){
                /*remove from S any code that would not give the same response if it (the guess) were the code
                	* A code is inconsistent if the answer from comparing 'tirada' and a
                        * code from 'S' is not the same as the answer from comparing
                        * 'tirada' and the secret code given by the game.               
                */
                for(int i = 0; i < S.size(); i++){
                    if(!compare(tirada,solucio,S.get(i))){
                        
                    }
                }
            }
            else{
                S.remove(aux);
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
