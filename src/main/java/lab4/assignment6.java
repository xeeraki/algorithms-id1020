package lab4;
/********************************************************************************************************
 * Find the directed cycle
 * out put:
 *******************************************************************************************************/

import edu.princeton.cs.algorithms.Digraph;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.StdOut;

import java.io.*;
import java.util.Scanner;

public class assignment6 {
        private boolean[] marked;        // marked[v] = has vertex v been marked?
        private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
        private boolean[] onStack;       // onStack[v] = is vertex on the stack?
        private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)

        /**
         * Determines whether the digraph {@code G} has a directed cycle and, if so,
         * finds such a cycle.
         */
        public assignment6(Digraph G) {
            marked  = new boolean[G.V()];
            onStack = new boolean[G.V()];
            edgeTo  = new int[G.V()];
            for (int v = 0; v < G.V(); v++)
                if (!marked[v] && cycle == null) dfs(G, v);
        }

        // check that algorithm computes either the topological order or finds a directed cycle
        private void dfs(Digraph G, int v) {
            onStack[v] = true;
            marked[v] = true;
            for (int w : G.adj(v)) {

                // short circuit if directed cycle found
                if (cycle != null) return;

                    // found new vertex, so recur
                else if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(G, w);
                }

                // trace back directed cycle
                else if (onStack[w]) {
                    cycle = new Stack<Integer>();
                    for (int x = v; x != w; x = edgeTo[x]) {
                        cycle.push(x);
                    }
                    cycle.push(w);
                    cycle.push(v);
                }
            }
            onStack[v] = false;
        }


         //Does the digraph have a directed cycle?

        public boolean hasCycle() {
            return cycle != null;
        }

         //Returns a directed cycle if the digraph has a directed cycle

        public Iterable<Integer> cycle() {
            return cycle;
        }


        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(new FileInputStream("tinyDAG.txt"));
            while (scanner.hasNext()) {// while there is another token to read
                int r = scanner.nextInt();

            Digraph G = new Digraph(r);

            assignment6 finder = new assignment6(G);
            if (finder.hasCycle()) {
                StdOut.print("Directed cycle: ");
                for (int v : finder.cycle()) {
                    StdOut.print(v + " ");
                }
                StdOut.println();
            }

            else {
                StdOut.println("No directed cycle");
            }
            StdOut.println();
        }

    }
}
