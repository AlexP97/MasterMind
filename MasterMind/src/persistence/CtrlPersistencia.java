/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import utils.Pair;

/**
 *
 * @author Pérez Ortiz, Alejandro
 */
public abstract class CtrlPersistencia {
    
    public abstract Pair<Boolean,String> write(byte[] serial, String path);
    
    public abstract byte[] read(String s1, String s2);
}
