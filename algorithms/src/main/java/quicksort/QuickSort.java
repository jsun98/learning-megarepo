package quicksort;

import edu.princeton.cs.algs4.StdRandom;


/**
 * Class QuickSort
 * Implements the quick sort algorithm
 * O(NlogN) - a bit faster than merge sort and has no space overhead
 */ 
public class QuickSort {
    
    /*
     * Basic idea:
     * everything to the left of i is less than the partitioning elem (a[lo])
     * everythign to the right of j is greater
     */
    private static int partition (Comparable[] a, int lo, int hi) {
        
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) //move i until an elem is greater than a[lo] is found
                if (i > hi) break;
            while (less(a[lo], a[--j])) //move j until an elem is less than a[lo] is found
                if (j < lo) break;
            if (i >= j) break; //check if pointers cross
            exch(a, i, j); //exch elements that are out of place
        }
        exch(a, lo, j); //j is now the partition elem
        return j; //return index of j
    }
    
    //
    private static void sort (Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = partition(a, lo, hi);
        sort (a, lo, mid);
        sort (a, mid + 1, hi);
    }
    
    public static void sort (Comparable[] a) {
        StdRandom.shuffle(a); //needed for performance gurantee
        sort(a, 0, a.length - 1);
    }
    
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    
    private static void exch (Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
                                                              
}