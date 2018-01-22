
public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N;
    public FixedCapacityStackOfStrings (int size) {
        N = 0;
        s = new String[size];
    }
    public void push(String item) {
        if (N==s.length) throw new ArrayIndexOutOfBoundsException();
        s[N++] = item;
    }
    public String pop() {
        if(empty()) throw new ArrayIndexOutOfBoundsException();
        String top = s[--N];
        s[--N] = null;
        return top;
        
    }
    public boolean empty() {
        return N==0;
    }
}