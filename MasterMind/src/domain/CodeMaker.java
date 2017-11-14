/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import utils.Funciones;

/**
 *
 * @author usuario
 */
public final class CodeMaker extends Jugador {
    
    public CodeMaker(boolean IA, int nfichas, int ncolores) {
       super(nfichas, ncolores);
       
       if(IA)
           super.setIA();
    }
    
    public ArrayList<Integer> dona_patro(String s) {
        ArrayList<Integer> linea;
        linea = new ArrayList<>();
        if(s.equals("IA")) {
            for(int i = 0; i < super.getNFichas(); i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, super.getNColores() + 1);
                linea.add(randomNum);
            }
        }
        else {
            boolean jugadaHecha = false;
            while(!jugadaHecha) {
                Scanner input = new Scanner(System.in);
                System.out.print("Introduce el patron a adivinar poniendo "+super.getNFichas()+" fichas, poniendo cada ficha del 1 al "+super.getNColores()+" separada de un espacio:" + "\n");
                String jugada = input.nextLine();
                String fichas[] = jugada.split(" ");
                boolean fichasNoValid = false;
                if(fichas.length != super.getNFichas())
                    fichasNoValid =  true;
                for(int i = 0; i < fichas.length && !fichasNoValid; i++) {
                    int num = Integer.parseInt(fichas[i]);
                    if(num >= 1 && num <= super.getNColores()) linea.add(num);
                }
                if(linea.size() == fichas.length) jugadaHecha = true;
                if(fichasNoValid) 
                    System.out.println("El número de fichas introducido es incorrecto.");
                else if (!jugadaHecha) 
                    System.out.println("Has introducido un valor incorrecto.");
            }
        }
        return linea;
    }
    
    public ArrayList<Integer> jugar(String s, ArrayList<CodePeg> tirada, ArrayList<CodePeg> solucio) {
        ArrayList<Integer> linea = null;
        linea = new ArrayList<>();
        
        if(s.equals("IA")) {
            linea = super.donaSolucio(tirada, solucio);
        }
        else {
            boolean jugadaHecha = false;
            boolean guardar = false;
            //esto se deberia hacer en game
            for(int i = 0; i < tirada.size(); i++) {
                System.out.print(tirada.get(i).getColour() + " ");
            }
            System.out.println();
            while (!jugadaHecha && !guardar){
                Scanner input = new Scanner(System.in);
                System.out.print("Introduce tu pista poniendo "+super.getNFichas()+" fichas, cada ficha del 0 al 2 separada de un espacio."
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
                        if (num >= 0 && num <= 2) linea.add(num);
                    }
                    if(linea.size() == fichas.length) jugadaHecha = true;
                    if(fichasNoValid) 
                        System.out.println("El número de fichas introducido es incorrecto.");
                    if (!jugadaHecha) 
                        System.out.println("Has introducido un valor incorrecto.");
                }
            }
            Funciones.ordenar(linea);
        }
        
        
        return linea;
    }
    
    
}
