package mergesort;

/**
 * Class Merge
 * Implements the merge sort algorithm
 * an example of the divide and conquer strategy
 * O(NlogN) time, O(N) space
 */
public class Merge {
    private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static boolean isSorted (Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) 
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);
        
        for (int i = lo; i <= hi; i++)
            aux[i] = a[i];
        
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
    }
    
    //divide a by half, then sort the left and right, then merge
    //smallest merge is an array of length 1
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort (a, aux, lo, mid);
        sort (a, aux, mid+1, hi);
        if (!less(a[mid+1], a[mid])) return;
        merge (a, aux, lo, mid, hi);
    }
    
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}