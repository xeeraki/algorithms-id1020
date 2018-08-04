import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class QuickUnion {
    private int[] id;
    private int count;

    public QuickUnion(int n){
        count = n;
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }
    private int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q){

     int pRoot = find(p);
     int qRoot = find(q);
     if(pRoot == qRoot) return;
     id[pRoot] = qRoot;
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
        QuickUnion uf = new QuickUnion(N);
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

