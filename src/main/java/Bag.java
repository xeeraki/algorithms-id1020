import java.util.Iterator;
import java.util.ListIterator;

public class Bag<Item> implements Iterable<Item> {
    private int N;
    private Node first;

    private class Node{
        Node next;
        Item item;
    }

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    boolean isEmpty(){
        return N == 0;
    }

    int size(){

        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(); }

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
}
