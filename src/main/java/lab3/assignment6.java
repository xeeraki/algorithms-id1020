package lab3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.io.*;
import java.util.Scanner;

public class assignment6 {

    private assignment6() {
    }

    public static void main(String[] args) throws IOException {
    // key = word, value = set of files containing that word
    ST<String, SET<File>> st = new ST<String, SET<File>>();
        BufferedReader reader = new BufferedReader(new FileReader("gutenberg.txt"));
    // create inverted index of all files
        StdOut.println("Indexing files");
        for (String filename : args) {
        StdOut.println("  " + filename);
        File file = new File(filename);
        In in = new In(file);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (!st.contains(word)) st.put(word, new SET<File>());
            SET<File> set = st.get(word); String query = StdIn.readString();
            set.add(file);
        }
    }


    // read queries from standard input, one per line

        // compute frequency countsString key;
        String query;
        while ((query = reader.readLine()) != null) {
        if (st.contains(query)) {
            SET<File> set = st.get(query);
            for (File file : set) {
                StdOut.println("  " + file.getName());
            }
        }
    }

}

}


