import javax.xml.soap.Node;

public class Stack<Item> {

    private Node first;
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
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

}
