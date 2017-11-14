/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import persistence.JugadorPersistenciaDriver;
import utils.FuncionesDriver;
import utils.PairDriver;

/**
 *
 * @author Usuario
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CodePegDriver codePegDriver = new CodePegDriver();
        KeyPegDriver keyPegDriver = new KeyPegDriver();
        JugadorDriver jugadorDriver = new JugadorDriver();
        CodeBreakerDriver codeBreakerDriver = new CodeBreakerDriver();
        CodeMakerDriver codeMakerDriver = new CodeMakerDriver();
        RankingDriver rankingDriver = new RankingDriver();
        FuncionesDriver funcDriver = new FuncionesDriver();
        PairDriver pairDriver = new PairDriver();
        JugadorPersistenciaDriver jpDriver = new JugadorPersistenciaDriver();
    }
    
}
