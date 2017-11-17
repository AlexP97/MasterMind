package utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class FuncionesDriver {
    ArrayList<Integer> a;
    
    public FuncionesDriver(){
        a = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String metodo = "prueba";
        while(!metodo.equals("salir")){
            System.out.println("¿Qué método quieres probar?");
            System.out.println("1- Crear una array.");
            System.out.println("2- Ordenar una array.");
            System.out.println("Escribe salir para probar otra clase.");
            metodo = input.nextLine();
            if(metodo.equals("1")) testCreaArray();
            else if(metodo.equals("2")) testOrdenar();
            else if(!metodo.equals("prueba")) System.out.println("Entrada no válida");
        }
    }
    
    public void testOrdenar(){
        testCreaArray();
        Funciones.ordenar(a);
        for(int i = 0; i < a.size(); i++) System.out.print(a.get(i)+" ");
    }
    
    public void testCreaArray(){
        Scanner input = new Scanner(System.in);
        System.out.println("Escribe 4 números, separados de un espacio");
        String num = input.nextLine();
        String num2[] = num.split(" ");
        a = Funciones.creaArray(Integer.parseInt(num2[0]),Integer.parseInt(num2[1]),Integer.parseInt(num2[2]),Integer.parseInt(num2[3]));
    }
}
