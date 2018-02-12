public class RedBlackBST {
    
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node
    {
        Key key;
        Value val;
        Node left, right;
        boolean color; // color of parent link
    }
    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return x.color == RED;
    }

    /*
     * Same as Vanilla BST
     * guranteed O(lg N) because of 2-3 tree perfect balance
     */
    public Val get(Key key)
    {
        Node x = root;
        while (x != null)
        {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return x.val;
        }
        return null;
    }
    
    private Node rotateLeft(Node h)
    {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
}