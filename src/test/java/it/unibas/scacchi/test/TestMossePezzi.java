package it.unibas.scacchi.test;

import it.unibas.scacchi.modello.Cavallo;
import it.unibas.scacchi.modello.Costanti;
import it.unibas.scacchi.modello.Scacchiera;
import junit.framework.*;

public class TestMossePezzi extends TestCase{
    
    private Scacchiera scacchiera;
    
    public void setUp(){
        scacchiera = new Scacchiera();
    }
    
    //////////////////////////
    ////// Metodi Test Cavallo
    //////////////////////////
    
    public void testMosseCavalloUno(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 0, 0);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size(), 2);
    }
    
    public void testMosseCavalloDue(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 1, 1);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 2);
    }
    
    public void testMosseCavalloTre(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 4, 4);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() ,4);
    }
    
    public void testMosseCavalloQuattro(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 7, 7);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 2);
    }
    
    public void testMosseCavalloCinque(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 0, 6);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 1);
    }
    
    public void testMosseCavalloConNemico(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        Cavallo cortix = new Cavallo(Costanti.BIANCO);
        scacchiera.posizionaPezzo(valerio, 4, 4);
        scacchiera.posizionaPezzo(cortix, 6, 5);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 4);
    }
    
    public void testMosseCavalloConAmico(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        Cavallo cortix = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 4, 4);
        scacchiera.posizionaPezzo(cortix, 6, 5);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 3);
    }
    
    
    
}
