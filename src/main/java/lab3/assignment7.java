package lab3;
/***************************************************************************************************
 * To run the main method user need to provide a.txt file in the same directory as the project
 * The text file name should be given inside FileReader
 * The user need to enter an arbitrary length cutoff integer.
 * The text file used for measurement from http://www.gutenberg.org/files/98/98-0.txt
 ****************************************************************************************************/
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdOut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class assignment7 <Key, Value >{
    private static final int INIT_CAPACITY = 4;

    private int n;
    private int m;
    private SequentialSearchST<Key, Value>[] st;


    public assignment7(){
        this(INIT_CAPACITY);
    }

    public assignment7(int m){
        this.m = m;
        st = (SequentialSearchST<Key,Value>[]) new SequentialSearchST[m];
        for(int i = 0; i < m; i++){
            st[i] = new SequentialSearchST<Key,Value>();
        }

    }
    private void resize(int chains) {
        assignment7<Key, Value> temp = new assignment7<>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key){
        int i = hash(key);
        return  st[i].get(key);
    }

    public void put(Key key , Value val){
        // double table size if average length of list >= 10
        if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if(!st[i].contains(key))
            st[i].put(key,val);
        n++;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public int size() {
        return n;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
    public static void main(String[] args) throws IOException {
        int distinct = 0, words = 0;
        assignment7<String, Integer> st = new assignment7<String, Integer>();
        Scanner scan = new Scanner(System.in);
        int minlen = scan.nextInt(); // key-length cutoff

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
        //Stopwatch timer = new Stopwatch();
        //Find a key with the highest frequency count.
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
