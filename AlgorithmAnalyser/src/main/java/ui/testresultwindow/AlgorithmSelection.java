package ui.testresultwindow;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.Grid;

/**
 *
 * @author eerop
 */
public class AlgorithmSelection extends JPanel {

    private JCheckBox AManhattan, AEuclidean, AOctile, AChebyshev, BManhattan, BEuclidean,
            BOctile, BChebyshev, Breadth, Depth, Dijkstra;
    private JButton ready;
    private Font heuristics, algorithms;
    private TestRunner tr;

    public AlgorithmSelection(TestRunner tr) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(960, 544));
        setFonts();
        initializeComponents();
        setPositionings();
        addComponents();
        addLabels();
        
        this.tr = tr;
        tr.setComponents(AManhattan, AEuclidean, AOctile, AChebyshev, BManhattan, BEuclidean, 
                BOctile, BChebyshev, Breadth, Depth, Dijkstra, ready);
        ready.addActionListener(tr);
    }

    private void initializeComponents() {
        this.AManhattan = new JCheckBox("Manhattan");
        AManhattan.setFont(heuristics);
        this.AEuclidean = new JCheckBox("Euclidean");
        AEuclidean.setFont(heuristics);
        this.AOctile = new JCheckBox("Octile");
        AOctile.setFont(heuristics);
        this.AChebyshev = new JCheckBox("Chebyshev");
        AChebyshev.setFont(heuristics);
        this.BManhattan = new JCheckBox("Manhattan");
        BManhattan.setFont(heuristics);
        this.BEuclidean = new JCheckBox("Euclidean");
        BEuclidean.setFont(heuristics);
        this.BOctile = new JCheckBox("Octile");
        BOctile.setFont(heuristics);
        this.BChebyshev = new JCheckBox("Chebyshev");
        BChebyshev.setFont(heuristics);
        this.Breadth = new JCheckBox("BFS");
        Breadth.setFont(algorithms);
        this.Depth = new JCheckBox("DFS");
        Depth.setFont(algorithms);
        this.Dijkstra = new JCheckBox("Dijkstra");
        Dijkstra.setFont(algorithms);
        this.ready = new JButton("Continue");
        ready.setFont(algorithms);
    }

    private void setPositionings() {
        AManhattan.setBounds(64, 224, 160, 32);
        AEuclidean.setBounds(64, 256, 160, 32);
        AOctile.setBounds(64, 288, 160, 32);
        AChebyshev.setBounds(64, 320, 160, 32);
        BManhattan.setBounds(256, 224, 160, 32);
        BEuclidean.setBounds(256, 256, 160, 32);
        BOctile.setBounds(256, 288, 160, 32);
        BChebyshev.setBounds(256, 320, 160, 32);
        Breadth.setBounds(448, 192, 160, 32);
        Depth.setBounds(608, 192, 160, 32);
        Dijkstra.setBounds(768, 192, 160, 32);
        ready.setBounds(320, 448, 320, 64);
    }

    private void addComponents() {
        add(AManhattan);
        add(AEuclidean);
        add(AOctile);
        add(AChebyshev);
        add(BManhattan);
        add(BEuclidean);
        add(BOctile);
        add(BChebyshev);
        add(Breadth);
        add(Depth);
        add(Dijkstra);
        add(ready);
    }
    
    private void addActionListeners(){
        
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
