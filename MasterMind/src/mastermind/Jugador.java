/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
    
    public String getName() {
        return this.name;
    }
    
    public boolean register(String n, String c) throws IOException {
        File dir = new File("players/"+n);
        boolean b = dir.mkdir();
        if(b) {      
            System.out.println("Te has registrado correctamente");
            this.name = n;
            this.password = c;
            this.IA = false;
            this.record = 0;
            File dir2 = new File("players/"+n+"/games");
            dir2.mkdir();
            File info = new File("players/"+n+"/info.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(info));
            bw.write(n+" "+c+" 0 true");
            bw.close();
            return true;
        }
        else {
            System.out.println("El jugador ya existe");
            return false;
        }
    }
    
    public boolean login(String n, String c) throws IOException {
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
        catch(FileNotFoundException ex) {
            System.out.println("El usuario introducido es incorrecto");
            return false;
        }
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public int getRecord() {
        return this.record;
    }
    
    public boolean esIA() {
        return this.IA;
    }
    
    public void setRecord(int r) {
        if(r > this.record) 
            this.record = r;
    }
    
    public ArrayList<Integer> jugar() { 
            return null;
    }
    
  
    
}
