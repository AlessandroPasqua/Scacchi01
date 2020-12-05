package it.unibas.scacchi.modello;

public class Gioco {
    
    private String nomePlayer1;
    private String nomePlayer2;
    private Scacchiera scacchiera;

    public Gioco() {
    }
    
    

    public Gioco(String nomePlayer1, String nomePlayer2) {
        this.nomePlayer1 = nomePlayer1;
        this.nomePlayer2 = nomePlayer2;
    }

    public String getNomePlayer1() {
        return nomePlayer1;
    }

    public void setNomePlayer1(String nomePlayer1) {
        this.nomePlayer1 = nomePlayer1;
    }

    public String getNomePlayer2() {
        return nomePlayer2;
    }

    public void setNomePlayer2(String nomePlayer2) {
        this.nomePlayer2 = nomePlayer2;
    }

    public Scacchiera getScacchiera() {
        return scacchiera;
    }

    public void setScacchiera(Scacchiera scacchiera) {
        this.scacchiera = scacchiera;
    }
      
}
