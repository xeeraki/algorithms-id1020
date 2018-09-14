import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;

    //inner class
    private class Node{

        Item item;
        Node next;
    }

    public void push(Item item){

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop(){
        Item item = last.item;
        last.next=null;
        N--;
        return item;
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

    public Boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

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
        Stack<String> s = new Stack<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("\n"))
                s.push(item);
            else if(!s.isEmpty()) StdOut.print(s.pop() +"");
        }

        StdOut.println("(" + s.size() + " left on ths queue");

        for(String item: s) {
            StdOut.println(item);
        }
    }

}
