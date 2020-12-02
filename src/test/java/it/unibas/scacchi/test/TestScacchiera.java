package it.unibas.scacchi.test;

import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.modello.Re;
import it.unibas.scacchi.modello.Scacchiera;
import it.unibas.scacchi.modello.Torre;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestScacchiera extends TestCase {

    private Scacchiera scacchiera;
    static Logger log = LoggerFactory.getLogger(TestScacchiera.class);

    public void setUp() {
        scacchiera = new Scacchiera();
    }

    public void testScaccoNormale() {
        Re re = new Re(Costanti.BIANCO);
        scacchiera.posizionaPezzo(re, 4, 4);
        Torre t = new Torre(Costanti.NERO);
        scacchiera.posizionaPezzo(t, 4, 0);
        assertTrue(scacchiera.verificaScacco(re.getColore()));
    }

    public void testScaccoFalso() {
        Re re = new Re(Costanti.BIANCO);
        scacchiera.posizionaPezzo(re, 4, 4);
        Torre t = new Torre(Costanti.BIANCO);
        scacchiera.posizionaPezzo(t, 4, 0);
        assertTrue(!scacchiera.verificaScacco(re.getColore()));
    }

    public void testScaccoMatto() {
        Re re = new Re(Costanti.BIANCO);
        scacchiera.posizionaPezzo(re, 4, 4);
        Torre t1 = new Torre(Costanti.NERO);
        Torre t2 = new Torre(Costanti.NERO);
        Torre t3 = new Torre(Costanti.NERO);
        scacchiera.posizionaPezzo(t1, 4, 0);
        scacchiera.posizionaPezzo(t2, 5, 0);
        scacchiera.posizionaPezzo(t3, 6, 0);
        assertTrue(scacchiera.verificaScacco(re.getColore()));
        assertTrue(scacchiera.verificaScaccoMatto(re.getColore()));
    }

}
