package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public class JugadorPersistencia {

    /**
     *
     * @param n nombre de usuario
     * @param c contraseña
     * @return si se ha registrado con éxito
     */
    public Pair<Boolean, String> register(String n, String c) {
        File dir = new File("data/players/"+n);
        boolean b = dir.mkdirs();
        Pair<Boolean, String> p = new Pair();
        if(b) {      
            p.setRight("Te has registrado correctamente");
            File dir2 = new File("data/players/"+n+"/games");
            dir2.mkdir();
            File info = new File("data/players/"+n+"/info.txt");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(info));
                bw.write(n+" "+c);
                bw.close();
            }
            catch(IOException e) {
                p.setRight("Error en el registro");
                p.setLeft(false);
                return p;
            }
            p.setLeft(true);
        }
        else {
            p.setRight("El jugador ya existe");
            p.setLeft(false);
        }
        return p;
    }
    
    /**
     *
     * @param n nombre de usuario
     * @param c contraseña
     * @return si ha hecho login con éxito
     */
    public Pair<Boolean, String> login(String n, String c) {
        Pair<Boolean, String> p = new Pair();
        try{
            String linea;
            FileReader f = new FileReader("data/players/"+n+"/info.txt");
            BufferedReader b = new BufferedReader(f);
            linea = b.readLine();
            b.close();
            String palabra[] = linea.split(" ");
            if(!palabra[1].equals(c)) {
                p.setRight("La contraseña introducida es incorrecta");
                p.setLeft(false);
                return p;
            }
            p.setRight("Has iniciado sesión correctamente");
            p.setLeft(true);
        }
        catch(IOException ex) {
            p.setRight("El usuario introducido es incorrecto");
            p.setLeft(false);
            return p;
        }
        return p;
     }
}
