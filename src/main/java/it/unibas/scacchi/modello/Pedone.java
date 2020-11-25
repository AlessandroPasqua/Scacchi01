package it.unibas.scacchi.modello;

public class Pedone extends AbstractPezzo{
    
    private boolean primaMossa ;
    
    public Pedone(boolean kill, String colore, boolean primaMossa) {
        super(kill, colore);
        this.primaMossa = primaMossa ;
    }

    public boolean isPrimaMossa() {
        return primaMossa;
    }    

    @Override
    public void mangiare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reNelleMieMosse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calcolaMosse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eseguiAzione() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
