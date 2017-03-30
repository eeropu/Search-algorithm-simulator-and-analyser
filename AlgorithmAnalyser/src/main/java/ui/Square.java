package ui;

import datastructures.Vertex;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author eerop
 */
public class Square extends JLabel {

    private int x, y, size;
    private Vertex v;

    public Square(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        setBounds(x * (size + 1), y * (size + 1), size, size);
        setBackground(Color.white);
        setOpaque(true);
    }

    public Vertex getV() {
        return v;
    }
}
