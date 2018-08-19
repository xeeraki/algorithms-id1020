public class MaxPQ<Key extends Comparable<Key>> {
    private int N = 0;
    private Node first;
    private Key pq[];

    private class Node{
        Key key;
        Node next;
    }

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public  Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private boolean less(int v, int w){
        return pq[v].compareTo(pq[w])<0;
    }
    public void swim(int k){

            while(k > 1 && less(k/2,k)){
                exch(k/2,k);
            k=k/2;
        }
    }

    public  void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }


    public void sink(int k){
        while(2*k <= N) {
            int j = 2 * k;
            if (k > 1 && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k / 2, k);
            k = j;
        }
    }
}
