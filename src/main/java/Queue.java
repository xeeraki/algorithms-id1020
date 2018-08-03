import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

public class Queue<Item>{
    private Node first;
    private Node last;
    private int N;


    private class Node{
        Item item;
        Node next;
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

    public static void main(String[] args){
        Queue<String> s = new Queue<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.enqueue(item);
            else if(!s.isEmpty()) StdOut.print(s.dequeue() + " ");
        }
        StdOut.println("(" +s.size() + " left on ths queue");
    }
}
