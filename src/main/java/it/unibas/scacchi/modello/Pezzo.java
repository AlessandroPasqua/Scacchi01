package it.unibas.scacchi.modello;

import java.util.List;


public interface Pezzo {
    
    public void cambiaPosizione(int x , int y );
    
    public void reNelleMieMosse();

    public void calcolaMosse();
    
    public void calcolaMosse( Scacchiera scacchiera );
    
    public boolean isStessoColore(Pezzo p);
    
    //Metodi Get e Set 
    
    public String getColore();
    
    public List<Mossa> getMossePossibili();
    
    public void setPosX(int posX);
            
    public void setPosY(int posY);
    
}
