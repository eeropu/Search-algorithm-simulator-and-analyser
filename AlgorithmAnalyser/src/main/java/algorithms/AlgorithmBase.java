package algorithms;

import datastructures.Vertex;
import javax.swing.JOptionPane;

/**
 * This class contains the implementations of the getRoute and currentReady
 * methods which are identical for all the searchalgorithms.
 *
 * @author eerop
 */
public abstract class AlgorithmBase implements Algorithm {

    protected Vertex f, current;

    @Override
    public void getRoute() {
        Vertex v = null;
        try {
            v = f.getPrev();
            while (true) {
                if (v.getPrev() == null) {
                    v.setMode('s');
                    v.refresh();
                    break;
                }
                v.setMode('r');
                v.refresh();
                v = v.getPrev();
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Could not find a route", "Search failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean currentReady() {
        return current.neighboursFinished();
    }

}
