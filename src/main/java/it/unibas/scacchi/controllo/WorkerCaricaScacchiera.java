package it.unibas.scacchi.controllo;

import it.unibas.scacchi.Applicazione;
import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.modello.Scacchiera;
import it.unibas.scacchi.persistenza.DAOException;
import java.io.File;
import javax.swing.SwingWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerCaricaScacchiera extends SwingWorker {

    private File fileDaCaricare;
    private Logger logger = LoggerFactory.getLogger(WorkerCaricaScacchiera.class);

    public WorkerCaricaScacchiera(File fileDaCaricare) {
        this.fileDaCaricare = fileDaCaricare;
    }

    @Override
    protected Object doInBackground() throws Exception {
        String stringaFile = fileDaCaricare.toString();
        logger.debug("LA stringa del file da caricare e'" + stringaFile);
        try {
            Scacchiera scacchiera = Applicazione.getInstance().getDao().carica(stringaFile);
            logger.debug("Scacchiera caricata");
            return scacchiera;
        } catch (DAOException ex) {
            logger.error("Eccezione durante il caricamento" + ex.getMessage());
            return null;
        }
    }

    @Override
    protected void done() {
        try {
            Scacchiera scacchiera = (Scacchiera) this.get();
            if (scacchiera == null) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Nessuna partita in sospeso trovata");
                Applicazione.getInstance().getFrame().nascondiCursoreCaricamento();
                return;
            }
            Applicazione.getInstance().getModello().insertBean(Costanti.SCACCHIERA, scacchiera);
            Applicazione.getInstance().getVistaPrincipale().aggiornaScacchiera();
            if ( scacchiera.isTurnoBianco() ){
                Applicazione.getInstance().getVistaPrincipale().getColoreTurno().setText("Bianco");
            } else {
                Applicazione.getInstance().getVistaPrincipale().getColoreTurno().setText("Nero");
            }
            Applicazione.getInstance().getFrame().mostraMessaggio("Caricata la partita precedente");
            
            
        } catch (Exception ex) {
            logger.debug(ex.getMessage());
            Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare la partita");
        } finally {
            Applicazione.getInstance().getFrame().nascondiCursoreCaricamento();
        }
    }

}
