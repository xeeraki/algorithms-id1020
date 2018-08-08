import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class InsertionSort {

    public static void sort(Comparable[]a){
        int n = a.length;
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && less(a[j],a[j-1]); j--)
                exchange(a,j,j-1);
        }
    }

    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exchange(Comparable[] a , int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i] + "");

        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }


    public static void main(String[] args){
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
