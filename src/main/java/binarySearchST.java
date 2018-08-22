public class binarySearchST<Key extends Comparable<Key> , Value> {

    private Key[] keys;
    private Value[] val;
    private int N;


    public binarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        val = (Value[])new Comparable[capacity];

    }

}
