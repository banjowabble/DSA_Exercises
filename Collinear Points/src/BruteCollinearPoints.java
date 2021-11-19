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

        // sort array
        // Arrays.sort(points);

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].slopeTo(points[j]) == points[j].slopeTo(points[k]) &&
                                points[j].slopeTo(points[k]) == points[k].slopeTo(points[l])) {

                            // add newly found line segment to the list
                            addLine(new LineSegment(points[i], points[l]));
                            points[i].drawTo(points[l]);
//                            StdDraw.show();
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

        if(size == lineSegments.length) {
            resize(2 * lineSegments.length);
        }

        lineSegments[size++] = item;
    }

    // Check for exceptions
    private void checkExceptions(Point[] points){
        if(points == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < points.length; i ++) {
            for(int j = 0; j < points.length; j++) {

                if(points[i] == null || points[j] == null) {
                    throw new IllegalArgumentException();
                }

                if(i != j && points[i].compareTo(points[j]) == 0) {
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