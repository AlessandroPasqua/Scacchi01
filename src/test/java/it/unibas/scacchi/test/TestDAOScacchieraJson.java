
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
            Pezzo torreNera = scacchiera.getPezzo(0, 0);
            scacchiera.movimentoPezzo(torreNera, new Mossa(0, 0, 4, 4));
            dao.salva(scacchiera, "./Scacchiera.json");
            Scacchiera scacchieraDopo = dao.carica("./Scacchiera.json");
            assertEquals(scacchieraDopo.getPezzo(4, 4).getColore(), Costanti.NERO);
        } catch (DAOException ex) {
            logger.debug("Errore nel caricamento della scacchiera" + ex.getMessage());
            fail();
        }
    }
  
}
