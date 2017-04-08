package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.listeners.SquareListener;

/**
 *
 * @author eerop
 */
public class Grid extends JPanel {

    private int size;
    private Square[][] squares;
    private SquareListener sl;

    public Grid() {
        setPreferredSize(new Dimension(960, 640));
        setBounds(0, 0, 960, 640);
        setLayout(null);
        setBackground(Color.black);
        this.size = 30;
        squares = new Square[size][20];
    }

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

    public Square[][] getSquares() {
        return squares;
    }

    public void initializeGrid(SquareListener sl) {
        this.sl = sl;
        setSquares();
    }

    public void initializeSquares() {
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

    public void initializeSquaresWithDiagonals() {
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

    public Square getStart() {
        Square s = null;
        for (Square[] square : squares) {
            for (Square square1 : square) {
                if (square1.getV().getMode() == 's') {
                    s = square1;
                }
            }
        }
        return s;
    }

}
