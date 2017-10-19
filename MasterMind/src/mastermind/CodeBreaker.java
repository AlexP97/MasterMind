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
public class CodeBreaker extends Jugador {
    public CodeBreaker() {
       super();
    }
    
    @Override
    public ArrayList<Integer> jugar(String s) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            
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
