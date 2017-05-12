package ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import ui.Grid;
import ui.testresultwindow.ResultsWindowHandler;

/**
 *
 * @author eerop
 */
public class SpeedTestWindowOpener implements ActionListener{
    
    private final JButton button;
    private final Grid grid;
    private final JRadioButton diagonal;

    public SpeedTestWindowOpener(JButton button, Grid grid, JRadioButton diagonal) {
        this.button = button;
        this.grid = grid;
        this.diagonal = diagonal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            SwingUtilities.invokeLater(new ResultsWindowHandler(grid, diagonal.isSelected()));
        }
    }
    
}
