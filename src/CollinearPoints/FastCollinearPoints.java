package CollinearPoints;

import java.util.Arrays;

public class FastCollinearPoints {
    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("Argument is null");
        for (int i = 0; i < points.length; i++) {
            if(points[i] == null) throw new IllegalArgumentException("CollinearPoints.Point index " + i + " is null");
        }
        Arrays.sort(points);
        for (int i = 0; i < points.length-1; i++) {
            if(points[i].compareTo(points[i+1]) == 0) throw new IllegalArgumentException("Duplicates found");
        }
        int n = points.length;
        Point[] copy = Arrays.copyOf(points,n);
        for (int i = 0; i < n; i++) {
            Point origin = copy[i];
            Arrays.sort(points,origin.slopeOrder());
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return 0;
    }

    // the line segments
    public LineSegment[] segments() {
        return null;
    }
}
