package it.unibas.scacchi;

import it.unibas.scacchi.controllo.ControlloMenu;
import it.unibas.scacchi.controllo.ControlloPrincipale;
import it.unibas.scacchi.modello.Gioco;
import it.unibas.scacchi.modello.Modello;
import it.unibas.scacchi.vista.Frame;
import it.unibas.scacchi.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloPrincipale controlloPrincipale;
    private ControlloMenu controlloMenu;
    private Modello modello;
    private ResourceManager resourceManager;

    public static Applicazione getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

    public void inizializza() {
        frame = new Frame();
        vistaPrincipale = new VistaPrincipale();
        controlloPrincipale = new ControlloPrincipale();
        controlloMenu = new ControlloMenu();
        modello = new Modello();
        resourceManager = new ResourceManager();
        vistaPrincipale.inizializza();
        frame.inizializza();
        
        //String s = frame.inserisciNomePlayer();
        //Gioco g = new Gioco( String s );
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public Modello getModello() {
        return modello;
}

    public ResourceManager getResourceManager() {
        return resourceManager;
    }
    
}
