import edu.princeton.cs.introcs.StdRandom;

public class QuickSort {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi+1;
        Comparable v = a[lo];

        while(true){
            while(less(a[++i]))
        }


    }
}
