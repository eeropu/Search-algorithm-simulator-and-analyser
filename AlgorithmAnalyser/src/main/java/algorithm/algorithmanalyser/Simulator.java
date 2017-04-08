package algorithm.algorithmanalyser;

import algorithms.BreadthFirstSearch;
import algorithms.DepthFirstSearch;
import ui.Grid;

/**
 *
 * @author eerop
 */
public class Simulator {
    
    private final Grid grid;

    public Simulator(Grid grid) {
        this.grid = grid;
    }
    
    public void bfs(boolean diagonal){
        initializeGrid(diagonal);
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.run(grid.getStart().getV());
        bfs.getRoute();
    }
    
    public void dfs(boolean diagonal){
        initializeGrid(diagonal);
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.run(grid.getStart().getV());
        dfs.getRoute();
    }
    
    public void initializeGrid(boolean diagonal){
        if(diagonal){
            grid.initializeSquaresWithDiagonals();
        } else {
            grid.initializeSquares();
        }
    }
}
