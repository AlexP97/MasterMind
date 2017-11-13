/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Usuario
 */
public class PairDriver {
    Pair<String,Integer> p;
    
    public PairDriver(){
        PairTest();
        PairTest2();
        PairTest3();
        getLeftTest();
        getRightTest();
        setLeftTest();
        setRightTest();
    }
    public void PairTest() {
        p = new Pair();
    }

    public void PairTest2() {
        p = new Pair("adri",2);
    }
    
    public void PairTest3(){
        Pair<String,Integer> p2 = new Pair("adri",2);
        p = new Pair(p);
    }

    public void getLeftTest() {
        String aux = p.getLeft();
    }
    
    public void getRightTest() {
        int aux = p.getRight();
    }
    
    public void setLeftTest() {
        p.setLeft("adri");
    }
    
    public void setRightTest() {
        p.setRight(2);
    }
}
