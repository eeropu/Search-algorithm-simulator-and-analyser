package ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.listeners.MenuListener;

/**
 *
 * @author eerop
 */
public class WindowHandler implements Runnable {

    private final CardLayout cl;
    private final JPanel cardPanel, panel;
    private final Grid grid;

    public WindowHandler() {
        cl = new CardLayout();
        cardPanel = new JPanel(cl);
        cardPanel.setBounds(960, 0, 256, 640);

        grid = new Grid();

        MenuListener ml = new MenuListener(grid, this);
        Menu menu = new Menu(ml);
        cardPanel.add(menu, "menu");
        cl.show(cardPanel, "menu");
        
        SimulationMenu sm = new SimulationMenu();
        cardPanel.add(sm, "simulation");
        
        panel = new JPanel();
        panel.setLayout(null);
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
    
    public void simulation(){
        cl.show(cardPanel, "simulation");
    }
}
