package algorithm.algorithmanalyser;

import javax.swing.SwingUtilities;
import ui.WindowHandler;

/**
 * Starts the program.
 *
 * @author eerop
 */
public class Main {

    /**
     * The programs main method that starts the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WindowHandler wh = new WindowHandler();
        SwingUtilities.invokeLater(wh);

    }

}
