package it.unibas.scacchi.controllo;

import it.unibas.scacchi.Applicazione;
import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.modello.Mossa;
import it.unibas.scacchi.modello.Pezzo;
import it.unibas.scacchi.modello.Scacchiera;
import it.unibas.scacchi.vista.VistaPrincipale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloPrincipale {
    
    private static final Logger log = LoggerFactory.getLogger(ControlloPrincipale.class);
    private final MouseListener mouseClick = new MouseClick();
    private final MouseMotionListener mouseMovimento = new MouseMovimento();
    
    private class MouseClick implements MouseListener{
        
        private List<JPanel> ripristinaColore = new ArrayList<JPanel>();

        @Override
        public void mouseClicked(MouseEvent e) {
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
            this.mouseClicked(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
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
    
    private class MouseMovimento implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            //log.debug("Dragged "+e.getX() + " y : " + e.getY());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
             //To change body of generated methods, choose Tools | Templates.
        }
        
    }

    public MouseListener getMouseClick() {
        return mouseClick;
    }

    public MouseMotionListener getMouseMovimento() {
        return mouseMovimento;
    }
    
    
}
