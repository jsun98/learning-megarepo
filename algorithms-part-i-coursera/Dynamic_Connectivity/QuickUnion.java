/**
 * Class QuickUnion
 * Solves the dynamic connectivity problem
 * find O(n)
 * union O(n)
 */
public QuickUnion {
    //index of array rep. a component
    //Array rep. a tree of connected components
    //id[i] is the parent of i
    private int[] id;
    
    //initialize array
    //O(n)
    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0;i < n; i++) {
            id[i] = i;
        }
    }
    
    //check if same root
    //complexity is depty of p + depth of q
    //worst case O(n) if tree = linked list
    public boolean find(int p, int q) {
        return root(p) == root(q);
    }
    
    //set the id of p's root to id of q's root
    //complexity is depth of p + depth of q
    //wrost case O(n) if tree = linked list
    public void union (int p, int q) {
        id[root(p)] = root(q);
    }
    
    //recursively find the root of i
    //stops when id[i] = i
    //complexity is depth of i
    private int root (int i) {
        while(id[i]!=i) 
            i=id[i];
        return i;
    }
}