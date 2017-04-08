package algorithms;

import datastructures.Stack;
import datastructures.Vertex;
import javax.swing.JOptionPane;

/**
 *
 * @author eerop
 */
public class DepthFirstSearch {

    private Vertex f;

    public void run(Vertex v) {
        Stack s = new Stack();
        s.push(v);
        while (!s.isEmpty()) {
            Vertex x = s.pop();
            while (true) {
                Vertex a = x.getNeighbour();
                if (a == null) {
                    break;
                }
                if (a.getMode() == 'w') {
                    s.push(a);
                    a.setMode('g');
                    a.refresh();
                    a.setPrev(x);
                    a.setDistance(x.getDistance() + 1);
                } else if (a.getMode() == 'd') {
                    if (x.getDistance() + 1 < a.getDistance()) {
                        a.setDistance(x.getDistance() + 1);
                        a.setPrev(x);
                    }
                } else if (a.getMode() == 'f') {
                    if (this.f == null) {
                        this.f = a;
                        a.setPrev(x);
                        a.setDistance(x.getDistance() + 1);
                    } else if (x.getDistance() + 1 < a.getDistance()){
                        a.setPrev(x);
                        a.setDistance(x.getDistance() + 1);
                    }
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
