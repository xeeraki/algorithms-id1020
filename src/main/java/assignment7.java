import java.util.*;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class assignment7<Item extends Comparable> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        Node next;
        Node prev;
        int item;
        public Node(int item){
        this.item = item;}
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
        Node newNode = new Node(item);
        if(first == null || first.item >= newNode.item){

            newNode.next = first;
            first = newNode;
        }
       Node current = first;

       while (current.next != null) {
           current = current.next;
           if(current.next.item < newNode.item){

               newNode.next = current.next;
               current.next = newNode;
               StdOut.println("pushed item " + item);
               return;
       }
      current = current.next;

           StdOut.println("pushed item " +item);
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

                list.push(1);
                list.push(2);
                list.push(4);
                list.push(3);
                list.push(0);

        for (Integer item : list) {
            StdOut.println(list);
        }
    }
}
