
import edu.princeton.cs.algs4.Queue;

public class BST <Key extends Comparable<Key>, Value> {
    
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int count;
        Node (Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
    
    //O(logN) iff keys come in random order
    public Value get (Key key) {
        Node x = root;
        
        while (x != null) {
            int comp = key.compareTo(x.key);
            if (comp < 0) x = x.left;
            else if (comp > 0) x = x.right;
            else return x.val;
        }
        
        return null;
    }
    
    //O(logN) iff keys come in random order
    public void put (Key key, Value val) {
        root = put (root, key, val);
    }
    
    //if key exists, update value, else make new node
    //O(log N)
    //NOTE: put returns Node x
    private Node put (Node x, Key key, Value val) {
        if (x == null) return new Node(key,  val);
        int comp = key.compareTo(x.key);
        if (comp < 0) x.left = put(x.left, key, val);
        else if (comp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
            
    }
    
    /* Hibbard Deletion
     * case 0: no children, return null
     * case 1: 1 child, return child
     * case 2: 2 child, find smallest element in right subtree
     * Problem: after sufficiently large numbers of insert and deletes,
     * depth of tree becomes sqrt N instead of lg N
     */
    public void delete (Key key) {
        root = delete (root, key);
    }
    
    private Node delete (Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left; //no right child
            if (x.left == null) return x.right; //no left child
            
            //2 children
            Node t = x; 
            x = min(t.right); //set x as min node of right sub tree
            x.right = deleteMin(t.right); //delete min node and return root of right sub tree
            x.left = t.left;   
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public void deleteMin () {
        root = deleteMin(root);
    }
    
    private Node deleteMin (Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    //O(log N)
    public Key min () {
        Node t = min (root);
        if (t == null) return null;
        else return t.key;
    }
    
    private Node min (Node x) {
        if (x.left == null) return x;
        return min (x.left);
    }
    
    /*
     * Returns the largest key less than or equal to key
     * O(log N)
     */
    public Key floor (Key key) {
        Node x = floor (root, key);
        if (x == null) return null;
        else return x.key;
    }
    
    public Node floor (Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        
        if (cmp == 0) return x; //equal key found
        else if (cmp < 0) return floor(x.left, key); //must be in the left subtree and thus x is not a candidate
        else { //could be x, or could be in right subtree
            Node t = floor(x.right, key);
            if (t == null) return x; //x is the result
            else return t; //t is greater than x and less than or equal to key
        }
        
    }
    
    /*
     * returns the number of keys less than key
     * O(log N)
     */
    public int rank (Key key) {
        return rank (key, root);
    }
    
    //O(log N)
    private int rank (Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank (key, x.left); //number of keys less than x in the left subtree
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); //# of keys in left subtree + x + # of keys in right subtree
        else return size(x.left); //number of keys less than x
    }
    
    //O(N)
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        inorder(root, q);
        return q;
    }
    
    /*
     * Inorder traversal
     * returns an interable object
     * keys are in ascending order
     */
    private void inorder (Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }
    
    public int size() {
        return size(root);
    }
    
    private int size(Node x) {
        if (x == null) return 0;
        else return x.count;
    }
    
    

}