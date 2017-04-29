package ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import ui.Grid;
import ui.WindowHandler;

/**
 * This class gives functionality for the Main menu.
 *
 * @author eerop
 */
public class MenuListener implements ActionListener {

    private final Grid grid;
    private final WindowHandler wh;
    private JButton simulate, speedtest, resize;
    private JComboBox<String> dropdown;

    /**
     * Constructor for this class.
     *
     * @param grid reference to the grid.
     * @param wh reference to the windowhandler.
     */
    public MenuListener(Grid grid, WindowHandler wh) {
        this.grid = grid;
        this.wh = wh;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resize) {
            grid.resize(Integer.parseInt((String) dropdown.getSelectedItem()));
            grid.repaint();
        } else if (e.getSource() == simulate) {
            wh.simulation();
        } else if (e.getSource() == speedtest) {
            wh.speedTest();
        }
    }

    /**
     * Sets the buttons.
     *
     * @param simulate button
     * @param speedtest button
     * @param resize button
     */
    public void setButtons(JButton simulate, JButton speedtest, JButton resize) {
        this.simulate = simulate;
        this.speedtest = speedtest;
        this.resize = resize;
    }

    public void setDropdown(JComboBox<String> dropdown) {
        this.dropdown = dropdown;
    }

}
