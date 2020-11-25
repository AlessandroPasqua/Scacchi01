/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.scacchi.Persistenza;

import it.unibas.scacchi.modello.Alfiere;
import it.unibas.scacchi.modello.Cavallo;
import it.unibas.scacchi.modello.Costanti;
import it.unibas.scacchi.modello.Pedone;
import it.unibas.scacchi.modello.Pezzo;
import it.unibas.scacchi.modello.Re;
import it.unibas.scacchi.modello.Regina;
import it.unibas.scacchi.modello.Scacchiera;
import it.unibas.scacchi.modello.Torre;

/**
 *
 * @author alessandro
 */
public class DAOScacchiera {

    private Scacchiera scacchiera;

    public Scacchiera Carica() {
        scacchiera = new Scacchiera();
        Pezzo[][] matriceScacchiera = this.inizializzaPedoni();
        matriceScacchiera = this.inizializzaAltriPezzi();
        scacchiera.setMatriceScacchiera(matriceScacchiera);
        return scacchiera;
    }

    private Pezzo[][] inizializzaPedoni() {
        Pezzo[][] matriceScacchiera = this.scacchiera.getMatriceScacchiera();
        Pezzo pedone = new Pedone(Costanti.NERO, false);
        Pezzo pedone1 = new Pedone(Costanti.NERO, true);
        for (int i = 0; i < Costanti.N; i++) {
            for (int j = 0; j < Costanti.N; j++) {
                if (j == 6) {
                    matriceScacchiera[i][j] = pedone;
                }
                if (j == 1) {
                    matriceScacchiera[i][j] = pedone1;
                }
            }
        }
        return matriceScacchiera;
    }

    private Pezzo[][] inizializzaAltriPezzi() {
        Pezzo[][] matriceScacchiera = this.scacchiera.getMatriceScacchiera();
        matriceScacchiera[0][0] = new Torre(Costanti.BIANCO);
        matriceScacchiera[0][7] = new Torre(Costanti.BIANCO);
        matriceScacchiera[7][0] = new Torre(Costanti.NERO);
        matriceScacchiera[7][7] = new Torre(Costanti.NERO);
        
        matriceScacchiera[0][1] = new Cavallo(Costanti.BIANCO);
        matriceScacchiera[0][6] = new Cavallo(Costanti.BIANCO);
        matriceScacchiera[7][1] = new Cavallo(Costanti.NERO);
        matriceScacchiera[7][6] = new Cavallo(Costanti.NERO);
        
        matriceScacchiera[0][2] = new Alfiere(Costanti.BIANCO);
        matriceScacchiera[0][5] = new Alfiere(Costanti.BIANCO);
        matriceScacchiera[7][2] = new Alfiere(Costanti.NERO);
        matriceScacchiera[7][5] = new Alfiere(Costanti.NERO);
        
        matriceScacchiera[0][4] = new Re(Costanti.BIANCO);
        matriceScacchiera[0][3] = new Regina(Costanti.BIANCO);
        matriceScacchiera[7][4] = new Re(Costanti.NERO);
        matriceScacchiera[7][3] = new Regina(Costanti.NERO);
        
        return matriceScacchiera;
    }
}
