package it.unibas.scacchi.modello;

import it.unibas.scacchi.Applicazione;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPezzo implements Pezzo{
    
    static Logger log = LoggerFactory.getLogger(Cavallo.class);
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

    public abstract void calcolaMosse();
    
    public abstract void calcolaMosse( Scacchiera scacchiera );
    
    public boolean reNelleMieMosse() {
        Scacchiera s = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        Pezzo p;
        for ( Mossa m : this.getMossePossibili() ){
            p = s.getPezzo(m.getSuccX(), m.getSuccY() );
            if ( p != null && p instanceof Re ){
                return true;
            }
        }
        return false;
    }
    
    public boolean reNelleMieMosse(Scacchiera s) {
        Pezzo p;
        for ( Mossa m : this.getMossePossibili() ){
            p = s.getPezzo(m.getSuccX(), m.getSuccY() );
            if ( p != null && p instanceof Re ){
                return true;
            }
        }
        return false;
    }
    
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
    
    
    
    public void addMossa(Mossa m) {
        this.mossePossibili.add(m);
    }
}
