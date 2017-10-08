/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

/**
 *
 * @author usuario
 */
public class Jugador {
    private String name;
    private String password;
    private int record;
    private final boolean IA;
    
    public Jugador(String n, String c) {
        this.name = n;
        this.password = c;
        this.IA = true;
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
    
  
    
}
