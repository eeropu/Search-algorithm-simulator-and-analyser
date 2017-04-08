package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import ui.listeners.SimulationMenuListener;

/**
 *
 * @author eerop
 */
public class SimulationMenu extends JPanel{
    
    private JComboBox<String> jcb;
    private final Font font;
    private JLabel editGraph, addWeight, setHeuristic, allow;
    private JRadioButton start, goal, wall, weightButton;
    private JRadioButton manhattan, euclidean, octile, chebyshev;
    private JRadioButton yes, no;
    private JButton simulate, clear, fill, back, help;
    private JTextField weightText;
    private SimulationMenuListener sml;

    public SimulationMenu(WindowHandler wh, Grid grid) {
        this.font = new Font("Vredana", Font.BOLD, 18);
        setLayout(null);
        setPreferredSize(new Dimension(256, 640));
        setComponents();
        this.sml = new SimulationMenuListener(jcb, addWeight, setHeuristic, start, goal, wall, weightButton, manhattan, euclidean, octile, chebyshev, yes, no, simulate, clear, fill, back, help, weightText);
        sml.setGrid(grid);
        sml.setWH(wh);
        setListener();
    }
    
    private void setComponents(){
        jcb = new JComboBox<>(algorithms());
        jcb.setBounds(32, 32, 192, 32);
        add(jcb);
        setLabels();
        setRadioButtons();
        weightSetter();
        selectHeuristic();
        allowDiagonal();
        setButtons();
    }
    
    private String[] algorithms(){
        String[] r = new String[5];
        r[0] = "A*";
        r[1] = "Best-first-search";
        r[2] = "Breadth-first-search";
        r[3] = "Depth-first-search";
        r[4] = "Dijkstra";
        return r;
    }
    
    private void setLabels(){
        editGraph = new JLabel("Edit graph:");
        editGraph.setFont(font);
        editGraph.setBounds(32, 96, 192, 32);
        add(editGraph);
        addWeight = new JLabel("Add weights:");
        addWeight.setFont(font);
        addWeight.setBounds(32, 192, 192, 32);
        add(addWeight);
    }
    
    private void setRadioButtons(){
        start = new JRadioButton("Start");
        start.setBounds(32, 128, 192, 20);
        goal = new JRadioButton("Goal");
        goal.setBounds(32, 148, 192, 20);
        wall = new JRadioButton("Add / remove 'walls'");
        wall.setBounds(32, 168, 192, 20);
        weightButton = new JRadioButton();
        weightButton.setBounds(136, 232, 32, 32);
        ButtonGroup bg = new ButtonGroup();
        bg.add(start);
        bg.add(goal);
        bg.add(wall);
        bg.add(weightButton);
        add(start);
        add(goal);
        add(wall);
        add(weightButton);
    }
    
    private void weightSetter(){
        this.weightText = new JTextField("weight here");
        weightText.setBounds(32, 232, 96, 32);
        add(weightText);
    }
    
    private void selectHeuristic(){
        this.setHeuristic = new JLabel("Set Heuristic:");
        setHeuristic.setFont(font);
        setHeuristic.setBounds(32, 288, 192, 32);
        add(setHeuristic);
        
        this.manhattan = new JRadioButton("Manhattan");
        manhattan.setBounds(32, 320, 192, 20);
        this.euclidean = new JRadioButton("Euclidean");
        euclidean.setBounds(32, 340, 192, 20);
        this.octile = new JRadioButton("Octile");
        octile.setBounds(32, 360, 192, 20);
        this.chebyshev = new JRadioButton("Chebyshev");
        chebyshev.setBounds(32, 380, 192, 20);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(manhattan);
        bg.add(euclidean);
        bg.add(octile);
        bg.add(chebyshev);
        add(manhattan);
        add(euclidean);
        add(octile);
        add(chebyshev);
    }
    
    private void allowDiagonal(){
        this.allow = new JLabel("Allow Diagonal:");
        allow.setFont(font);
        allow.setBounds(32, 416, 192, 32);
        add(allow);
        
        this.yes = new JRadioButton("Yes");
        yes.setBounds(32, 448, 96, 32);
        this.no = new JRadioButton("No");
        no.setBounds(128, 448, 96, 32);
        no.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);
        add(yes);
        add(no);
    }
    
    private void setButtons(){
        this.simulate = new JButton("Simulate");
        simulate.setFont(font);
        simulate.setBounds(32, 496, 196, 32);
        add(simulate);
        this.clear = new JButton("Clear");
        clear.setBounds(48, 544, 64, 32);
        add(clear);
        this.fill = new JButton("Fill");
        fill.setBounds(144, 544, 64, 32);
        add(fill);
        this.back = new JButton("Return");
        back.setBounds(32, 592, 96, 32);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.white);
        add(back);
        this.help = new JButton("?");
        help.setFont(font);
        help.setBounds(144, 592, 64, 32);
        help.setBackground(Color.DARK_GRAY);
        help.setForeground(Color.white);
        add(help);
    }
    
    private void setListener(){
        jcb.addActionListener(sml);
        simulate.addActionListener(sml);
        clear.addActionListener(sml);
        fill.addActionListener(sml);
        back.addActionListener(sml);
        help.addActionListener(sml);
    }

    public JRadioButton getStart() {
        return start;
    }

    public JRadioButton getGoal() {
        return goal;
    }

    public JRadioButton getWall() {
        return wall;
    }

    public JRadioButton getWeightButton() {
        return weightButton;
    }

    public JRadioButton getManhattan() {
        return manhattan;
    }

    public JRadioButton getEuclidean() {
        return euclidean;
    }

    public JRadioButton getOctile() {
        return octile;
    }

    public JRadioButton getChebyshev() {
        return chebyshev;
    }

    public JTextField getWeightText() {
        return weightText;
    }
}
