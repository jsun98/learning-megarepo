/**
 * Class MergeBU
 * Implements the bottom up merge sort algorithm iteratively
 */
    
public class MergeBU {
    private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    private static boolean isSorted (Comparable[] a, int lo, int hi) {
        for (int i = lo ; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void merge (Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);
        
        for (int k = lo; k <= hi; k++) 
            aux[k] = a[k];
        
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)             a[k] = aux[j++];
            else if (j > hi)              a[k] = aux[i++];
            else if (less(aux[i],aux[j])) a[k] = aux[i++];
            else                          a[k] = aux[j++];
        }
        
        assert isSorted(a, lo, hi);
    }
    
    public static void sort (Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz * 2)
            for (int lo = 0; lo < N-sz; lo += sz * 2)
                merge (a, aux, lo, lo + sz - 1, Math.min(lo + sz * 2 - 1, N - 1));
    }

    
    
}