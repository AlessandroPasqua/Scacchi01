
package it.unibas.scacchi.persistenza;

import it.unibas.scacchi.modello.Scacchiera;

public interface IDAOScacchiera {
    public void salva(Scacchiera scacchiera, String nomeFile) throws  DAOException;   
    public Scacchiera carica(String nomeFile) throws DAOException;
}
