import static edu.princeton.cs.introcs.BinaryStdIn.isEmpty;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.*;
import java.util.Queue;

public class BinarySearchST<Key extends Comparable<Key> , Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }


    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[])new Object[capacity];

    }

    public int size(){
        return N;
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = N-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) hi = mid-1;
            else if(cmp > 0) lo = mid +1;
            else return mid;
        }
        return lo;

    }

    public void put(Key key, Value val){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }

        for(int j = N; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }



    public void delete(Key key){

    }

    public Key min()
    { return keys[0];
    }
    public Key max()
    { return keys[N-1];
    }
    public Key select(int k)
    { return keys[k]; }
    public Key ceiling(Key key)
    {
        int i = rank(key);
        return keys[i];
    }
    //public Key floor(Key key)
    // See Exercise 3.1.17.
    private boolean contains(Key hi) {
        return size() != 0;
    }

   /*public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new PriorityQueue<Key>();
        for  (int i = rank(lo); i < rank(hi); i++)
            queue.(keys[i]);
        if (contains(hi))
            queue.enqueue(keys[rank(hi)]);
        return queue;
    }
*/


}
