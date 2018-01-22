import java.lang.*;
import java.util.*;
import edu.princeton.cs.algs4.*;

public class Board {
    private int[][] board;
    private int n;
    private int hamming;
    private int manhattan;
    private int zeroRow;
    private int zeroCol;
    private String strRep = "";
    private ArrayList<Board> neighbors = new ArrayList<Board>();
    
    private void exch (int r1, int c1, int r2, int c2) {
        int temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }
    private boolean isValidBlock (int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    private int calcDistance (int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
    private void addNeighbor (int i, int j, int r, int c) {
        if (isValidBlock(r, c)) {
            exch(i, j, r, c);
            neighbors.add(new Board(board));
            exch(i, j, r, c);
        }
    }
    private void addAllNeighbors () {
        int i = zeroRow;
        int j = zeroCol;
        addNeighbor(i, j, i-1, j);
        addNeighbor(i, j, i, j-1);
        addNeighbor(i, j, i+1, j);
        addNeighbor(i, j, i, j+1);
    }
    public Board(int[][] blocks) {
        if (blocks == null) throw new IllegalArgumentException();
        n = blocks.length;
        
        board = new int[n][n];
        
        strRep += Integer.toString(n) + '\n';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                strRep += " ";
                board[i][j] = blocks[i][j];
                int val = board[i][j];
                
                if (board[i][j] == 0) {
                    
                    zeroRow = i;
                    zeroCol = j;
                } else {
                    int targetVal = i * n + j + 1;
                    int targetRow = (val - 1) / n;
                    int targetCol = (val - 1) % n;
                    if (val != targetVal) {
                        ++hamming;
                        manhattan += calcDistance(targetRow, targetCol, i, j);
                    }

                }
                strRep += Integer.toString(val) + " ";
            }
            strRep += "\n";
        }
        
        
    }
    public int dimension() {
        return n;
    }
    public int hamming() {
        return hamming;
    }
    public int manhattan() {
        return manhattan;
    }
    public boolean isGoal() {
        return hamming == 0;
    }
    public Board twin() {
        if (n < 2)
            return new Board(board);
            
        int r1 = 0;
        int c1 = 0;
        int r2 = 1;
        int c2 = 1;
        
        if (board[r1][c1] == 0)
            r1 = 1;
        else if (board[r2][c2] == 0)
            r2 = 0;
        exch(r1,c1,r2,c2);
        Board temp = new Board(board);
        exch(r1,c1,r2,c2);
        return temp;
    }
    public boolean equals(Object y) {
        Board other;
        if (y instanceof Board)
            other = (Board) y;
        else
            return false;

        if (!this.toString().equals(other.toString()))
            return false;
        return true;
    }
    public Iterable<Board> neighbors() {
        if (neighbors.isEmpty())
            addAllNeighbors();
        return neighbors;
    }
    public String toString()  {
        return strRep;
    }

    public static void main(String[] args) {
        //int[][] board1arr = {{0}};
        int[][] board1arr = {{1,2,3},{4,6,7},{7,8,0}};
        //int[][] board1arr = {{7,1,3,2},{5,4,0,10},{6,8,9,11},{13,12,14,15}};
        Board board1 = new Board(board1arr);
        System.out.println(board1.toString());
        System.out.println("hamming: "+board1.hamming());
        System.out.println("manhattan: "+board1.manhattan());
        System.out.println("isGoal: "+board1.isGoal());
        System.out.println("twin: \n"+board1.twin().toString());
        System.out.println("neighbors length: "+((ArrayList<Board>)board1.neighbors()).size());
        
        
    }
}