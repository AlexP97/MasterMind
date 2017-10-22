/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author usuario
 */
public class CodeMaker extends Jugador {
    public CodeMaker() {
       super();
    }
    
    public ArrayList<Integer> dona_patro(String s) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            for(int i = 0; i < 4; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
                linea.add(randomNum);
            }
        }
        else {
            Scanner input = new Scanner(System.in);
            System.out.print("Introduce el patron a adivinar poniendo cada ficha del 1 al 6 separada de un espacio:" + "\n");
            String jugada = input.nextLine();
            String fichas[] = jugada.split(" ");
            for(int i = 0; i < fichas.length; i++) {
                linea.add(Integer.parseInt(fichas[i]));
            }
        }
        return linea;
    }
    
    public ArrayList<Integer> jugar(String s, ArrayList<CodePeg> tirada, ArrayList<CodePeg> solucio) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            for(int i = 0; i < tirada.size(); i++){
                for(int k = 0; k < solucio.size(); k++) {
                    if(tirada.get(i).getColour() == solucio.get(k).getColour()) {
                        if(tirada.get(i).getPosition() == solucio.get(k).getPosition()) 
                            linea.add(2);
                        else 
                            linea.add(1);
                    }
                }        
            }
            while(linea.size() < 4)
                linea.add(0);
        }
        else {
            Scanner input = new Scanner(System.in);
            System.out.print("Introduce tu pista poniendo cada ficha del 0 al 2 separada de un espacio:" + "\n");
            String jugada = input.nextLine();
            String fichas[] = jugada.split(" ");
            for(int i = 0; i < fichas.length; i++) {
                linea.add(Integer.parseInt(fichas[i]));
            }
        }
        return linea;
    }
    
    
}
