import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class QuickSort {
    public static void main(String[] args){
        String[] a  = StdIn.readAllStrings();
        sort(a);
        show(a);
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;//return -1 , 0 or 1
    }



    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi+1;
        Comparable v = a[lo];// pivot(partition element)

        while(true){
            while(less(a[++i] ,v))
                if(i == hi)break;//to check not out of bound
            while(less(v, a[--j]))
                if(j == lo)break;//to check not out of bound
            if(i >= j) break;// if pointer cross each other
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;


    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return; // if just one  element in the array
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }


    private static void exch(Comparable[] a , int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void show(String[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + "");

        StdOut.println();
    }

}
