package it.unibas.scacchi.modello;

public class Pedone extends AbstractPezzo{
    
    private boolean primaMossa ;
    
    public Pedone(String colore, boolean primaMossa) {
        super(colore);
        this.primaMossa = primaMossa ;
    }

    public boolean isPrimaMossa() {
        return primaMossa;
    }
}
