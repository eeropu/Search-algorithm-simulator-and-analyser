package ui.testresultwindow;

import algorithms.Algorithm;
import algorithms.AlgorithmFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import ui.Grid;

/**
 * Runs the tests for the selected algorithms.
 *
 * @author eerop
 */
public class TestRunner implements ActionListener {

    private JCheckBox aManhattan, aEuclidean, aOctile, aChebyshev, bManhattan, bEuclidean,
            bOctile, bChebyshev, breadth, depth, dijkstra;
    private JButton ready;
    private Grid grid;
    private boolean diagonal;
    private AlgorithmFactory af;
    private ResultsWindowHandler rwh;
    private final String[] results;

    /**
     * Constructor for this class.
     *
     * @param grid reference to the grid
     * @param diagonal true if diagonal movement is allowed
     * @param rwh reference to the resultswindowhandler
     */
    public TestRunner(Grid grid, boolean diagonal, ResultsWindowHandler rwh) {
        this.grid = grid;
        this.diagonal = diagonal;

        this.af = new AlgorithmFactory(grid.getStartOrFinish('s').getV());
        this.rwh = rwh;
        this.results = new String[25];
        for (int i = 0; i < results.length; i++) {
            results[i] = "";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ready) {
            rwh.load();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    runAlgorithms();
                }
            };
            thread.start();
        }
    }

    private void runAlgorithms() {
        if (aManhattan.isSelected()) {
            run("Astar", "manhattan");
        }
        if (aEuclidean.isSelected()) {
            run("Astar", "euclidean");
        }
        if (aOctile.isSelected()) {
            run("Astar", "octile");
        }
        if (aChebyshev.isSelected()) {
            run("Astar", "chebychev");
        }
        if (bManhattan.isSelected()) {
            run("BestFirst", "manhattan");
        }
        if (bEuclidean.isSelected()) {
            run("BestFirst", "euclidean");
        }
        if (bOctile.isSelected()) {
            run("BestFirst", "octile");
        }
        if (bChebyshev.isSelected()) {
            run("BestFirst", "chebyshev");
        }
        if (breadth.isSelected()) {
            run("BFS", "");
        }
        if (depth.isSelected()) {
            run("DFS", "");
        }
        if (dijkstra.isSelected()) {
            run("Dijkstra", "");
        }
        rwh.showResults(results);
    }

    private void run(String a, String s) {
        Method m = null;

        try {
            m = af.getClass().getMethod("get" + a);
        } catch (UnsupportedOperationException | NoSuchMethodException ex) {
            JOptionPane.showMessageDialog(null, "Oops, something went wrong...", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Algorithm alg = null;

        try {
            alg = (Algorithm) m.invoke(af);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            JOptionPane.showMessageDialog(null, "Oops, something went wrong...", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        grid.algorithmTestPreset(alg, s);

        long[] array = new long[10];

        for (int j = 0; j < 10; j++) {
            long l = System.currentTimeMillis();

            for (int i = 0; i < 100; i++) {
                try {
                    alg = (Algorithm) m.invoke(af);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    JOptionPane.showMessageDialog(null, "Oops, something went wrong...", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                initThread(alg);
            }

            long l2 = System.currentTimeMillis();
            array[j] = l2 - l;
        }

        long result = 0;
        for (long b : array) {
            result += b;
        }

        for (int j = 0; j < results.length; j++) {
            if (results[j].equals("")) {
                results[j] = a + " " + s;
                results[j + 1] = "" + result;
                break;
            }
        }
    }

    private void initThread(Algorithm alg) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                grid.runAlgorithmTest(alg, diagonal);
            }
        };
        thread.start();
    }

    /**
     * Used to give access to the checkboxes in the algorithmselection.
     *
     * @param aManhattan JCheckBox
     * @param aEuclidean JCheckBox
     * @param aOctile JCheckBox
     * @param aChebyshev JCheckBox
     * @param bManhattan JCheckBox
     * @param bEuclidean JCheckBox
     * @param bOctile JCheckBox
     * @param bChebyshev JCheckBox
     * @param breadth JCheckBox
     * @param depth JCheckBox
     * @param dijkstra JCheckBox
     * @param ready JButton
     */
    public void setComponents(JCheckBox aManhattan, JCheckBox aEuclidean, JCheckBox aOctile,
            JCheckBox aChebyshev, JCheckBox bManhattan, JCheckBox bEuclidean, JCheckBox bOctile,
            JCheckBox bChebyshev, JCheckBox breadth, JCheckBox depth, JCheckBox dijkstra,
            JButton ready) {

        this.aManhattan = aManhattan;
        this.aEuclidean = aEuclidean;
        this.aOctile = aOctile;
        this.aChebyshev = aChebyshev;
        this.bManhattan = bManhattan;
        this.bEuclidean = bEuclidean;
        this.bOctile = bOctile;
        this.bChebyshev = bChebyshev;
        this.breadth = breadth;
        this.depth = depth;
        this.dijkstra = dijkstra;
        this.ready = ready;
    }

}
