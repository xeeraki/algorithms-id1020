import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class slectionSorNoComparable {

    public static void sort(int a[]){

    for(int i = 0; i < a.length; i++){
        int min = i;
        for(int j = i+1; j < a.length; j++) {
        if(a[i] > a[j])
            min = j;
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

   }

    private static void show(int[] a){
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i] + "");

        StdOut.println();
    }
    public static void main(String[] args){
        int[] a = StdIn.readAllInts();
        sort(a);
        show(a);
    }
}
