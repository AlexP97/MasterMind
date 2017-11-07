/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public final class CodeBreaker extends Jugador implements Serializable{
    ArrayList<ArrayList<Integer> > compatibles;
    ArrayList<ArrayList<Integer> > noUsados;
    ArrayList<ArrayList<Integer> > combinaciones;
    boolean primeraOpcio = true;
    
    public boolean GuardarMatrices(String userName, String id, boolean cargado) {
        try {
        ByteArrayOutputStream bs= new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream (bs);
        os.writeObject(compatibles);  // this es de tipo DatoUdp
        os.close();
        byte[] bytes =  bs.toByteArray(); // devuelve byte
        
        if (cargado) {
            File file = new File("players/"+userName+"/games/"+id+"MatrComp.txt");
            file.delete();
        }
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("players/"+userName+"/games/"+id+"MatrComp.txt"));

        for (int i = 0; i < bytes.length; i++)
        {
            // ojo, se hace un new por cada Persona. El new dentro del bucle.
            Byte b = bytes[i];
            oos.writeObject(b);
        }
        oos.close();  // Se cierra al terminar.
        
        } catch (IOException ex) {
            System.out.print("No se han podido guardar los datos de la IA");
            return false;
        }
        
        try {
        ByteArrayOutputStream bs= new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream (bs);
        os.writeObject(noUsados);  // this es de tipo DatoUdp
        os.close();
        byte[] bytes =  bs.toByteArray(); // devuelve byte
        
        if (cargado) {
            File file = new File("players/"+userName+"/games/"+id+"MatrNoUs.txt");
            file.delete();
        }
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("players/"+userName+"/games/"+id+"MatrNoUs.txt"));

        for (int i = 0; i < bytes.length; i++)
        {
            // ojo, se hace un new por cada Persona. El new dentro del bucle.
            Byte b = bytes[i];
            oos.writeObject(b);
        }
        oos.close();  // Se cierra al terminar.
        
        } catch (IOException ex) {
            System.out.print("No se han podido guardar los datos de la IA");
            return false;
        }
        
        try {
        ByteArrayOutputStream bs= new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream (bs);
        os.writeObject(combinaciones);  // this es de tipo DatoUdp
        os.close();
        byte[] bytes =  bs.toByteArray(); // devuelve byte
        
        if (cargado) {
            File file = new File("players/"+userName+"/games/"+id+"MatrComb.txt");
            file.delete();
        }
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("players/"+userName+"/games/"+id+"MatrComb.txt"));

        for (int i = 0; i < bytes.length; i++)
        {
            // ojo, se hace un new por cada Persona. El new dentro del bucle.
            Byte b = bytes[i];
            oos.writeObject(b);
        }
        oos.close();  // Se cierra al terminar.
        
        } catch (IOException ex) {
            System.out.print("No se han podido guardar los datos de la IA");
            return false;
        }
        return true;
    }
    
    public void CargarMatrices() {
        
        
        
    }
    
    private void conjunt(int i, ArrayList<Integer> aux, ArrayList<Integer> pos) {
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
    
    private void creaCombinaciones(){
        combinaciones.add(creaArray(2,2,2,2));
        combinaciones.add(creaArray(2,2,1,1));
        combinaciones.add(creaArray(2,1,1,1));
        combinaciones.add(creaArray(1,1,1,1));
        combinaciones.add(creaArray(2,2,2,0));
        combinaciones.add(creaArray(2,2,1,0));
        combinaciones.add(creaArray(2,1,1,0));
        combinaciones.add(creaArray(1,1,1,0));
        combinaciones.add(creaArray(2,2,0,0));
        combinaciones.add(creaArray(2,1,0,0));
        combinaciones.add(creaArray(1,1,0,0));
        combinaciones.add(creaArray(2,0,0,0));
        combinaciones.add(creaArray(1,0,0,0));
        combinaciones.add(creaArray(0,0,0,0));
    }
    
    private ArrayList<Integer> creaArray(int a, int b, int c, int d){
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(a);
        aux.add(b);
        aux.add(c);
        aux.add(d);
        return aux;
    }
    
    public CodeBreaker(boolean IA) {
        super();
        compatibles = new ArrayList<>();
        noUsados = new ArrayList<>();
        combinaciones = new ArrayList<>();
        if(IA)
            super.setIA();
        if(this.esIA()){
            ArrayList<Integer> aux = creaArray(1,1,1,1);
            ArrayList<Integer> pos = new ArrayList<>();
            for(int i = 0; i < 6; i++){
                pos.add(i+1);
            }
            conjunt(0,aux, pos);
            noUsados = (ArrayList<ArrayList<Integer>>) compatibles.clone();
        }
        creaCombinaciones();
    }
    
    private ArrayList<CodePeg> convert(ArrayList<Integer> a) {
        ArrayList<CodePeg> cambioCodePeg = new ArrayList<>();
        cambioCodePeg.add(new CodePeg(a.get(0),1));
        cambioCodePeg.add(new CodePeg(a.get(1),2));
        cambioCodePeg.add(new CodePeg(a.get(2),3));
        cambioCodePeg.add(new CodePeg(a.get(3),4));
        return cambioCodePeg;
    }
    //code es un posible codigo inconsistente
    private boolean compare(ArrayList<CodePeg> tirada, ArrayList<KeyPeg> solucio, ArrayList<Integer> code){
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
    
    private ArrayList<Integer> miraSolucio(ArrayList<Integer> candidat, ArrayList<Integer> descartat){
        ArrayList<CodePeg> cambioCodePeg = convert(candidat);
        ArrayList<CodePeg> cambioCodePeg2 = convert(descartat);
        return donaSolucio(cambioCodePeg, cambioCodePeg2);
    }
    
    private boolean miraDescartes(ArrayList<Integer> candidat, ArrayList<Integer> descartat, ArrayList<Integer> combinacio) {
        ArrayList<Integer> aux = miraSolucio(candidat,descartat);
        return combinacio.equals(aux);
    }
    
    private ArrayList<Integer> millorOpcio() {
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
            while (!jugadaHecha){
                Scanner input = new Scanner(System.in);
                System.out.print("Introduce tu jugada poniendo cada ficha del 1 al 6 separada de un espacio:" + "\n");
                String jugada = input.nextLine();
                String fichas[] = jugada.split(" ");
                jugadaHecha = true;
                for(int i = 0; i < fichas.length; i++) {
                    int num = Integer.parseInt(fichas[i]);
                    if (num >= 1 && num <= 6) linea.add(num);
                    else jugadaHecha = false;
                }
                if (!jugadaHecha) System.out.print("\nHas introducido un valor incorrecto.\n");
            }
        }
        return linea;
    }
}
