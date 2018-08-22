import static edu.princeton.cs.introcs.BinaryStdIn.isEmpty;

public class binarySearchST<Key extends Comparable<Key> , Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;


    public binarySearchST(int capacity){
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

}
