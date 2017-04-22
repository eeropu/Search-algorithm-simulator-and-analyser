package algorithms;

import datastructures.Heap;
import datastructures.Vertex;

/**
 * This class is used to run a Best-First-Search.
 *
 * @author eerop
 */
public class BestFirstSearch extends AlgorithmBase {

    private final Heap h;
    private boolean ready;

    /**
     * Constructor for this class.
     *
     * @param current the start-vertex of the given Grid.
     */
    public BestFirstSearch(Vertex current) {
        h = new Heap();
        h.insert(current);
        this.current = current;
        this.ready = false;
    }

    @Override
    public void run() {
        Vertex a = current.getNeighbour();
        if (a == null) {
            return;
        }
        if (a.getMode() == 'w') {
            h.insert(a);
            a.setMode('g');
            a.refresh();
            a.setPrev(current);
        } else if (a.getMode() == 'f') {
            a.setPrev(current);
            this.f = a;
            this.ready = true;
        }
    }

    @Override
    public void next() {
        current.setMode('d');
        current.refresh();
        current = h.delMin();
    }

    @Override
    public boolean done() {
        return h.isEmpty() || ready;
    }

}
