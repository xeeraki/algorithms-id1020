import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
public class assignment3 {
    public static void sort(Comparable[]a){
        int count = 0;
        int n = a.length;
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && less(a[j],a[j-1]); j--) {
                show(a);
                exchange(a, j, j - 1);
                count++;
            }
        }
        StdOut.println("Number of swaps "+ count);
    }
    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exchange(Comparable[] a , int i , int j){

        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        //StdOut.println("total swap "+count);
    }
    //print the sorted array
    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i] + "");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }
    public static void main(String[] args){
        StdOut.println("Enter the input size");
        int input = StdIn.readInt();
        String a[] = new String[input];
        StdOut.println("Enter the integers to be sorted");
        for(int i = 0; i < a.length; i++)
            a[i] = StdIn.readString();
        sort(a);
        //is the array sorted
        assert isSorted(a);
        //print the sorted array
        StdOut.println("The sorted Array");
        show(a);
    }
}
