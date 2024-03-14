package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MenuPanel extends JPanel {

    JButton btnIniciar = new JButton("JUGAR");
    JLabel lblTitle = new JLabel("~ Mini Ball ~");
    JFrame parentFrame;

    public MenuPanel(JFrame parentFrame) {

        this.parentFrame = parentFrame;
        setLayout(null);
        
        btnIniciar.setBounds(130, 300, 120, 50);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        btnIniciar.setBorder(border);
        btnIniciar.setFocusable(false);
        btnIniciar.setBackground(Color.CYAN);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mini Ball");
                Panel panel = new Panel(frame);
                frame.setSize(600, 600);
                frame.add(panel);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                Thread hilo = new Thread(panel);
                hilo.start();

                parentFrame.dispose();
            }

        };
        btnIniciar.addActionListener(listener);
        add(btnIniciar);

        lblTitle.setBounds(50, 100, 300, 100);
        lblTitle.setFont(new Font(TOOL_TIP_TEXT_KEY, WIDTH, 50));
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        setBackground(new Color(0, 33, 71));
    }

}
