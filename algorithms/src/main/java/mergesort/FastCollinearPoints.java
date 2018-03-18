package mergesort;

import java.util.*;

import edu.princeton.cs.algs4.*;

public class FastCollinearPoints {
    private ArrayList<LineSegment> lines = new ArrayList<>();
    private HashMap<Double, HashSet<Point>> existingLines = new HashMap<>();
        
    
    private void addLineIfUnique (Double slope, Point min, Point max) {
    
        if (existingLines.containsKey(slope)) {
            if (existingLines.get(slope).contains(min))
                return;
        } else {
            existingLines.put(slope, new HashSet<>());
        }
        existingLines.get(slope).add(min);
        lines.add(new LineSegment(min, max));
    }
    
    private boolean areValidPoints (Point[] points) {
        if (points[0] == null) return false;
        for (int i = 1; i < points.length; i++) {
            if (points[i] == null || points[i].compareTo(points[i-1]) == 0)
                return false;
        }
        return true;
    }
        
    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();
        
        Point[] sorted = Arrays.copyOf (points, points.length);
        
        if (!areValidPoints(sorted))
            throw new IllegalArgumentException();
        
        if (points.length < 2)
            return;
        

        HashSet checkPoints = new HashSet();
        
        for (int i = 0; i < points.length; i++) {
            Arrays.sort(sorted, points[i].slopeOrder());
            Point origin = sorted[0];
            Point minPoint = origin.compareTo(sorted[1]) < 0 ? origin : sorted[1];
            Point maxPoint = origin.compareTo(sorted[1]) > 0 ? origin : sorted[1];
            double slopeToOrigin = origin.slopeTo(sorted[1]);
            int numOfPointsOnLine = 2;
            for (int j = 2; j < sorted.length; j++) {
                double compSlope = origin.slopeTo(sorted[j]);
                if (Double.compare(slopeToOrigin, compSlope) == 0) {
                    ++numOfPointsOnLine;
                    minPoint = minPoint.compareTo(sorted[j]) < 0 ? minPoint : sorted[j];
                    maxPoint = maxPoint.compareTo(sorted[j]) > 0 ? maxPoint : sorted[j];
                } else {
                    if (numOfPointsOnLine >= 4) {
                        addLineIfUnique(slopeToOrigin, minPoint, maxPoint);
                    }
                    slopeToOrigin = compSlope;
                    numOfPointsOnLine = 2;
                    minPoint = origin.compareTo(sorted[j]) < 0 ? origin : sorted[j];
                    maxPoint = origin.compareTo(sorted[j]) > 0 ? origin : sorted[j];
                }   
            }
            if (numOfPointsOnLine >= 4) {
                addLineIfUnique(slopeToOrigin, minPoint, maxPoint);
            }
                    
        }
    }
    public int numberOfSegments() {
        return lines.size();
    }
    public LineSegment[] segments() {
        return lines.toArray(new LineSegment[lines.size()]);
    }
    
public static void main(String[] args) {

    // read the n points from a file
    In in = new In(args[0]);
    int n = in.readInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
        int x = in.readInt();
        int y = in.readInt();
        points[i] = new Point(x, y);
    }

    // draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point p : points) {
        p.draw();
    }
    StdDraw.show();

    // print and draw the line segments
    
    FastCollinearPoints collinear = new FastCollinearPoints(points);
    
    StdOut.println(collinear.numberOfSegments());
    for (LineSegment segment : collinear.segments()) {
        StdOut.println(segment);
        segment.draw();
    }
    StdDraw.show();
    
    
}
}
