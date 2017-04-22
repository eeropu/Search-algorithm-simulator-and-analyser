package datastructures;

/**
 * The queue datastructure that uses the first in first out principle.
 *
 * @author eerop
 */
public class Queue {

    private int head, tail;
    private Vertex[] array;

    /**
     * Basic constructor that creates the queue.
     */
    public Queue() {
        this.array = new Vertex[10000];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * This method is used to add objects to the queue.
     *
     * @param v the Vertex that is going to be added.
     */
    public void enqueue(Vertex v) {
        array[head] = v;
        head++;
    }

    /**
     * This method is used to get the first object in the queue.
     *
     * @return the first vertex in the queue
     */
    public Vertex dequeue() {
        Vertex r = array[tail];
        tail++;
        return r;
    }

    /**
     * This method is used to check if the queue is empty.
     *
     * @return true if empty otherwise false.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /*
     Following classes are only for tests!
     */
    /**
     * Only for tests.
     *
     * @return the heads index.
     */
    protected int getHead() {
        return head;
    }

    /**
     * Only for tests.
     *
     * @return the tails index.
     */
    protected int getTail() {
        return tail;
    }

    /**
     * Only for test.
     *
     * @return the array
     */
    protected Vertex[] getArray() {
        return array;
    }

}
