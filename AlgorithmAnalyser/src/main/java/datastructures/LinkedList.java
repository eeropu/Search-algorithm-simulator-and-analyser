package datastructures;

import ui.Square;

/**
 *
 * @author eerop
 */
public class LinkedList {

    private Node header;

    public LinkedList() {
    }

    public void insert(Vertex s) {
        Node n = new Node(s);
        n.setNext(header);
        this.header = n;
    }

    public Vertex remove() {
        try {
            Vertex s = header.getS();
            this.header = header.next;
            return s;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean isEmpty() {
        return header == null;
    }

    private class Node {

        private Vertex s;
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

        public Node getNext() {
            return next;
        }

    }
}
