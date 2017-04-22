package ui;

import datastructures.Vertex;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * This class represents a square in the grid.
 *
 * @author eerop
 */
public class Square extends JLabel {

    private int x, y, size;
    private Vertex v;

    /**
     * Constructor for this class.
     *
     * @param x coordinate for this square
     * @param y coordinate for this square
     * @param size the size of the square
     */
    public Square(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.v = new Vertex(x, y);
        v.setS(this);
        setBounds(x * (size + 1), y * (size + 1), size, size);
        setBackground(Color.white);
        setOpaque(true);
    }

    /**
     * Sets the vertex that this square represents in the Grid's graph.
     *
     * @param v a vertex
     */
    public void setV(Vertex v) {
        this.v = v;
        v.setS(this);
        if (this.getBackground() == Color.green) {
            v.setMode('s');
        } else if (this.getBackground() == Color.red) {
            v.setMode('f');
        } else if (this.getBackground() == Color.black) {
            v.setMode('b');
        }
    }

    public Vertex getV() {
        return v;
    }

    /**
     * Sets the color of this square depending on the mode of vertex v.
     */
    public void refresh() {
        if (v.getMode() == 'w') {
            setBackground(Color.white);
        } else if (v.getMode() == 'b') {
            setBackground(Color.black);
        } else if (v.getMode() == 'g') {
            setBackground(Color.lightGray);
        } else if (v.getMode() == 's') {
            setBackground(Color.green);
        } else if (v.getMode() == 'f') {
            setBackground(Color.red);
        } else if (v.getMode() == 'd') {
            setBackground(Color.darkGray);
        } else if (v.getMode() == 'r') {
            setBackground(Color.cyan);
        }
    }

    /**
     * Returns the value of x.
     *
     * @return x coordinate
     */
    public int getXcoor() {
        return x;
    }

    /**
     * Returns the value of y.
     *
     * @return y coordinate
     */
    public int getYcoor() {
        return y;
    }
}
