/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.CtrlDominioPartida;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Daniel
 */
public class CtrlPresentacionGame {
    
    private CtrlDominioPartida CDp;
    
    public CtrlPresentacionGame(CtrlDominioPartida cd){
        this.CDp = cd;
    }
    
    public Pair <Boolean,String> crearPartida(String userName, String id, String dif, String mod, int num, int ran){
        return CDp.crearPartida(userName,id,dif,mod,num,ran);
    }
    
    public Pair <Boolean, String> eliminarPartida(String userName, String id){
        return CDp.eliminarPartida(userName, id);
    }
    
    public Pair <Boolean, String> setCodIni(ArrayList<Integer> cods){
        return CDp.setCodIni(cods);
    }
    
    public ArrayList<Integer> jugadaCodeB(ArrayList<Integer> cods){
        return CDp.jugadaCodeB(cods);
    }
    
    public Pair <Boolean,Integer> finishGame(boolean b){
        return CDp.finishGame(b);
    }
}
