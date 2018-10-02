package lab3;
/******************************************************************************************
 * algorithm 3.2  binary search is used in an ordered array.
 * This algorithms running time is compared to the algorithm 3.3 BST which use Binary search tree
 * and obtained that ...
 *
 * The running time using stop watch with leipzig100k.txt
 * words    = 100000
 * elapsed time = 72.226 s
 *
 *
 * The running time for gutenberg.txt
 * distinct = 95
 * words    = 12652
 * elapsed time = 2.0 s
 *
 *
 * This algorithm is much more slow compared to the algorithm BST.
* *****************************************************************************************************/
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdIn;
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
        if (val == null) {
            delete(key);
            return;
        }

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
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        N--;
        keys[N] = null;  // to avoid loitering
        vals[N] = null;

        // resize if 1/4 full
        if (N > 0 && N == keys.length/4) resize(keys.length/2);

    }
    public boolean contains(Key key) {
        if (key == null) ;
        return get(key) != null;
    }
    public Key min() {
        if (isEmpty());
        return keys[0];
    }


    public Key max() {
        if (isEmpty());
        return keys[N-1];
    }


    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

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
        // compute frequency countsString key;
        String key;
        while ((key = reader.readLine())!= null) { // Build symbol table and count frequencies.
            if (key.length() < minlen) continue; // Ignore short keys.
            words++;
            if (!st.contains(key)) {
                st.put(key, 1);
            } else {
                st.put(key, st.get(key) + 1);
                distinct++;
            }
        }
// Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        StdOut.println("elapsed time = " + timer.elapsedTime());

    }
}


