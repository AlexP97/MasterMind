/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        Game game = new Game("1", "1", "1");
        
        System.out.print("Introduce el nombre de usuario." + "\n");

        Scanner input = new Scanner(System.in);

        String user = input.nextLine();
                    
        game.LoadGame(user);
        
    }
    
}
