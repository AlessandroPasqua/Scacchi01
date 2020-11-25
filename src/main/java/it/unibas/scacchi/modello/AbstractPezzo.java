package it.unibas.scacchi.modello;

public abstract class AbstractPezzo implements Pezzo{
    
    private boolean kill ;
    private String colore ;

    public AbstractPezzo(boolean kill, String colore) {
        this.kill = kill;
        this.colore = colore;
    }

    public boolean isKill() {
        return kill;
    }

    public void setKill(boolean kill) {
        this.kill = kill;
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
