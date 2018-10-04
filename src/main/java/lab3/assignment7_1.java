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
import java.util.Scanner;

public class assignment7_1<Key , Value> {
    private static final int INIT_CAPACITY = 4;
    private int n;
    private int m = 100;
    private Key[] keys;
    private Value[] vals;


    public assignment7_1(int capacity){
        m = capacity;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];

    }

    public assignment7_1() {
        this(INIT_CAPACITY);
    }


    private int hash(Key key){
        return (key.hashCode()&0x7fffffff) % m;
    }

    private void resize(int capacity) {
        assignment7_1<Key, Value> temp = new assignment7_1<>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m = temp.m;
    }
    public void put(Key key, Value val){
        if(n >= m/2) resize(2*m);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    public Value get(Key key){
        for(int i = hash(key); keys[i] != null; i = (i+1) % m)
            if(keys[i].equals(key))
                return vals[i];
        return null;
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }



    public static void main(String[] args) throws IOException {
    int distinct = 0, words = 0;
    assignment7_1<String, Integer> st = new assignment7_1<String, Integer>();
    Scanner scan = new Scanner(System.in);
    int minlen = scan.nextInt(); // length cutoff
    //int maxlen = scan.nextInt();

    BufferedReader reader = new BufferedReader(new FileReader("gutenberg.txt"));
    String key;
        while ((key = reader.readLine()) != null) {
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
        st.put(max, 0);
        for (String word : st.keys()) {
        if (st.get(word) > st.get(max)) {
            max = word;
        }
    }
    Stopwatch timer = new Stopwatch();
        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        StdOut.println("elapsed time = " + timer.elapsedTime());

}

}
