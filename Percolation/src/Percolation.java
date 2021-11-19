import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    //virtual top and bottom
    private static final int TOP = 0;
    private final int bottom;

    //n by n grid
    private final boolean[][] grid;
    private final int size;

    //number of opened sites
    private int openedSites;

    private final WeightedQuickUnionUF qf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        //check exception
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        grid = new boolean[size][size];
        openedSites = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        //check exception
        checkException(row, col);

        //open a site (has to reduce by 1 since we are working on an array starting with 0)
        grid[row - 1][col - 1] = true;
        openedSites++;

        //connect this site to the virtual top and bottom if it is on the top or bottom edge
        if (row == 1) {
            qf.union(getUFIndex(row, col), TOP);
        }
        if (row == size) {
            qf.union(getUFIndex(row, col), bottom);
        }

        //connect this site to its neighboring sites
        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(getUFIndex(row, col), getUFIndex(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
            qf.union(getUFIndex(row, col), getUFIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(getUFIndex(row, col), getUFIndex(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
            qf.union(getUFIndex(row, col), getUFIndex(row, col + 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkException(row,col);
        return grid[row - 1][col - 1]; //true = opened, false = blocked
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkException(row, col);
        //a site is full when it is connected to virtual top
        return qf.find(TOP) == qf.find(getUFIndex(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        //the system percolates when virtual top is connected to virtual bottom
        return qf.find(TOP) == qf.find(bottom);
    }

    //check and throw illegal argument exception
    private void checkException(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException();
        }
    }

    //convert two dimensional index into one dimensional index (for union find usage)
    private int getUFIndex(int row, int col) {
        return size * (row - 1) + col;
    }
}