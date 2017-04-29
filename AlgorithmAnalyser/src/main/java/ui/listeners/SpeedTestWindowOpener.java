package ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import ui.testresultwindow.ResultsWindowHandler;

/**
 *
 * @author eerop
 */
public class SpeedTestWindowOpener implements ActionListener{
    
    private final JButton button;

    public SpeedTestWindowOpener(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            SwingUtilities.invokeLater(new ResultsWindowHandler());
        }
    }
    
}
