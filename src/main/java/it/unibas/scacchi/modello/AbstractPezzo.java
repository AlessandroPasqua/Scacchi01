package it.unibas.scacchi.modello;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPezzo implements Pezzo{
    
    private List<Mossa> mossePossibili = new ArrayList<Mossa>();
    private String colore ;
    private int posX;
    private int posY;

    public AbstractPezzo(String colore) {
        this.colore = colore;
    }
    
    //Metodi Di ogni Pezzo
    
    @Override
    public abstract void mangiare();
    
    public abstract void reNelleMieMosse();

    public abstract void calcolaMosse();
    
    public abstract void eseguiAzione();
    
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
    
    public void cambiaPosizione(int x , int y ){
        this.posX = x;
        this.posY = y;
    }


    
}
