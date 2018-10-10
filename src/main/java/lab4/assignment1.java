package lab4;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.io.*;
import java.util.*;


public class assignment1 {
    private boolean marked[];
    private int[]   edgeTo;
    private final int s;

    public assignment1(Graph g, int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g,s);
    }
    private void dfs(Graph g, int v) {
        marked[v] = true;
        for(int w : g.adj(v)){
            if(!marked[w])
                edgeTo[w] = v;
                dfs(g,w);
        }
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x]){
                path.push(x);
        }
        path.push(s);
        return path;
    }
    public static void main(String[] args) throws IOException {
        //contiguous-usa.dat
       BufferedReader scanner = new BufferedReader(new FileReader("tiny.txt"));
        while (scanner !=null) {      // while there is another token to read
            Graph G = new Graph(scanner.read());
            Scanner scan = new Scanner(System.in);
            int s = scan.nextInt();
/*        Scanner scan = new Scanner(new FileInputStream("tiny.txt"));
        while(scan.hasNext()){
            int r = Integer.parseInt(scan.next());
            int s = Integer.parseInt(scan.next());
            Graph G = new Graph(r);
            if(args.length < 1) {
                System.exit(1);
                Graph G = new Graph(Integer.parseInt(args[0]));
                int s = Integer.parseInt(args[1]);*/


            assignment1 search = new assignment1(G,s);

            for (int v = 0; v < G.V(); v++) {
                System.out.print(s + " to " + v + ": ");
                if (search.hasPathTo(v))
                    for (int x : search.pathTo(v))
                        if (x == s) System.out.print(x);
                        else System.out.print("-" + x);
                System.out.println();
            }
        }
    }
}
