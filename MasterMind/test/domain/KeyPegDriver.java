package domain;

import java.util.Scanner;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class KeyPegDriver {
    KeyPeg keyPeg;
    int nC;
    int nF;
    
    public KeyPegDriver(){
        Scanner input = new Scanner(System.in);
        boolean creado = false;
        while(!creado){
            creado = true;
            System.out.println("Creación de una KeyPeg");
            System.out.println("Escribe el color, posición y total de fichas, por orden y separados de un espacio");
            String keypeg = input.nextLine();
            String cp[] = keypeg.split(" ");
            nC = 2;
            nF = Integer.parseInt(cp[2]);
            try{
                keyPeg = new KeyPeg(Integer.parseInt(cp[0]),Integer.parseInt(cp[1]),Integer.parseInt(cp[2]));
            } catch(IllegalArgumentException ex){
                creado = false;
            }
        }

        String metodo = "prueba";
        while(!metodo.equals("salir")){
            System.out.println("¿Qué método quieres probar?");
            System.out.println("1- Mirar si el color es válido.");
            System.out.println("2- Mirar si la posición es válida.");
            System.out.println("3- Mirar el color de la pista creada.");
            System.out.println("4- Mirar la posición de la pista creada.");
            System.out.println("Escribe salir para probar otra clase.");
            metodo = input.nextLine();
            if(metodo.equals("1")) testColourValid();
            else if(metodo.equals("2")) testPosValid();
            else if(metodo.equals("3")) testGetColour();
            else if(metodo.equals("4")) testGetPosition();
            else if(!metodo.equals("prueba")) System.out.println("Entrada no válida");
        }
    }
    
    public void testColourValid() {
        boolean result = keyPeg.colourValid(keyPeg.getColour(),nC);
        if(result) System.out.println("El color es válido");
    }
    
    public void testPosValid() {
        boolean result = keyPeg.posValid(keyPeg.getPosition(),nF);
        if(result) System.out.println("La posición es válida");
    }

    public void testGetColour() {
        int result = keyPeg.getColour();
        System.out.println(result);
    }

    public void testGetPosition() {
        int result = keyPeg.getPosition();
        System.out.println(result);
    }
}
