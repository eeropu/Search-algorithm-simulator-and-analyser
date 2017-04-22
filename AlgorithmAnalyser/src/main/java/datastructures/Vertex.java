package datastructures;

import ui.Square;

/**
 * Objects of this class represent the vertices of the graph that is being
 * analysed.
 *
 * @author eerop
 */
public class Vertex implements Comparable<Vertex> {

    private int x, y, weight, distance;
    private double heuristic;
    private char mode;
    private LinkedList neighbours;
    private Square s;
    private Vertex prev;

    /**
     * Constructor that is used to create a vertex without weight or heuristic
     * value.
     *
     * @param x x coordinate of this vertex
     * @param y y coordinate of this vertex
     */
    public Vertex(int x, int y) {
        this.neighbours = new LinkedList();
        this.x = x;
        this.y = y;
        this.distance = 0;
        this.mode = 'w';
        this.heuristic = 0;
    }

    /**
     * Constructor that is used to create a vertex with weights on the edges
     * leading to it but without heuristic value.
     *
     * @param x x coordinate of this vertex
     * @param y y coordinate of this vertex
     * @param weight weight on the edges leading to this vertex
     */
    public Vertex(int x, int y, int weight) {
        this(x, y);
        this.weight = weight;
    }

    /**
     * Constructor that is used to create a vertex without weight but with
     * heuristic value.
     *
     * @param x x coordinate of this vertex
     * @param y y coordinate of this vertex
     * @param h the heuristic funktion that is going to be used
     * @param goal the goal vertex
     */
    public Vertex(int x, int y, String h, Vertex goal) {
        this(x, y);

        double dx = Math.abs(this.x - goal.x);
        double dy = Math.abs(this.y - goal.y);

        switch (h) {
            case "manhattan":
                heuristic = dx + dy;
                break;
            case "euclidean":
                heuristic = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                break;
            case "octile":
                heuristic = (dx + dy) + ((Math.sqrt(2) - 2) * Math.min(dx, dy));
                break;
            case "chebyshev":
                heuristic = (dx + dy) - Math.min(dx, dy);
                break;
        }
    }

    /**
     * Constructor that is used to create a vertex with weight on the edges
     * leading to it and heuristic value.
     *
     * @param x x coordinate of this vertex
     * @param y y coordinate of this vertex
     * @param weight weight on the edges leading to this vertex
     * @param h the heuristic funktion that is going to be used
     * @param goal the goal vertex
     */
    public Vertex(int x, int y, int weight, String h, Vertex goal) {
        this(x, y, h, goal);
        this.weight = weight;
    }

    @Override
    public int compareTo(Vertex v) {
        try {
            if ((this.heuristic + this.distance) <= (v.getHeuristic() + v.getDistance())) {
                return -1;
            } else if (this == v) {
                return 0;
            } else {
                return 1;
            }
        } catch (NullPointerException e) {
            return 1;
        }
    }

    /**
     * Adds a new vertex to the neighbourslist.
     *
     * @param v the vertex to be added.
     */
    public void addNeighbour(Vertex v) {
        neighbours.insert(v);
    }

    /**
     * Returns and removes a vertex from the neighbourslist.
     *
     * @return a vertex
     */
    public Vertex getNeighbour() {
        return neighbours.remove();
    }

    /**
     * Used to know if all of the neighbourvertices has been removed.
     *
     * @return true if neighbourslist is empty, else false.
     */
    public boolean neighboursFinished() {
        return this.neighbours.isEmpty();
    }

    /**
     * Updates the UI's square's, that represents this vertex, color.
     */
    public void refresh() {
        s.refresh();
    }

    //Getters and Setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWeight() {
        return weight;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public int getDistance() {
        return distance;
    }

    public char getMode() {
        return mode;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setMode(char mode) {
        this.mode = mode;
    }

    public void setS(Square s) {
        this.s = s;
    }

    public void setPrev(Vertex v) {
        this.prev = v;
    }

    public Vertex getPrev() {
        return prev;
    }
}
