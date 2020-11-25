package it.unibas.scacchi;

import javax.swing.SwingUtilities;

public class Applicazione {
    
    private static Applicazione singleton = new Applicazione() ;
    
    public static Applicazione getInstance() {
        return singleton ;
    }
    
    public void inizializza() {
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }
}
