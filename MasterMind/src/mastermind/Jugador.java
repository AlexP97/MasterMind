/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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
    
    public void register(String n, String c) throws IOException {
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
            if(info.exists())
                System.out.println("Te has registrado correctamente");
            else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(info));
                bw.write(n+" "+c);
                bw.close();
            }
        }
        else
            System.out.println("El jugador ya existe");
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
    
  
    
}
