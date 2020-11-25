package it.unibas.scacchi.modello;

public abstract class AbstractPezzo implements Pezzo{
    
    private String colore ;

    public AbstractPezzo(String colore) {
        this.colore = colore;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    @Override
    public abstract void mangiare();
    
    public abstract void reNelleMieMosse();

    public abstract void calcolaMosse();
    
    public abstract void eseguiAzione();
    
}
