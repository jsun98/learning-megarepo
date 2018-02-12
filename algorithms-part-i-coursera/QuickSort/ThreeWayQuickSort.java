import edu.princeton.cs.algs4.StdRandom;

/**
 * Class ThreeWayQuickSort
 * Handles situations that arise with duplicate key values
 * O(NlogN) when all distinct
 * O(N) when there's a constant number of distinct keys
 */
public class ThreeWayQuickSort {
    
    public static void sort (Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a);
    }
    
    /**
     * Basic idea
     * Partition array into 3 sections
     * entires between lt and gt are equal to the key
     * no larger entries left of lt
     * no smaller entries right of gt
     */
    
    private static void sort (Comparable[] a, int lo, int hi) {
        if (hi <= lo ) return;
        
        Comparable v = a[lo]; //key
        
        //everything to the left of lt are < v
        //everything to the right of gt are > v
        int i = lo, lt = lo, gt = hi; 
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);  //exchange i with lt then increment both
            else if (cmp > 0) exch(a, i, gt--); //exchange i with gt then decrement gt only, a[i] is not compared yet so we don't increment i
            else i++; //when duplicate key, increment i
        }
        
        sort (a, lo, lt - 1);
        sort (a, gt + 1, hi);
    
    }
    
        private static void exch (Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}