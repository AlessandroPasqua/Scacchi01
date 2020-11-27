package it.unibas.scacchi.modello;

import java.util.List;


public interface Pezzo {
    
    public void cambiaPosizione(int x , int y );
    
    public void reNelleMieMosse();

    public void calcolaMosse();
    
    public boolean isStessoColore(Pezzo p);
    
    //Metodi Get e Set 
    
    public String getColore();
    
    public List<Mossa> getMossePossibili();
    
}
