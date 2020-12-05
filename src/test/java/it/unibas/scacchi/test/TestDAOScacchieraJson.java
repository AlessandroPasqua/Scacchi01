
package it.unibas.scacchi.test;

import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.modello.Mossa;
import it.unibas.scacchi.modello.Pezzo;
import it.unibas.scacchi.modello.Scacchiera;
import it.unibas.scacchi.persistenza.DAOException;
import it.unibas.scacchi.persistenza.DAOScacchieraJson;
import it.unibas.scacchi.persistenza.IDAOScacchiera;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDAOScacchieraJson extends TestCase{
    private Logger logger = LoggerFactory.getLogger(TestDAOScacchieraJson.class);
    private Scacchiera scacchiera = new Scacchiera();
    private IDAOScacchiera dao = new DAOScacchieraJson();
    
    public void testSalvaScacchiera() {
        scacchiera.setScacchieraIniziale();
        try {
            dao.salva(scacchiera, "./Scacchiera.json");
            logger.debug("Scacchiera salvata con successo!");
        } catch (DAOException ex) {
           logger.debug("Errore nel salvataggio del file!" + ex.getMessage());
           fail();
        }
    }
    
    public void testCaricaScacchiera() {
        try {
            Scacchiera scacchiera = dao.carica("./Scacchiera.json");
            logger.debug("Scacchiera caricata con successo");
            assertNotNull(scacchiera);
        } catch (DAOException ex) {
            logger.debug("Errore nel caricamento della scacchiera" + ex.getMessage());
            fail();
        }
    }
    
    
    public void testModificaSalvaECaricaScacchiera() {
        try {
            Scacchiera scacchiera = dao.carica("./Scacchiera.json");
            Pezzo pedoneNero1 = scacchiera.getPezzo(1, 0);
            Pezzo pedoneNero2 = scacchiera.getPezzo(1, 1);
            Pezzo pedoneNero3 = scacchiera.getPezzo(1, 2);
            Pezzo pedoneNero4 = scacchiera.getPezzo(1, 4);
            Pezzo pedoneNero5 = scacchiera.getPezzo(1, 5);
            
            Pezzo pedoneBianco1 = scacchiera.getPezzo(6, 1);
            Pezzo pedoneBianco2 = scacchiera.getPezzo(6, 2);
            Pezzo pedoneBianco3 = scacchiera.getPezzo(6, 3);
            Pezzo pedoneBianco4 = scacchiera.getPezzo(6, 4);
            Pezzo pedoneBianco5 = scacchiera.getPezzo(6, 5);
            
            scacchiera.movimentoPezzo(pedoneNero1, new Mossa(1, 0, 2, 0));
            scacchiera.movimentoPezzo(pedoneNero2, new Mossa(1, 1, 2, 1));
            scacchiera.movimentoPezzo(pedoneNero3, new Mossa(1, 2, 2, 2));
            scacchiera.movimentoPezzo(pedoneNero4, new Mossa(1, 4, 2, 4));
            scacchiera.movimentoPezzo(pedoneNero5, new Mossa(1, 5, 2, 5));
            
            scacchiera.movimentoPezzo(pedoneBianco1, new Mossa(6, 1, 5, 1));
            scacchiera.movimentoPezzo(pedoneBianco2, new Mossa(6, 2, 5, 2));
            scacchiera.movimentoPezzo(pedoneBianco3, new Mossa(6, 3, 5, 3));
            scacchiera.movimentoPezzo(pedoneBianco4, new Mossa(6, 4, 5, 4));
            scacchiera.movimentoPezzo(pedoneBianco5, new Mossa(6, 5, 5, 5));
            dao.salva(scacchiera, "./Scacchiera.json");
            Scacchiera scacchieraDopo = dao.carica("./Scacchiera.json");
            assertEquals(scacchieraDopo.getPezzo(2, 1).getColore(), Costanti.NERO);
        } catch (DAOException ex) {
            logger.debug("Errore nel caricamento della scacchiera" + ex.getMessage());
            fail();
        }
    }
  
}
