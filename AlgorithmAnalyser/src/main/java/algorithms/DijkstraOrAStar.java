package algorithms;

import datastructures.Heap;
import datastructures.Vertex;

/**
 * This class is used to run a Dijkstra's algorithm or a A*-algorithm. If before
 * using this class the Grid's vertices has only been initialized with weights,
 * it will lead to Dijkstra's algorithm, but if they have also been initialized
 * with heuristics, it will lead to A*-algorithm.
 *
 * @author eerop
 */
public class DijkstraOrAStar extends AlgorithmBase {

    private Heap h;
    private boolean ready;

    /**
     * Constructor for this class.
     *
     * @param current the start-vertex of the given Grid.
     */
    public DijkstraOrAStar(Vertex current) {
        this.current = current;
        this.h = new Heap();
        h.insert(current);
        ready = false;
    }

    @Override
    public void run() {
        Vertex a = current.getNeighbour();
        if (a == null) {
            return;
        }
        double i = 1;
        if (a.getX() != current.getX() && a.getY() != current.getY()) {
            i = Math.sqrt(2);
        }
        if (a.getMode() == 'w') {
            a.setMode('g');
            a.refresh();
            a.setPrev(current);
            if (a.getWeight() >= 0) {
                a.setDistance(current.getDistance() + i * a.getWeight());
            } else {
                a.setDistance(current.getDistance() + i);
            }
            h.insert(a);
        } else if (a.getMode() == 'g') {
            if (a.getWeight() >= 0 && a.getDistance() > current.getDistance() + i * a.getWeight()) {
                a.setPrev(current);
                a.setDistance(current.getDistance() + i * a.getWeight());
                h.insert(a);
            } else if (a.getWeight() < 0 && a.getDistance() > current.getDistance() + i) {
                a.setPrev(current);
                a.setDistance(current.getDistance() + i);
                h.insert(a);
            }
        } else if (a.getMode() == 'f') {
            if (f == null) {
                this.f = a;
                a.setPrev(current);
                if (a.getWeight() >= 0) {
                    a.setDistance(current.getDistance() + i * a.getWeight());
                } else {
                    a.setDistance(current.getDistance() + i);
                }
                h.insert(a);
            } else if (a.getWeight() >= 0 && a.getDistance() > current.getDistance() + i * a.getWeight()) {
                a.setDistance(current.getDistance() + i * a.getWeight());
                a.setPrev(current);
                h.insert(a);
            } else if (a.getWeight() < 0 && a.getDistance() > current.getDistance() + i) {
                a.setDistance(current.getDistance() + i);
                a.setPrev(current);
                h.insert(a);
            }
        }
    }

    @Override
    public void next() {
        current.setMode('d');
        current.refresh();
        while (current.getMode() == 'd') {
            current = h.delMin();
        }
        if (current.getMode() == 'f') {
            ready = true;
        }
    }

    @Override
    public boolean done() {
        return h.isEmpty() || ready;
    }

}
