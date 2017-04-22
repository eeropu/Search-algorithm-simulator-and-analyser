package datastructures;

/**
 * The Stack datastructure that uses the first in last out principle.
 *
 * @author eerop
 */
public class Stack {

    private int top;
    private Vertex[] array;

    /**
     * Basic constructor that creates the Stack.
     */
    public Stack() {
        this.top = 0;
        this.array = new Vertex[10000];
    }

    /**
     * Adds a new object on the top of the Stack.
     *
     * @param v the object that is being added
     */
    public void push(Vertex v) {
        array[top] = v;
        top++;
    }

    /**
     * Returns the Object on top of the Stack.
     *
     * @return a Vertex on top of the Stack
     */
    public Vertex pop() {
        top--;
        return array[top];
    }

    /**
     * This method is used to find out if the stack is empty.
     *
     * @return true if empty otherwise false
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /*
     Following classes are only used for tests
     */
    /**
     * Only for tests.
     *
     * @return the top index.
     */
    protected int getTop() {
        return top;
    }

    /**
     * Only for tests.
     *
     * @return the array.
     */
    protected Vertex[] getArray() {
        return array;
    }
}
