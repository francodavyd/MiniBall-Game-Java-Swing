package game;

import javax.swing.JFrame;

public class Game {

    public static void main(String[] args) {
        iniciar();

    }

    public static void iniciar() {
        JFrame menu = new JFrame("Mini ball");
        menu.setSize(400, 400);
        MenuPanel menuP = new MenuPanel(menu);
        menu.add(menuP);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
        menu.setVisible(true);

    }

}
