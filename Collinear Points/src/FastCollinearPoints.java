import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class FastCollinearPoints {

    private LineSegment[] lineSegments;
    private int size;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

        // check for exceptions
        checkExceptions(points);

        lineSegments = new LineSegment[2]; // size = 2 (1 is also okay) to prevent resizing right from the beginning
        size = 0;
        LinkedList<Point> collinearPoints = new LinkedList<>(); // temporary storage for potential collinear points
        Point prevPoint = points[0]; // to store the most recently accessed point

        // an ascending points array (to iterate without meeting the same point again)
        Point[] sortedPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(sortedPoints);

        // for each point sort the entire array according to every other point's slope compared to this point
        for (Point point : sortedPoints) {
            Arrays.sort(points, point.slopeOrder());
            double prevSlope = 0.0; // slope of the previously checked point

            // check every other point's slope, if 3 (or more) adjacent points have equal slopes
            // then they, with the current outer loop's point, are collinear
            for (int i = 0; i < points.length; i++) {
                double currentSlope = point.slopeTo(points[i]);

                // if start of a new cycle OR found an unsatisfactory adjacent Point
                if (i == 0 || currentSlope != prevSlope) {

                    // if there exists 3 or more satisfactory adjacent points in the temp storage
                    if (collinearPoints.size() >= 3) {

                        //add the invoking point to the set
                        if (i == 0) collinearPoints.add(prevPoint);
                        else collinearPoints.add(point);

                        // make the set into a unique ascending set of collinear points to avoid duplications
                        Collections.sort(collinearPoints); // I learned this from coursera's discussion section

                        // save the previously found segment that was stored in temporary storage
                        addLine(new LineSegment(collinearPoints.getFirst(), collinearPoints.getLast()));
                        collinearPoints.getFirst().drawTo(collinearPoints.getLast());
                    }
                    // else if there aren't any segment clear the temporary storage
                    collinearPoints.clear();
                }

                // else add it to the temporary storage
                collinearPoints.add(points[i]);
                prevSlope = currentSlope;
            }
            prevPoint = point;
        }

    }

    // the number of line segments
    public int numberOfSegments() {
        return size;
    }

    // the line segments
    public LineSegment[] segments() {
        return Arrays.copyOf(lineSegments, size);
    }

    // Resize array (to implement resizing array)
    private void resize(int capacity) {
        LineSegment[] copy = new LineSegment[capacity];
        System.arraycopy(lineSegments, 0, copy, 0, size);
        lineSegments = copy;
    }

    // Add a new line segment
    private void addLine(LineSegment item) {
        boolean isDuplicate = false;
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (size == lineSegments.length) {
            resize(2 * lineSegments.length);
        }

        // check for duplicate line segments
        for (LineSegment lineSegment : lineSegments) {
            if (lineSegment != null && Objects.equals(lineSegment.toString(), item.toString())) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            lineSegments[size++] = item;
        }
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
}