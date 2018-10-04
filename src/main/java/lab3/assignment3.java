package lab3;
/***************************************************************************************************
 * To run the main method user need to provide a.txt file in the same directory as the project
 * The text file name should be given inside FileReader
 * The user need to enter an arbitrary length cutoff integer.
 * The text file used for measurement from http://www.gutenberg.org/files/98/98-0.txt
 ****************************************************************************************************/
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class assignment3<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int size;


        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }


    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }


    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }

    public boolean contains(Key key) {
        if (key == null) ;
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }


    public static void main(String[] args) throws IOException {
        int distinct = 0, words = 0;
        assignment3<String, Integer> st = new assignment3<String, Integer>();
        Stopwatch timer = new Stopwatch();
        Scanner scan = new Scanner(System.in);
        int minlen = scan.nextInt(); // length cutoff
        //int maxlen = scan.nextInt();

        BufferedReader reader = new BufferedReader(new FileReader("gutenberg.txt"));
        String key;
        while ((key = reader.readLine())!= null) {
            String[] keys = key.split(" ");
            for (String word : keys) {
            if ((word.length() < minlen))
                continue; // Ignore keys out of this range.
                words++;
                if (!st.contains(word)) {
                    st.put(word, 1);
                } else {
                    st.put(word, st.get(word) + 1);
                    distinct++;

                }

            }
        }
// Find a key with the highest frequency count.
        String max = "";
        String min = "";
        st.put(max, 0);
        st.put(min,0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
                StdOut.println(max + " " + st.get(max));
            }
        }    //StdOut.println(st.ceiling(max));

                StdOut.println("distinct = " + distinct);
                StdOut.println("words    = " + words);
                StdOut.println("elapsed time = " + timer.elapsedTime());

    }

}







