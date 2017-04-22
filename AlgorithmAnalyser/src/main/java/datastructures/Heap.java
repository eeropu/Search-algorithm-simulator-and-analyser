package datastructures;

/**
 * Heap datastructure. Used to efficiently store vertices in a way that the
 * vertex with the smallest distance and heauristic values is easily retrieved.
 *
 * @author eerop
 */
public class Heap {

    private Vertex[] array;
    private int index;

    /**
     * Constructor for this class.
     */
    public Heap() {
        this.array = new Vertex[10000];
        this.index = 1;
    }

    /**
     * This method is used to insert a new Vertex to the correct position in the
     * heap.
     *
     * @param v The vertex to be inserted.
     */
    public void insert(Vertex v) {
        array[index] = v;
        int i = index;
        while (array[i].compareTo(array[i / 2]) == -1) {
            change(i, i / 2);
            i = i / 2;
        }
        index++;
    }

    /**
     * This method is used to get the Vertex with the smallest distance and
     * heuristic values in the heap.
     *
     * @return a vertex
     */
    public Vertex delMin() {
        index--;
        Vertex v = array[1];
        array[1] = array[index];
        array[index] = null;
        heapify(1);
        return v;
    }

    /**
     * This method is used to check if the heap is empty.
     *
     * @return true if empty, else false
     */
    public boolean isEmpty() {
        return index == 1;
    }

    /**
     * This method is used to move a vertex to a correct position in the heap.
     *
     * @param i the index of the vertex that is possibly going to be moved.
     */
    public void heapify(int i) {
        if (array[i * 2] != null && array[i * 2 + 1] != null) {
            if (array[i * 2].compareTo(array[i * 2 + 1]) == -1 && array[i].compareTo(array[i * 2]) == 1) {
                change(i, i * 2);
                heapify(i * 2);
            } else if (array[i * 2 + 1].compareTo(array[i * 2]) == -1 && array[i].compareTo(array[i * 2 + 1]) == 1) {
                change(i, i * 2 + 1);
                heapify(i * 2 + 1);
            }
        } else if (array[i * 2] != null && array[i].compareTo(array[i * 2]) == 1) {
            change(i, i * 2);
            heapify(i * 2);
        } else if (array[i * 2 + 1] != null && array[i].compareTo(array[i * 2 + 1]) == 1) {
            change(i, i * 2 + 1);
            heapify(i * 2 + 1);
        }
    }

    private void change(int i, int j) {
        Vertex v = array[i];
        array[i] = array[j];
        array[j] = v;
    }

    /**
     * Only for tests.
     *
     * @return Array of vertices
     */
    public Vertex[] getArray() {
        return array;
    }

    /**
     * Only for tests.
     *
     * @return current value of the index variable
     */
    public int getIngex() {
        return index;
    }
}
