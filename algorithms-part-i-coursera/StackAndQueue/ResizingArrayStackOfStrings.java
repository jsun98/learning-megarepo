/**
 * Class ResizingArrayStackOfStrings
 * Implements the Stack ADT using an resizing array
 */
public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N;
    
    private void resize(int len) {
        String[] newS = new String[len];
        int length = s.length > len ? len : s.length;
        for (int i = 0; i < length; i++) {
            newS[i] = s[i];
        }
        s = newS;
    }
    
    public ResizingArrayStackOfStrings() {
        s = new String[1];
        N = 0;
    }
    
    //resizes the array times 2 when N == s.length
    public void push (String item) {
        if (N == s.length) 
            resize(2 * s.length);
        s[N++] = item;
    }
    
    //resizes the array by half when N == s.length / 4
    public String pop () {
        String item = s[--N];
        s[N] = null;
        if (N>0 && N == s.length / 4)
            resize(s.length / 2);
        return item;
    }
    
}