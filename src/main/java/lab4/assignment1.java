package lab4;

import edu.princeton.cs.algs4.Graph;

public class assignment1 {
    private boolean marked[];
    private int count;



    public assignment1(Graph g, int s){
        marked = new boolean[g.V()];
        dfs(g,s);

    }

    private void dfs(Graph g, int v) {

        marked[v] = true;
        count++;
        for(int w : g.adj(v)){
            if(!marked[w])
                dfs(g,w);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count(){
        return count;
    }
}
