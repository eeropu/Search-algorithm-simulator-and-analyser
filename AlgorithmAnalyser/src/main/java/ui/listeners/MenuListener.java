package ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import ui.Grid;
import ui.WindowHandler;

/**
 *
 * @author eerop
 */
public class MenuListener implements ActionListener {

    private final Grid grid;
    private final WindowHandler wh;
    private JButton simulate, speedtest, resize;
    private JComboBox<String> dropdown;

    public MenuListener(Grid grid, WindowHandler wh) {
        this.grid = grid;
        this.wh = wh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resize) {
            grid.resize(Integer.parseInt((String)dropdown.getSelectedItem()));
            grid.repaint();
        } else if(e.getSource() == simulate){
            wh.simulation();
        }
    }

    public void setButtons(JButton simulate, JButton speedtest, JButton resize) {
        this.simulate = simulate;
        this.speedtest = speedtest;
        this.resize = resize;
    }

    public void setDropdown(JComboBox<String> dropdown) {
        this.dropdown = dropdown;
    }

}
