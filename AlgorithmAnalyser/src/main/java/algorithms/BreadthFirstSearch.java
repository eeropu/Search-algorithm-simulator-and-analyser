package algorithms;

import datastructures.Queue;
import datastructures.Vertex;

/**
 * This class is used to run a Breadth-First-Search.
 *
 * @author eerop
 */
public class BreadthFirstSearch extends AlgorithmBase {

    private final Queue q;
    private boolean ready;

    /**
     * Constructor for this class.
     *
     * @param v the start-vertex of the given Grid.
     */
    public BreadthFirstSearch(Vertex v) {
        this.q = new Queue();
        this.current = v;
        q.enqueue(v);
        this.ready = false;
    }

    @Override
    public void run() {
        Vertex a = current.getNeighbour();
        if (a == null) {
            return;
        }
        if (a.getMode() == 'w') {
            q.enqueue(a);
            a.setMode('g');
            a.refresh();
            a.setPrev(current);
        } else if (a.getMode() == 'f') {
            a.setPrev(current);
            this.f = a;
            ready = true;
        }

    }

    @Override
    public void next() {
        current.setMode('d');
        current.refresh();
        this.current = q.dequeue();
    }

    @Override
    public boolean done() {
        return q.isEmpty() || ready;
    }
}
