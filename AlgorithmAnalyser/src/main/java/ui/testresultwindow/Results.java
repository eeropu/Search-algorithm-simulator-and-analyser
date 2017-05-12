package ui.testresultwindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eerop
 */
public class Results extends JPanel {

    private String[] strings;
    private int[] heights;

    public Results(String... strings) {
        setLayout(null);
        this.strings = strings;
        heights = new int[12];
        listResults();
        drawDiagram();
    }

    private void listResults() {
        Font f = new Font("Verdana", Font.BOLD, 20);
        int y = 32;

        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("")) {
                JLabel l = null;
                if (i % 2 == 0) {
                    l = new JLabel(strings[i] + ":");
                    l.setBounds(32, y, 256, 32);
                } else {
                    l = new JLabel(strings[i] + "ms");
                    l.setBounds(288, y, 160, 32);
                    y += 32;
                }
                l.setFont(f);
                add(l);
            }
        }
    }

    private void drawDiagram() {
        Font font = new Font("Verdana", Font.BOLD, 10);
        for (int i = 0; i < strings.length; i += 2) {
            if (!strings[i].equals("")) {
                JLabel l = new JLabel(strings[i]);
                l.setBounds(448 + i * 32, 480, 32, 32);
                l.setFont(font);
                add(l);

                int h = Integer.parseInt(strings[i + 1]);
                h /= 10;
                heights[i / 2] = h;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        for (int i = 0; i < heights.length; i++) {
            g.fillRect(448 + i * 32 * 2 + 6, 448 - heights[i], 20, heights[i]);
        }
    }

}
