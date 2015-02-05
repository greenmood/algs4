import java.lang.Exception.*;
import java.util.ArrayList;
import java.util.List;

public class Percolation {
    private boolean[][] grid;
    private List<Cell> cells = new ArrayList<Cell>();
    public Percolation(int N){
        if (N <= 0){
            throw new java.lang.IllegalArgumentException(Integer.toString(N));
        }
        grid = new boolean[N][N];

        for (int i = 0; i<N; i++){
            for (int j = 0;j<N; j++){
                grid[i][j] = false;
                Cell cell = new Cell();
                cell.x = i;
                cell.y = j;
                cells.add(cell);
            }
        }
    }

    public void open(int i, int j){
        if (i > this.grid.length || j > this.grid.length ||
                this.grid.length < 1 || this.grid.length < 1){
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (grid[i][j] != true){
            grid[i][j] = true;
        }
    }

    public boolean isOpen(int i, int j){
        if (i > this.grid.length || j > this.grid.length ||
                this.grid.length < 1 || this.grid.length < 1){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return grid[i][j] == true;
    }

    public boolean isFull(int i, int j){
        return !this.isOpen(i,j);
    }

    public boolean percolates(){
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){

            }
        }
        return false;
    }

    public static void main(String[] args){
        Percolation perc = new Percolation(10);
    }
}