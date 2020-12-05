package it.unibas.scacchi.controllo;

import it.unibas.scacchi.Applicazione;
import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.modello.Scacchiera;
import it.unibas.scacchi.persistenza.DAOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Level;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloMenu {
    private final Logger logger = LoggerFactory.getLogger(ControlloMenu.class);
    private final Action azioneSalva = new AzioneSalva();
    private final Action azioneCarica = new AzioneCarica();
    private final Action azioneEsci = new AzioneEsci();

    public Action getAzioneSalva() {
        return azioneSalva;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    private class AzioneSalva extends AbstractAction {

        public AzioneSalva() {
            this.putValue(NAME, "Salva");
            this.putValue(SHORT_DESCRIPTION, "Salva la partita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                Scacchiera scacchieraAttuale = (Scacchiera) Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
                Applicazione.getInstance().getDao().salva(scacchieraAttuale, "./Scacchiera.json");
                Applicazione.getInstance().getFrame().mostraMessaggio("Partita salvata");
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nel salvataggio della partita" + ex.getMessage());
            }
        }

    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica la partita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            File fileSelezionato = new File("./Scacchiera.json");
            logger.debug("file selezionato" + fileSelezionato);
            Applicazione.getInstance().getFrame().mostraCursoreCaricamento();
            WorkerCaricaScacchiera worker = new WorkerCaricaScacchiera(fileSelezionato);
            worker.execute(); 
        }

    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }
}
