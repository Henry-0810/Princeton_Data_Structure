package CollinearPoints;

import java.util.Arrays;

public class BruteCollinearPoints {
    Point[] collinearPoints = new Point[4];
    LineSegment[] segments = new LineSegment[Integer.MAX_VALUE];
    int numOfSegments = 0;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points){
        if (points == null) throw new IllegalArgumentException("Argument is null");
        for (int i = 0; i < points.length; i++) {
            if(points[i] == null) throw new IllegalArgumentException("CollinearPoints.Point index " + i + " is null");
        }
        Arrays.sort(points);
        for (int i = 0; i < points.length-1; i++) {
            if(points[i].compareTo(points[i+1]) == 0) throw new IllegalArgumentException("Duplicates found");
        }
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        double slope1 = points[i].slopeTo(points[j]);
                        double slope2 = points[i].slopeTo(points[k]);
                        double slope3 = points[i].slopeTo(points[l]);
                        if(slope1 == slope2 && slope1 == slope3){
                            collinearPoints = new Point[]{points[i], points[j], points[k], points[l]};
                            Arrays.sort(collinearPoints);
                            segments[i] = new LineSegment(collinearPoints[0], collinearPoints[3]);
                            numOfSegments++;

                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return numOfSegments;
    }

    // the line segments
    public LineSegment[] segments() {
        return Arrays.copyOf(segments, numOfSegments);
    }
}
