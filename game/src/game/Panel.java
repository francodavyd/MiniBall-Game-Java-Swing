package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel implements Runnable {
    
    Pelota pelota = new Pelota(this);
    Jugador jugador = new Jugador(this);
    JFrame frameP;
    JTextField txtVida = new JTextField("LIFE " + pelota.getVidas());
    JTextField txtScore = new JTextField("SCORE " + pelota.getScore());
            
    public Panel(JFrame frameP) {
        this.frameP = frameP;
        setLayout(null); 
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                jugador.keyReleased(e);
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                jugador.keyPressed(e);
            }
        });
        setFocusable(true);
        txtVida.setEditable(false);
        txtVida.setFocusable(false);
        txtVida.setBounds(30,0,100,30);
        
        txtScore.setEditable(false);
        txtScore.setFocusable(false);
        txtScore.setBounds(480,0,100,30);
        add(txtVida);
        add(txtScore);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.red);
        pelota.paint(g2);
        g2.setColor(Color.GRAY);
        jugador.paint(g2);
    }
    
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Lo sentimos, has perdido. Vuelve a intentarlo", "Game Over", JOptionPane.YES_NO_OPTION);
        frameP.dispose();
        Game.iniciar();
        
    }
    
    public void actualizarField() {
        txtVida.setText("LIFE " + pelota.getVidas());
        
    }
    
    public void actualizarScore(){
        txtScore.setText("SCORE " + pelota.getScore());
        
         if (pelota.getScore() % 10 == 0) {
             Toolkit.getDefaultToolkit().beep();
           
    }
    }
    
    @Override
    public void run() {
        
        while (pelota.getVidas() > 0) {
            try {
                pelota.mover();
                jugador.mover();
                this.repaint();
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
    }
}

