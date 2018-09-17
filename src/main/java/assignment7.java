import java.util.Iterator;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class assignment7<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;


    private class Node {
        Node next;
        Item item;
    }
    public Boolean isEmpty() {
        return first = null;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    private class ListIterator<Item> implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = (Item) current.item;
            current = current.next;
            return item;

        }

        @Override
        public void remove() {

        }

    }

    public static void main(String[] args){
        assignment7<Integer> s = new assignment7<Integer>();
        while(!StdIn.isEmpty()){
            Integer item = StdIn.readInt();
            if(!item.equals("\n"))
                s.push(item);
            else if(!s.isEmpty()) StdOut.print(s.pop() +"");
        }

        StdOut.println("(" + s.size() + " left on ths queue");

        for(Integer item: s) {
            StdOut.println(item);
        }
    }

    private void push(Item item) {


    }

}