/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Round {
    private final int number;
    private final ArrayList<Casilla> casilla;
    
    public Round(int number, ArrayList<Casilla> casilla){
        this.number = number;
        this.casilla = casilla;
    }
}
