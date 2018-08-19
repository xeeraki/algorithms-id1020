
public class heapSort <Key extends Comparable <Key>>{
    private int N = 0;
    private Key pq[];

    public static void sort(Comparable[] pq){
    int N = pq.length;
    for(int k = N/2; k >= 1; k--)
        sink(pq,k,N);
    while(N > 1){
        exch(pq,1,N);
        sink(pq,1,--N);
    }

    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private static boolean less(Comparable[] pq,int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    public void swim(Comparable[] pq,int k,int N){

        while(k > 1 && less(pq,k/2,k)){
            exch(pq,k/2,k);
            k=k/2;
        }
    }

    public  static void exch(Comparable[] pq,int i, int j){
        Comparable temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }


    public static void sink(Comparable[] pq,int k, int N){
        while(2*k <= N) {
            int j = 2 * k;
            if (k > 1 && less(pq,j, j + 1)) j++;
            if (!less(pq,k, j)) break;
            exch(pq,k / 2, k);
            k = j;
        }
    }
}


