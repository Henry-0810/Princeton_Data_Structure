import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    // constructs the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw() {
    }

    // draws the line segment from this point to that point
    public void drawTo(Point that) {
    }

    // string representation
    public String toString() {
        return "Point is (" + this.x + "," + this.y + ")";
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y < that.y) return -1;
        else if (this.y == that.y) {
            return Integer.compare(this.x, that.x);
        } else return 1;
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {
        if (this.x == that.x && this.y == that.y) return Double.NEGATIVE_INFINITY;
        if (this.y == that.y) return 0;
        if (this.x == that.x) return Double.POSITIVE_INFINITY;
        return (double) (this.y - that.y) / (this.x - that.x);
    }

    // compare two points by slopes they make with this point
    public Comparator<Point> slopeOrder() {
        return new SlopeOrder();
    }

    private class SlopeOrder implements Comparator<Point>{
        @Override
        public int compare(Point p1, Point p2) {
            double slope1 = slopeTo(p1);
            double slope2 = slopeTo(p2);
            return Double.compare(slope1, slope2);
        }
    }
}
