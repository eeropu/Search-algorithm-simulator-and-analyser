package ui.testresultwindow;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.Grid;

/**
 * This class is responsible of what is shown in the speedtest-window.
 *
 * @author eerop
 */
public class ResultsWindowHandler implements Runnable {

    private JFrame frame;
    private final CardLayout cl;
    private final JPanel cardPanel;
    private AlgorithmSelection algorithmselection;
    private Grid grid;

    /**
     * Basic constructor.
     *
     * @param grid reference to the grid
     * @param diagonal true if diagonal movement is allowed
     */
    public ResultsWindowHandler(Grid grid, boolean diagonal) {
        this.grid = grid;

        TestRunner tr = new TestRunner(grid, diagonal, this);

        this.cl = new CardLayout();
        this.cardPanel = new JPanel(cl);

        this.algorithmselection = new AlgorithmSelection(tr);
        cardPanel.add(algorithmselection, "select");
    }

    @Override
    public void run() {
        frame = new JFrame("Speedtesting");
        frame.setVisible(true);
        frame.getContentPane().setPreferredSize(new Dimension(960, 544));
        frame.add(cardPanel);
        frame.pack();
    }

    /**
     * Shows the loadscreen.
     */
    public void load() {
        cardPanel.add(new LoadingScreen(), "load");
        cl.show(cardPanel, "load");
    }

    /**
     * Shows the results screen.
     *
     * @param s the testresults
     */
    public void showResults(String... s) {
        cardPanel.add(new Results(s), "result");
        cl.show(cardPanel, "result");
    }
}
