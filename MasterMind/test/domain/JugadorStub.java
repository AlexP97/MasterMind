/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public class JugadorStub {
    
    public Jugador create(){
        return new Jugador();
    }
    
    public int getNFichas(){
        return 4;
    }
    
    public int getNColores(){
        return 6;
    }
}
