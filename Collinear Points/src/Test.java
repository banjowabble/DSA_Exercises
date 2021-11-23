import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Point[] points = new Point[10];
        Point p0 = new Point(0, 0);
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(2, 1);
        Point p5 = new Point(2, 3);
        Point p6 = new Point(-1, 0);
        Point p7 = new Point(2, 0);
        Point p8 = new Point(2, -1);
        Point p9 = new Point(-1, 2);

        points[0] = p0;
        points[1] = p1;
        points[2] = p2;
        points[3] = p3;
        points[4] = p4;
        points[5] = p5;
        points[6] = p6;
        points[7] = p7;
        points[8] = p8;
        points[9] = p9;

        FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
        System.out.println(Arrays.toString(bruteCollinearPoints.segments()));
        System.out.println(Arrays.toString(fastCollinearPoints.segments()));

    }
}
