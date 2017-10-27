/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class CodeBreaker extends Jugador {
    Set<ArrayList<Integer> > S;
    public CodeBreaker() {
        super();
        if(this.esIA()){
            ArrayList<Integer> aux = new ArrayList<Integer>();
            for(int a = 1; a < 7; a++){
                for(int b = 1; b < 7; b++){
                    for(int c = 1; c < 7; c++){
                        for(int d = 1; d < 7; d++){
                            aux.add(a);
                            aux.add(b);
                            aux.add(c);
                            aux.add(d);
                            this.S.add(aux);
                        }
                    }
                }
            }
        }
    }
    
    public ArrayList<Integer> jugar(String s, ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            ArrayList<Integer> aux = new ArrayList<Integer>();
            aux.add(1);
            aux.add(1);
            aux.add(2);
            aux.add(2);
            if(!this.S.contains(aux)){
                
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
