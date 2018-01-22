import edu.princeton.cs.algs4.*;
import java.lang.*;
import java.util.*;


public class Solver {
    
    private class Node implements Comparable<Node> {
        Board board;
        Node prev;
        int numOfMoves;
        int manhattan;
        @Override
        public int compareTo (Node other) {
            return (manhattan - other.board.manhattan()) + (this.numOfMoves - other.numOfMoves);
        }
        Node (Board initial, Node prev, int numOfMoves) {
            this.board = initial;
            this.prev = prev;
            this.numOfMoves = numOfMoves;
            this.manhattan = this.board.manhattan();
        }   
    }
    private Node minNode;
    private boolean solvable = true;
    private Board initial;
    private ArrayList<Board> minSeq = new ArrayList<Board>();
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();
        this.initial = initial;
        
        MinPQ<Node> pq1 = new MinPQ<Node>();
        MinPQ<Node> pq2 = new MinPQ<Node>();
        pq1.insert(new Node(initial, null, 0));
        pq2.insert(new Node(initial.twin(), null, 0));
        
        Node min1 = pq1.delMin();
        Node min2 = pq2.delMin();
        while (!min1.board.isGoal() && !min2.board.isGoal()) {
            for (Board i : min1.board.neighbors()) {
                if (min1.prev == null || !i.equals(min1.prev.board))
                    pq1.insert(new Node(i, min1, min1.numOfMoves + 1));
            }
            for (Board i : min2.board.neighbors()) {
                if (min2.prev == null || !i.equals(min2.prev.board))
                    pq2.insert(new Node(i, min2, min2.numOfMoves + 1));
            }
            min1 = pq1.delMin();
            min2 = pq2.delMin();
        }
        solvable = min1.board.isGoal();
        
        if (solvable) {
            minNode = min1;
            Node runner = min1;
            while (runner != null) {
                minSeq.add(runner.board);
                runner = runner.prev;
            }
            Collections.reverse(minSeq);
        }
    }
    public boolean isSolvable() {
        return solvable;
    }
    public int moves() {
        return solvable ? minNode.numOfMoves : -1;
    }
    public Iterable<Board> solution() {
        if (!solvable)
            return null;
        return minSeq;
    }
    public static void main(String[] args) {
        
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
       
        
        
        // solve the puzzle
        Solver solver = new Solver(initial);
        
        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
        
    }
}