package it.unibas.scacchi.modello;

import it.unibas.scacchi.Costanti;
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
        //prelevo le possibili caselle dove puo andare il pedone
        // verifico se non sono accupate da altri pezzi e aggiungo alla lista
        int x = super.getPosX();
        int y = super.getPosY();
        //non faccio il controllo che esce fuori dalla matrice perche secondo alepa non ha senso.
        //poiche puo avanzare di 2 caselle sono alla prima mossa , e quando arriva in capo alla scacchiera , il pedone è in promozione
        Pezzo pezzoAvanti2 = scacchiera.getPezzo(x+2,y);
        Pezzo pezzoAvanti1 = scacchiera.getPezzo(x+1,y);
        
        if (pezzoAvanti1 == null) {
            if ( this.primaMossa && pezzoAvanti2==null ) {
                this.aggiungiMossa(new Mossa(x, y, x + 2, y));
            }
            this.aggiungiMossa(new Mossa(x, y, x + 1, y));
        }
        

        // considero il caso in cui il pedone possa mangiare

        //Caso in cui diminuisco la y , da verificare che sia maggiore di 0
        if ( (y-1) >= 0 ) {
            Pezzo pezzoAvanti12 = scacchiera.getPezzo(x+1, y-1);

            if (pezzoAvanti12 != null && pezzoAvanti12.getColore() != this.getColore()) {
                log.debug("fammi vedere se entri in mangio a sinistra");
                this.aggiungiMossa(new Mossa(x, y, x + 1, y - 1));
            }
        }
        //Caso in cui aumento y , da verificare che sia minore di N
        if ( (y+1) < Costanti.N) {
            Pezzo pezzoAvanti11 = scacchiera.getPezzo(x+1,y+1);
            if (pezzoAvanti11 != null && pezzoAvanti11.getColore() != this.getColore()) {
                log.debug("fammi vedere se entri in mangio a sinistra");
                this.aggiungiMossa(new Mossa(x, y, x + 1, y + 1));
            }
        }
    }

    public void calcolaMossaBianco(Scacchiera scacchiera) {
        //prelevo le possibili caselle dove puo andare il pedone
        // verifico se non sono accupate da altri pezzi e aggiungo alla lista
        int x = super.getPosX();
        int y = super.getPosY();;
        //non faccio il controllo che esce fuori dalla matrice perche secondo alepa non ha senso.
        //poiche puo avanzare di 2 caselle sono alla prima mossa , e quando arriva in capo alla scacchiera , il pedone è in promozione
        Pezzo pezzoAvanti2 = scacchiera.getPezzo(x - 2,y);
        Pezzo pezzoAvanti1 = scacchiera.getPezzo(x - 1,y);
        
        if ( pezzoAvanti1 == null) {
            if (this.primaMossa && pezzoAvanti2 == null ) {
                this.aggiungiMossa(new Mossa(x, y, x - 2, y));
            }
            this.aggiungiMossa(new Mossa(x, y, x - 1, y));
        }
        
        // considero il caso in cui il pedone possa mangiare
        //Caso in cui diminuisco la y , da verificare che sia maggiore di 0
        if ( (y-1) >= 0 ) {
            Pezzo pezzoAvanti12 = scacchiera.getPezzo(x-1, y-1);
            if (pezzoAvanti12 != null && pezzoAvanti12.getColore() != this.getColore()) {
                log.debug("fammi vedere se entri in mangio a sinistra");
                this.aggiungiMossa(new Mossa(x, y, x - 1, y - 1));
            }
        }
        //Caso in cui aumento y , da verificare che sia minore di N
        if ( (y+1) < Costanti.N) {
            Pezzo pezzoAvanti11 = scacchiera.getPezzo(x-1,y+1);
            if (pezzoAvanti11 != null && pezzoAvanti11.getColore() != this.getColore()) {
                log.debug("fammi vedere se entri in mangio a sinistra");
                this.aggiungiMossa(new Mossa(x, y, x - 1, y + 1));
            }
        }
    }

    //Metodi Get e Set
    
    public boolean isPrimaMossa() {
        return primaMossa;
    }

    public void setPrimaMossa(boolean primaMossa) {
        this.primaMossa = primaMossa;
    }
    
    
    
    
}
