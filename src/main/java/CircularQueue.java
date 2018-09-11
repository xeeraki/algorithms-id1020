import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

public class CircularQueue<Item> implements Iterable<Item> {

        private Node first;
        private Node last;
        private int N;


        private class Node {
            Item item;
            Node next;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return N;
        }

        public void enqueue(Item item) {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else oldLast.next = last;
            N++;
        }

        public Item dequeue() {
            Item item = first.item;
            first = first.next;
            if (isEmpty()) last = null;
            N--;
            return item;


        }

        public static void main(String[] args) {
            Queue<String> s = new Queue<>();
            while (!StdIn.isEmpty()) {
                String item = StdIn.readString();
                if (!item.equals("-"))
                    s.enqueue(item);
                else if (!s.isEmpty()) StdOut.print(s.dequeue() + " ");
            }
            StdOut.println("(" + s.size() + " left on ths queue");
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
}
