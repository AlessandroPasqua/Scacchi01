package it.unibas.scacchi.modello;

import it.unibas.scacchi.Applicazione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        Scacchiera scacchiera = (Scacchiera) Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        calcolaMosse(scacchiera);
    }

    @Override
    public void calcolaMosse(Scacchiera scacchiera) {
        if (this.getColore() == Costanti.NERO) {
            calcolaMossaNero(scacchiera);
        } else {
            calcolaMossaBianco(scacchiera);
        }
    }

    public void calcolaMossaNero(Scacchiera scacchiera) {
        Pezzo[][] matrice = scacchiera.getMatriceScacchiera();

        //prelevo le possibili caselle dove puo andare il pedone
        // verifico se non sono accupate da altri pezzi e aggiungo alla lista
        int x = super.getPosX();
        int y = super.getPosY();;

        int x1 = x + 1;
        int x2 = x + 2;

        //non faccio il controllo che esce fuori dalla matrice perche secondo alepa non ha senso.
        //poiche puo avanzare di 2 caselle sono alla prima mossa , e quando arriva in capo alla scacchiera , il pedone è in promozione
        Pezzo pezzoAvanti2 = matrice[x + 2][y];
        Pezzo pezzoAvanti1 = matrice[x + 1][y];
        log.debug("dove entri?");
        if (pezzoAvanti2 == null) {
            log.debug("fammi vedere se entri in pezzoAvanti2 == null");
            if (this.primaMossa) {
                log.debug("fammi vedere se entri in primaMossa == true");
                this.aggiungiMossa(new Mossa(x, y, x + 2, y));
            }
        }
        if (pezzoAvanti1 == null) {
            this.aggiungiMossa(new Mossa(x, y, x + 1, y));
        }

        // considero il caso in cui il pedone possa mangiare
        Pezzo pezzoAvanti11 = matrice[x + 1][y + 1];
        Pezzo pezzoAvanti12 = matrice[x + 1][y - 1];

        int y10 = y - 1;
        int y12 = y + 1;
        if (y10 < Costanti.N && y12 < Costanti.N) {

            if (pezzoAvanti11 != null && pezzoAvanti11.getColore() != this.getColore()) {
                log.debug("fammi vedere se entri in mangio a sinistra");
                this.aggiungiMossa(new Mossa(x, y, x + 1, y + 1));
            }

            if (pezzoAvanti12 != null && pezzoAvanti12.getColore() != this.getColore()) {
                log.debug("fammi vedere se entri in mangio a sinistra");
                this.aggiungiMossa(new Mossa(x, y, x + 1, y - 1));
            }
        }
    }

    public void calcolaMossaBianco(Scacchiera scacchiera) {

    }

    //Metodi Get e Set
    public boolean isPrimaMossa() {
        return primaMossa;
    }
}
