
package it.unibas.scacchi.persistenza;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unibas.scacchi.modello.Pezzo;
import it.unibas.scacchi.modello.PezzoAdapter;
import it.unibas.scacchi.modello.Scacchiera;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class DAOScacchieraJson implements IDAOScacchiera{
    
    public Scacchiera carica(String nomeFile) throws DAOException{
        Scacchiera scacchiera = null;
        FileReader flusso = null;
        try {
            flusso = new FileReader(nomeFile);
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Pezzo.class, new PezzoAdapter());
            Gson gson = builder.create();
            scacchiera = gson.fromJson(flusso, Scacchiera.class);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if(flusso != null) {
                try {
                    flusso.close();
                } catch (IOException ex) {
                    
                }
            }
        }
        return scacchiera;
    }
    
    
    public void salva(Scacchiera scacchiera, String nomeFile) throws  DAOException {
        PrintWriter flusso = null;
        try {
            FileWriter fileWriter = new FileWriter(nomeFile);
            flusso = new PrintWriter(fileWriter);
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Pezzo.class, new PezzoAdapter());
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            String scacchieraJson = gson.toJson(scacchiera);
            flusso.print(scacchieraJson);
        } catch (IOException ioe) {
            throw new DAOException(ioe.getMessage());
        } finally {
            if(flusso != null) {
                flusso.close();
            }
        }
    }
}
