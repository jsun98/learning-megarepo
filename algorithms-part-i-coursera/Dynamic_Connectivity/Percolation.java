import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private int n;
    private int count;
    private int top_node;
    private int bot_node;
    private WeightedQuickUnionUF qu;
    private boolean board[][];
    
    
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException ();
        
        this.n = n;
        count = 0;
        qu = new WeightedQuickUnionUF(n*n+2);
        board = new boolean[n][n];
        
        top_node = n*n;
        bot_node = n*n+1;
    }
    
    public void open (int row, int col) {
        if (isOutOfBounds(row,col))
            throw new IndexOutOfBoundsException();
        
        if (isOpen(row,col)) return;
        
        board[row-1][col-1] = true;
        
        ++count;
        
        int i = getIndexFromCoordinates(row, col);
        // top
        if (!isOutOfBounds(row+1,col) && isOpen(row+1,col))
            qu.union(i,getIndexFromCoordinates(row+1, col));
        // bot
        if (!isOutOfBounds(row-1,col) && isOpen(row-1,col))
            qu.union(i,getIndexFromCoordinates(row-1, col));
        // right
        if (!isOutOfBounds(row,col+1) && isOpen(row,col+1))
            qu.union(i,getIndexFromCoordinates(row, col+1));
        //left
        if (!isOutOfBounds(row,col-1) && isOpen(row,col-1))
            qu.union(i,getIndexFromCoordinates(row, col-1));
        
        if (row == 1) {
            qu.union(i,top_node);
        }
            
        if (row == n) {
            qu.union(i,bot_node);
        }
    }
    public boolean isOpen (int row, int col) {
        if (isOutOfBounds(row,col)) throw new IndexOutOfBoundsException();
        else return board[row-1][col-1];
    }
    public boolean isFull (int row, int col) {
        if (isOutOfBounds(row,col)) throw new IndexOutOfBoundsException();
        if (!isOpen(row,col)) return false;
        int i = getIndexFromCoordinates(row,col);
        if (qu.connected(i,top_node)) return true;
        else return false;
    }
    public int numberOfOpenSites() {
        return count;
    }
    public boolean percolates () {
        if (n==1 && !isOpen(1,1)) return false;
        return qu.connected(top_node,bot_node);
    }
    
    private int getIndexFromCoordinates(int row, int col) {
        if (isOutOfBounds(row,col)) return -1;
        else return (row-1)*n+(col-1);
    }
    
    private boolean isOutOfBounds(int row, int col) {
        return row<=0 || row>n || col <= 0 || col > n;
    }
    
    public static void main(String [] args) {
        Percolation p = new Percolation(3);
        StdOut.println("Open (1,3)");
        p.open(1,3);
        StdOut.println("Open (2,3)");
        p.open(2,3);
        StdOut.println("Open (3,3)");
        p.open(3,3);
        StdOut.println("Open (3,2)");
        p.open(2,1);
        StdOut.println("(2,1) isFull: "+p.isFull(2,1));
        StdOut.println("(2,1) isFull: "+p.isFull(2,1));
        /*
        StdOut.println("Open (1,1)");
        p.open(1,1);
        StdOut.println("Open (2,1)");
        p.open(2,1);
        StdOut.println("Open (3,1)");
        p.open(3,1);
        StdOut.println("Open (4,1)");
        p.open(4,1);
        StdOut.println("Open (5,1)");
        p.open(5,2);
        
        StdOut.println("Percolates: "+p.percolates());
        StdOut.println("Number of open sites: "+p.numberOfOpenSites());
        
        StdOut.println("Open (4,2)");
        p.open(4,2);
        
        StdOut.println("Percolates: "+p.percolates());
        StdOut.println("Number of open sites: "+p.numberOfOpenSites());
        
        StdOut.println("(3,1) isFull: "+p.isFull(3,1));
        StdOut.println("(5,4) isFull: "+p.isFull(5,1));
        StdOut.println("(3,1) isOpen: "+p.isOpen(3,1));
        */
    }
}
