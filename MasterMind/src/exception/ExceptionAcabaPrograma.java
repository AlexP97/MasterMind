/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Usuario
 */
public class ExceptionAcabaPrograma extends Exception{
    public ExceptionAcabaPrograma(){
        super("El juego ha finalizado su ejecución.");
    }
}
