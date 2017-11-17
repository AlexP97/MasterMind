
import domain.*;
import java.util.Scanner;
import persistence.*;
import utils.FuncionesDriver;
import utils.PairDriver;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String clase = "prueba";
        while(!clase.equals("salir")){
            System.out.println("¿Qué clase quieres probar?");
            System.out.println("1- CodePeg");
            System.out.println("2- KeyPeg");
            System.out.println("3- Jugador");
            System.out.println("4- CodeBreaker");
            System.out.println("5- CodeMaker");
            System.out.println("6- Ranking");
            System.out.println("7- Funciones");
            System.out.println("8- Pair");
            System.out.println("9- JugadorPersistencia");
            System.out.println("10- RankingPersistencia");
            System.out.println("11- GamePersistencia");
            System.out.println("Escribe salir para acabar la ejecución");
            clase = input.nextLine();
            if(clase.equals("1")){
                CodePegDriver codePegDriver = new CodePegDriver();
            }
            if(clase.equals("2")){
                KeyPegDriver keyPegDriver = new KeyPegDriver();
            }
            if(clase.equals("3")){
                JugadorDriver jugadorDriver = new JugadorDriver();
            }
            if(clase.equals("4")){
                CodeBreakerDriver codeBreakerDriver = new CodeBreakerDriver();
            }
            if(clase.equals("5")){
                CodeMakerDriver codeMakerDriver = new CodeMakerDriver();
            }
            if(clase.equals("6")){
                RankingDriver rankingDriver = new RankingDriver();
            }
            if(clase.equals("7")){
                FuncionesDriver funcDriver = new FuncionesDriver();
            }
            if(clase.equals("8")){
                PairDriver pairDriver = new PairDriver();
            }
            if(clase.equals("9")){
                JugadorPersistenciaDriver jpDriver = new JugadorPersistenciaDriver();
            }
            if(clase.equals("10")){
                RankingPersistenciaDriver rpDriver = new RankingPersistenciaDriver();
            }
            if(clase.equals("11")){
                GamePersistenciaDriver gpDriver = new GamePersistenciaDriver();
            }
        }      
    }
    
}
