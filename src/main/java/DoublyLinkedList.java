import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
public class DoublyLinkedList<Item> implements Iterable<Item> {


    private Node first; // before  first item
    private Node last; //after last item
    private int N;

    public DoublyLinkedList(){
        first = new Node();
        last = new Node();

        first.next = last;
        last.prev = first;

    }

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
//add item to the end of queue
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }
//delete item from the front of queue
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        else first.prev = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;
        private Node previous= last;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        public boolean hasPrevious() {
            return previous != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public Item previous(){
            Item item = current.item;
            current = current.prev;
            return item;
        }

        @Override
        public void remove() {

        }
    }
    //test client
    public static void main(String[] args){
        DoublyLinkedList<String> s = new DoublyLinkedList<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.enqueue(item);
            else if(!s.isEmpty()) StdOut.print("["+s.dequeue()+"]");
        }

        StdOut.println("(" + s.size() + " left on ths queue");

        for(String item: s) {
            StdOut.println("["+item+"]");
        }
    }
}
