/*Heap Sort Algorithm
 * NlogN worst case time
 * In place
 * Not often used because
 *   - inner loop longer than quicksort
 *   - poor use of cache memory
 *   - not stable (long distance exchanged)
 * Basic plan
 * - view items as a max heap
 * - 1st rearrange the items
 * - 2nd repeated delmax
 */
public class HeapSort {
    public static void sort(Comparable[] items) {
        int n = items.length; //maintains a pointer to the sorted array
        //heap construction
        //start with parent of last element in array
        for (int i = n/2; i >= 1; i--) {
            sink(items, i, n);
        }
        //repeated remove max
        while (n > 1) {
            exch(items, 1, n--); //put max at the end of array
            sink(items, 1, n);
        }
    }
    
    private static void sink(Comparable[] items, int k, int n) {
        while (2*k <= n) {
            int j = k*2;
            if (j < n && less(items, j, j+1))
                ++j;
            if (!less(items, k, j))
                break;
            exch(items, k, j);
            k = j;
        }
    }
    
    private static boolean less(Comparable[] items, int v, int w) {
        return items[v-1].compareTo(items[w-1]) < 0;
    }
    
    private static void exch(Comparable[] items, int v, int w) {
        Comparable item = items[v-1];
        items[v-1] = items[w-1];
        items[w-1] = item;
    }
}