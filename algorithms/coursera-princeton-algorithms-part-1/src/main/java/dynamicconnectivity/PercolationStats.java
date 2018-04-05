package dynamicconnectivity;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
   private double[] experiments;
   
   public PercolationStats(int n, int trials) {
       if (n<=0 || trials<=0) throw new IllegalArgumentException();
       Percolation p;
       this.experiments = new double[trials];
       
       for (int i = 0; i < trials; i++) {
           p = new Percolation(n);
           while (!p.percolates()) {
               int randRow = StdRandom.uniform(1,n+1);
               int randCol = StdRandom.uniform(1,n+1);
               p.open(randRow,randCol);
           }   
           experiments[i] = (double)p.numberOfOpenSites()/(n*n);
       }
   }
   public double mean() {
       return StdStats.mean(experiments);
   }
   public double stddev(){
       return StdStats.stddev(experiments);
   }
   public double confidenceLo() {
       return mean()-1.96*stddev()/Math.sqrt(experiments.length);
   }
   public double confidenceHi() {
       return mean()+1.96*stddev()/Math.sqrt(experiments.length);
   }

   public static void main(String[] args) {
       PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
       StdOut.println("mean = "+ps.mean());
       StdOut.println("stddev = "+ps.stddev());
       StdOut.println("95% confidence interval = ["+ps.confidenceLo()+", "+ps.confidenceHi()+"]");
   }
}