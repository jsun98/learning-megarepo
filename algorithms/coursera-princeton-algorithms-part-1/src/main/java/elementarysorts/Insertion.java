package elementarysorts;

/**
 * Class Insertion
 * Uses 1/4 N^2 compares and 1/4 N^2 exchanges on average
 * O(N^2)
 */
    
public class Insertion {
    public static void sort (Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else 
                    break;
            }
        }
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