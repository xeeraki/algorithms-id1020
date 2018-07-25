import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class testClient {
    public static void main(String[] args){
        Stack<String> str = new Stack<String>();

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
            str.push(item);
            else if(!str.isEmpty())StdOut.print(str.pop() + "");
        }
        StdOut.println("(" + str.size() + " left on stack)");

    }
}
