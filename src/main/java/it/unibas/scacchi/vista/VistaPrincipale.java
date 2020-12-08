/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.scacchi.vista;

import it.unibas.scacchi.Applicazione;
import it.unibas.scacchi.Costanti;
import it.unibas.scacchi.ResourceManager;
import it.unibas.scacchi.modello.Pezzo;
import it.unibas.scacchi.modello.Scacchiera;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author santo
 */
public class VistaPrincipale extends javax.swing.JPanel {
    private Logger logger = LoggerFactory.getLogger(VistaPrincipale.class);
    
    
    public void inizializza() {
        initComponents();
        //PROVA
        Scacchiera s = new Scacchiera();
        s.setScacchieraIniziale();
        Applicazione.getInstance().getModello().insertBean(Costanti.SCACCHIERA, s);
        //
        inizializzaComponenti();
        inizializzaPanelScacchiera();
        assegnaControlloScacchiera();
        aggiornaScacchiera();
        this.setVisible(true);
    }
    
    private void inizializzaComponenti(){

    }
    
    private void assegnaControlloScacchiera(){
        chessBoard.addMouseListener( Applicazione.getInstance().getControlloPrincipale().getMouseClick() ); //Da aggiungere Listener Mouse
        chessBoard.addMouseMotionListener( Applicazione.getInstance().getControlloPrincipale().getMouseMovimento() ); //Da aggiungere Listener Mouse 2
    }
    
    public void inizializzaPanelScacchiera(){
        Dimension boardSize = new Dimension(800,800);
        paneScacchiera.setPreferredSize(boardSize);
        chessBoard = new JPanel();
        paneScacchiera.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8,8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            chessBoard.add( square );
            int row = (i / 8) % 2;
            if (row == 0){
                square.setBackground( i % 2 == 0 ? Color.gray : Color.white );
            } else {
                square.setBackground( i % 2 == 0 ? Color.white : Color.gray );
            }
        }  
    }
    
    public void aggiornaScacchiera(){
        Scacchiera s = (Scacchiera)Applicazione.getInstance().getModello().getBean(Costanti.SCACCHIERA);
        ResourceManager r = Applicazione.getInstance().getResourceManager();
        Pezzo p;
        int c = 0;
        JLabel label ;
        JPanel panel ;
        for ( int i = 0 ; i < Costanti.N ; i++  ){
            for ( int y = 0 ; y < Costanti.N ; y++ ){
                p = s.getPezzo(i, y);
                if ( p != null ){
                    label = new JLabel( r.getImageResource( p.getPercorsoImmagine() ) );
                    label.setSize(75, 75);
                    panel = (JPanel)chessBoard.getComponent(c);
                    panel.add(label);
                    paneScacchiera.setPosition(panel, c);
                    
                } else {
                    panel = (JPanel)chessBoard.getComponent(c);
                    panel.removeAll();
                    panel.validate();
                    panel.repaint();
                    int row = (c / 8) % 2;
                    if (row == 0){
                        panel.setForeground(i % 2 == 0 ? Color.gray : Color.white );
                    } else {
                        panel.setForeground(i % 2 == 0 ? Color.white : Color.gray );
                    }
                }
                c++;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInfoPartita = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        nomeUtente1 = new javax.swing.JLabel();
        nomePlayer2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        tempoRimanente1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        tempoRimanenteAvversario = new javax.swing.JLabel();
        paneScacchiera = new javax.swing.JLayeredPane();

        panelInfoPartita.setBorder(javax.swing.BorderFactory.createTitledBorder("Informazioni Partita"));

        jLabel1.setText("Nome Player 1 :");

        jLabel2.setText("Nome Player 2 : ");

        nomeUtente1.setText("jLabel4");

        nomePlayer2.setText("Ciro ");

        jLabel3.setText("Tempo Rimanente :");

        tempoRimanente1.setText("jLabel5");

        jLabel6.setText("Tempo Rimanente :");

        tempoRimanenteAvversario.setText("jLabel7");

        javax.swing.GroupLayout panelInfoPartitaLayout = new javax.swing.GroupLayout(panelInfoPartita);
        panelInfoPartita.setLayout(panelInfoPartitaLayout);
        panelInfoPartitaLayout.setHorizontalGroup(
            panelInfoPartitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoPartitaLayout.createSequentialGroup()
                .addGroup(panelInfoPartitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoPartitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelInfoPartitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(panelInfoPartitaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelInfoPartitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomePlayer2)
                                    .addComponent(tempoRimanente1))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoPartitaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelInfoPartitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInfoPartitaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tempoRimanenteAvversario))
                            .addComponent(jLabel6))))
                .addContainerGap())
        );
        panelInfoPartitaLayout.setVerticalGroup(
            panelInfoPartitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoPartitaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeUtente1)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tempoRimanente1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomePlayer2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tempoRimanenteAvversario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneScacchiera.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout paneScacchieraLayout = new javax.swing.GroupLayout(paneScacchiera);
        paneScacchiera.setLayout(paneScacchieraLayout);
        paneScacchieraLayout.setHorizontalGroup(
            paneScacchieraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        paneScacchieraLayout.setVerticalGroup(
            paneScacchieraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfoPartita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneScacchiera)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneScacchiera)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInfoPartita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 214, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nomePlayer2;
    private javax.swing.JLabel nomeUtente1;
    private javax.swing.JLayeredPane paneScacchiera;
    private javax.swing.JPanel panelInfoPartita;
    private javax.swing.JLabel tempoRimanente1;
    private javax.swing.JLabel tempoRimanenteAvversario;
    // End of variables declaration//GEN-END:variables
    private JPanel chessBoard;

    public JPanel getChessBoard() {
        return chessBoard;
    }
    
    
}
