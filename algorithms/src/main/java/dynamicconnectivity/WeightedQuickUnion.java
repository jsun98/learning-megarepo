/**
 * Class WeightedQuickUnion
 * depth of any node x is at most lg n (log base 2 of n)
 * improvement 1: union - only link root of smaller tree to root of larger tree
 * find O(lg N)
 * union O(lg N)
 */ 
public WeightedQuickUnion {
    private int[] id; //array of refs to parent 
    private int[] size; //keep track of size of tree
    public QuickUnion(int n) {
        id = new int[n];   
        size = new int[n]; 
        for (int i = 0;i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    
    //same as before
    //O(lg N)
    public boolean find(int p, int q) {
        return root(p) == root(q);
    }
    
    //added weighted algorithm
    //always place the smaller tree as a child of the larger tree
    //O(lg N)
    public void union (int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i==j) return;
        if (size[i] < size[j]) { //i tree smaller than j tree
            id[i] = j;
            size[j]+=size[i];
        } else { //j tree smaller or equal to i tree
            id[j] = i;
            size[i]+=size[j];
        }
    }
    
    //added path compression
    //as we travel up the tree, set each node on the path to point to grandparent to make tree flatter
    //complexity is depth of i
    private int root (int i) {
        while(id[i]!=i) {
            id[i] = id[id[i]];
            i=id[i];
        }
        
        return i;
    }
}