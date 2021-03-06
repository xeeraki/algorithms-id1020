package lab4;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.io.*;
import java.util.Scanner;

public class assignment2 {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path

    public assignment2(Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    // breadth-first search from a single source
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {

        return marked[v];
    }

    public int distTo(int v) {

        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new FileReader("tiny.txt"));
        while (scanner !=null) {      // while there is another token to read
            Graph G = new Graph(scanner.read());
            Scanner scan = new Scanner(System.in);
            int s = scan.nextInt();
/*        Scanner scan = new Scanner(new FileInputStream("tiny.txt"));
        while(scan.hasNext()){
            int r = scan.nextInt();
            int s =scan.nextInt();
            Graph G = new Graph(r);*/
                assignment2 bfs = new assignment2(G, s);
                for (int v = 0; v < G.V(); v++) {
                    if (bfs.hasPathTo(v)) {
                        StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                        for (int x : bfs.pathTo(v)) {
                            if (x == s) StdOut.print(x);
                            else StdOut.print("-" + x);
                        }
                        StdOut.println();
                    } else {
                        StdOut.printf("%d to %d (-):  not connected\n", s, v);
                    }

                }
            }
        }


}