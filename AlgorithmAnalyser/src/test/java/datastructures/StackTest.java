package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eerop
 */
public class StackTest {
    
    private Stack s;
    
    public StackTest() {
    }
    
    @Before
    public void setUp() {
        this.s = new Stack();
    }
    
    @Test
    public void constructor(){
        assertEquals(0, s.getTop());
        Assert.assertArrayEquals(new Vertex[10000], s.getArray());
    }
    
    @Test
    public void push(){
        Vertex v = new Vertex(1, 1);
        s.push(v);
        assertEquals(1, s.getTop());
        Vertex[] test = s.getArray();
        assertEquals(v, test[0]);
    }
    
    @Test
    public void pop(){
        Vertex v = new Vertex(1, 1);
        s.push(v);
        Vertex c = s.pop();
        assertEquals(v, c);
        assertEquals(0, s.getTop());
    }
    
    @Test
    public void isEmpty(){
        Vertex v = new Vertex(1, 1);
        s.push(v);
        assertFalse(s.isEmpty());
        s.pop();
        assertTrue(s.isEmpty());
    }

}
