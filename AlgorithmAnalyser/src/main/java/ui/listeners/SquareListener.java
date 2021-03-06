package ui.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ui.SubMenu;
import ui.Square;

/**
 * This class makes modifying the grid possible by giving functionality for the
 * squares.
 *
 * @author eerop
 */
public class SquareListener implements MouseListener {

    volatile private boolean isRunning, mousedown;
    private char mode;
    private SubMenu sm;
    private Square start, goal;

    /**
     * Constructor for this class.
     *
     * @param sm Simulation menu.
     */
    public SquareListener(SubMenu sm) {
        this.sm = sm;
        isRunning = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Square s = (Square) e.getSource();
        if (sm.getWall().isSelected()) {
            changeSquareMode(s);
        } else if (sm.getStart().isSelected()) {
            if (start != null && start.getV().getMode() == 's') {
                start.getV().setMode('w');
                start.refresh();
            }
            s.getV().setMode('s');
            s.refresh();
            start = s;
        } else if (sm.getGoal().isSelected()) {
            if (goal != null && goal.getV().getMode() == 'f') {
                goal.getV().setMode('w');
                goal.refresh();
            }
            s.getV().setMode('f');
            s.refresh();
            goal = s;
        } else if (sm.getWeightButton().isSelected()) {
            s.getV().setMode('w');
            s.refresh();
            s.setText(sm.getWeightText().getText());
            s.setForeground(Color.black);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && sm.getWall().isSelected()) {
            mousedown = true;
            Square s = (Square) e.getSource();
            mode = s.getV().getMode();
            changeSquareMode(s);
            initThread();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            mousedown = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (isRunning) {
            Square s = (Square) e.getSource();
            changeSquareMode(s);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private synchronized boolean checkAndMark() {
        if (isRunning) {
            return false;
        }
        isRunning = true;
        return true;
    }

    private void initThread() {
        if (checkAndMark()) {
            new Thread() {
                @Override
                public void run() {
                    do {
                        isRunning = true;
                    } while (mousedown);
                    isRunning = false;
                }
            }.start();
        }
    }

    private void changeSquareMode(Square s) {
        if (mode == 'w') {
            s.getV().setMode('b');
        } else if (mode == 'b') {
            s.getV().setMode('w');
        }
        s.refresh();
    }

    public void setStart(Square start) {
        this.start = start;
    }

    public void setGoal(Square goal) {
        this.goal = goal;
    }

    public Square getStart() {
        return start;
    }

    public Square getGoal() {
        return goal;
    }

}
