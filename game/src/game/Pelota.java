package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JOptionPane;

public class Pelota {

    private final Panel panel;
    private Random rand = new Random(System.nanoTime());
    private int x = rand.nextInt(rand.nextInt(600), 600);
    private int y = 0;
    private int vida = 3;
    private int score = 0;

    private int speedx = 4;
    private int speedy = 4;

    public Pelota(Panel panel) {
        this.panel = panel;
    }

    public void mover() {
        if (x + speedx < 0) {
            speedx = 4;
        }
        if (x + speedx > panel.getWidth() - 30) {
            speedx = -4;
        }
        if (y + speedy < 0) {
            speedy = 4;
        }
        if (y + speedy > panel.getHeight() - 30) {
            vida--;
            JOptionPane.showMessageDialog(null, "Has perdido 1 vida. " + vida + " restantes");
            panel.actualizarField();
            x = rand.nextInt(rand.nextInt(600), 600);
            y = 0;

            if (vida == 0) {
                panel.gameOver();
            }
        }
        if (colision()) {
            speedy = -4;
            y = panel.jugador.obtenerLimiteSuperiorJugador() - 30;
            score++;
            panel.actualizarScore();
        }
        x += speedx;
        y += speedy;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

    private boolean colision() {
        return panel.jugador.obtenerLimite().intersects(obtenerLimite());
    }

    private Rectangle obtenerLimite() {
        return new Rectangle(x, y, 30, 30);
    }

    public int getVidas() {
        return vida;
    }
    public int getScore() {
        return score;
    }
}
