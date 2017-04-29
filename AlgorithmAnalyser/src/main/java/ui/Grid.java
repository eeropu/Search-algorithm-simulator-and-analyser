package ui;

import algorithms.Algorithm;
import datastructures.Vertex;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import ui.listeners.SquareListener;

/**
 * This class is used to represent the graph that is used with the search
 * algorithm. It works as a link between the graphs funktionality and the
 * userinterface.
 *
 * @author eerop
 */
public class Grid extends JPanel {

    private int size;
    private Square[][] squares;
    private SquareListener sl;
    private Timer timer;

    /**
     * Constructor for this class.
     */
    public Grid() {
        setPreferredSize(new Dimension(960, 640));
        setBounds(0, 0, 960, 640);
        setLayout(null);
        setBackground(Color.black);
        this.size = 30;
        squares = new Square[size][20];
    }

    /**
     * Changes the amount of squares in this grid.
     *
     * @param x the amount of squares vertically.
     */
    public void resize(int x) {
        size = x;
        x = (int) (size / 1.5);
        squares = new Square[size][x];
        setSquares();
    }

    private void setSquares() {
        removeAll();
        int x = (int) (size / 1.5);
        int z = (int) (960 / size - 1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < x; j++) {
                squares[i][j] = new Square(i, j, z);
            }
        }
        for (JLabel[] square : squares) {
            for (JLabel square1 : square) {
                square1.addMouseListener(sl);
                add(square1);
            }
        }
    }

    /**
     * Adds a heuristic value to the vertices.
     *
     * @param s tells the method which heuristic is going to be used.
     * @return false if there is no heuristic selected, else true
     */
    public boolean setHeauristics(String s) {
        if (s.equals("error")) {
            JOptionPane.showMessageDialog(this, "Select heuristic!", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Square finish = getStartOrFinish('f');
        Vertex finishVertex = new Vertex(finish.getXcoor(), finish.getYcoor());
        finish.setV(finishVertex);
        for (Square[] square : squares) {
            for (Square square1 : square) {
                if (square1 != finish) {
                    square1.setV(new Vertex(square1.getXcoor(), square1.getYcoor(), s, finishVertex));
                }
            }
        }
        return true;
    }

    /**
     * Sets weights to the vertices.
     */
    public void setWeights() {
        for (Square[] square : squares) {
            for (Square square1 : square) {
                try {
                    int i = Integer.parseInt(square1.getText());
                    square1.setV(new Vertex(square1.getXcoor(), square1.getYcoor(), i));
                } catch (NumberFormatException e) {
                    square1.setV(new Vertex(square1.getXcoor(), square1.getYcoor(), 1));
                }
            }
        }
    }

    /**
     * Sets weights and heuristics to the vertices.
     *
     * @param s tells the method which heuristic is going to be used.
     * @return false if there is no heuristic selected, else true
     */
    public boolean setWeightsAndHeuristics(String s) {
        if (s.equals("error")) {
            JOptionPane.showMessageDialog(this, "Select heuristic!", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Square finish = getStartOrFinish('f');
        Vertex finishVertex = new Vertex(finish.getXcoor(), finish.getYcoor(), 0, s, finish.getV());
        finish.setV(finishVertex);
        for (Square[] square : squares) {
            for (Square q : square) {
                int i = 1;
                try {
                    i = Integer.parseInt(q.getText());
                } catch (NumberFormatException e) {
                }
                if (q != finish) {
                    q.setV(new Vertex(q.getXcoor(), q.getYcoor(), i, s, finishVertex));
                }
            }
        }
        return true;
    }

    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Sets the SquareListener sl for this grid and passes it on for the
     * squares.
     *
     * @param sl squarelistener
     */
    public void initializeGrid(SquareListener sl) {
        this.sl = sl;
        setSquares();
    }

    private void initializeSquares() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (i != 0 && squares[i - 1][j].getV().getMode() != 'b') {
                    squares[i][j].getV().addNeighbour(squares[i - 1][j].getV());
                }
                if (i != squares.length - 1 && squares[i + 1][j].getV().getMode() != 'b') {
                    squares[i][j].getV().addNeighbour(squares[i + 1][j].getV());
                }
                if (j != 0 && squares[i][j - 1].getV().getMode() != 'b') {
                    squares[i][j].getV().addNeighbour(squares[i][j - 1].getV());
                }
                if (j != squares[i].length - 1 && squares[i][j + 1].getV().getMode() != 'b') {
                    squares[i][j].getV().addNeighbour(squares[i][j + 1].getV());
                }
            }
        }
    }

    private void initializeSquaresWithDiagonals() {
        initializeSquares();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (i != 0) {
                    if (j != 0 && squares[i - 1][j - 1].getV().getMode() != 'b') {
                        squares[i][j].getV().addNeighbour(squares[i - 1][j - 1].getV());
                    }
                    if (j != squares[i].length - 1 && squares[i - 1][j + 1].getV().getMode() != 'b') {
                        squares[i][j].getV().addNeighbour(squares[i - 1][j + 1].getV());
                    }
                }
                if (i != squares.length - 1) {
                    if (j != 0 && squares[i + 1][j - 1].getV().getMode() != 'b') {
                        squares[i][j].getV().addNeighbour(squares[i + 1][j - 1].getV());
                    }
                    if (j != squares[i].length - 1 && squares[i + 1][j + 1].getV().getMode() != 'b') {
                        squares[i][j].getV().addNeighbour(squares[i + 1][j + 1].getV());
                    }
                }
            }
        }
    }

    /**
     * Used to get the start or finish vertices of this graph.
     *
     * @param c tells which of the vertices is being fetched.
     * @return the startvertex if c = s and finish if c = f.
     */
    public Square getStartOrFinish(char c) {
        Square s = null;
        for (Square[] square : squares) {
            for (Square square1 : square) {
                if (square1.getV().getMode() == c) {
                    return square1;
                }
            }
        }
        return s;
    }

    /**
     * Runs a searchalgorithm for this graph.
     *
     * @param a the searchalgorithm being used.
     * @param diagonal tells if it is allowed to move diagonally in the grid.
     * @param i the speed that algorithm runs in milliseconds.
     */
    public void run(Algorithm a, boolean diagonal, int i) {
        if (diagonal) {
            initializeSquaresWithDiagonals();
        } else {
            initializeSquares();
        }
        timer = initializeSimulationTimer(a, i);
        timer.start();
    }

    private Timer initializeSimulationTimer(Algorithm a, int i) {
        return new Timer(i, (ActionEvent e) -> {
            if (a.currentReady()) {
                if (a.done()) {
                    a.getRoute();
                    stop();
                } else {
                    a.next();
                }
            }
            a.run();
            repaint();
        });
    }

    private void stop() {
        timer.stop();
    }

}
