package it.unibas.scacchi.test;

import it.unibas.scacchi.modello.AbstractPezzo;
import it.unibas.scacchi.modello.Alfiere;
import it.unibas.scacchi.modello.Cavallo;
import it.unibas.scacchi.modello.Costanti;
import it.unibas.scacchi.modello.Mossa;
import it.unibas.scacchi.modello.Pedone;
import it.unibas.scacchi.modello.Re;
import it.unibas.scacchi.modello.Regina;
import it.unibas.scacchi.modello.Scacchiera;
import it.unibas.scacchi.modello.Torre;
import junit.framework.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMossePezzi extends TestCase{
    
    private Scacchiera scacchiera;
    static Logger log = LoggerFactory.getLogger(TestMossePezzi.class);
    
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
        assertEquals(valerio.getMossePossibili().size() , 4);
    }
    
    public void testMosseCavalloTre(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 4, 4);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() ,8);
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
        assertEquals(valerio.getMossePossibili().size() , 3);
    }
    
    public void testMosseCavalloConNemico(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        Cavallo cortix = new Cavallo(Costanti.BIANCO);
        scacchiera.posizionaPezzo(valerio, 4, 4);
        scacchiera.posizionaPezzo(cortix, 6, 5);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 8);
    }
    
    public void testMosseCavalloConAmico(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        Cavallo cortix = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 0, 7);
        scacchiera.posizionaPezzo(cortix, 2, 6);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 1);
    }
    
    public void testMosseCavalloConAmico2(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        Cavallo cortix = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 4, 4);
        scacchiera.posizionaPezzo(cortix, 6, 5);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 7);
    }
    
    public void testMosseCavalloPosizione21(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 2, 1);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 6);
    }
    
    public void testMosseCavalloPosizione54(){
        Cavallo valerio = new Cavallo(Costanti.NERO);
        scacchiera.posizionaPezzo(valerio, 5, 4);
        valerio.calcolaMosse(scacchiera);
        assertEquals(valerio.getMossePossibili().size() , 8);
    }
    
    //////////////////////////
    ////// Metodi Test Torre
    //////////////////////////
    
    public void testMosseTorreUno(){
        Torre guevara = new Torre(Costanti.NERO);
        scacchiera.posizionaPezzo(guevara, 0, 0);
        guevara.calcolaMosse(scacchiera);
        assertEquals(guevara.getMossePossibili().size(), 14);
    }
    
    public void testMosseTorreDue(){
        Torre guevara = new Torre(Costanti.NERO);
        scacchiera.posizionaPezzo(guevara, 7, 7);
        guevara.calcolaMosse(scacchiera);
        assertEquals(guevara.getMossePossibili().size(), 14);
    }
    
    public void testMosseTorreTre(){
        Torre guevara = new Torre(Costanti.NERO);
        scacchiera.posizionaPezzo(guevara, 4, 4);
        guevara.calcolaMosse(scacchiera);
        assertEquals(guevara.getMossePossibili().size(), 14);
    }
    
    public void testMosseTorreAmico(){
        Torre guevara = new Torre(Costanti.NERO);
        Torre arcaica = new Torre(Costanti.NERO);
        scacchiera.posizionaPezzo(guevara, 0, 0);
        scacchiera.posizionaPezzo(arcaica, 1, 0);
        guevara.calcolaMosse(scacchiera);
        assertEquals(guevara.getMossePossibili().size(), 7);
    }
    
    public void testMosseTorreNemico(){
        Torre guevara = new Torre(Costanti.NERO);
        Torre arcaica = new Torre(Costanti.BIANCO);
        scacchiera.posizionaPezzo(guevara, 0, 0);
        scacchiera.posizionaPezzo(arcaica, 1, 0);
        guevara.calcolaMosse(scacchiera);
        assertEquals(guevara.getMossePossibili().size(), 8);
    }
    
    //////////////////////////
    ////// Metodi Test Alfiere
    //////////////////////////
    
    public void testMosseAlfiereUno(){
        Alfiere romeo = new Alfiere(Costanti.NERO);
        scacchiera.posizionaPezzo(romeo, 0, 0);
        romeo.calcolaMosse(scacchiera);
        assertEquals(romeo.getMossePossibili().size(), 7);   
    }
    
    public void testMosseAlfiereDue(){
        Alfiere romeo = new Alfiere(Costanti.NERO);
        scacchiera.posizionaPezzo(romeo, 7, 7);
        romeo.calcolaMosse(scacchiera);
        assertEquals(romeo.getMossePossibili().size(), 7);   
    }
    
    public void testMosseAlfiereTre(){
        Alfiere romeo = new Alfiere(Costanti.NERO);
        Alfiere bianco = new Alfiere(Costanti.BIANCO);
        scacchiera.posizionaPezzo(romeo, 1, 1);
        scacchiera.posizionaPezzo(bianco, 2, 2);
        romeo.calcolaMosse(scacchiera);
        assertEquals(romeo.getMossePossibili().size(), 4);   
    }
    
    public void testMosseAlfiereTre2(){
        Alfiere romeo = new Alfiere(Costanti.NERO);
        Alfiere bianco = new Alfiere(Costanti.NERO);
        scacchiera.posizionaPezzo(romeo, 1, 1);
        scacchiera.posizionaPezzo(bianco, 2, 2);
        romeo.calcolaMosse(scacchiera);
        assertEquals(romeo.getMossePossibili().size(), 3);   
    }
    
    public void testMosseAlfiereTre3(){
        Alfiere romeo = new Alfiere(Costanti.NERO);
        Alfiere nemico1 = new Alfiere(Costanti.BIANCO);
        scacchiera.posizionaPezzo(romeo, 1, 1);
        scacchiera.posizionaPezzo(nemico1, 0, 2);
        scacchiera.posizionaPezzo(nemico1, 2, 0);
        scacchiera.posizionaPezzo(nemico1, 2, 2);
        romeo.calcolaMosse(scacchiera);
        assertEquals(romeo.getMossePossibili().size(), 4);   
    }
    
    public void testMosseAlfiereTre4(){
        Alfiere romeo = new Alfiere(Costanti.NERO);
        Alfiere amico1 = new Alfiere(Costanti.NERO);
        scacchiera.posizionaPezzo(romeo, 1, 1);
        scacchiera.posizionaPezzo(amico1, 0, 2);
        scacchiera.posizionaPezzo(amico1, 2, 0);
        scacchiera.posizionaPezzo(amico1, 2, 2);
        scacchiera.posizionaPezzo(amico1, 0, 0);
        romeo.calcolaMosse(scacchiera);
        assertEquals(romeo.getMossePossibili().size(), 0);   
    }
    
    
    
    public void testMosseAlfiereQuattro(){
        Alfiere romeo = new Alfiere(Costanti.NERO);
        scacchiera.posizionaPezzo(romeo, 4, 4);
        romeo.calcolaMosse(scacchiera);
        assertEquals(romeo.getMossePossibili().size(), 13);   
    }
    
    //////////////////////////
    ////// Metodi Test Pedone
    //////////////////////////
    
    public void testPedone1(){
        Pedone pedone = new Pedone(Costanti.NERO, true);
        scacchiera.posizionaPezzo(pedone, 1, 1);
        pedone.calcolaMosse(scacchiera);
        assertEquals(pedone.getMossePossibili().size(), 2);
    }
    
    //pedone con prima mossa == true con possibilita di mangiare
    public void testPedone2(){
        Pedone pedone = new Pedone(Costanti.NERO, true);
        Pedone pedone1 = new Pedone(Costanti.BIANCO, true);
        scacchiera.posizionaPezzo(pedone, 1, 1);
        scacchiera.posizionaPezzo(pedone1, 2, 2);
        pedone.calcolaMosse(scacchiera);
        assertEquals(pedone.getMossePossibili().size(), 3);
    }
    
    //pedone con prima mossa == false con possibilita di mangiare
    public void testPedone3(){
        Pedone pedone = new Pedone(Costanti.NERO, false);
        Pedone pedone1 = new Pedone(Costanti.BIANCO, true);
        scacchiera.posizionaPezzo(pedone, 1, 1);
        scacchiera.posizionaPezzo(pedone1, 2, 2);
        pedone.calcolaMosse(scacchiera);
        assertEquals(pedone.getMossePossibili().size(), 2);
    }
    
    //test pedone nero bloccato con pezzo subito avanti
    public void testPedone4(){
        Pedone pedone = new Pedone(Costanti.NERO, false);
        Pedone pedone1 = new Pedone(Costanti.NERO, true);
        scacchiera.posizionaPezzo(pedone, 1, 1);
        scacchiera.posizionaPezzo(pedone1, 2, 1);
        pedone.calcolaMosse(scacchiera);
        //log.debug(pedone.getMossePossibili().toString());
        assertEquals(pedone.getMossePossibili().size(), 0);
    }
    
    public void testPedone5(){
        Pedone pedone = new Pedone(Costanti.BIANCO, false);
        scacchiera.posizionaPezzo(pedone, 6, 1);
        pedone.calcolaMosse(scacchiera);
        assertEquals(pedone.getMossePossibili().size(), 1);
    }
    
    public void testPedone6(){
        Pedone pedone = new Pedone(Costanti.BIANCO, true);
        scacchiera.posizionaPezzo(pedone, 6, 1);
        pedone.calcolaMosse(scacchiera);
        assertEquals(pedone.getMossePossibili().size(), 2);
    }
    
    public void testPedone7(){
        Pedone pedone = new Pedone(Costanti.BIANCO, true);
        Pedone pedone1 = new Pedone(Costanti.NERO, false);
        scacchiera.posizionaPezzo(pedone1, 5, 1);
        scacchiera.posizionaPezzo(pedone, 6, 1);
        pedone.calcolaMosse(scacchiera);
        assertEquals(pedone.getMossePossibili().size(), 0);
    }
    
    public void testPedone8(){
        Pedone pedone = new Pedone(Costanti.BIANCO, true);
        Pedone pedone1 = new Pedone(Costanti.NERO, true);
        scacchiera.posizionaPezzo(pedone1, 5, 2);
        scacchiera.posizionaPezzo(pedone, 6, 1);
        pedone.calcolaMosse(scacchiera);
        assertEquals(pedone.getMossePossibili().size(), 3);
    }
    
    //Test Che Lancia NullPointer per non aver calcolato gli strabordi di y 0=<y<Costanti.N
    public void testPedone4Null(){
        Pedone pedone = new Pedone(Costanti.NERO, true);
        scacchiera.posizionaPezzo(pedone, 0, 0);
        pedone.calcolaMosse(scacchiera);
        assertEquals(pedone.getMossePossibili().size(), 2);
    }
    
    //////////////////////////
    ////// Metodi Test Regina
    //////////////////////////
    
    public void testMosseReginaUno(){
        Regina r = new Regina(Costanti.BIANCO);
        scacchiera.posizionaPezzo(r, 0, 0);
        r.calcolaMosse(scacchiera);
        assertEquals(r.getMossePossibili().size(), 21);
    }
    
    public void testMosseReginaDue(){
        Regina r = new Regina(Costanti.BIANCO);
        scacchiera.posizionaPezzo(r, 7, 7);
        r.calcolaMosse(scacchiera);
        assertEquals(r.getMossePossibili().size(), 21);
    }
    
    public void testMosseReginaTre(){
        Regina r = new Regina(Costanti.BIANCO);
        scacchiera.posizionaPezzo(r, 4, 4);
        r.calcolaMosse(scacchiera);
        assertEquals(r.getMossePossibili().size(), 27);
    }
    
    public void testMosseReginaAmico(){
        Regina r = new Regina(Costanti.BIANCO);
        Regina re = new Regina(Costanti.BIANCO);
        scacchiera.posizionaPezzo(r, 0, 0);
        scacchiera.posizionaPezzo(re, 1, 1);
        r.calcolaMosse(scacchiera);
        assertEquals(r.getMossePossibili().size(), 14);
    }
    
    public void testMosseReginaNemico(){
        Regina r = new Regina(Costanti.BIANCO);
        Regina re = new Regina(Costanti.NERO);
        scacchiera.posizionaPezzo(r, 0, 0);
        scacchiera.posizionaPezzo(re, 1, 1);
        r.calcolaMosse(scacchiera);
        assertEquals(r.getMossePossibili().size(), 15);
    }
    
    //////////////////////////
    ////// Metodi Test Re
    //////////////////////////
    
    public void testMosseReUno(){
        Re re = new Re(Costanti.BIANCO);
        scacchiera.posizionaPezzo(re,0,0);
        re.calcolaMosse(scacchiera);
        assertEquals(re.getMossePossibili().size(),3);
    }
    
    public void testMosseReDue(){
        Re re = new Re(Costanti.BIANCO);
        scacchiera.posizionaPezzo(re,7,7);
        re.calcolaMosse(scacchiera);
        assertEquals(re.getMossePossibili().size(),3);
    }
    
    public void testMosseReTre(){
        Re re = new Re(Costanti.BIANCO);
        scacchiera.posizionaPezzo(re,4,4);
        re.calcolaMosse(scacchiera);
        assertEquals(re.getMossePossibili().size(),8);
    }
    
    public void testMosseReAmico(){
        Re re = new Re(Costanti.BIANCO);
        Re re2 = new Re(Costanti.BIANCO);
        scacchiera.posizionaPezzo(re,0,0);
        scacchiera.posizionaPezzo(re2,1,0);
        re.calcolaMosse(scacchiera);
        assertEquals(re.getMossePossibili().size(),2);
    }
    
    public void testMosseReNemico(){
        Re re = new Re(Costanti.BIANCO);
        Re re2 = new Re(Costanti.NERO);
        scacchiera.posizionaPezzo(re,0,0);
        scacchiera.posizionaPezzo(re2,1,0);
        re.calcolaMosse(scacchiera);
        assertEquals(re.getMossePossibili().size(),3);
    }
    
    public void testMosseReRidottePerSuicidio(){
        Re re = new Re(Costanti.BIANCO);
        Torre t = new Torre(Costanti.NERO);
        scacchiera.posizionaPezzo(re,0,0);
        scacchiera.posizionaPezzo(t,7,1);
        re.calcolaMosse(scacchiera);
        assertEquals(re.getMossePossibili().size(),1);
    }
    
    public void testMosseReRidottePerSuicidio2(){
        Re re = new Re(Costanti.BIANCO);
        Torre t = new Torre(Costanti.NERO);
        Torre t2 = new Torre(Costanti.NERO);
        scacchiera.posizionaPezzo(re,4,4);
        scacchiera.posizionaPezzo(t,7,5);
        scacchiera.posizionaPezzo(t2,7,3);
        re.calcolaMosse(scacchiera);
        assertEquals(re.getMossePossibili().size(),2);
    }
    
    
}
