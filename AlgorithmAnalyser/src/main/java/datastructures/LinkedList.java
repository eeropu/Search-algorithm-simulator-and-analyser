package datastructures;

/**
 * Linked list datastructure.
 *
 * @author eerop
 */
public class LinkedList {

    private Node header;

    /**
     * Constructor for this class.
     */
    public LinkedList() {
    }

    /**
     * This method is used to add a new vertex to the head of the list.
     *
     * @param s the vertex to be inserted
     */
    public void insert(Vertex s) {
        Node n = new Node(s);
        n.setNext(header);
        this.header = n;
    }

    /**
     * This method is used to get the first vertex in this list.
     *
     * @return a vertex.
     */
    public Vertex remove() {
        try {
            Vertex s = header.getS();
            this.header = header.next;
            return s;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Used to check if the List is empty.
     *
     * @return true if empty, else false.
     */
    public boolean isEmpty() {
        return header == null;
    }

    private class Node {

        private final Vertex s;
        private Node next;

        public Node(Vertex s) {
            this.s = s;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public Vertex getS() {
            return s;
        }

    }
}
