package ui.testresultwindow;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author eerop
 */
public class LoadingScreen extends JPanel{
     
    private final JLabel wait, running;
    private Timer t;
    
    public LoadingScreen(){
        setLayout(null);
        this.wait = new JLabel("Please wait,");
        this.running = new JLabel("The algorithms are running...");
        setLocations();
        setFonts();
        add(wait);
        add(running);
        start();
    }
    
    private void setLocations(){
        wait.setBounds(160, 96, 320, 96);
        running.setBounds(128, 224, 640, 64);
    }
    
    private void setFonts(){
        wait.setFont(new Font("Verdana", Font.BOLD, 35));
        running.setFont(new Font("Verdana", Font.BOLD, 30));
    }
    
    private void start(){
        this.t = new Timer(500, (ActionEvent e) -> {
            changeRunning();
        });
        t.start();
    }
    
    private void changeRunning(){
        switch (running.getText()) {
            case "The algorithms are running...":
                running.setText("The algorithms are running");
                break;
            case "The algorithms are running":
                running.setText("The algorithms are running.");
                break;
            case "The algorithms are running.":
                running.setText("The algorithms are running..");
                break;
            case "The algorithms are running..":
                running.setText("The algorithms are running...");
                break;
        }
    }
}
