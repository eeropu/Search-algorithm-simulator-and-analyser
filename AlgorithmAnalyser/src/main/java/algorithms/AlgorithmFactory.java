package algorithms;

import datastructures.Vertex;

/**
 * Used to fetch new instances of the algorithms.
 *
 * @author eerop
 */
public class AlgorithmFactory {

    private final Vertex v;

    /**
     * Basic constructor for this class.
     *
     * @param v staring vertex
     */
    public AlgorithmFactory(Vertex v) {
        this.v = v;
    }

    /**
     * Used to get an Astar algorithm.
     *
     * @return new instance of Astar
     */
    public DijkstraOrAStar getAstar() {
        return new DijkstraOrAStar(v);
    }

    /**
     * Used to get a dijkstra's algorithm.
     *
     * @return new instance of dijkstra
     */
    public DijkstraOrAStar getDijkstra() {
        return new DijkstraOrAStar(v);
    }

    /**
     * Used to get a BestFirstalgorithm.
     *
     * @return new instance of BestFirstSearch.
     */
    public BestFirstSearch getBestFirst() {
        return new BestFirstSearch(v);
    }

    /**
     * Used to get a BFS.
     *
     * @return a new BFS-algorithm.
     */
    public BreadthFirstSearch getBFS() {
        return new BreadthFirstSearch(v);
    }

    /**
     * Used to get a DFS.
     *
     * @return new DFS-algorithm.
     */
    public DepthFirstSearch getDFS() {
        return new DepthFirstSearch(v);
    }
}
