package datastructures;

/**
 * Objects of this class represent the vertices of the graph that is being
 * analysed.
 *
 * @author eerop
 */
public class Vertex implements Comparable<Vertex> {

    private int x, y, weight, distance;
    private double heuristic;
    private String state;

    /**
     * Constructor that is used to create a vertex without weight or heuristic
     * value.
     *
     * @param x x coordinate of this vertex
     * @param y y coordinate of this vertex
     */
    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = 0;
        this.state = "w";
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
        if ((this.heuristic + this.distance) < (v.heuristic + v.distance)) {
            return -1;
        } else {
            return 1;
        }
    }

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

    public String getState() {
        return state;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setState(String state) {
        this.state = state;
    }
}
