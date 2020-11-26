package it.unibas.scacchi.modello;

public class Scacchiera {
    
   private Pezzo[][] matriceScacchiera = new Pezzo[Costanti.N][Costanti.N] ;

    public Pezzo[][] getMatriceScacchiera() {
        return matriceScacchiera;
    }

    public void setScacchieraIniziale(Pezzo[][] matriceScacchiera) {
        for (int j = 0; j < Costanti.N; j++) {
           matriceScacchiera[1][j] = Costanti.PEDONENERO ;
           matriceScacchiera[Costanti.N - 1][j] = Costanti.PEDONEBIANCO ;
        }
        //posizionamento pezzi bianchi
        matriceScacchiera[Costanti.N][0] = Costanti.TORREBIANCO ;
        matriceScacchiera[Costanti.N][1] = Costanti.CAVALLOBIANCO ;
        matriceScacchiera[Costanti.N][2] = Costanti.ALFIEREBIANCO ;
        matriceScacchiera[Costanti.N][3] = Costanti.REBIANCO ;
        matriceScacchiera[Costanti.N][4] = Costanti.REGINABIANCO ;
        matriceScacchiera[Costanti.N][5] = Costanti.ALFIEREBIANCO ;
        matriceScacchiera[Costanti.N][6] = Costanti.CAVALLOBIANCO ;
        matriceScacchiera[Costanti.N][7] = Costanti.TORREBIANCO ;
        //posizionamento pezzi neri
        matriceScacchiera[0][0] = Costanti.TORRENERO;
        matriceScacchiera[0][1] = Costanti.CAVALLONERO ;
        matriceScacchiera[0][2] = Costanti.ALFIERENERO ;
        matriceScacchiera[0][3] = Costanti.RENERO ;
        matriceScacchiera[0][4] = Costanti.REGINANERO ;
        matriceScacchiera[0][5] = Costanti.ALFIERENERO ;
        matriceScacchiera[0][6] = Costanti.CAVALLONERO ;
        matriceScacchiera[0][7] = Costanti.TORRENERO ;
        //
        this.matriceScacchiera = matriceScacchiera ;
    }
   
}
       
