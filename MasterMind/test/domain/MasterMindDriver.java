/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Usuario
 */
public class MasterMindDriver {
    MasterMind main;
    
    public MasterMindDriver(){
        main = new MasterMind();
    }
    
    public void testLogin(){
        System.out.println("login");
    }
    
    public void testRegister(){
        System.out.println("register");
    }
    
    public void testCrearPartida(){
        System.out.println("crearPartida");
    }
    
    public void testCargarPartida(){
        System.out.println("cargarPartida");
    }
    
    public void testMuestraRanking(){
        System.out.println("muestraRanking");
    }
}
