import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class weightedQuickUnionUF {

    private int[] id;
    private int count;
    private int[] sz; // size of component for roots (sites indexed)

    public weightedQuickUnionUF(int n){
        count = n;
        id = new int[n];
        for(int i = 0; i < n; i++)
            id[i] = i;
        sz = new int[n];
        for(int i = 0; i < n; i++)
            sz[i] = 1;
    }
    private int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q){

      int i = find(p);
      int j = find(q);
      if(i == j) return;
      //make smaller root point to larger one
      if(sz[i] < sz[j]){id[i] = j; sz[j] += sz[i];}
      else { id[j] = i; sz[i] += sz[j];

          }
        count--;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }


    public static void main(String[] args){
        int N = StdIn.readInt();
       weightedQuickUnionUF uf = new weightedQuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p +" " +q);
        }
        StdOut.println(uf.count() + "components");

    }
}
