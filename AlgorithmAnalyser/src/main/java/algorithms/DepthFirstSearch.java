package algorithms;

import datastructures.Stack;
import datastructures.Vertex;

/**
 * This class is used to run a Depth-First-Search.
 *
 * @author eerop
 */
public class DepthFirstSearch extends AlgorithmBase {

    private final Stack s;

    /**
     * Constructor for this class.
     *
     * @param v the start-vertex of the given Grid.
     */
    public DepthFirstSearch(Vertex v) {
        s = new Stack();
        this.current = v;
    }

    @Override
    public void run() {
        Vertex a = current.getNeighbour();
        if (a == null) {
            return;
        }
        if (a.getMode() == 'w') {
            s.push(a);
            a.setMode('g');
            a.refresh();
            a.setPrev(current);
            a.setDistance(current.getDistance() + 1);
        } else if (a.getMode() == 'f') {
            if (this.f == null) {
                this.f = a;
                a.setPrev(current);
                a.setDistance(current.getDistance() + 1);
            } else if (current.getDistance() < a.getDistance()) {
                a.setPrev(current);
                a.setDistance(current.getDistance() + 1);
            }
        } else {
            if (current.getDistance() < a.getDistance()) {
                a.setDistance(current.getDistance() + 1);
                a.setPrev(current);
            }
        }
    }

    @Override
    public void next() {
        current.setMode('d');
        current.refresh();
        current = s.pop();
    }

    @Override
    public boolean done() {
        return s.isEmpty();
    }
}
