package ui.listeners;

import algorithms.BestFirstSearch;
import algorithms.BreadthFirstSearch;
import algorithms.DepthFirstSearch;
import algorithms.DijkstraOrAStar;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import ui.Grid;
import ui.Square;
import ui.WindowHandler;

/**
 * This class gives functionality for the Simulation menu.
 *
 * @author eerop
 */
public class SubMenuListener implements ActionListener {

    private final JComboBox<String> jcb;
    private final JLabel addWeight, setHeuristic;
    private final JRadioButton start, goal, wall, weightButton;
    private final JRadioButton manhattan, euclidean, octile, chebyshev;
    private final JRadioButton yes, no;
    private final JButton simulate, clear, fill, back, help;
    private final JTextField weightText;
    private JTextField speedSetter;
    private Grid grid;
    private WindowHandler wh;

    /**
     * Constructor for this class.
     *
     * @param jcb javacombobox
     * @param addWeight jlabel
     * @param setHeuristic jlabel
     * @param start radiobutton
     * @param goal radiobutton
     * @param wall radiobutton
     * @param weightButton radiobutton
     * @param manhattan radiobutton
     * @param euclidean radiobutton
     * @param octile radiobutton
     * @param chebyshev radiobutton
     * @param yes radiobutton
     * @param no radiobutton
     * @param simulate button
     * @param clear button
     * @param fill button
     * @param back button
     * @param help button
     * @param weightText textfield
     */
    public SubMenuListener(JComboBox<String> jcb, JLabel addWeight, JLabel setHeuristic,
            JRadioButton start, JRadioButton goal,
            JRadioButton wall, JRadioButton weightButton, JRadioButton manhattan,
            JRadioButton euclidean, JRadioButton octile, JRadioButton chebyshev,
            JRadioButton yes, JRadioButton no, JButton simulate, JButton clear, JButton fill,
            JButton back, JButton help, JTextField weightText) {

        this.jcb = jcb;
        this.addWeight = addWeight;
        this.setHeuristic = setHeuristic;
        this.start = start;
        this.goal = goal;
        this.wall = wall;
        this.weightButton = weightButton;
        this.manhattan = manhattan;
        this.euclidean = euclidean;
        this.octile = octile;
        this.chebyshev = chebyshev;
        this.yes = yes;
        this.no = no;
        this.simulate = simulate;
        this.clear = clear;
        this.fill = fill;
        this.back = back;
        this.help = help;
        this.weightText = weightText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 20;
        try {
            i = Integer.parseInt(speedSetter.getText());
        } catch (NumberFormatException ex) {
        }
        if (jcb.getSelectedItem().equals("A*")) {
            enableWeights(true);
            enableHeuristic(true);
            if (e.getSource() == simulate && startAndFinishAreSelected()) {
                if (grid.setWeightsAndHeuristics(getHeuristics())) {
                    grid.run(new DijkstraOrAStar(grid.getStartOrFinish('s').getV()), yes.isSelected(), i);
                }
            }
        } else if (jcb.getSelectedItem().equals("Best-first-search")) {
            enableWeights(false);
            enableHeuristic(true);
            if (e.getSource() == simulate && startAndFinishAreSelected()) {
                if (grid.setHeauristics(getHeuristics())) {
                    grid.run(new BestFirstSearch(grid.getStartOrFinish('s').getV()), yes.isSelected(), i);
                }
            }
        } else if (jcb.getSelectedItem().equals("Breadth-first-search")) {
            enableWeights(false);
            enableHeuristic(false);
            if (e.getSource() == simulate && startAndFinishAreSelected()) {
                grid.run(new BreadthFirstSearch(grid.getStartOrFinish('s').getV()), yes.isSelected(), i);
            }
        } else if (jcb.getSelectedItem().equals("Depth-first-search")) {
            enableWeights(false);
            enableHeuristic(false);
            if (e.getSource() == simulate && startAndFinishAreSelected()) {
                grid.run(new DepthFirstSearch(grid.getStartOrFinish('s').getV()), yes.isSelected(), i);
            }
        } else if (jcb.getSelectedItem().equals("Dijkstra")) {
            enableWeights(true);
            enableHeuristic(false);
            if (e.getSource() == simulate && startAndFinishAreSelected()) {
                grid.setWeights();
                grid.run(new DijkstraOrAStar(grid.getStartOrFinish('s').getV()), yes.isSelected(), i);
            }
        }
        if (e.getSource() == clear) {
            boolean clean = true;
            for (Square[] s : grid.getSquares()) {
                for (Square s1 : s) {
                    if (s1.getV().getMode() == 'g' || s1.getV().getMode() == 'd' || s1.getV().getMode() == 'r') {
                        s1.getV().setMode('w');
                        s1.getV().refresh();
                        clean = false;
                    }
                }
            }
            if (clean) {
                for (Square[] s : grid.getSquares()) {
                    for (Square s1 : s) {
                        s1.setBackground(Color.white);
                        s1.getV().setMode('w');
                        s1.setText("");
                    }
                }
            }
        } else if (e.getSource() == fill) {
            for (Square[] s : grid.getSquares()) {
                for (Square s1 : s) {
                    s1.setBackground(Color.black);
                    s1.getV().setMode('b');
                }
            }
        } else if (e.getSource() == back) {
            wh.mainMenu();
        } else if (e.getSource() == help) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("www.github.com/eeropu/Search-algorithm-simulator-and-analyser"));
                } catch (IOException | URISyntaxException ex) {
                    JOptionPane.showMessageDialog(null, "Go to www.github.com/eeropu/Search-algorithm-simulator-and-analyser for instructions", "Failed to open browser", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private String getHeuristics() {
        if (manhattan.isSelected()) {
            return "manhattan";
        } else if (euclidean.isSelected()) {
            return "euclidean";
        } else if (octile.isSelected()) {
            return "octile";
        } else if (chebyshev.isSelected()) {
            return "chebyshev";
        } else {
            return "error";
        }
    }

    private void enableWeights(boolean b) {
        if (weightText.isEnabled() && b == false) {
            weightText.setText("");
            wall.setSelected(true);
        }
        weightText.setEnabled(b);
        weightButton.setEnabled(b);
        if (b) {
            addWeight.setForeground(Color.black);
        } else {
            addWeight.setForeground(Color.lightGray);
        }
    }

    private void enableHeuristic(boolean b) {
        manhattan.setEnabled(b);
        euclidean.setEnabled(b);
        octile.setEnabled(b);
        chebyshev.setEnabled(b);
        if (b) {
            setHeuristic.setForeground(Color.black);
        } else {
            setHeuristic.setForeground(Color.lightGray);
        }
    }
    
    private boolean startAndFinishAreSelected(){
        boolean b = grid.getStartOrFinish('s') != null && grid.getStartOrFinish('f') != null;
        if(!b){
            JOptionPane.showMessageDialog(null, "Grid needs to have start and finish!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return b;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setWH(WindowHandler wh) {
        this.wh = wh;
    }

    public void setSpeedSetter(JTextField speedSetter) {
        this.speedSetter = speedSetter;
    }
}
