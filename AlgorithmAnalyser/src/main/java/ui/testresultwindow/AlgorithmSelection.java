package ui.testresultwindow;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates the window where user can choose what algorithms are going to be
 * included in the comparison.
 *
 * @author eerop
 */
public class AlgorithmSelection extends JPanel {

    private JCheckBox aManhattan, aEuclidean, aOctile, aChebyshev, bManhattan, bEuclidean,
            bOctile, bChebyshev, breadth, depth, dijkstra;
    private JButton ready;
    private Font heuristics, algorithms;
    private TestRunner tr;

    /**
     * Basic constructor.
     *
     * @param tr testrunner
     */
    public AlgorithmSelection(TestRunner tr) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(960, 544));
        setFonts();
        initializeComponents();
        setPositionings();
        addComponents();
        addLabels();

        this.tr = tr;
        tr.setComponents(aManhattan, aEuclidean, aOctile, aChebyshev, bManhattan, bEuclidean,
                bOctile, bChebyshev, breadth, depth, dijkstra, ready);
        ready.addActionListener(tr);
    }

    private void initializeComponents() {
        this.aManhattan = new JCheckBox("Manhattan");
        aManhattan.setFont(heuristics);
        this.aEuclidean = new JCheckBox("Euclidean");
        aEuclidean.setFont(heuristics);
        this.aOctile = new JCheckBox("Octile");
        aOctile.setFont(heuristics);
        this.aChebyshev = new JCheckBox("Chebyshev");
        aChebyshev.setFont(heuristics);
        this.bManhattan = new JCheckBox("Manhattan");
        bManhattan.setFont(heuristics);
        this.bEuclidean = new JCheckBox("Euclidean");
        bEuclidean.setFont(heuristics);
        this.bOctile = new JCheckBox("Octile");
        bOctile.setFont(heuristics);
        this.bChebyshev = new JCheckBox("Chebyshev");
        bChebyshev.setFont(heuristics);
        this.breadth = new JCheckBox("BFS");
        breadth.setFont(algorithms);
        this.depth = new JCheckBox("DFS");
        depth.setFont(algorithms);
        this.dijkstra = new JCheckBox("Dijkstra");
        dijkstra.setFont(algorithms);
        this.ready = new JButton("Continue");
        ready.setFont(algorithms);
    }

    private void setPositionings() {
        aManhattan.setBounds(64, 224, 160, 32);
        aEuclidean.setBounds(64, 256, 160, 32);
        aOctile.setBounds(64, 288, 160, 32);
        aChebyshev.setBounds(64, 320, 160, 32);
        bManhattan.setBounds(256, 224, 160, 32);
        bEuclidean.setBounds(256, 256, 160, 32);
        bOctile.setBounds(256, 288, 160, 32);
        bChebyshev.setBounds(256, 320, 160, 32);
        breadth.setBounds(448, 192, 160, 32);
        depth.setBounds(608, 192, 160, 32);
        dijkstra.setBounds(768, 192, 160, 32);
        ready.setBounds(320, 448, 320, 64);
    }

    private void addComponents() {
        add(aManhattan);
        add(aEuclidean);
        add(aOctile);
        add(aChebyshev);
        add(bManhattan);
        add(bEuclidean);
        add(bOctile);
        add(bChebyshev);
        add(breadth);
        add(depth);
        add(dijkstra);
        add(ready);
    }

    private void addLabels() {
        JLabel a = new JLabel("A*:");
        a.setFont(algorithms);
        a.setBounds(32, 192, 160, 32);
        add(a);
        JLabel best = new JLabel("Best-first:");
        best.setFont(algorithms);
        best.setBounds(224, 192, 160, 32);
        add(best);
        JLabel select = new JLabel("Select algorithms to be tested:");
        select.setFont(algorithms);
        select.setBounds(256, 32, 640, 64);
        add(select);
    }

    private void setFonts() {
        this.heuristics = new Font("Verdana", Font.BOLD, 18);
        this.algorithms = new Font("Verdana", Font.BOLD, 25);
    }
}
