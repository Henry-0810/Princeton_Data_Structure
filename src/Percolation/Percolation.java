import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF full;
    private final WeightedQuickUnionUF perc;
    private final int virtualTopSite;
    private final int virtualBottomSite;
    private int countOpen;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        this.n = n;
        grid = new boolean[n][n];
        full = new WeightedQuickUnionUF(n * n + 1);
        perc = new WeightedQuickUnionUF(n * n + 2);
        virtualTopSite = n * n;
        virtualBottomSite = n * n + 1;
        countOpen = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (validateIndex(row, col)) {
            if (!isOpen(row, col)) {
                grid[row - 1][col - 1] = true;
                countOpen++;
            }

            if (row == 1) {
                perc.union(col - 1, virtualTopSite);
                full.union(col - 1, virtualTopSite);
            }

            if (row == n) perc.union((row - 1) * n + col - 1, virtualBottomSite);

            if (row > 1 && isOpen(row - 1, col)) union2D(row - 1, col - 1, row - 2, col - 1);

            if (row < n && isOpen(row + 1, col)) union2D(row - 1, col - 1, row, col - 1);

            if (col > 1 && isOpen(row, col - 1)) union2D(row - 1, col - 1, row - 1, col - 2);

            if (col < n && isOpen(row, col + 1)) union2D(row - 1, col - 1, row - 1, col);
        } else {
            throw new IllegalArgumentException("Index out of bounds.");
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (validateIndex(row, col)) {
            return grid[row - 1][col - 1];
        }
        throw new IllegalArgumentException();
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (validateIndex(row, col)) {
            return full.find((row - 1) * n + col - 1) == full.find(virtualTopSite);
        }
        throw new IllegalArgumentException();
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return countOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return perc.find(virtualTopSite) == perc.find(virtualBottomSite);
    }

    private boolean validateIndex(int row, int col) {
        return row >= 1 && row <= n && col >= 1 && col <= n;
    }

    private void union2D(int rowA, int colA, int rowB, int colB) {
        perc.union(rowA * n + colA, rowB * n + colB);
        full.union(rowA * n + colA, rowB * n + colB);
    }
}