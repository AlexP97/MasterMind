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
import persistence.JugadorPersistencia;


/**
 *
 * @author Pérez Ortiz, Alejandro
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
        JugadorPersistencia j = new JugadorPersistencia();
        Pair<Boolean, String> p = j.register(n,c);
        if(p.getLeft()) {      
            this.name = n;
            this.password = c;
            this.IA = false;
        }
        return p;
    }
    
    public Pair<Boolean, String> login(String n, String c) {
        JugadorPersistencia j = new JugadorPersistencia();
        Pair<Boolean, String> p = j.login(n,c);
        if(p.getLeft()) {
            this.name = n;
            this.password = c;
            this.IA = false;
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
        File dir = new File("data/players/"+this.name);
        File dir2 = new File("data/players/"+n);
        boolean success = dir.renameTo(dir2);
        if(!success) {
            System.out.println("El nombre de usuario ya está en uso.");
            return;
        }
        File info = new File("data/players/"+n+"/info.txt");
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
        File info = new File("data/players/"+this.name+"/info.txt");
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
    
    private void borrarDirectorio(File f) {
        File[] ficheros = f.listFiles();
        for(int i = 0; i < ficheros.length; i++) {
            if(ficheros[i].isDirectory())
                borrarDirectorio(ficheros[i]);
            ficheros[i].delete();
        }
    }
    
    public void elimina() {
        File f = new File("data/players/"+this.name);
        borrarDirectorio(f);
        if(f.delete()) 
            System.out.println("El usuario se ha eliminado correctamente");
        else
            System.out.println("No se ha podido eliminar el usuario");
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
