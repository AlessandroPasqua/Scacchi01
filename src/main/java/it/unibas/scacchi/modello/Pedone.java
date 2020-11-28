package it.unibas.scacchi.modello;

public class Pedone extends AbstractPezzo{
    
    private boolean primaMossa ;
    
   // Costruttori
    
    public Pedone(String colore, boolean primaMossa) {
        super(colore);
        this.primaMossa = primaMossa ;
    }
    
    //Metodi Classe

    @Override
    public void reNelleMieMosse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calcolaMosse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calcolaMosse(Scacchiera scacchiera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Metodi Get e Set
    
    public boolean isPrimaMossa() {
        return primaMossa;
    }
}
