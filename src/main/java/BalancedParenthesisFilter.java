import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

public class BalancedParenthesisFilter<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    //inner class
    private class Node {

        Item item;
        Node next;
    }

    public void push(Item item) {

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public Item checkBalance(Item item) {
        for (Node x = first; x != null; x = x.next) {
            if (item.equals("(") || item.equals("{") || item.equals("[")) {
                push(item);
                //StdOut.println(s);
            } else if ((item.equals(")") || item.equals("}") || item.equals("]"))) {
                if ((first.item == "(" && item.equals(")"))
                        || (first.item == "{" && item.equals("}"))

                        || (first.item == "[" && item.equals("]"))) {
                    pop();
                    StdOut.println(" not balanced");
                } else {
                    StdOut.println("not Balanced");
                }
            } else {
                if ((item.equals("]") || item.equals("}") || item.equals(")"))) {
                    StdOut.println("not balanced");
                }
            }
        }
        return item;
    }


    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }


    public int size() {
        return N;
    }


    public String toString() {
        StringBuilder st = new StringBuilder();
        for (Item item : this) {
            //st.append(",");
            st.append(item);
            //st.append("]");
        }
        return st.toString();
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

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


    public static void main(String[] args) {
        BalancedParenthesisFilter<String> s = new BalancedParenthesisFilter<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
                s.checkBalance(item);

                //s.delete(2);
            } else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }

        StdOut.println("(" + s.size() + " left on ths queue");
        //StdOut.println(s.delete(3) + " node deleted at position 2");
        for (String item : s) {
            StdOut.println(item);
        }

    }
}