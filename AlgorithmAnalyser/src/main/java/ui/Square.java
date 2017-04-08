package ui;

import datastructures.Vertex;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author eerop
 */
public class Square extends JLabel {

    private int x, y, size;
    private Vertex v;

    public Square(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.v = new Vertex(x, y);
        v.setS(this);
        setBounds(x * (size + 1), y * (size + 1), size, size);
        setBackground(Color.white);
        setOpaque(true);
    }
    
    public void setV(Vertex v){
        this.v = v;
        v.setS(this);
    }

    public Vertex getV() {
        return v;
    }
    
    public void refresh(){
        if(v.getMode() == 'w'){
            setBackground(Color.white);
        } else if (v.getMode() == 'b'){
            setBackground(Color.black);
        } else if (v.getMode() == 'g'){
            setBackground(Color.lightGray);
        } else if (v.getMode() == 's'){
            setBackground(Color.green);
        } else if (v.getMode() == 'f'){
            setBackground(Color.red);
        } else if (v.getMode() == 'd'){
            setBackground(Color.darkGray);
        } else if (v.getMode() == 'r'){
            setBackground(Color.cyan);
        }
        
    } 
}
