package stackandqueue;

/*
 * Class StackOfStrings
 * Implements the stack ADT storing Strings using a list of nodes
 */
public class StackOfStrings {
    private class Node {
        String item;
        Node next;
    }
    private Node first;
    public StackOfStrings() {
        first = null;
    }
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    public String pop() {
        if (first==null) throw new NullPointerException();
        String item = first.item;
        first = first.next;
        return item;
    }
    public String peek() {
        if (first==null) throw new NullPointerException();
        return first.item;
    }
    public boolean empty() {
        return first==null;
    }
}