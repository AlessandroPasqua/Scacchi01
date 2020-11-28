package it.unibas.scacchi.modello;

import it.unibas.scacchi.Applicazione;

public class Cavallo extends AbstractPezzo {

    //Costruttori
    
    public Cavallo(String colore) {
        super(colore);
    }

    //Metodi Classe

    //Metodo che calcola le Mosse del cavallo , crea oggetti mossa e li aggiunge ad una lista di mosse
    // Possibili Movimenti del Cavallo x + 2 e y + 1 , y + 2 e x  + 1 , corrispettivi con il meno
    @Override
    public void calcolaMosse() {
        this.getMossePossibili().clear();
        //Temporale , dobbiamo valutare la possibilità di mettere un collegamento pezzo astratto scacchiera
        Scacchiera scacchiera = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        int x = this.getPosX();
        int y = this.getPosY();
        if ( (x + 2) < Costanti.N && (y + 1) < Costanti.N && (scacchiera.getPezzo(x+2,y+1)== null || !this.isStessoColore(scacchiera.getPezzo(x+2,y+1))) ){
            this.aggiungiMossa(new Mossa(x,y,x+2,y+1));
        }
        if ( (y + 2) < Costanti.N && (x + 1) < Costanti.N && (scacchiera.getPezzo(x+1,y+2)== null || !this.isStessoColore(scacchiera.getPezzo(x+1,y+2))) ){
            this.aggiungiMossa(new Mossa(x,y,x+1,y+2));
        }
       if ( (y - 2) >= 0 && (x - 1) >= 0 && (scacchiera.getPezzo(x-1,y-2)== null || !this.isStessoColore(scacchiera.getPezzo(x-1,y-2))) ){
            this.aggiungiMossa(new Mossa(x,y,x-1,y-2));
        }
        if ( ( x - 2) >= 0 && (y - 1) >= 0 && (scacchiera.getPezzo(x-2,y-1)== null || !this.isStessoColore(scacchiera.getPezzo(x-2,y-1)) )){
            this.aggiungiMossa(new Mossa(x,y,x-2,y-1));
        }
    }
    
    //Metodo creato per Testare La funzionalità del sottoprogramma , ma possibile candidato a sostituire il precedente
    @Override
    public void calcolaMosse( Scacchiera scacchiera) {
        this.getMossePossibili().clear();
        int x = this.getPosX();
        int y = this.getPosY();
        if ( (x + 2) < Costanti.N && (y + 1) < Costanti.N && (scacchiera.getPezzo(x+2,y+1)== null || !this.isStessoColore(scacchiera.getPezzo(x+2,y+1))) ){
            this.aggiungiMossa(new Mossa(x,y,x+2,y+1));
            log.debug("Aggiunto mossa +2 +1");
        }
        if ( (y + 2) < Costanti.N && (x + 1) < Costanti.N && (scacchiera.getPezzo(x+1,y+2)== null || !this.isStessoColore(scacchiera.getPezzo(x+1,y+2))) ){
            this.aggiungiMossa(new Mossa(x,y,x+1,y+2));
            log.debug("Aggiunto mossa +1 +2");
        }
        if ( (y - 2) >= 0 && (x - 1) >= 0 && (scacchiera.getPezzo(x-1,y-2)== null || !this.isStessoColore(scacchiera.getPezzo(x-1,y-2))) ){
            this.aggiungiMossa(new Mossa(x,y,x-1,y-2));
            log.debug("Aggiunto mossa -1 -2");
        }
        if ( ( x - 2) >= 0 && (y - 1) >= 0 && (scacchiera.getPezzo(x-2,y-1)== null || !this.isStessoColore(scacchiera.getPezzo(x-2,y-1)) )){
            this.aggiungiMossa(new Mossa(x,y,x-2,y-1));
            log.debug("Aggiunto mossa -2 -1");
        }
    }

    //Metodi Get e Set
    
}
