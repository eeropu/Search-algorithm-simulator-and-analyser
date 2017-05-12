package algorithms;

/**
 * All search algorithms will implement this interface.
 *
 * @author eerop
 */
public interface Algorithm {

    /**
     * This method will paint the founded route from start vertex to goal by
     * changing the mode of the route's vertices. After running this method, if
     * the route is found, calling the repaint method of the Grid will higlight
     * the route.
     */
    void getRoute();

    /**
     * This method contains the main functionality of the algorithm.
     */
    void run();

    /**
     * This method fetches the next vertex to be used from the algorithms
     * datastructure (Stack, Queue or Heap).
     */
    void next();

    /**
     * This method tells if all of the neighbours of the vertex currently being
     * examined has been checked.
     *
     * @return true if all the neighbours has been examined, else false.
     */
    boolean currentReady();

    /**
     * This method tells if the algorithm has finished it progression. (the
     * datastructure being used to contain the vertices is empty or, for some
     * algorithms, the goal has been found.)
     *
     * @return true if ready, false if not
     */
    boolean done();

}
