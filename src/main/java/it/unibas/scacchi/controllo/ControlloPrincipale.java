package it.unibas.scacchi.controllo;

import it.unibas.scacchi.Applicazione;
import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.modello.Mossa;
import it.unibas.scacchi.modello.Pezzo;
import it.unibas.scacchi.modello.Scacchiera;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloPrincipale {
    
    private static final Logger log = LoggerFactory.getLogger(ControlloPrincipale.class);
    private final MouseListener mouseClick = new MouseClick();
    
    private class MouseClick implements MouseListener{
        
        private List<JPanel> ripristinaColore = new ArrayList<JPanel>();
        
        public void mouseClicked(MouseEvent e){}
        
        //Al click del mouse calcola le mosse per il pezzo scelto e colora le caselle possibili delle mosse
        
        public void mouseClicke(MouseEvent e) {
            //DEVI FARE IL CONTROLLO SUL TURNO
            ripristinaColori();
            int riga = e.getY()/100;
            int colonna = e.getX()/100;
            log.debug("x: "+ riga + " y: " + colonna );
            JPanel chessBoard = Applicazione.getInstance().getVistaPrincipale().getChessBoard();
            Scacchiera s = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
            if ( s.getPezzo(riga, colonna) == null /* verificaPezzoNonTurno */ ){
                //log.debug("Pezzo selezionato è nullo");
                return;
            }
            Pezzo p = s.getPezzo(riga,colonna);
            p.calcolaMosse();
            List<Mossa> mosse = p.getMossePossibili();
            //log.debug("Mosse possibili del pezzo selezionato : " +  mosse.size() );
            int coColonna;
            int coRiga;
            for ( Mossa m : mosse ){
                coRiga = (m.getSuccY() *100)+1;
                coColonna = (m.getSuccX() *100)+1;
                //log.debug("cerco di colorare i quadrati di coordinate " + coox + " - " + cooy);
                JPanel quadrato = (JPanel)chessBoard.getComponentAt(coRiga, coColonna);
                this.ripristinaColore.add(quadrato);
                if ( quadrato.getBackground() == Color.white ){
                    quadrato.setBackground( new Color(128,255,128) );
                } else {
                    quadrato.setBackground( new Color(0,128,0) ); 
                }  
            }
        }
        
        private void ripristinaColori(){
            for ( JPanel p : this.ripristinaColore ){
                if ( p.getBackground().equals(new Color(128,255,128) ) ){
                    p.setBackground(Color.white);
                } else {
                    p.setBackground(Color.GRAY);
                }
            }
            this.ripristinaColore.clear();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int riga = e.getY()/100;
            int colonna = e.getX()/100;
            Scacchiera s = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
            Pezzo p = s.getPezzo(riga, colonna);
            if ( p == null ){
                //this.ripristinaColori();
                return;
            }
            if ( p.getColore().equals(Costanti.NERO) && s.isTurnoBianco() ){
                return;
            }
            if ( p.getColore().equals(Costanti.BIANCO) && !s.isTurnoBianco() ){
                return;
            }
            Applicazione.getInstance().getModello().insertBean(Costanti.PEZZOATTIVO,p);
            this.mouseClicke(e);
        }

        //Al rilascio del mouse si verifica la casella dove si ha rilasciato , se fa parte delle mosse (colorata di verde) si attiva il modello
        @Override
        public void mouseReleased(MouseEvent e) {
            Pezzo p = (Pezzo)Applicazione.getInstance().getModello().getBean(Costanti.PEZZOATTIVO);
            if ( p == null ){
                this.ripristinaColori();
                return;
            }
            int riga = e.getY()/100;
            int colonna = e.getX()/100;
            JPanel chessBoard = Applicazione.getInstance().getVistaPrincipale().getChessBoard();
            JPanel panel = (JPanel)chessBoard.getComponentAt( e.getX(), e.getY() );
            if ( !panel.getBackground().equals(new Color(128,255,128)) /*VERDE CHIARO*/  && !panel.getBackground().equals(new Color(0,128,0))  /*VERDE SCURO*/ ){
                this.ripristinaColori();
                return;
            }
            Scacchiera s = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
            Mossa m = p.cercaMossa(riga, colonna);
            if ( m == null ){
                return;
            }
            s.movimentoPezzo(p, m );
            s.cambiaTurno();
            if ( s.isTurnoBianco() ){
                Applicazione.getInstance().getVistaPrincipale().getColoreTurno().setText("Bianco");
            } else {
                Applicazione.getInstance().getVistaPrincipale().getColoreTurno().setText("Nero");
            }
            //Da aggiungere un controllo del tipo "Se muovo questo pezzo il mio re va sotto scacco?"
            String colore;
            if ( p.getColore().equals(Costanti.BIANCO) ){
                colore = Costanti.NERO;
            } else {
                colore = Costanti.BIANCO;
            }
            this.ripristinaColori();
            Applicazione.getInstance().getVistaPrincipale().aggiornaScacchiera();
            if ( s.verificaScacco(colore) ) {
                if ( s.verificaScaccoMatto(colore) ){
                    Applicazione.getInstance().getFrame().mostraMessaggio("Scacco matto!");
                } else {
                    Applicazione.getInstance().getFrame().mostraMessaggio("Scacco!");
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //To change body of generated methods, choose Tools | Templates.
        }
        
        
    }

    public MouseListener getMouseClick() {
        return mouseClick;
    }
    
}
