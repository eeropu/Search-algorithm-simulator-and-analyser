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
import ui.listeners.SpeedTestWindowOpener;
import ui.listeners.SubMenuListener;

/**
 * This class is used to create the Simulation menu.
 *
 * @author eerop
 */
public class SubMenu extends JPanel {

    private JComboBox<String> jcb;
    private final Font font;
    private JLabel editGraph, addWeight, setHeuristic, allow;
    private JRadioButton start, goal, wall, weightButton;
    private JRadioButton manhattan, euclidean, octile, chebyshev;
    private JRadioButton yes, no;
    private JButton clear, fill, back, help;
    private JTextField weightText;
    private final SubMenuListener sml;
    private final SpeedTestWindowOpener stwo;
    private JButton activate;
    private JLabel speed;
    private JTextField speedSetter;

    /**
     * Constructor for this class.
     *
     * @param wh reference to the windowhandler
     * @param grid reference to the grid
     */
    public SubMenu(WindowHandler wh, Grid grid) {
        this.font = new Font("Verdana", Font.BOLD, 18);
        setLayout(null);
        setPreferredSize(new Dimension(256, 640));
        setComponents();
        this.sml = new SubMenuListener(jcb, addWeight, setHeuristic, start, goal, wall, weightButton, manhattan, euclidean, octile, chebyshev, yes, no, activate, clear, fill, back, help, weightText);
        this.stwo = new SpeedTestWindowOpener(activate, grid, yes);
        sml.setGrid(grid);
        sml.setWH(wh);
        setListener();
        setSpeed();
    }

    private void setComponents() {
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

    private String[] algorithms() {
        String[] r = new String[5];
        r[0] = "A*";
        r[1] = "Best-first-search";
        r[2] = "Breadth-first-search";
        r[3] = "Depth-first-search";
        r[4] = "Dijkstra";
        return r;
    }

    private void setLabels() {
        editGraph = new JLabel("Edit graph:");
        editGraph.setFont(font);
        editGraph.setBounds(32, 96, 192, 32);
        add(editGraph);
        addWeight = new JLabel("Add weights:");
        addWeight.setFont(font);
        addWeight.setBounds(32, 192, 192, 32);
        add(addWeight);
    }

    private void setRadioButtons() {
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

    private void weightSetter() {
        this.weightText = new JTextField("weight here");
        weightText.setBounds(32, 232, 96, 32);
        add(weightText);
    }

    private void selectHeuristic() {
        this.setHeuristic = new JLabel("Set Heuristic:");
        setHeuristic.setFont(font);
        setHeuristic.setBounds(32, 268, 192, 32);
        add(setHeuristic);

        this.manhattan = new JRadioButton("Manhattan");
        manhattan.setBounds(32, 300, 192, 20);
        this.euclidean = new JRadioButton("Euclidean");
        euclidean.setBounds(32, 320, 192, 20);
        this.octile = new JRadioButton("Octile");
        octile.setBounds(32, 340, 192, 20);
        this.chebyshev = new JRadioButton("Chebyshev");
        chebyshev.setBounds(32, 360, 192, 20);

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

    private void allowDiagonal() {
        this.allow = new JLabel("Allow Diagonal:");
        allow.setFont(font);
        allow.setBounds(32, 384, 192, 32);
        add(allow);

        this.yes = new JRadioButton("Yes");
        yes.setBounds(32, 412, 96, 32);
        this.no = new JRadioButton("No");
        no.setBounds(128, 412, 96, 32);
        no.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);
        add(yes);
        add(no);
    }

    private void setSpeed() {
        speed = new JLabel("Set speed:");
        speed.setFont(font);
        speed.setBounds(32, 448, 128, 32);
        add(speed);
        speedSetter = new JTextField("20");
        speedSetter.setBounds(160, 448, 64, 32);
        sml.setSpeedSetter(speedSetter);
        add(speedSetter);
    }

    private void setButtons() {
        this.activate = new JButton("Simulate");
        activate.setFont(font);
        activate.setBounds(32, 496, 196, 32);
        add(activate);
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

    private void setListener() {
        jcb.addActionListener(sml);
        clear.addActionListener(sml);
        fill.addActionListener(sml);
        back.addActionListener(sml);
        help.addActionListener(sml);
    }

    /**
     * Sets the components for simulationmenu.
     */
    public void simulationMenu() {
        add(jcb);
        add(setHeuristic);
        add(manhattan);
        add(euclidean);
        add(octile);
        add(chebyshev);
        add(speedSetter);
        add(speed);
        activate.setText("Simulate");
        activate.removeActionListener(stwo);
        activate.addActionListener(sml);
    }

    /**
     * Sets the components for speedtestmenu.
     */
    public void speedTestMenu() {
        remove(jcb);
        remove(setHeuristic);
        remove(manhattan);
        remove(euclidean);
        remove(octile);
        remove(chebyshev);
        remove(speedSetter);
        remove(speed);
        activate.setText("Run tests");
        activate.removeActionListener(sml);
        activate.addActionListener(stwo);
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
