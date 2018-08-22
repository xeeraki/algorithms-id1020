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
        if(i < N && keys[i].compareTo(key)== 0)
            return vals[i];
        else
            return null;
    }

    private int rank(Key key) {
        
    }

}
