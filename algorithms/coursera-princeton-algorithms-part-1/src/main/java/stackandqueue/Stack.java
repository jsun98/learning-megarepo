package stackandqueue;

import java.util.Iterator;

/**
 * Class Stack
 * implements the stack ADT using a list of nodes
 */
public class Stack <Item> implements Iterable<Item> {
    private Node first; //ref to the first node
    
    private class Node {
        Item val;
        Node next;
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() { throw new UnsupportedOperationException(); }
        
        public Item next() {
            Item item = current.val;
            current = current.next;
            return item;
        }
    }
    
    public Iterator<Item> iterator () {
        return new ListIterator();
    }
    public Stack() {
        first = null;
    }
    
    public void push (Item newVal) {
        Node lastFirst = first;
        first = new Node();
        first.val = newVal;
        first.next = lastFirst;
    }
    
    public Item pop() {
        Item val = first.val;
        first = first.next;
        return val;
    }
    
    boolean isEmpty() {
        return first == null;       
    }
    
}