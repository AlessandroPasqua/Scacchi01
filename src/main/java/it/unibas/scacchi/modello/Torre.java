package it.unibas.scacchi.modello;

import it.unibas.scacchi.Applicazione;

public class Torre extends AbstractPezzo {

    //Costruttori
    
    public Torre(String colore) {
        super(colore);
    }

    //Metodi Classe
    
    //Movimento di una torre è possibile in un incremento/decremento della sola x o incremento/decremento della sola y
    @Override
    public void calcolaMosse() {
        this.getMossePossibili().clear();
        Scacchiera scacchiera = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        calcolaMosse(scacchiera);
    }
    
    
    @Override
    public void calcolaMosse(Scacchiera scacchiera) {
        int prevX = this.getPosX();
        int prevY = this.getPosY();
        Pezzo p ;
        for ( int i = prevX+1 ; i < Costanti.N ; i++ ){
            p = scacchiera.getPezzo(i, prevY );
            if ( p == null ){
                this.aggiungiMossa(new Mossa(prevX,prevY,i,prevY));
                log.debug("Casella vuota , aggiungo alla lista");
            } else {
                if ( !this.isStessoColore(p) ){
                    this.aggiungiMossa(new Mossa(prevX,prevY,i,prevY));
                    log.debug("Posso mangiare il nemico!");
                }
                break;
            }
        }
        for ( int i = prevX-1 ; i >= 0 ; i-- ){
            p = scacchiera.getPezzo(i, prevY );
            if ( p == null ){
                this.aggiungiMossa(new Mossa(prevX,prevY,i,prevY));
                log.debug("Casella vuota , aggiungo alla lista");
            } else {
                if ( !this.isStessoColore(p) ){
                    this.aggiungiMossa(new Mossa(prevX,prevY,i,prevY));
                    log.debug("Posso mangiare il nemico!");
                }
                break;
            }
        }
        for ( int i = prevY+1 ; i < Costanti.N ; i++ ){
            p = scacchiera.getPezzo(prevX, i );
            if ( p == null ){
                this.aggiungiMossa(new Mossa(prevX,prevY,prevX,i));
                log.debug("Casella vuota , aggiungo alla lista");
            } else {
                if ( !this.isStessoColore(p) ){
                    this.aggiungiMossa(new Mossa(prevX,prevY,prevX,i));
                    log.debug("Posso mangiare il nemico!");
                }
                break;
            }
        }
        for ( int i = prevY-1 ; i >= 0 ; i-- ){
            p = scacchiera.getPezzo(prevX, i );
            if ( p == null ){
                this.aggiungiMossa(new Mossa(prevX,prevY,prevX,i));
                log.debug("Casella vuota , aggiungo alla lista");
            } else {
                if ( !this.isStessoColore(p) ){
                    this.aggiungiMossa(new Mossa(prevX,prevY,prevX,i));
                    log.debug("Posso mangiare il nemico!");
                }
                break;
            }
        }
    }
    
    //Metodi Get e Set

    
}
