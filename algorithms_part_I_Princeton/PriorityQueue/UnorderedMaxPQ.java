/**
 * Heap ordering:
 * children of a node is no bigger than its parent
 * Representation:
 * the array represents a binary head (i = 0 is node 1 level 1, i = 1 is node 1 level 2, i = 2 is node 2 level 2 etc..)
 * Parent is always at k/2
 * Left child is always K * 2 and right is K*2+1
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    
    //use capacity + 1 to make index arithmetic easier
    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }
    
    public boolean isEmpty () {
        return N == 0;
    }
    
    // insert x at the last position in the array, then swim it to the right place
    public void insert (Key x) {
        pq[++N] = x;
        swim(N);
    }
    
    /* max is at the root node
     * exch max with last element in array
     * then sink position 1 to the right place
     */ 
    public Key delMax () {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }
    
    /* k is the position of element in the array to sink
     * left child is always k*2 and right child is always k*2+1
     * sink exchanges with the largest child (j or j+1)
     */
    private void sink (int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) //choose the bigger child
                j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    
    /* parent is always at k/2
     * exchange k with k's parents as long as k is greater than its parent
     */
    private void swim (int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private boolean less (int v, int w) {
        return pq[v].compareTo(pq[w]) < 0;
    }
    
    private void exch (int v, int w) {
        Key temp = pq[v];
        pq[v] = pq[w];
        pq[w] = temp;
    }
}