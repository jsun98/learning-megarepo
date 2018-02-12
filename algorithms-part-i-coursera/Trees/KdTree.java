import edu.princeton.cs.algs4.*;
import java.lang.*;
import java.util.*;

public class KdTree {
    private final boolean VNODE = true;
    private final boolean HNODE = false;
    
    private class Node {
        Node left;
        Node right;
        Point2D point;
        boolean levelType;
        RectHV rect;
        Node (Point2D point, boolean levelType, RectHV rect) {
            this.point = point;
            this.left = null;
            this.right = null;
            this.levelType = levelType;
            this.rect = rect;
        }
    }
    
    private Node root;
    private int size;
    
    public KdTree() {
        root = null;
        size = 0;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public int size() {
        return size;
    }
    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        double x = p.x();
        double y = p.y();
        Node runner = root;
        Node prev = null;
        while (runner != null) {
            prev = runner;
            if (runner.point.equals(p))
                return;
            if (runner.levelType == VNODE) {
                if (x < runner.point.x())
                    runner = runner.left;
                else
                    runner = runner.right;
            } else {
                if (y < runner.point.y())
                    runner = runner.left;
                else
                    runner = runner.right;
            }
        }
        if (prev == null) {
            root = new Node (p, VNODE, new RectHV(0.0, 0.0, 1.0, 1.0));
        } else {
            if (prev.levelType == VNODE) {
                if (x < prev.point.x())
                    prev.left = new Node (p, HNODE, new RectHV(prev.rect.xmin(),prev.rect.ymin(),prev.point.x(),prev.rect.ymax()));
                else
                    prev.right = new Node (p, HNODE, new RectHV(prev.point.x(),prev.rect.ymin(),prev.rect.xmax(),prev.rect.ymax())); 
            }
            else {
                if (y < prev.point.y())
                    prev.left = new Node (p, VNODE, new RectHV(prev.rect.xmin(),prev.rect.ymin(),prev.rect.xmax(),prev.point.y()));
                else
                    prev.right = new Node (p, VNODE, new RectHV(prev.rect.xmin(),prev.point.y(),prev.rect.xmax(),prev.rect.ymax()));
            }
        }
        ++size;
    }
    
    private boolean contains(Node root, Point2D p) {
        if (root == null) return false;
        if (root.point.compareTo(p) == 0) return true;
        if (root.levelType == VNODE) {
            if (p.x() < root.point.x()) {
                return contains(root.left, p);
            } else {
                return contains(root.right, p);
            }
        } else {
            if (p.y() < root.point.y()) {
                return contains(root.left, p);
            } else {
                return contains(root.right, p);
            }
        }
    }
    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        return contains(root, p);
    }
    private void draw (Node root) {
        if (root == null) return;
        StdDraw.setPenColor(StdDraw.BLACK);
        root.point.draw();
        if (root.levelType == VNODE) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(root.point.x(),root.rect.ymin(),root.point.x(),root.rect.ymax());
        }
        else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(root.rect.xmin(),root.point.y(),root.rect.xmax(),root.point.y());
        }
        draw(root.left);
        draw(root.right);
    }
    public void draw() {
        draw (root);
    }
    private void searchAndAdd (ArrayList<Point2D> points, RectHV rect, Node root) {
        if (root == null) return;
        if (rect.contains(root.point))
            points.add(root.point);
        if (root.left != null && rect.intersects(root.left.rect))
            searchAndAdd(points, rect, root.left);
        if (root.right != null && rect.intersects(root.right.rect))
            searchAndAdd(points, rect, root.right);
        
    }
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException();
        if (root == null) return null;
        ArrayList<Point2D> points = new ArrayList<>();
        searchAndAdd(points, rect, root);
        return points;
    }
    private Node nearest (Node min, Node root, Point2D p) {
        
        
        if (root == null) return min;
        
        double minDist = min.point.distanceTo(p);
        if (minDist < root.rect.distanceTo(p)) return min;
        double dist = root.point.distanceTo(p);
        if (dist < minDist) {
            min = root;
        }
        

        if (root.levelType == VNODE) {
            if (p.x() < root.point.x()) {
                min = nearest(min, root.left, p);
                min = nearest(min, root.right, p);
            } else {
                min = nearest(min, root.right, p);
                min = nearest(min, root.left, p);
            }
        } else {
            if (p.y() < root.point.y()) {
                min = nearest(min, root.left, p);
                min = nearest(min, root.right, p);
            } else {
                min = nearest(min, root.right, p);
                min = nearest(min, root.left, p);
            } 
        }
        
        return min;
        
        
    }
    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        if (isEmpty()) return null;
        Node min = root;
        min = nearest(min, root, p);
        return min.point;
    }

    public static void main(String[] args) {
        KdTree tree = new KdTree();
        tree.insert(new Point2D (0.99, 0.99));
        tree.insert(new Point2D (0.1112, 0.1));
        tree.insert(new Point2D (0.712313, 0.3123123123));
    }
}