import edu.princeton.cs.algs4.StdOut;
import java.util.*;


public class Deque<Item> implements Iterable<Item> {
    private class Node {
        private Item val;
        private Node next;
        private Node prev;
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.val;
            current = current.next;
            return item;
        }
        public void remove() {throw new UnsupportedOperationException();}

    }
    
    private Node first;
    private Node last;
    private int numOfItems;
    
    public Deque () {
        first = null;
        last = null;
        numOfItems = 0;
    }
    
    public boolean isEmpty () {
        return first == null;
    }
    
    public int size () {
        return numOfItems;
    }
    
    public void addFirst(Item item) {
        if (item==null) throw new IllegalArgumentException();
        Node oldFirst = first;
        first = new Node();
        first.val = item;
        first.next = oldFirst;
        first.prev = null;
        ++numOfItems;
        if (last==null) last = first;
        if (oldFirst!=null) oldFirst.prev = first;
    }
    
    public void addLast(Item item) {
        if (item==null) throw new IllegalArgumentException();
        Node oldLast = last;
        last = new Node();
        last.val = item;
        last.next = null;
        last.prev = oldLast;
        ++numOfItems;
        if (first==null) 
            first = last;
        else
            oldLast.next = last;
    }
    
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.val;
        first = first.next;
        --numOfItems;
        if (first == null) 
            last = null;
        else 
            first.prev = null;
        return item;
    }
    
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.val;
        last = last.prev;
        --numOfItems;
        if (last == null) 
            first = null;
        else 
            last.next = null;
        return item;
    }
    
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    public static void main(String args[]) {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(0);
        d.addFirst(2);
        d.addFirst(3);
        d.removeLast();
        Iterator<Integer> i = d.iterator();
        StdOut.println(i.hasNext());
        while(i.hasNext()) {
            StdOut.println(i.next());
        }
    }
}