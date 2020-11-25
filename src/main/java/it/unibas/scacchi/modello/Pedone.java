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

    @Override
    public void mangiare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
