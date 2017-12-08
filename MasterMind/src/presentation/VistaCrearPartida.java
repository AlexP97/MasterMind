/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.ArrayList;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class VistaCrearPartida extends VistaGenerica {
    
    public VistaCrearPartida(){
        super();
    }
    
    @Override
    public void obtenerDatos(ArrayList<String> datos){
        System.out.println("Escribe el id de la partida");
        datos.add(input.nextLine());
        boolean siguiente = false;
        while(!siguiente){
            System.out.println("Escribe la dificultad de la partida");
            System.out.println("1 - Fácil");
            System.out.println("2 - Medio");
            System.out.println("3 - Difícil");
            String aux = input.nextLine();
            if(aux.equals("1")){
                datos.add("facil");
                siguiente = true;
            }
            else if(aux.equals("2")){
                datos.add("medio");
                siguiente = true;
            }
            else if(aux.equals("3")){
                datos.add("dificil");
                siguiente = true;
            }
            else System.out.println("Entrada no válida");
        }
        siguiente = false;
        while(!siguiente){
            System.out.println("Escribe el modo de la partida");
            System.out.println("1 - Codemaker");
            System.out.println("2 - Codebreaker");
            String aux = input.nextLine();
            if(aux.equals("1")){
                datos.add("codemaker");
                siguiente = true;
            }
            else if(aux.equals("2")){
                datos.add("codebreaker");
                siguiente = true;
            }
            else System.out.println("Entrada no válida");
        }
        siguiente = false;
        while(!siguiente){
            System.out.print("Escribe el número de fichas con las que quieres jugar del 1 al 9" + "\n");
            Integer num = Integer.parseInt(input.nextLine());
            if (num > 0 && num < 10){
                datos.add(num.toString());
                siguiente = true;
            }
            else System.out.println("Número de fichas no válido");
        }
        siguiente = false;
        while(!siguiente){
            System.out.print("Escribe el número máximo que quieres que tenga la ficha del 1 al 9" + "\n");
            Integer ran = Integer.parseInt(input.nextLine());
            if (ran > 0 && ran < 10){
                datos.add(ran.toString());
                siguiente = true;
            }
            else System.out.println("Rango no válido");
        }
    }

    @Override
    void mostrarVista() {

    }

    @Override
    int getOpciones() {
        return 1;
    }
}
