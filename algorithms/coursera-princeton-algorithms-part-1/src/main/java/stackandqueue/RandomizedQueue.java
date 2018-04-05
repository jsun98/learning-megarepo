package stackandqueue;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int N;
    
    private void resize(int len) {
        Item[] newS = (Item[]) new Object[len];
        int length = s.length > len ? len : s.length;
        for (int i = 0; i < length; i++) {
            newS[i] = s[i];
        }
        s = newS;
    }
    
    private class ListIterator implements Iterator<Item> {
        private Item[] randS;
        private int k;
        
        public ListIterator () {
            randS = (Item[]) new Object[s.length];
            for (int i = 0 ; i < randS.length; i ++) {
                randS[i] = s[i];
            }
            k = N;
        }
        
        public boolean hasNext () {
            return k != 0;
        }
        public Item next () {
            if (!hasNext()) throw new NoSuchElementException();
            int index = StdRandom.uniform(0,k);
            Item val = randS[index];
            randS[index] = randS[--k];
            return val;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    public RandomizedQueue(){
        //Java does not allow generic array creation
        //i.e. s = new Item[n]; is illegal
        s = (Item[]) new Object[1];
        N = 0;
    }
    
        
    public boolean isEmpty() {
        return N==0;
    }
    
    public int size() {
        return N;
    }
    
    public void enqueue(Item item) {
        if (item==null) throw new IllegalArgumentException();
        if (N==s.length) 
            resize(s.length * 2);
        s[N++] = item;
    }
        
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = StdRandom.uniform(0,N);
        Item val = s[index];
        s[index] = s[--N];
        s[N] = null;
        if (N>0 && N==s.length/4)
            resize(s.length/2);
        return val;
    }
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return s[StdRandom.uniform(0,N)];
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    public static void main(String args[]) {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
         q.enqueue(90);
         q.enqueue(857);
         q.enqueue(546);
         q.dequeue();
         q.size();
         Iterator<Integer> i = q.iterator();
         while (i.hasNext()) {
             StdOut.println(i.next());
         }
        
    
    }
}