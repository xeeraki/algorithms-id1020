import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import java.util.Iterator;



public class GeneralizedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;



    private class Node{
        Item item;
        Node next;
        Node prev;
    }

    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }

    public Item delete(int position) {

       if (position == 1) {
           Item item = first.item;
           first = first.next;
           if(isEmpty()) last = null;
           N--;
           return item;
        } else {
           Node previous = first;
           int count = 1;
           while (count < position - 1) {
               previous = previous.next;
               count++;
           }
           Node current = previous.next;
           Item item = current.item;
           previous.next = current.next;
           current.next = null;
           N--;
           return item;
       }
    }
    public String toString(){
        StringBuilder st = new StringBuilder();
        for(Item item:this) {
            st.append("[");
            st.append(item);
            st.append("]");
        }
        return st.toString();
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args){
        GeneralizedQueue<String> s = new GeneralizedQueue();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) {
                s.enqueue(item);
                //s.delete(2);
            }else if(!s.isEmpty()) StdOut.print("["+s.dequeue()+"]");
        }

        StdOut.println("(" + s.size() + " left on ths queue");
        StdOut.println(s.delete(3) + " node deleted at position 2");
        for(String item: s) {
            StdOut.println("["+item+"]");
        }

    }
}
