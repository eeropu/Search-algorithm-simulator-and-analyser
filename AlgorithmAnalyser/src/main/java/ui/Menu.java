package ui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.listeners.MenuListener;

/**
 * This class is used to create the main menu.
 *
 * @author eerop
 */
public class Menu extends JPanel {

    private JButton simulate, speedtest, resize;
    private JComboBox<String> dropdown;
    private Font font;
    private MenuListener ml;

    /**
     * Constructor for this class.
     *
     * @param ml Menulistener.
     */
    public Menu(MenuListener ml) {
        this.ml = ml;
        setLayout(null);
        setPreferredSize(new Dimension(256, 640));
        font = new Font("Verdana", Font.BOLD, 20);
        setButtons();
        setDropdown();
        ml.setButtons(simulate, speedtest, resize);
        ml.setDropdown(dropdown);
        simulate.addActionListener(ml);
        speedtest.addActionListener(ml);
        resize.addActionListener(ml);

        Font h = new Font("Verdana", Font.BOLD, 30);
        JLabel header1 = new JLabel("Algorithm-");
        header1.setFont(h);
        header1.setBounds(36, 32, 196, 64);
        add(header1);
        JLabel header2 = new JLabel("Analyser");
        header2.setFont(h);
        header2.setBounds(52, 70, 196, 64);
        add(header2);
    }

    private void setButtons() {
        this.simulate = new JButton("Simulate");
        simulate.setBounds(32, 192, 192, 32);
        simulate.setFont(font);
        this.speedtest = new JButton("Speedtest");
        speedtest.setBounds(32, 256, 192, 32);
        speedtest.setFont(font);
        add(simulate);
        add(speedtest);
    }

    private void setDropdown() {
        JLabel label = new JLabel("Set size:");
        label.setBounds(32, 320, 192, 32);
        label.setFont(font);
        add(label);
        this.dropdown = new JComboBox(choises());
        dropdown.setVisible(true);
        dropdown.setBounds(32, 352, 192, 32);
        dropdown.setFont(font);
        dropdown.setSelectedIndex(5);
        this.resize = new JButton("Resize");
        resize.setBounds(64, 416, 128, 32);
        resize.setFont(font);
        add(dropdown);
        add(resize);
    }

    private String[] choises() {
        String[] r = new String[26];
        for (int i = 0; i < 26; i++) {
            r[i] = "" + (15 + (i * 3));
        }
        return r;
    }
}
