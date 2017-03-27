package ui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eerop
 */
public class Menu extends JPanel{
    
    private JButton simulate, speedtest, resize;
    private JComboBox<String> dropdown;
    private Font font;

    public Menu() {
        setLayout(null);
        setPreferredSize(new Dimension(256, 640));
        font = new Font("Verdana", Font.BOLD, 20);
        setButtons();
        setDropdown();
    }
    
    private void setButtons(){
        this.simulate = new JButton("Simulate");
        simulate.setBounds(32, 160, 192, 32);
        simulate.setFont(font);
        this.speedtest = new JButton("Speedtest");
        speedtest.setBounds(32, 224,192, 32);
        speedtest.setFont(font);
        add(simulate);
        add(speedtest);
    }
    
    private void setDropdown(){
        JLabel label = new JLabel("Set size:");
        label.setBounds(32, 288, 192, 32);
        label.setFont(font);
        add(label);
        this.dropdown = new JComboBox(choises());
        dropdown.setVisible(true);
        dropdown.setBounds(32, 320, 192, 32);
        dropdown.setFont(font);
        this.resize = new JButton("Resize");
        resize.setBounds(64, 384, 128, 32);
        resize.setFont(font);
        add(dropdown);
        add(resize);
    }
    
    private String[] choises(){
        String[] r = new String[26];
        for (int i = 0; i < 26; i++) {
            r[i] = "" + (15 + (i*3));
        }
        return r;
    }
}
