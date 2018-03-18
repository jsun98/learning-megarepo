package stackandqueue;

/**
 * Class LinkedQueueOfStrings
 * Implements the Queue ADT using a list of nodes
 */
public class LinkedQueueOfStrings {
    private class Node {
        Node next;
        String val;
    }
    private Node first;
    private Node last;
    
    public LinkedQueueOfStrings () {
        this.first = null;
        this.last = null;
    }
    
    //add to the back of the queue
    public void enqueue(String newVal) {
        Node oldLast = last;
        last = new Node();
        last.val = newVal;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }
    
    public String deque () {
        String val = first.val;
        first = first.next;
        if (isEmpty()) last = first;
        return val;
        
    }
    
    boolean isEmpty() {
        return first == null;
    }
 
    
}