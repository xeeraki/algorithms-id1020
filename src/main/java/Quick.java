import edu.princeton.cs.introcs.StdRandom;

public class Quick {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo)return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[]a, int lo, int hi){
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true){
            while(less(a[++i],v)) if(i ==hi) break;
            while (less(v,a[--j])) if(j == lo) break;
            if(i >= j)break;
            exchange(a,i,j);
        }
        exchange(a,lo,hi);
        return j;
    }

    private static boolean  less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

}
