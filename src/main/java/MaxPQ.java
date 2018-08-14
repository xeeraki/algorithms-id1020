public class MaxPQ<Key extends Comparable<Key>> {
    private int N;
    private Node first;

    private class Node{
        Key key;
        Node next;
    }

    public MaxPQ(){

    }
    public MaxPQ(int max,int capacity){

    }

    public MaxPQ( Key[] a){

    }


    public void insert(Key key){
        Node oldfirst = first;
        first = new Node();
        first.key = key;
        first.next = oldfirst;
        N++;

    }

    public  Key delMax(Key max){


        return max;
    }

    public Key max(Key max){
        Key maxi = key[i];
        for(int i = 0; i < key.length; i++){

            if(less(maxi,max))
                maxi = max;
        }
        return max;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public boolean less(Key v, Key w){
        return v.compareTo(w)<0;
    }
}
