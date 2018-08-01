import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class FixedCapacityStackStrings<Item> {

    private Item[] a;
    private int n;


    public FixedCapacityStackStrings(int cap){
        a = (Item[])new String[cap];

    }

 public boolean isEmpty(){
        return n == 0;
 }
 public int size(){
        return n;
 }

 public void push(Item item){
        a[n++] = item;
 }

 public Item pop(){
        return a[--n];
 }



 public static void main(String[] args){
        FixedCapacityStackStrings<String> s = new FixedCapacityStackStrings<String>(100);

        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(s.equals("-")) s.push(item);
            else if(!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
 }
}
