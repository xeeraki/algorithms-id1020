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

import java.io.*;
import java.util.Scanner;

import static edu.princeton.cs.introcs.BinaryStdIn.isEmpty;

public class assignment2<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int N;


    public assignment2() {
        this(INIT_CAPACITY);

    }

    public assignment2(int capacity) {
        // See Algorithm 1.1 for standard array-resizing code.
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }


    public int size() {
        return N;
    }


    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
            return null;
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;

    }

    // See page 381.
    public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
        int i = rank(key);
        //if key already in the table
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        if (N == keys.length) resize(2 * keys.length);

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    public boolean contains(Key key) {
        if (key == null) ;
        return get(key) != null;
    }
    public Key min() {
        return keys[0];
    }


    public Key max() {
        return keys[N-1];
    }


    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }

    public static void main(String[] args) throws IOException {
        int distinct = 0, words = 0;
        Scanner scan = new Scanner(System.in);
        int minlen = scan.nextInt();
        // key-length cutoff
        assignment2<String, Integer> st = new assignment2<String, Integer>();

        Stopwatch timer = new Stopwatch();
        BufferedReader reader = new BufferedReader(new FileReader("gutenberg.txt"));
        String key;
        while ((key = reader.readLine())!= null){
            String[] keys = key.split(" ");
            for (String word : keys) {
                if ((word.length() < minlen))
                    continue;
                // Ignore keys out of this range.
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
        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        StdOut.println("elapsed time = " + timer.elapsedTime());

    }
}


