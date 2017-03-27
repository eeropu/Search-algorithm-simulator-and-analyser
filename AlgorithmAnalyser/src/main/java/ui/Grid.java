package ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eerop
 */
public class Grid extends JPanel {

    private int size;
    private JLabel[][] squares;

    public Grid() {
        setPreferredSize(new Dimension(960, 640));
        setBounds(0, 0, 960, 640);
        setLayout(null);
        setBackground(Color.black);
        this.size = 30;
        squares = new JLabel[size][20];
        setSquares();
    }

    public void resize(int x) {
        if (x < 15) {
            x = 15;
        } else if (x > 90) {
            x = 90;
        }
        while (x % 1.5 != 0) {
            x++;
        }
        size = x;
        x = (int) (size / 1.5);
        squares = new JLabel[size][x];
        setSquares();
    }

    private void setSquares() {
        int x = (int) (size / 1.5);
        int z = (int) (960 / size - 1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < x; j++) {
                squares[i][j] = new Square(i, j, z);
            }
        }
        for (JLabel[] square : squares) {
            for (JLabel square1 : square) {
                add(square1);
            }
        }
    }

}
