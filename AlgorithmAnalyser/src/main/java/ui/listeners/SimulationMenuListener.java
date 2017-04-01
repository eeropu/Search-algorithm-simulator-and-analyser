package ui.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author eerop
 */
public class SimulationMenuListener implements ActionListener {

    private JComboBox<String> jcb;
    private JLabel addWeight, setHeuristic;
    private JRadioButton start, goal, wall, weightButton;
    private JRadioButton manhattan, euclidean, octile, chebyshev;
    private JRadioButton yes, no;
    private JButton simulate, clear, fill, back, help;
    private JTextField weightText;

    public SimulationMenuListener(JComboBox<String> jcb, JLabel addWeight, JLabel setHeuristic,
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
        if (jcb.getSelectedItem().equals("A*")){
            enableWeights(true);
            enableHeuristic(true);
        } else if (jcb.getSelectedItem().equals("Best-first-search")){
            enableWeights(false);
            enableHeuristic(true);
        } else if (jcb.getSelectedItem().equals("Breadth-first-search")) {
            enableWeights(false);
            enableHeuristic(false);
        } else if (jcb.getSelectedItem().equals("Depth-first-search")){
            enableWeights(false);
            enableHeuristic(false);
        } else if (jcb.getSelectedItem().equals("Dijkstra")){
            enableWeights(true);
            enableHeuristic(false);
        }
    }

    private void enableWeights(boolean b) {
        if(weightText.isEnabled() && b == false){
            weightText.setText("");
            wall.setSelected(true);
        }
        weightText.setEnabled(b);
        weightButton.setEnabled(b);
        if(b){
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
        if(b){
            setHeuristic.setForeground(Color.black);
        } else {
            setHeuristic.setForeground(Color.lightGray);
        }
    }

}
