package algorithms;

import datastructures.Queue;
import datastructures.Vertex;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.Grid;

/**
 *
 * @author eerop
 */
public class BreadthFirstSearch {

    private Vertex f;

    public void run(Vertex v) {
        boolean done = false;
        Queue q = new Queue();
        q.enqueue(v);
        while (!q.isEmpty() && !done) {
            Vertex x = q.dequeue();
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BreadthFirstSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
                Vertex a = x.getNeighbour();
                if (a == null) {
                    break;
                }
                if (a.getMode() == 'w') {
                    q.enqueue(a);
                    a.setMode('g');
                    a.refresh();
                    a.setPrev(x);
                } else if (a.getMode() == 'f') {
                    a.setPrev(x);
                    this.f = a;
                    done = true;
                    break;
                }
            }
            x.setMode('d');
            x.refresh();
        }

    }

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
}
