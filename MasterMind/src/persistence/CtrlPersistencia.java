/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public abstract class CtrlPersistencia {
    
    public Pair<Boolean,String> write(Object object, String path){
        Pair <Boolean,String> p = new Pair();
        
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) file.delete();
                
        try {
         FileOutputStream fileOut = new FileOutputStream(path);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(object);
         out.close();
         fileOut.close();
         p = new Pair(true, "");
        } catch (IOException i) {
            System.out.println(i);
            p = new Pair(false, "Problema en el guardado");
      }
        
        return p;
    }
    
    public Object read(String path) {
      
        Object object = null;
        try {
         FileInputStream fileIn = new FileInputStream(path);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         object = in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         return null;
      } catch (ClassNotFoundException c) {
         return null;
      }
        
        return object;
    }
}
