package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eerop
 */
public class QueueTest {
    
    private Queue q;
    
    public QueueTest() {
    }
    
    @Before
    public void setUp() {
        this.q = new Queue();
    }
    
    @Test
    public void constructor(){
        assertEquals(0, q.getHead());
        assertEquals(0, q.getTail());
        Assert.assertArrayEquals(new Vertex[10000], q.getArray());
    }
    
    @Test
    public void enqueue(){
        Vertex v = new Vertex(1, 1);
        q.enqueue(v);
        assertEquals(1, q.getHead());
        Vertex[] test = q.getArray();
        assertEquals(test[0], v);
    }
    
    @Test
    public void dequeue(){
        Vertex v = new Vertex(1, 1);
        q.enqueue(v);
        Vertex c = q.dequeue();
        assertEquals(1, q.getTail());
        assertEquals(v, c);
    }
    
    @Test
    public void isEmpty(){
        Vertex v = new Vertex(1, 1);
        q.enqueue(v);
        assertFalse(q.isEmpty());
        q.dequeue();
        assertTrue(q.isEmpty());
    }

}
