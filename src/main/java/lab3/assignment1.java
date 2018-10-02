package lab3;
/*********************************************************************************************
*  key value
 *
 * Q 29
 * x 663
 * z 215
 * q 637
 * X 60
 * V 115
 * W 605
 * K 54
 * I 2874
 * H 886
 * O 328
 * M 1626
 * U 83
 * N 412
 * J 281
 * R 220
 * F 438
 * S 896
 * L 835
 * p 9464
 * Y 438
 * v 5088
 * m 13670
 * d 27057
 * D 990
 * y 11748
 * s 36692
 * i 38143
 * C 754
 * w 13516
 * l 21213
 * a 47273
 * A 897
 * f 13125
 * k 4733
 * B 535
 * E 413
 * g 12163
 * b 7887
 * n 41974
 * u 16656
 * G 385
 * t 52358
 * c 13149
 * j 433
 * o 46208
 * r 36994
 * P 496
 *   160501
 * e 74427
 * h 38090
 * T 1695
*
* **********************************************************************************************/
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
        BufferedReader reader = new BufferedReader(new FileReader("gutenberg.txt"));
        String key;
        while ((key = reader.readLine()) != null) {
            for (int i = 0; i != key.length(); i++) {
                char c = key.charAt(i);
                if (!Character.isLetter(c)) {
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