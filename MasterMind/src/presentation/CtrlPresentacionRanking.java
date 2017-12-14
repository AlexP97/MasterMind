/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.CtrlDominioRanking;
import java.util.ArrayList;
import utils.Pair;

/**
 *
 * @author Espejo Saldaña, Adrián
 */
public class CtrlPresentacionRanking {
    private final CtrlDominioRanking CDr;
    
    public CtrlPresentacionRanking(CtrlDominioRanking CDr){
        this.CDr = CDr;
    }
    public ArrayList<Pair<String, Integer>> mostrarRanking(){
        return CDr.muestraRanking();
    }
    public Pair<Boolean,Integer> actualizaRanking(String nombre, int puntos){
        return CDr.actualizaRanking(nombre, puntos);
    }
}
