package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    
    /**
     *
     * @param n1 nombre actual del usuario
     * @param n2 nombre que se quiere poner el usuario
     * @param c contraseña del usuario
     * @return si se ha cambiado el nombre correctamente y el mensaje de si lo ha hecho bien o no
     */
    public Pair<Boolean, String> setName(String n1,String n2, String c) {
        File dir = new File("data/players/"+n1);
        File dir2 = new File("data/players/"+n2);
        boolean success = dir.renameTo(dir2);
        Pair<Boolean, String> p = new Pair<>();
        if(!success) {
            p.setRight("El nombre de usuario ya está en uso.");
            p.setLeft(false);
        }
        else {
            File info = new File("data/players/"+n2+"/info.txt");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(info));
                bw.write(n2+" "+c);
                bw.close();
                p.setRight("Has cambiado tu nombre de usuario correctamente.");
                p.setLeft(true);
            }
            catch (IOException e) {
                p.setRight("Error al cambiar de nombre");
                p.setLeft(false);
            }
        }
        return p;
    }
    
    /**
     *
     * @param n el nombre del usuario
     * @param c la contraseña
     * @return si se ha cambiado la contraseña correctamente y el mensaje de si lo ha hecho bien o no
     */
    public Pair<Boolean, String> setPassword(String n, String c) {
        File info = new File("data/players/"+n+"/info.txt");
        Pair<Boolean, String> p = new Pair<>();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(info));
            bw.write(n+" "+c);
            bw.close();
            p.setRight("Has cambiado tu contraseña correctamente.");
            p.setLeft(true);
        }
        catch (IOException e) {
            p.setRight("Error al cambiar de contraseña");
            p.setLeft(false);
        }
        return p;
    }
    
    private void borrarDirectorio(File f) {
        File[] ficheros = f.listFiles();
        for(int i = 0; i < ficheros.length; i++) {
            if(ficheros[i].isDirectory())
                borrarDirectorio(ficheros[i]);
            ficheros[i].delete();
        }
    }
    
    /**
     *
     * @param n nombre del usuario
     * @return el mensaje de si lo ha hecho bien o no
     */
    public Pair<Boolean,String> elimina(String n) {
        File f = new File("data/players/"+n);
        borrarDirectorio(f);
        Pair<Boolean,String> p = new Pair<>();
        if(f.delete()) {
            p.setLeft(true);
            p.setRight("El usuario se ha eliminado correctamente");
            return p;
        }
        else {
            p.setLeft(false);
            p.setRight("No se ha podido eliminar el usuario");
            return p;
        }
    }
    
    public ArrayList<String> obtenerPartidas(String n) {
        ArrayList<String> res = new ArrayList<>();
        File dir = new File("data/players/"+n+"/games");
        if(dir.exists()) {
            File[] ficheros = dir.listFiles();
            for(int i = 0; i < ficheros.length; i++) {
                res.add(ficheros[i].getName());
            }
        }
        return res;
    }
}
