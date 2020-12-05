package it.unibas.scacchi.modello;

import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.Applicazione;
import java.util.List;

public class Regina extends AbstractPezzo {
    
    //Costruttori

    
    
    public Regina() {
    }

    public Regina(String colore) {
        super(colore);
        if ( colore.equals(Costanti.BIANCO) ){
            this.setPercorsoImmagine(Costanti.REGINABIANCO);
        } else {
            this.setPercorsoImmagine(Costanti.REGINANERO);
        }
    }

    //Metodi Classe

    @Override
    public void calcolaMosse() {
        this.getMossePossibili().clear();
        Scacchiera s = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        calcolaMosse(s);
    }
    
    @Override
    public void calcolaMosse(Scacchiera scacchiera) {
        int x = this.getPosX();
        int y = this.getPosY();
        Alfiere a = new Alfiere(this.getColore());
        Torre t = new Torre(this.getColore());
        a.setPosX(x);
        a.setPosY(y);
        t.setPosX(x);
        t.setPosY(y);
        a.calcolaMosse(scacchiera);
        t.calcolaMosse(scacchiera);
        List<Mossa> mosse = this.getMossePossibili();
        mosse.addAll(t.getMossePossibili());
        mosse.addAll(a.getMossePossibili());
    }
    
    //Metodi Get e Set

    
}
