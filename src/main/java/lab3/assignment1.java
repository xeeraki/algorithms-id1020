package lab3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class assignment1<Key , Value>{

    private Node first;
    private int N;

    private class Node {
        Key key;
        Node next;
        Value val;


        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public assignment1() {
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //lazy version of delete
    public void delete(Key key) {
        //put(key,null);
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        if (key.equals(x.key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }


    public Value get(Key key) {

        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;
        return null;
    }


    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        first = new Node(key, val, first);
        N++;
    }


    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    public static void main(String[] args) throws IOException {
        assignment1<Character, Integer> st = new assignment1<Character, Integer>();

        BufferedReader file = new BufferedReader(new FileReader("gutenberg.txt"));
        String key;
        while ((key = file.readLine())!=null) {
            for (int i = 0; i != key.length(); i++) {
                char c = key.charAt(i);
                if (!Character.isLetter(c)) {
                    c = ' ';
                }
                st.put(c, st.contains(c) ? st.get(c) + 1 : 1);
                for (Character s : st.keys())
                    StdOut.println(s +" " +st.get(s));
            }
        }
    }
}