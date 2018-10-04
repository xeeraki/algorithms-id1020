package lab3;
/***************************************************************************************************
 * To run the main method user need to provide a.txt file in the same directory as the project
 * The text file name should be given inside FileReader
 * The user need to enter an arbitrary word to search for.
 * The text file used for measurement from http://www.gutenberg.org/files/98/98-0.txt
 ****************************************************************************************************/

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class assignment6 {

    private assignment6() {
    }

    public static void main(String[] args) throws IOException {
        Map<String, List<Integer>> occurences = new HashMap<>();

        LineNumberReader reader = new LineNumberReader(new FileReader("gutenberg.txt"));
        // create inverted index of all files
        StdOut.println("Enter the search word");
        Scanner scan = new Scanner(System.in);
        String query = scan.nextLine();
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.equalsIgnoreCase(query)) {
                    List<Integer> list = occurences.get(word);
                    if (list == null) {
                        list = new ArrayList<>();
                        occurences.put(word, list);
                        list.add(count);
                    }
                    list.add(count);
                    count++;
                    StdOut.println("Word found at position " + reader.getLineNumber());
                }
            }
        }
        StdOut.println("The word " + query + " appears " + count + " times.");
    }
}








