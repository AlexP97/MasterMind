package utils;

import java.util.Scanner;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public final class PairDriver {
    Pair<String,String> p;
    
    public PairDriver(){
        Scanner input = new Scanner(System.in);
        String metodo = "prueba";
        while(!metodo.equals("salir")){
            System.out.println("¿Qué método quieres probar?");
            System.out.println("1- Crear un par vacío.");
            System.out.println("2- Crear un par con atributos.");
            System.out.println("3- Clonar un par.");
            System.out.println("4- Mirar el primer atributo.");
            System.out.println("5- Mirar el segundo atributo.");
            System.out.println("6- Asignar el primer atributo.");
            System.out.println("7- Asignar el segundo atributo.");
            System.out.println("Escribe salir para probar otra clase.");
            metodo = input.nextLine();
            if(metodo.equals("1")) PairTest();
            else if(metodo.equals("2")) PairTest2();
            else if(metodo.equals("3")) PairTest3();
            else if(metodo.equals("4")) getLeftTest();
            else if(metodo.equals("5")) getRightTest();
            else if(metodo.equals("6")) setLeftTest();
            else if(metodo.equals("7")) setRightTest();
            else if(!metodo.equals("prueba")) System.out.println("Entrada no válida");
        }
    }
    public void PairTest() {
        p = new Pair();
    }

    public void PairTest2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escribe el primer atributo que quieres que tenga el par");
        String primero = input.nextLine();
        System.out.println("Escribe el segundo atributo que quieres que tenga el par");
        String segundo = input.nextLine();
        p = new Pair(primero,segundo);
    }
    
    public void PairTest3(){
        p = new Pair(p);
    }

    public void getLeftTest() {
        String aux = p.getLeft();
        System.out.println(aux);
    }
    
    public void getRightTest() {
        String aux = p.getRight();
        System.out.println(aux);
    }
    
    public void setLeftTest() {
        Scanner input = new Scanner(System.in);
        String primero = input.nextLine();
        p.setLeft(primero);
    }
    
    public void setRightTest() {
        Scanner input = new Scanner(System.in);
        String segundo = input.nextLine();
        p.setRight(segundo);
    }
}
