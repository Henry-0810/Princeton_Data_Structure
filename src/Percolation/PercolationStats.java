import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;
    private final double[] fractions;
    private final int trials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.trials = trials;
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        this.fractions = new double[trials];
        for (int i = 0; i < trials; i++) {
            int openSites;
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                if (!p.isOpen(row, col) && !p.isFull(row, col)) {
                    p.open(row, col);
                }
            }
            openSites = p.numberOfOpenSites();
            fractions[i] = (double) openSites / (n * n);
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev() / Math.sqrt(trials)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev() / Math.sqrt(trials)));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(StdIn.readLine());
        int trials = Integer.parseInt(StdIn.readLine());
        PercolationStats ps = new PercolationStats(n, trials);
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}