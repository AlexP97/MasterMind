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
        
        System.out.print("Bienvenido a MasterMind." + "\n");
        Boolean entrado = false; 
        Scanner input = new Scanner(System.in);
        while(!entrado){
            System.out.print("Escribe login para iniciar sesión, o register para registrarte." + "\n");
            String start = input.nextLine();
            if(start == "login"){   //no entra nunca en ninguna de las 2 opciones
                System.out.print("Introduce el nombre de usuario." + "\n");
                System.out.print("Introduce la contraseña." + "\n");
                entrado = true;
            }
            else if(start == "register"){
                System.out.print("Introduce el nombre de usuario." + "\n");
                System.out.print("Introduce la contraseña." + "\n");
                entrado = true;
            }
            else System.out.print("Entrada no válida" + "\n");
        }
           
        Game game = new Game("1", "1", "1");           
        
    }
    
}
