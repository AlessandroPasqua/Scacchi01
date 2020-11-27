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
    
    public List<Mossa> filtraListaFuoriScacchiera(){
        for (Mossa mossa : this.mossePossibili) {
            if(mossa.getSuccX() > 7 || mossa.getSuccX() < 0){
                this.mossePossibili.remove(mossa);
            }
            if(mossa.getSuccY() > 7 || mossa.getSuccY() < 0){
                this.mossePossibili.remove(mossa);
            }
        }
        return mossePossibili;
    }
    
    public void cambiaPosizione(int x , int y ){
        this.posX = x;
        this.posY = y;
    }
    
    public abstract void reNelleMieMosse();

    public abstract void calcolaMosse();
    
    public boolean isStessoColore(Pezzo p){
        return p.getColore().equals(this.colore);
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
    
    public void addMossa(Mossa m) {
        this.mossePossibili.add(m);
    }
}
