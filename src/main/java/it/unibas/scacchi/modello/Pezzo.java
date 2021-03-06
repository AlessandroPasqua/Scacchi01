package it.unibas.scacchi.modello;

import java.util.List;


public interface Pezzo {
    
    
    
    public void cambiaPosizione(int x , int y );
    
    public boolean reNelleMieMosse();
    
    public boolean reNelleMieMosse(Scacchiera s);

    public void calcolaMosse();
    
    public void calcolaMosse( Scacchiera scacchiera );
    
    public boolean isStessoColore(Pezzo p);
    
    public Mossa cercaMossa(int x , int y);
            
    public int getPosX();
    
    public int getPosY();
    //Metodi Get e Set 
    
    
    public String getColore();
    
    public List<Mossa> getMossePossibili();
    
    public void setPosX(int posX);
            
    public void setPosY(int posY);
    
    public String getPercorsoImmagine();
    
}
