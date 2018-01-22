import edu.princeton.cs.algs4.*;
import java.lang.*;
import java.util.*;

public class PointSET {
    private TreeSet<Point2D> pointsSet;
    
    public PointSET() {
        pointsSet = new TreeSet<>();
    }
    
    public boolean isEmpty()  {
        return pointsSet.isEmpty();
    }
        
    public int size() {
        return pointsSet.size();
    }
    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        pointsSet.add(p);
    }
    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        return pointsSet.contains(p);
    }
    public void draw() {
        for (Point2D pt: pointsSet) {
            pt.draw();
        }
    }
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException();
        ArrayList<Point2D> points = new ArrayList<Point2D>();
        for (Point2D pt: pointsSet) {
            if (rect.contains(pt))
                points.add(pt);
        }
        return points;
    }
    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        if (isEmpty()) return null;
        Point2D nearest = pointsSet.first();
        double dist = pointsSet.first().distanceTo(p);
        for (Point2D pt: pointsSet) {
            if (pt.distanceTo(p) < dist) {
                dist = pt.distanceTo(p);
                nearest = pt;
            }
        }
        return nearest;
    }

    public static void main(String[] args) {
        
    }
}