package ui.testresultwindow;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eerop
 */
public class ResultsWindowHandler implements Runnable{
    
    private final CardLayout cl;
    private final JPanel cardPanel;
    private AlgorithmSelection algorithmselection;

    public ResultsWindowHandler() {
        this.cl = new CardLayout();
        this.cardPanel = new JPanel(cl);
        
        this.algorithmselection = new AlgorithmSelection();
        cardPanel.add(algorithmselection, "select");
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Speedtesting");
        frame.setVisible(true);
        frame.getContentPane().setPreferredSize(new Dimension(960, 544));
        frame.add(cardPanel);
        frame.pack();
    }
}
