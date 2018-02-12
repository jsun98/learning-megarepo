/**
 * Class QuickFind
 * Solves the dynamic connectivity problem
 * find O(1)
 * union O(n)
 */
public class QuickFind {
    //Array index rep. a node
    // p and q are connected iff they have the same id
    private int[] id;
    
    //constructor initializes array
    //O(n)
    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {id[i] = i;}
    }
    
    //checks if id's are equal
    //O(1)
    public boolean find(int p, int q) {
        return id[p]==id[q];
    }
    
    //change all elements whose id equals id[p] to id[q]
    //O(n)
    public void union(int p, int q) {
        for (int i = 0; i < id.length; i++) {
            if (id[i]==id[p])
                id[i]=id[q];
        }
    }
}