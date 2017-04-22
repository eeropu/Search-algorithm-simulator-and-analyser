/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eerop
 */
public class HeapTest {

    private Heap h;
    private Vertex v, w, x;

    public HeapTest() {
        this.h = new Heap();
        v = new Vertex(0, 0);
        v.setDistance(1);
        w = new Vertex(1, 1);
        w.setDistance(2);
        x = new Vertex(2, 2);
        x.setDistance(0);
    }

    @Test
    public void insertTest() {
        Vertex[] array = h.getArray();
        Vertex[] comp = new Vertex[10000];
        assertArrayEquals(array, comp);
        assertEquals(1, h.getIngex());
        h.insert(v);
        comp[1] = v;
        assertArrayEquals(array, comp);
        assertEquals(2, h.getIngex());
        h.insert(w);
        comp[2] = w;
        assertArrayEquals(array, comp);
        assertEquals(3, h.getIngex());
        h.insert(x);
        comp[1] = x;
        comp[3] = v;
        assertArrayEquals(array, comp);
        assertEquals(4, h.getIngex());
    }

    @Test
    public void delMinTest() {
        h.insert(v);
        h.insert(w);
        h.insert(x);
        assertEquals(x, h.delMin());
        assertEquals(v, h.delMin());
        assertEquals(w, h.delMin());
    }

    @Test
    public void heapifyTest() {
        h.getArray()[1] = w;
        h.getArray()[2] = v;
        h.heapify(1);
        assertEquals(h.getArray()[1], v);
        assertEquals(h.getArray()[2], w);
        h.heapify(1);
        assertEquals(h.getArray()[1], v);
        assertEquals(h.getArray()[2], w);
        h.getArray()[3] = x;
        h.heapify(1);
        assertEquals(h.getArray()[1], x);
        assertEquals(h.getArray()[2], w);
        assertEquals(h.getArray()[3], v);
        h.getArray()[1] = w;
        h.getArray()[2] = x;
        h.heapify(1);
        assertEquals(h.getArray()[1], x);
        assertEquals(h.getArray()[2], w);
        assertEquals(h.getArray()[3], v);
        h.getArray()[1] = v;
        h.getArray()[2] = null;
        h.getArray()[3] = x;
        h.heapify(1);
        assertEquals(h.getArray()[1], x);
        assertEquals(h.getArray()[2], null);
        assertEquals(h.getArray()[3], v);
    }
    
    @Test
    public void isEmptyTest(){
        assertTrue(h.isEmpty());
        h.insert(v);
        assertFalse(h.isEmpty());
        h.delMin();
        assertTrue(h.isEmpty());
    }

}
