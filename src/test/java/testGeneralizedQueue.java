import edu.princeton.cs.introcs.StdOut;
import org.junit.Test;
public class testGeneralizedQueue {


    @Test
    public void delete() {
        GeneralizedQueue<String> s = new GeneralizedQueue<String>();
        s.delete(3);
        StdOut.println(s);
    }
}
