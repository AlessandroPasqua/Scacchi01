package it.unibas.scacchi.modello;

public class Pedone extends AbstractPezzo {

    private boolean primaMossa;

    // Costruttori
    public Pedone(String colore, boolean primaMossa) {
        super(colore);
        this.primaMossa = primaMossa;
    }

    //Metodi Classe

    @Override
    public void calcolaMosse() {
        Scacchiera scacchiera = new Scacchiera();
        Pezzo[][] matrice = scacchiera.getMatriceScacchiera();

        //prelevo le possibili caselle dove puo andare il pedone
        // verifico se non sono accupate da altri pezzi e aggiungo alla lista
        int x = super.getPosX();
        int y = super.getPosY();;

        Pezzo pezzoAvanti2 = matrice[x + 2][y];
        Pezzo pezzoAvanti1 = matrice[x + 1][y];
        if (pezzoAvanti1 == null || pezzoAvanti2 == null) {
            if (this.primaMossa) {
                super.addMossa(new Mossa(x, y, x + 2, y));
            }
            super.addMossa(new Mossa(x, y, x + 1, y));
        }

        // considero il caso in cui il pedone possa mangiare
        Pezzo pezzoAvanti11 = matrice[x + 1][y+1];
        Pezzo pezzoAvanti12 = matrice[x + 1][y-1];
        
        if (pezzoAvanti11 != null && pezzoAvanti11.getColore() != this.getColore()) {
            super.addMossa(new Mossa(x, y, x + 1, y+1));
        }
        
        if (pezzoAvanti12 == null && pezzoAvanti12.getColore() != this.getColore()) {
            super.addMossa(new Mossa(x, y, x + 1, y-1));
        }
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
