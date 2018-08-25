import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

public class SequentialSearchST<Key , Value> {

    private Node first;
    private Node last;
    private int N;

    private class Node{
        Key key;
        Node next;
        Value val;


        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public SequentialSearchST() {
    }

    public int size(){
        return N;
    }

/*
    public void enqueue(Key key,Value val){
        Node oldLast = last;
        last = new Node(key,val,first);
        last.key = key;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }
*/

    public boolean isEmpty(){
        return size() == 0;
    }
    //lazy version of delete
    public void delete(Key key){
        //put(key,null);
        first = delete(first,key);
    }

    private Node delete(Node x, Key key){
        if(x == null)
            return null;
        if(key.equals(x.key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next,key);
        return x;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }


    public Value get(Key key){

        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;
        return null;
    }


    public void put(Key key , Value val){
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key)){
                x.val = val;
            return;}
        first = new Node(key , val ,first);
        N++;
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return (Iterable)queue;
    }

    public static void main(String[] args){
        SequentialSearchST<String , Integer> st = new SequentialSearchST<String, Integer>();
        for(int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key,i);
        }

        for(String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
