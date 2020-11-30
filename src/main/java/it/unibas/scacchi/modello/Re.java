package it.unibas.scacchi.modello;

import it.unibas.scacchi.Applicazione;
import java.util.ArrayList;
import java.util.List;

public class Re extends AbstractPezzo{

    //Costruttori
    
    public Re(String colore) {
        super(colore);
    }
    
    //Metodi Classe

    @Override
    public void calcolaMosse() {
        this.getMossePossibili().clear();
        Scacchiera s = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        calcolaMosse(s);
    }
    
    //Con il for scansiono le caselle intorno al re che vanno formando un quadrato , e infine
    //Chiamo il metodo eliminaMosseSuicidio per eliminare Mosse del re dove andrebbe a suicidarsi ( Provocare uno scacco)
    @Override
    public void calcolaMosse(Scacchiera scacchiera) {
        int prevX = this.getPosX();
        int prevY = this.getPosY();
        int tmpx;
        int tmpy;
        Pezzo p ;
        for ( int i = -1 ; i <= 1 ; i++ ){
            for ( int j = -1 ; j <= 1 ; j++ ){
                if ( !(i == 0 && j== 0) ){
                    tmpx = prevX + i;
                    tmpy = prevY + j;
                    if ( tmpx >= 0 && tmpx < Costanti.N && tmpy >= 0 && tmpy < Costanti.N){
                        p = scacchiera.getPezzo(tmpx, tmpy);
                        if ( p == null ){
                            this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                        } else {
                            if ( !this.isStessoColore(p) ){
                                this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                            }
                        }   
                    }
                }
            }
        }
        eliminaMosseSuicidio(scacchiera);
    }
    
    //Metodo che Verifica le mosse avversarie e cerca se in quelle esiste una casella interessata ad un
    //Movimento del re , se trovata inserita in una lista e quest'ultima eliminata dalla lista delle mosse del re
    //Approccio con la lista preferito al remove nel for poichè lanciava eccezione su modifica concorrente
    private void eliminaMosseSuicidio(Scacchiera s){
        List<Mossa> mosse = s.getMosseTotaliAvversario(this.getColore());
        List<Mossa> mosseSuicide = new ArrayList<Mossa>();
        log.debug("La lista delle mosse avversarie e' di lunghezza " + mosse.size());
        for ( Mossa m : this.getMossePossibili() ){
            log.debug("Sto controllando la mossa " + m.getSuccX() + " : " + m.getSuccY() );
            if ( mosse.contains(m) ){
                log.debug("Ho trovato una mossa che il team avversario potrebbe mettermi sotto scacco!");
                mosseSuicide.add(m);
            }
        }  
        this.getMossePossibili().removeAll(mosseSuicide);
    }
    
    //Metodi Get e Set

}
