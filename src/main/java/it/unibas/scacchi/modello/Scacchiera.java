package it.unibas.scacchi.modello;

import it.unibas.scacchi.Costanti;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scacchiera {
   
   private Pezzo[][] matriceScacchiera = new Pezzo[Costanti.N][Costanti.N];
   private Re reNero;
   private Re reBianco;
   private List<Pezzo> pezziAttiviBianchi = new ArrayList<Pezzo>();
   private List<Pezzo> pezziAttiviNeri = new ArrayList<Pezzo>();
   private List<Pezzo> pezziMangiatiBianchi = new ArrayList<Pezzo>();
   private List<Pezzo> pezziMangiatiNeri = new ArrayList<Pezzo>();
   private static final Logger log = LoggerFactory.getLogger(Scacchiera.class);
   private boolean turnoBianco = true;

   //Costruttori

    public Scacchiera() {
    }

    //Metodi Classe
    
        //Metodo che inizializza la scacchiera con i suoi pezzi in posizione iniziale e li inserisce in due liste "PezziAttivi" per 
        //Ogni colore , liste che saranno utilizzate per effettuare controlli successivamente 
    public void setScacchieraIniziale() {
        for (int j = 0; j < Costanti.N; j++) {
            this.posizionaPezzo(new Pedone(Costanti.NERO,true), 1, j);
            pezziAttiviBianchi.add(matriceScacchiera[1][j]);
            this.posizionaPezzo(new Pedone(Costanti.BIANCO,true), Costanti.N-2, j);
            pezziAttiviNeri.add(matriceScacchiera[Costanti.N-2][j]);
        }        
        
        //posizionamento pezzi bianchi
        this.posizionaPezzo(new Torre(Costanti.BIANCO), Costanti.N-1, 0);
        this.posizionaPezzo(new Cavallo(Costanti.BIANCO), Costanti.N-1, 1);
        this.posizionaPezzo(new Alfiere(Costanti.BIANCO), Costanti.N-1, 2);
        reBianco = new Re(Costanti.BIANCO);
        this.posizionaPezzo(reBianco, Costanti.N-1, 3);
        this.posizionaPezzo(new Regina(Costanti.BIANCO), Costanti.N-1, 4);
        this.posizionaPezzo(new Alfiere(Costanti.BIANCO), Costanti.N-1, 5);
        this.posizionaPezzo(new Cavallo(Costanti.BIANCO), Costanti.N-1, 6);
        this.posizionaPezzo(new Torre(Costanti.BIANCO), Costanti.N-1, 7);
        for ( int i = 0 ; i < Costanti.N ; i++ ){
            //Aggiungo I Pezzi Del Bianco in una lista dove sarà più facile accedervi
            pezziAttiviBianchi.add(matriceScacchiera[Costanti.N-1][i]);
        }
        //posizionamento pezzi neri
        this.posizionaPezzo(new Torre(Costanti.NERO), 0, 0);
        this.posizionaPezzo(new Cavallo(Costanti.NERO), 0, 1);
        this.posizionaPezzo(new Alfiere(Costanti.NERO), 0, 2);
        this.posizionaPezzo(new Regina(Costanti.NERO), 0, 3);
        reNero = new Re(Costanti.NERO);
        this.posizionaPezzo(reNero, 0, 4);
        this.posizionaPezzo(new Alfiere(Costanti.NERO), 0, 5);
        this.posizionaPezzo(new Cavallo(Costanti.NERO), 0, 6);
        this.posizionaPezzo(new Torre(Costanti.NERO), 0, 7);
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
        if ( siMuove instanceof Pedone  ){
            Pedone p = (Pedone)siMuove;
            p.setPrimaMossa(false);
        }
        if ( this.getPezzo(succX,succY) != null ){
            //I controlli che quel pezzo non sia dello stesso colore dobbiamo farlo nella classe Pezzo
            pezzoMangiato(this.getPezzo(succX,succY));
        }
        matriceScacchiera[succX][succY] = matriceScacchiera[prevX][prevY];
        matriceScacchiera[prevX][prevY] = null;
        siMuove.cambiaPosizione(succX, succY);
    }
    
    //Metodo che inserisce il pezzo nella scacchiera e modifica la posizione di esso nelle sue variabili
    public void posizionaPezzo(Pezzo p , int x , int y ){
        p.setPosX(x);
        p.setPosY(y);
        if ( p instanceof Re ){
           if ( p.getColore().equals(Costanti.BIANCO)){
               reBianco = (Re)p;
           } else {
               reNero = (Re)p;
           }
        }
        aggiungiPezzoAListaAttivi(p);
        this.matriceScacchiera[x][y] = p;
    }
    
    //All'aggiunta di un pezzo nella scacchiera a seconda del suo colore viene aggiunto ad una lista
    //utile al ricapitolo dei pezzi ancora attivi sulla scacchiera per ogni colore
    public void aggiungiPezzoAListaAttivi(Pezzo p){
        if ( p.getColore().equals(Costanti.BIANCO)){
            this.pezziAttiviBianchi.add(p);
        } else {
            this.pezziAttiviNeri.add(p);
        }
    }
    
    //Metodo che crea una lista di mosse totali dei pezzi dell'avversario
    //N.B. La condizione che esclude il re nella scansione dei pezzi è dovuta al fatto
    // Che si creava un loop infinito di chiamate dei sottoprogrammi e lanciava eccezione
    // Motivo per cui si è supposto che MAI un re possa mettere sotto scacco un altro
    public List<Mossa> getMosseTotaliAvversario(String colore) {
        List<Pezzo> pezzi;
        List<Mossa> mosse = new ArrayList<Mossa>();
        if ( colore.equals(Costanti.BIANCO) ){
           pezzi = this.pezziAttiviNeri; 
           log.debug("Ho scelto la lista pezzi attivi neri");
        } else {
            pezzi = this.pezziAttiviBianchi;
            log.debug("Ho scelto la lista pezzi attivi neri");
        }
        for ( Pezzo p : pezzi ){
            if ( !(p instanceof Re)){
                log.debug("" + p + " " + p.toString());
                p.calcolaMosse(this);
                mosse.addAll(p.getMossePossibili());
            }
        }
        return mosse;
    }
    
    //Metodo che viene chiamato per primo per verificare se il re di un dato colore sia sotto scacco , scacco verificato vedendo se la sua posizione
    //Sia nelle mosse di almeno un pezzo del colore avversario
    public boolean verificaScacco(String colore){
        Re tmp;
        if ( colore.equals(Costanti.BIANCO)){
            tmp = this.reBianco;
        } else {
            tmp = this.reNero;
        }
        List<Mossa> mosse = this.getMosseTotaliAvversario(colore);
        if ( mosse.contains(new Mossa(0,0,tmp.getPosX(),tmp.getPosY())) ){
            return true;
        }        
        return false;
    }
    
    //Metodo che viene chiamato dopo aver chiamato il metodo precedente , dopo aver verificato che esso sia sotto scacco
    //Verifichiamo se abbia qualche mossa possibile per scappare da questo , se non può è matto.  
    // N.B. Per semplicità non abbbiamo aggiunto la possibilità che un pezzo possa mettersi nella traiettoria dello scacco
    // Cosi' annullandolo 
    //TODO : FEATURE DA AGGIUNGERE
    public boolean verificaScaccoMatto(String colore){
        Re tmp;
        if ( colore.equals(Costanti.BIANCO)){
            tmp = this.reBianco;
        } else {
            tmp = this.reNero;
        }
        List<Mossa> mosse = tmp.getMossePossibili();
        if ( mosse.isEmpty() ){
            return true;
        }
        return false;
    }
    
    public void cambiaTurno(){
        this.turnoBianco = !this.turnoBianco;
    }
    
            ////////////////////////
            ////Metodi Get e Set////
            ////////////////////////
    
    public Pezzo getPezzo( int x , int y ){
        if ( x > Costanti.N || y > Costanti.N || x < 0 || y < 0 ){
            return null;
        }
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

    public boolean isTurnoBianco() {
        return turnoBianco;
    }
    
    
   
}