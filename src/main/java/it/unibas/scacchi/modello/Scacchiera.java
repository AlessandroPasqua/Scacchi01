package it.unibas.scacchi.modello;

import java.util.ArrayList;
import java.util.List;

public class Scacchiera {
    
   private Pezzo[][] matriceScacchiera = new Pezzo[Costanti.N][Costanti.N];
   private List<Pezzo> pezziAttiviBianchi = new ArrayList<Pezzo>();
   private List<Pezzo> pezziAttiviNeri = new ArrayList<Pezzo>();
   private List<Pezzo> pezziMangiatiBianchi = new ArrayList<Pezzo>();
   private List<Pezzo> pezziMangiatiNeri = new ArrayList<Pezzo>();

   //Costruttori

    public Scacchiera() {}
   
    
    //Metodi Classe
    
        //Metodo che inizializza la scacchiera con i suoi pezzi in posizione iniziale e li inserisce in due liste "PezziAttivi" per 
        //Ogni colore , liste che saranno utilizzate per effettuare controlli successivamente 
    public void setScacchieraIniziale(Pezzo[][] matriceScacchiera) {
        for (int j = 0; j < Costanti.N; j++) {
           matriceScacchiera[1][j] = new Pedone(Costanti.NERO, true) ;
           pezziAttiviBianchi.add(matriceScacchiera[1][j]);
           matriceScacchiera[Costanti.N - 1][j] = new Pedone(Costanti.BIANCO, true) ;
           pezziAttiviNeri.add(matriceScacchiera[Costanti.N-1][j]);
        }        
        
        //posizionamento pezzi bianchi
        matriceScacchiera[Costanti.N][0] = new Torre(Costanti.BIANCO) ;
        matriceScacchiera[Costanti.N][1] = new Cavallo(Costanti.BIANCO) ;
        matriceScacchiera[Costanti.N][2] = new Alfiere(Costanti.BIANCO) ;
        matriceScacchiera[Costanti.N][3] = new Re(Costanti.BIANCO) ;
        matriceScacchiera[Costanti.N][4] = new Regina(Costanti.BIANCO) ;
        matriceScacchiera[Costanti.N][5] = new Alfiere(Costanti.BIANCO) ;
        matriceScacchiera[Costanti.N][6] = new Cavallo(Costanti.BIANCO) ;
        matriceScacchiera[Costanti.N][7] = new Torre(Costanti.BIANCO) ;
        for ( int i = 0 ; i < Costanti.N ; i++ ){
            //Aggiungo I Pezzi Del Bianco in una lista dove sarà più facile accedervi
            pezziAttiviBianchi.add(matriceScacchiera[Costanti.N][i]);
        }
        //posizionamento pezzi neri
        matriceScacchiera[0][0] = new Torre(Costanti.NERO);
        matriceScacchiera[0][1] = new Cavallo(Costanti.NERO) ;
        matriceScacchiera[0][2] = new Alfiere(Costanti.NERO) ;
        matriceScacchiera[0][3] = new Re(Costanti.NERO) ;
        matriceScacchiera[0][4] = new Regina(Costanti.NERO) ;
        matriceScacchiera[0][5] = new Alfiere(Costanti.NERO) ;
        matriceScacchiera[0][6] = new Cavallo(Costanti.NERO) ;
        matriceScacchiera[0][7] = new Torre(Costanti.NERO) ;
        for ( int i = 0 ; i < Costanti.N ; i++ ){
            //Aggiungo I Pezzi Del Nero in una lista dove sarà più facile accedervi
            pezziAttiviNeri.add(matriceScacchiera[0][i]);
        }
    }
    
        //Metodo che Toglie il pezzo Dalla lista dei pezzi Attivi Di un colore e lo aggiunge nella lista dei pezzi Mangiati
    public void pezzoMangiato(Pezzo p){
        String colore = p.getColore();
        if ( colore.equals(Costanti.BIANCO) ){
            this.pezziAttiviBianchi.remove(p);
            this.pezziMangiatiBianchi.add(p);
        } else {
            this.pezziAttiviNeri.remove(p);
            this.pezziMangiatiNeri.add(p);
        }
    }
    
        //Metodo che dato in input il pezzo e la sua mossa effettuata verifica se sia un movimento normale o un movimento per mangiare
        //Un pezzo , se è quest'ultimo il caso richiama il metodo precedente
    public void movimentoPezzo(Pezzo siMuove , Mossa m ){
        int succX = m.getSuccX();
        int succY = m.getSuccY();
        int prevX = m.getPrevX();
        int prevY = m.getPrevY();
        if ( matriceScacchiera[succX][succY] != null ){
            //I controlli che quel pezzo non sia dello stesso colore dobbiamo farlo nella classe Pezzo
            pezzoMangiato(matriceScacchiera[succX][succY]);
        }
        matriceScacchiera[succX][succY] = matriceScacchiera[prevX][prevY];
        matriceScacchiera[prevX][prevY] = null;
        siMuove.cambiaPosizione(succX, succY);
    }
    
    //Metodo creato per effettuare test sui pezzi
    public void posizionaPezzo(Pezzo p , int x , int y ){
        p.setPosX(x);
        p.setPosY(y);
        this.matriceScacchiera[x][y] = p;
    }
    
            ////////////////////////
            ////Metodi Get e Set////
            ////////////////////////
    
    public Pezzo getPezzo( int x , int y ){
        return matriceScacchiera[x][y];
    }
    
    public Pezzo[][] getMatriceScacchiera() {
        return matriceScacchiera;
    }

    public List<Pezzo> getPezziAttiviBianchi() {
        return pezziAttiviBianchi;
    }

    public List<Pezzo> getPezziAttiviNeri() {
        return pezziAttiviNeri;
    }

    public List<Pezzo> getPezziMangiatiBianchi() {
        return pezziMangiatiBianchi;
    }

    public List<Pezzo> getPezziMangiatiNeri() {
        return pezziMangiatiNeri;
    }
   
}