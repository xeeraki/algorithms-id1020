import edu.princeton.cs.introcs.StdOut;
import java.util.Iterator;

public class LinkedList{
      private  Node first;

      private class Node {
            int item;
            Node next;
            public Node(int item){
                this.item = item;
                next = null;
            }
        }
        public void push(Node newNode)
        {
            Node current;

            if (first == null || first.item >= newNode.item)
            {
                newNode.next = first;
                first = newNode;
            }
            else {
                current = first;

                while (current.next != null &&
                        current.next.item < newNode.item)
                    current = current.next;
                //swap
                newNode.next = current.next;
                current.next = newNode;
            }
        }
       public Node newNode(int item)
        {
            Node node = new Node(item);
            return node;
        }

        void printList()
        {
            Node temp = first;
            while (temp != null) {
                StdOut.print(temp.item+" ");
                temp = temp.next;
            }
        }
/*    public Iterator<Item> iterator() {
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
    }*/
        public static void main(String args[])
        {
            LinkedList list = new LinkedList();
            Node newNode;
            newNode = list.newNode(1);
            list.push(newNode);
            newNode = list.newNode(2);
            list.push(newNode);
            newNode = list.newNode(4);
            list.push(newNode);
            newNode = list.newNode(3);
            list.push(newNode);
            newNode = list.newNode(5);
            list.push(newNode);
            newNode = list.newNode(0);
            list.push(newNode);
            list.printList();
            }

        }


