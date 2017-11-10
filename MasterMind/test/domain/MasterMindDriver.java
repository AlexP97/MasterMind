/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Usuario
 */
public final class MasterMindDriver {
    MasterMind main;
    JugadorStub jugador;
    RankingStub ranking;
    
    public MasterMindDriver(){
        testLogin();
        testRegister();
        testCrearPartida();
        testCargarPartida();
        testMuestraRanking();
    }
    
    public void testLogin(){
        boolean b = MasterMind.login(jugador.create());
    }
    
    public void testRegister(){
        boolean b = MasterMind.register(jugador.create());
    }
    
    public void testCrearPartida(){
        MasterMind.crearPartida(jugador.create());
    }
    
    public void testCargarPartida(){
        MasterMind.cargarPartida(jugador.create());
    }
    
    public void testMuestraRanking(){
        ranking.muestraRanking();
    }
}
