package lab3;
/***************************************************************************************************
 * To run the main method user need to provide a.txt file in the same directory as the project
 * The text file name should be given inside FileReader
 * The text file used for measurement from http://www.gutenberg.org/files/98/98-0.txt
 ****************************************************************************************************/

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdOut;

import java.io.*;

public class assignment1<Key extends Comparable<Key>, Value> {

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
        BufferedReader reader = new BufferedReader(new FileReader("gutenberg.txt"));
        String key;
        while ((key = reader.readLine()) != null) {
            for (int i = 0; i != key.length(); i++) {
                char c = key.charAt(i);
                if (!Character.isLetter(c) || c == ' ' || c == '\n') {
                    c = ' ';
                }
                if (!st.contains(c)) st.put(c, 1);
                else
                    st.put(c, st.get(c) + 1);
                //st.put(c, st.contains(c) ? st.get(c) + 1 : 1);
            }
        }
        for (Character s : st.keys())
            StdOut.println(s + " " + st.get(s));

    }
}