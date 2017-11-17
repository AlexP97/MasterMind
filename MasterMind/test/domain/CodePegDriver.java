package domain;

import java.util.Scanner;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class CodePegDriver {
    CodePeg codePeg;
    int nC;
    int nF;
    
    public CodePegDriver(){
        Scanner input = new Scanner(System.in);
        boolean creado = false;
        while(!creado){
            creado = true;
            System.out.println("Creación de una CodePeg");
            System.out.println("Escribe el color, posición, total de fichas y total de colores, por orden y separados de un espacio");
            String codepeg = input.nextLine();
            String cp[] = codepeg.split(" ");
            nC = Integer.parseInt(cp[3]);
            nF = Integer.parseInt(cp[2]);
            try{
                codePeg = new CodePeg(Integer.parseInt(cp[0]),Integer.parseInt(cp[1]),Integer.parseInt(cp[2]),Integer.parseInt(cp[3]));
            } catch(IllegalArgumentException ex){
                creado = false;
            }
        }
    
        String metodo = "prueba";
        while(!metodo.equals("salir")){
            System.out.println("¿Qué método quieres probar?");
            System.out.println("1- Mirar si el color es válido.");
            System.out.println("2- Mirar si la posición es válida.");
            System.out.println("3- Mirar el color de la ficha creada.");
            System.out.println("4- Mirar la posición de la ficha creada.");
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
        boolean result = codePeg.colourValid(codePeg.getColour(),nC);
        if(result) System.out.println("El color es válido");
    }
    
    public void testPosValid() {
        boolean result = codePeg.posValid(codePeg.getPosition(),nF);
        if(result) System.out.println("La posición es válida");
    }

    public void testGetColour() {
        int result = codePeg.getColour();
        System.out.println(result);
    }

    public void testGetPosition() {
        int result = codePeg.getPosition();
        System.out.println(result);
    }
}
