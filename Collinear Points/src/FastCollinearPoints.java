import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {

    private LineSegment[] lineSegments;
    private int size;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

        // check for exceptions
        checkExceptions(points);

        this.lineSegments = new LineSegment[2];
        this.size = 0;
        LinkedList<Point> collinearPoints = new LinkedList<>();

        for (Point point : points) {
            Arrays.sort(points, point.slopeOrder());
            double prevSlope = 0.0;

            for (int i = 0; i < points.length; i++) {
                double currentSlope = point.slopeTo(points[i]);
                if (i == 0 || currentSlope != prevSlope) {
                    if(collinearPoints.size() >= 3) {
                        //Collections.sort(collinearPoints);
                        this.addLine(new LineSegment(collinearPoints.getFirst(), collinearPoints.getLast()));
                        collinearPoints.getFirst().drawTo(collinearPoints.getLast());
                        StdDraw.show();
                    }
                    collinearPoints.clear();
                }

                collinearPoints.add(points[i]);
                prevSlope = currentSlope;
            }
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

    public static void main(String[] args) {
        In in = new In("files\\grid4x4.txt");      // input file
        int n = in.readInt();

        // padding for drawing
        int padding = 1000;

        // set draw scale
        StdDraw.setXscale(-padding, Short.MAX_VALUE + padding);
        StdDraw.setYscale(-padding, Short.MAX_VALUE + padding);

        // Index of array
        int index = 0;

        // turn on animation mode
        StdDraw.enableDoubleBuffering();

        // Create array
        Point[] points = new Point[n];

        points[index] = new Point(in.readInt(), in.readInt());
        points[index].draw();
        StdDraw.show();

        index++;

        while (!in.isEmpty()) {
            points[index] = new Point(in.readInt(), in.readInt());
            points[index].draw();
            StdDraw.show();

            index++;
        }

        FastCollinearPoints fclp = new FastCollinearPoints(points);
        //LineSegment[] lineSegments = fclp.lineSegments();
    }
}