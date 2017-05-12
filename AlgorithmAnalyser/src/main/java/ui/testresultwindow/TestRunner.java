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
 *
 * @author eerop
 */
public class TestRunner implements ActionListener {

    private JCheckBox AManhattan, AEuclidean, AOctile, AChebyshev, BManhattan, BEuclidean,
            BOctile, BChebyshev, Breadth, Depth, Dijkstra;
    private JButton ready;
    private Grid grid;
    private boolean diagonal;
    private AlgorithmFactory af;
    private ResultsWindowHandler rwh;
    private final String[] results;

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
            Thread thread = new Thread(){
                @Override
                public void run(){
                    runAlgorithms();
                }
            };
            thread.start();
        }
    }

    private void runAlgorithms() {
        if (AManhattan.isSelected()) {
            run("Astar", "manhattan");
        }
        if (AEuclidean.isSelected()) {
            run("Astar", "euclidean");
        }
        if (AOctile.isSelected()) {
            run("Astar", "octile");
        }
        if (AChebyshev.isSelected()) {
            run("Astar", "chebychev");
        }
        if (BManhattan.isSelected()) {
            run("BestFirst", "manhattan");
        }
        if (BEuclidean.isSelected()) {
            run("BestFirst", "euclidean");
        }
        if (BOctile.isSelected()) {
            run("BestFirst", "octile");
        }
        if (BChebyshev.isSelected()) {
            run("BestFirst", "chebyshev");
        }
        if (Breadth.isSelected()) {
            run("BFS", "");
        }
        if (Depth.isSelected()) {
            run("DFS", "");
        }
        if (Dijkstra.isSelected()) {
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

    public void setComponents(JCheckBox AManhattan, JCheckBox AEuclidean, JCheckBox AOctile,
            JCheckBox AChebyshev, JCheckBox BManhattan, JCheckBox BEuclidean, JCheckBox BOctile,
            JCheckBox BChebyshev, JCheckBox Breadth, JCheckBox Depth, JCheckBox Dijkstra,
            JButton ready) {

        this.AManhattan = AManhattan;
        this.AEuclidean = AEuclidean;
        this.AOctile = AOctile;
        this.AChebyshev = AChebyshev;
        this.BManhattan = BManhattan;
        this.BEuclidean = BEuclidean;
        this.BOctile = BOctile;
        this.BChebyshev = BChebyshev;
        this.Breadth = Breadth;
        this.Depth = Depth;
        this.Dijkstra = Dijkstra;
        this.ready = ready;
    }

}
