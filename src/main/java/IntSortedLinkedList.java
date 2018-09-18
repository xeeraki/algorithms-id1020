import java.util.Random;

public class IntSortedLinkedList {

        // Linked List Node Object
        class Node {
            public Node prev;
            public Node next;
            public int value;
            public Node(int val) {
                this.value = val;
            }
        }

        // public and private Fields
        public Node head;
        public Node tail;
        private int size = 0;

        // Insert the new node
        // If nodeToInsertAfter is null, make the newNode to be the head node
        // Else If nodeToInsertAfter.next is null, make the newNode to be the tail node
        // Else Insert the newNode after the node nodeToInsertAfter
        private void insertNode(Node nodeToInsertAfter, Node newNode) {
            Node tmpNode;
            if (nodeToInsertAfter == null) {
                this.head.prev = newNode;
                tmpNode  = this.head;
                this.head = newNode;
                this.head.next = tmpNode;
                if (this.size <= 1) {
                    this.tail = tmpNode;
                    this.tail.next = null;
                }
            } else if (nodeToInsertAfter.next == null) {
                newNode.prev = nodeToInsertAfter;
                nodeToInsertAfter.next = newNode;
                this.tail = newNode;
            } else {
                Node prevNode, nextNode;
                prevNode = nodeToInsertAfter;
                nextNode = nodeToInsertAfter.next;
                prevNode.next = newNode;
                newNode.prev = prevNode;
                newNode.next = nextNode;
                nextNode.prev = newNode;
            }
            this.size++;
        }

        // Find the node that the new node will be inserted after it
        private Node findNodeToInsertAfter(Node newNode) {
            Node curNode = this.head;
            if (newNode.value < curNode.value) {
                return null;
            }
            while(curNode.next != null) {
                if (newNode.value == curNode.value) {
                    return curNode;
                }
                else if (newNode.value > curNode.value && newNode.value < curNode.next.value) {
                    return curNode;
                }
                curNode = curNode.next;
            }
            return curNode;
        }

        // Get the value and create the new node to be inserted.
        // If the current list is null, set the new node to be the head.
        // Else find nodeToInsertAfter and then insertNode accordingly.
        public void insert(int value) {
            System.out.println("value: " + value);
            Node newNode = new Node(value);
            Node nodeToInsertAfter;
            if (this.head == null) {
                this.head = newNode;
                this.head.next = this.tail;
                this.size++;
            } else {
                nodeToInsertAfter = findNodeToInsertAfter(newNode);
                if (nodeToInsertAfter == null || nodeToInsertAfter.value != newNode.value) {
                    insertNode(nodeToInsertAfter, newNode);
                }

                if (this.tail == null)System.out.println("tail is null when value is : " + value);
            }
        }

        public int getSize() {
            return this.size;
        }

        public void print() {
            Node curNode = this.head;
            while(curNode != null) {
                System.out.println(curNode.value);
                curNode = curNode.next;
            }
        }

        public void reversePrint() {
            Node curNode = this.tail;
            while(curNode != null) {
                System.out.println(curNode.value);
                curNode = curNode.prev;
            }
        }

        public static void main(String args[]) {
            IntSortedLinkedList ll = new IntSortedLinkedList();
            Random rand = new Random();
            int testSize = 5;
            int maxNum = 100;
            for(int i=0; i<testSize; i++) {
                ll.insert(rand.nextInt(maxNum)+1);
            }
            ll.print();
            System.out.println("..........................");
            ll.reversePrint();
            System.out.println("list size: " + ll.getSize());
        }
    }

