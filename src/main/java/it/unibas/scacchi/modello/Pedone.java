package it.unibas.scacchi.modello;

import it.unibas.scacchi.Applicazione;

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
        this.getMossePossibili().clear();
        Scacchiera scacchiera = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        calcolaMosse(scacchiera);   
    }

    @Override
    public void calcolaMosse(Scacchiera scacchiera) {
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
    
    //Metodi Get e Set
    public boolean isPrimaMossa() {
        return primaMossa;
    }
}
