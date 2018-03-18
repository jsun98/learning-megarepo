package mergesort;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> lines = new ArrayList<>();
    
    private boolean isCollinear (Point one, Point two, Point three, Point four) {
        return one.slopeTo(two) == one.slopeTo(three) &&
               one.slopeTo(two) == one.slopeTo(four);
    }
    
    private boolean isValidPoints (Point[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) return false;
            for (int j = i+1; j < points.length; j++) {
                if (points[j] == null || points[i].compareTo(points[j]) == 0)
                    return false;
            }
        }
        return true;
    }
    
    
    public BruteCollinearPoints(Point[] points) { 
        if (points == null || !isValidPoints(points)) 
            throw new IllegalArgumentException();

        int N = points.length;
        
        if (N < 4) { return; }
        
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    for (int m = k+1; m < N; m++) {
                        if (isCollinear(points[i], points[j], points[k], points[m])) {
                            
                            Point max = points[i];
                            Point min = points[i];
                            if (points[j].compareTo(max) > 0) max = points[j];
                            if (points[j].compareTo(min) < 0) min = points[j];
                            if (points[k].compareTo(max) > 0) max = points[k];
                            if (points[k].compareTo(min) < 0) min = points[k];
                            if (points[m].compareTo(max) > 0) max = points[m];
                            if (points[m].compareTo(min) < 0) min = points[m];
                            
                            LineSegment l = new LineSegment(min, max);
                            if (!lines.contains(l))
                                lines.add(l);
                        }
                    }
                }
            }
        }
    }
    
    public int numberOfSegments() {
        return lines.size();
    }
    
    public LineSegment[] segments() {
        return lines.toArray(new LineSegment[lines.size()]);
    }
}