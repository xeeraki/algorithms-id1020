import java.util.*;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;


public class assignment7<Item extends Comparable> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Node next;
        Node prev;
        int item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    private static Boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void push(int item) {
        Node newNode = new Node();
        newNode.item = item;
        Node current;
        if (first == null || first.item >= newNode.item) {
            newNode.next = first;
            first = newNode;
            StdOut.println("pushed item " + item);
        } else {
            current = first;

            while (current.next != null &&
                    current.next.item < newNode.item)
                current = current.next;

            newNode.next = current.next;
            current.next = newNode;
            N++;

            StdOut.println("pushed item " + item);
        }
    }


    public void printList(){
        for(Node x = first; x != null; x =x.next ){
            StdOut.print(x.item + " ");
        }
    }


    public int pop() {
        int item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        StdOut.println("popped item" + item);
        return item;
    }

    public Iterator<Item> iterator() {
        return (Iterator<Item>) new ListIterator();
    }

    private class ListIterator implements Iterator<Integer> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            int item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {

        assignment7<Integer> list = new assignment7<>();
        for (int i = 0; i < 6; i++)
            list.push(StdRandom.uniform(10));
                list.printList();
    }

}