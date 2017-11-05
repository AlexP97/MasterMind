/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author usuario
 */
public class Jugador {
    private String name;
    private String password;
    private int record;
    private boolean IA;
    
    public Jugador() {
      
    }
    
    public Jugador(String userName, String pass) {
        
        this.name = userName;
        this.password = pass;
        
    }
    
    public ArrayList<Integer> donaSolucio(ArrayList<CodePeg> tirada, ArrayList<CodePeg> solucio) {
        ArrayList<Integer> linea = new ArrayList<>();
        ArrayList<Integer> visitats = new ArrayList<>();
        for(int i = 0; i < 4; i++) 
            visitats.add(0);
        int indice;
        int valor;
        for(int i = 0; i < tirada.size(); i++){
            valor = 0;
            indice = -1;
            for(int k = 0; k < solucio.size(); k++) {
                if(tirada.get(i).getColour() == solucio.get(k).getColour()) {
                    if(tirada.get(i).getPosition() == solucio.get(k).getPosition()) {
                        indice = k;
                        valor = 2;
                    } 
                    else {
                        if(valor == 0 && visitats.get(k) == 0) {
                            indice = k;
                            valor = 1;
                        }     
                    }
                }
            }
            if(indice != -1) {
                if(visitats.get(indice) < valor)
                    visitats.set(indice, valor);
            }
        }
        //ordenar el vector
        for(int i = 0; i < visitats.size(); i++) {
            if(visitats.get(i) == 2)
                linea.add(2);
        }
        for(int i = 0; i < visitats.size(); i++) {
            if(visitats.get(i) == 1)
                linea.add(1);
        }
        while(linea.size() < 4)
            linea.add(0);
        return linea;
    }
       
    public boolean register(String n, String c) {
        File dir = new File("players/"+n);
        boolean b = dir.mkdirs();
        if(b) {      
            System.out.println("Te has registrado correctamente");
            this.name = n;
            this.password = c;
            this.IA = false;
            this.record = 0;
            File dir2 = new File("players/"+n+"/games");
            dir2.mkdir();
            File info = new File("players/"+n+"/info.txt");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(info));
                bw.write(n+" "+c+" 0 true");
                bw.close();
            }
            catch(IOException e) {
                System.out.println("Error en el registro");
                return false;
            }
            return true;
        }
        else {
            System.out.println("El jugador ya existe");
            return false;
        }
    }
    
    public boolean login(String n, String c) {
        try{
            String linea;
            FileReader f = new FileReader("players/"+n+"/info.txt");
            BufferedReader b = new BufferedReader(f);
            linea = b.readLine();
            b.close();
            String palabra[] = linea.split(" ");
            if(!palabra[1].equals(c)) {
                System.out.println("La contraseña introducida es incorrecta");
                return false;
            }
            this.name = palabra[0];
            this.password = palabra[1];
            this.record = Integer.parseInt(palabra[2]);
            this.IA = Boolean.valueOf(palabra[3]);
            System.out.println("Has iniciado sesión correctamente");
            return true;
        }
        catch(IOException ex) {
            System.out.println("El usuario introducido es incorrecto");
            return false;
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public int getRecord() {
        return this.record;
    }
    
    public void setIA() {
        this.IA = true;
    }
    
    public boolean esIA() {
        return this.IA;
    }
    
    public void setRecord(int r) {
        if(r > this.record) {
            this.record = r;
            File info = new File("players/"+this.name+"/info.txt");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(info));
                bw.write(this.name+" "+this.password+" "+String.valueOf(r)+" "+this.IA);
                bw.close();
            }
            catch(IOException e) {
                System.out.println("Error al agregar record");
            }
        }
    }
}
