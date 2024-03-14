package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Jugador {

    private int x = 0;
    private int speedx = 0;
    private Panel panel;

    public Jugador(Panel panel) {
        this.panel = panel;
    }

    public void mover() {
        if (x + speedx > 0 && x + speedx < panel.getWidth() - 90) {
            x += speedx;
        }
    }

    public void paint(Graphics2D g2) {
        g2.fillRect(x, 500, 90, 15);
    }

    public void keyReleased(KeyEvent e) {
        speedx = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            speedx = -4;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            speedx = 4;
        }
    }

    public Rectangle obtenerLimite() {
    return new Rectangle(x, 500, 90, 15);
    }
    public int obtenerLimiteSuperiorJugador(){
        return 500 - 15;
    }
}
