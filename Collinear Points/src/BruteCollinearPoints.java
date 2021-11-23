import java.util.Arrays;

public class BruteCollinearPoints {

    private LineSegment[] lineSegments; // list of line segments
    private int size; // number of added line segments

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

        // check for exceptions
        checkExceptions(points);

        lineSegments = new LineSegment[2]; // size = 2 (1 is also okay) to prevent resizing right from the beginning
        size = 0;

        Arrays.sort(points);
        // sort array in their coordinates' ascending order
        // because:
        // 1) eliminate the need for an additional tracker of start point and end point of a segment
        // 2) eliminate duplicate segments

        for (int p = 0; p < points.length - 3; p++) {
            for (int q = p + 1; q < points.length - 2; q++) {
                for (int r = q + 1; r < points.length - 1; r++) {
                    for (int s = r + 1; s < points.length; s++) {
                        if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r])
                                && points[p].slopeTo(points[r]) == points[r].slopeTo(points[s])) {
                            addLine(new LineSegment(points[p], points[s]));
                            points[p].drawTo(points[s]);
                        }
                    }
                }
            }
        }
    }

    // Resize array (to implement resizing array)
    private void resize(int capacity) {
        LineSegment[] copy = new LineSegment[capacity];
        System.arraycopy(lineSegments, 0, copy, 0, size);
        lineSegments = copy;
    }

    // Add a new line segment
    private void addLine(LineSegment item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (size == lineSegments.length) {
            resize(2 * lineSegments.length);
        }

        lineSegments[size++] = item;
    }

    // Check for exceptions
    private void checkExceptions(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (points[i] == null || points[j] == null) {
                    throw new IllegalArgumentException();
                }
                if (i != j && points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    // The number of line segments
    public int numberOfSegments() {
        return this.size;
    }

    // The line segments
    public LineSegment[] segments() {
        return Arrays.copyOf(this.lineSegments, this.size);
    }
}