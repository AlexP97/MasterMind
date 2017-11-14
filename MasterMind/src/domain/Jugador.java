/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import utils.Pair;
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
    private boolean IA;
    private int nFichas;
    private int nColores;
    
    
    public Jugador() {
      
    }
    
    public Jugador(int nfichas, int ncolores) {
        this.nFichas = nfichas;
        this.nColores = ncolores;
    }
    
    public Pair<Boolean, String> register(String n, String c) {
        File dir = new File("players/"+n);
        boolean b = dir.mkdirs();
        Pair<Boolean, String> p = new Pair();
        if(b) {      
            p.setRight("Te has registrado correctamente");
            this.name = n;
            this.password = c;
            this.IA = false;
            File dir2 = new File("players/"+n+"/games");
            dir2.mkdir();
            File info = new File("players/"+n+"/info.txt");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(info));
                bw.write(n+" "+c);
                bw.close();
            }
            catch(IOException e) {
                p.setRight("Error en el registro");
                p.setLeft(false);
                return p;
            }
            p.setLeft(true);
        }
        else {
            p.setRight("El jugador ya existe");
            p.setLeft(false);
        }
        return p;
    }
    
    public Pair<Boolean, String> login(String n, String c) {
        Pair<Boolean, String> p = new Pair();
        try{
            String linea;
            FileReader f = new FileReader("players/"+n+"/info.txt");
            BufferedReader b = new BufferedReader(f);
            linea = b.readLine();
            b.close();
            String palabra[] = linea.split(" ");
            if(!palabra[1].equals(c)) {
                p.setRight("La contraseña introducida es incorrecta");
                p.setLeft(false);
                return p;
            }
            this.name = palabra[0];
            this.password = palabra[1];
            this.IA = false;
            p.setRight("Has iniciado sesión correctamente");
            p.setLeft(true);
        }
        catch(IOException ex) {
            p.setRight("El usuario introducido es incorrecto");
            p.setLeft(false);
            return p;
        }
        return p;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public int getNColores() {
        return this.nColores;
    }
    
    public int getNFichas() {
        return this.nFichas;
    }
    
    public void setIA() {
        this.IA = true;
    }
    
    public boolean esIA() {
        return this.IA;
    }
    
    public void setName(String n) {
        File dir = new File("players/"+this.name);
        File dir2 = new File("players/"+n);
        boolean success = dir.renameTo(dir2);
        if(!success) {
            System.out.println("El nombre de usuario ya está en uso.");
            return;
        }
        File info = new File("players/"+n+"/info.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(info));
            bw.write(n+" "+this.password);
            bw.close();
            this.name = n;
            System.out.println("Has cambiado tu nombre de usuario correctamente.");
            
        }
        catch (Exception e) {
            System.out.println("Error al cambiar de nombre");
        }
    }
    
    public void setPassword(String c) {
        File info = new File("players/"+this.name+"/info.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(info));
            bw.write(this.name+" "+c);
            bw.close();
            this.password = c;
            System.out.println("Has cambiado tu contraseña correctamente.");
            
        }
        catch (Exception e) {
            System.out.println("Error al cambiar de contraseña");
        }
    }
    
    public ArrayList<Integer> donaSolucio(ArrayList<CodePeg> tirada, ArrayList<CodePeg> solucio) {
        ArrayList<Integer> linea = new ArrayList<>();
        ArrayList<Boolean> visitats = new ArrayList<>();
        ArrayList<Boolean> visitats2 = new ArrayList<>();
        for(int i = 0; i < nFichas; i++) {
            visitats.add(false);
            visitats2.add(false);
        }
        
        for(int i = 0; i < tirada.size(); i++) {
            if(tirada.get(i).getColour() == solucio.get(i).getColour()) {
                linea.add(2);
                visitats.set(i,true);
                visitats2.set(i,true);
            }   
        }
        
        
        for(int i = 0; i < tirada.size(); i++) {
            for(int j = 0; j < solucio.size() && !visitats.get(i); j++) {
                if(tirada.get(i).getColour() == solucio.get(j).getColour() && !visitats2.get(j)) {
                    linea.add(1);
                    visitats2.set(j,true);
                    visitats.set(i,true);
                }
            }
        }
        while(linea.size() < nFichas) {
            linea.add(0);
        }
            
        return linea;
    }
}
