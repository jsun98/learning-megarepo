package quicksort;

public class QuickSortPractice {
    public static void sort (Comparable[] a) {
        //shuffle
        sort(a, 0, a.length - 1);
    }
    
    private static void sort (Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = partition(a, lo, hi);
        sort(a, lo, mid - 1);
        sort(a, mid, hi);
    }
    
    private static int partition (Comparable[] a, int lo, int hi) {
        
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo]))
                if (i > hi) break;
            while (less(a[lo], a[--j]))
                if (j < lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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