package it.unibas.scacchi.modello;

import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.Applicazione;

public class Alfiere extends AbstractPezzo {
    
    //Costruttori

    public Alfiere(String colore) {
        super(colore);
    }

    //Metodi Classe

    //Calcolo le mosse dell'alfiere facendo variare in primis la x in positivo e in negativo , e richiamo due metodi che facciano
    //Variare l'altra coordinata y sia in positivo che negativo
    @Override
    public void calcolaMosse() {
        this.getMossePossibili().clear();
        Scacchiera scacchiera = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        calcolaMosse(scacchiera);   
    }
    
    //Stesso metodo di prima ma con scacchiera passata come argomento
    @Override
    public void calcolaMosse(Scacchiera scacchiera) {
        int prevX = this.getPosX();//1
        int prevY = this.getPosY();//1
        int tmpx;
        int tmpy;
        Pezzo p;
        for ( int i = 1 ; i < Costanti.N ; i++ ){ 
            tmpx = prevX + i;//2
            tmpy = prevY + i;//2
            if ( tmpx < Costanti.N && tmpy < Costanti.N ){
                p = scacchiera.getPezzo(tmpx, tmpy );
                if ( p == null ){
                    this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                } else {
                    if ( !this.isStessoColore(p) ){
                        this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                    }
                    break;
                }
            }else{
                break;
            }
        }

        for ( int j = 1 ; j < Costanti.N ; j++ ){
            tmpx = prevX - j;
            tmpy = prevY - j;
            if ( tmpx >= 0 && tmpy >= 0 ){
                p = scacchiera.getPezzo(tmpx, tmpy );
                if ( p == null ){
                    this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                } else {
                    if ( !this.isStessoColore(p) ){
                        this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                    }
                    break;
                }
            }else{
                break;
            }
        }
        
        for ( int k = 1 ; k < Costanti.N ; k++ ){
            tmpx = prevX + k;
            tmpy = prevY - k;
            if ( tmpx < Costanti.N && tmpy >= 0 ){
                p = scacchiera.getPezzo(tmpx, tmpy );
                if ( p == null ){
                    this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                } else {
                    if ( !this.isStessoColore(p) ){
                        this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                    }
                    break;
                }
            }else{
                break;
            }
        }
        
        for ( int z = 1 ; z < Costanti.N ; z++ ){
            tmpx = prevX - z;
            tmpy = prevY + z;
            if ( tmpx >= 0 && tmpy < Costanti.N ){
                p = scacchiera.getPezzo(tmpx, tmpy );
                if ( p == null ){
                    this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                } else {
                    if ( !this.isStessoColore(p) ){
                        this.aggiungiMossa(new Mossa(prevX,prevY,tmpx,tmpy));
                    }
                    break;
                }
            }else{
                break;
            }
        }
        
    }
    
    //Calcola Le mosse Possibili Fissando una variabile e facendone variare solo una in positivo
    //Usato per rendere Codice più leggibile e non mettere 90 for uno dentro l'altro
   /* public void aumentaVariabile ( int variabile , int fisso ,Scacchiera s){
        Pezzo p;
        for ( int k = variabile+1 ; k < Costanti.N ; k++ ){
            p = s.getPezzo(fisso, k);
            if ( p == null ){
                this.aggiungiMossa(new Mossa(this.getPosX(),this.getPosY(),fisso,k));
            } else {
                if ( !this.isStessoColore(p) ){
                    this.aggiungiMossa(new Mossa(this.getPosX(),this.getPosY(),fisso,k));
                }
                break;
            }
        }
    }
    
    //Calcola Le mosse Possibili Fissando una variabile e facendone variare solo una in negativo
    //Usato per rendere Codice più leggibile e non mettere 90 for uno dentro l'altro
    public void diminuisciVariabile ( int variabile, int fisso , Scacchiera s){
        Pezzo p;
        for ( int k = variabile-1 ; k >= 0 ; k-- ){
            p = s.getPezzo(fisso, k);
            if ( p == null ){
                this.aggiungiMossa(new Mossa(this.getPosX(),this.getPosY(),fisso,k));
            } else {
                if ( !this.isStessoColore(p) ){
                    this.aggiungiMossa(new Mossa(this.getPosX(),this.getPosY(),fisso,k));
                }
                break;
            }
        }
    }*/
    

    
    //Metodi Get e Set

    

}
