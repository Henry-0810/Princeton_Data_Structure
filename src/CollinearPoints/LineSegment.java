package CollinearPoints;

public class LineSegment {
    private final Point p;
    private final Point q;

    // constructs the line segment between points p and q
    public LineSegment(Point p, Point q) {
        this.p = p;
        this.q = q;
    }

    // draws this line segment
    public void draw() {
    }

    // string representation
    public String toString() {
        return "Line goes from point " + this.p + " to " + this.q;
    }
}
