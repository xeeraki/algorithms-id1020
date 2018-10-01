package lab3;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import static edu.princeton.cs.introcs.BinaryStdIn.isEmpty;

public class assignment2 {

    public class BinarySearchST<Key extends Comparable<Key>, Value>
    {
        private Key[] keys;
        private Value[] vals;
        private int N;
        public BinarySearchST(int capacity)
        {
            // See Algorithm 1.1 for standard array-resizing code.
            keys = (Key[]) new Comparable[capacity];
            vals = (Value[]) new Object[capacity];
        }
        public int size()
        { return N; }
        public Value get(Key key)
        {
            if (isEmpty()) return null;
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0) return vals[i];
            else
                return null;
        }
        public int rank(Key key)
        // See page 381.
        public void put(Key key, Value val)
        { // Search for key. Update value if found; grow table if new.
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0)
            { vals[i] = val; return; }
            for (int j = N; j > i; j--)
            { keys[j] = keys[j-1]; vals[j] = vals[j-1]; }
            keys[i] = key; vals[i] = val;
            N++;
        }
        public void delete(Key key)
// See Exercise 3.1.16 for this method.
    }









        public static void main(String[] args)
        {
            int minlen = Integer.parseInt(args[0]);
            // key-length cutoff
            ST<String, Integer> st = new ST<String, Integer>();
            while (!StdIn.isEmpty())
            { // Build symbol table and count frequencies.
                String word = StdIn.readString();
                if (word.length() < minlen) continue; // Ignore short keys.
                if (!st.contains(word)) st.put(word, 1);
                else
                    st.put(word, st.get(word) + 1);
            }
// Find a key with the highest frequency count.
            String max = "";
            st.put(max, 0);
            for (String word : st.keys())
                if (st.get(word) > st.get(max))
                    max = word;
            StdOut.println(max + " " + st.get(max));
        }
    }


