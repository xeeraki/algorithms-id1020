import edu.princeton.cs.introcs.In;

public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < E; i++)
            adj[i] = new Bag<>();

    }

    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEgde(v,w);
        }
    }

    public void addEgde(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return adj(v);
    }
}
