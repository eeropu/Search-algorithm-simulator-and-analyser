/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;


import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.Square;

/**
 *
 * @author eerop
 */
public class VertexTest {
    
    private Vertex v;
    private Vertex help;
    
    public VertexTest() {
    }
    
    @Before
    public void setUp() {
        this.v = new Vertex(1, 1);
        this.help = new Vertex(4, 5);
    }
    
    @Test
    public void basicConstructor(){
        assertEquals(1, v.getX());
        assertEquals(1, v.getY());
        assertEquals(0, v.getDistance(), 0.1);
        assertEquals('w', v.getMode());
    }
    
    @Test
    public void weightedConstructor(){
        this.v = new Vertex(1, 1, 10);
        assertEquals(10, v.getWeight());
    }
    
    @Test
    public void heuristicConstructor(){
        this.v = new Vertex(1, 1, "manhattan", help);
        assertEquals(7, v.getHeuristic(), 0.1);
        this.v = new Vertex(1, 1, "euclidean", help);
        assertEquals(5, v.getHeuristic(), 0.1);
        this.v = new Vertex(1, 1, "octile", help);
        assertEquals(5.24264, v.getHeuristic(), 0.01);
        this.v = new Vertex(1, 1, "chebyshev", help);
        assertEquals(4, v.getHeuristic(), 0.1);
    }
    
    @Test
    public void weightedHeuristicConstructor(){
        this.v = new Vertex(1, 1, 10, "euclidean", help);
        assertEquals(10, v.getWeight());
    }
    
    @Test
    public void comparing(){
        assertEquals(-1, v.compareTo(help));
        Vertex goal = new Vertex(5, 4);
        v = new Vertex(1, 1, "euclidean", goal);
        help = new Vertex(4, 5, "euclidean", goal);
        assertEquals(1, v.compareTo(help));
        assertEquals(-1, help.compareTo(v));
        v.setDistance(-10);
        assertEquals(-1, v.compareTo(help));
        assertEquals(1, help.compareTo(v));
        assertEquals(-1, v.compareTo(v));
        assertEquals(1, v.compareTo(null));
    }
    
    @Test
    public void distanceSetter(){
        v.setDistance(1);
        assertEquals(1, v.getDistance(), 0.1);
    }
    
    @Test
    public void stateSetter(){
        v.setMode('g');
        assertEquals('g', v.getMode());
    }
    
    @Test
    public void neighbourlistTest(){
        assertTrue(v.neighboursFinished());
        v.addNeighbour(help);
        assertFalse(v.neighboursFinished());
        assertEquals(help, v.getNeighbour());
        assertTrue(v.neighboursFinished());
    }
    
    @Test
    public void refreshTest(){
        Square s = new Square(1, 1, 1);
        s.setV(v);
        assertEquals(Color.white, s.getBackground());
        v.setMode('g');
        v.refresh();
        assertEquals(Color.lightGray, s.getBackground());
    }
    
    @Test
    public void previousTest(){
        v.setPrev(help);
        assertEquals(help, v.getPrev());
    }
}
