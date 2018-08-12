import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class mergeSort {
    private static Comparable[] aux;
    private static void show(String[] a) {
        for(int i = 0; i < a.length-1; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();

    }
    public static void main(String[] args){
        String [] a = StdIn.readAllStrings();
        sort(a);
        show(a);
    }
    private static void merge(Comparable[] a , Comparable[] aux, int lo, int mid, int hi){
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo, j = mid +1;
        for(int k = lo; k <= hi; hi++){
            if(i > mid)       a[k] = aux[j++];
            else if(j > hi)   a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    private static void sort(Comparable[] a,Comparable[] aux, int lo,int hi){
        if(hi <= lo) return;// if one element it's already sorted
        int mid = lo + (hi - lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
}
