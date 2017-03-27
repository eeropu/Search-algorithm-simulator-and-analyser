package ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eerop
 */
public class WindowHandler implements Runnable {

    private CardLayout cl;
    private JPanel cardPanel, panel;
    private Grid grid;

    public WindowHandler() {
        cl = new CardLayout();
        cardPanel = new JPanel(cl);
        cardPanel.setBounds(960, 0, 256, 640);
        Menu menu = new Menu();
        cardPanel.add(menu, "menu");
        cl.show(cardPanel, "menu");
        panel = new JPanel();
        panel.setLayout(null);
        grid = new Grid();
        panel.add(grid);
        panel.add(cardPanel);
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Algorithm analyser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setPreferredSize(new Dimension(1216, 640));
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
    }
}
