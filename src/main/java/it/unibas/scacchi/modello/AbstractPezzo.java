package it.unibas.scacchi.modello;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPezzo implements Pezzo{
    
    private List<Mossa> mossePossibili = new ArrayList<Mossa>();
    private String colore ;
    private int posX;
    private int posY;

    //Costruttori
      
    public AbstractPezzo(String colore) {
        this.colore = colore;
    }
    
    //Metodi Di ogni Pezzo
    
    public void cambiaPosizione(int x , int y ){
        this.posX = x;
        this.posY = y;
    }
    
    public abstract void reNelleMieMosse();

    public abstract void calcolaMosse();
    
    public abstract void calcolaMosse( Scacchiera scacchiera );
    
    public boolean isStessoColore(Pezzo p){
        return p.getColore().equals(this.colore);
    }
    
    public void aggiungiMossa(Mossa m){
        this.mossePossibili.add(m);
    }
    
    //Metodi Get e Set
   
    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public List<Mossa> getMossePossibili() {
        return mossePossibili;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
    
}
