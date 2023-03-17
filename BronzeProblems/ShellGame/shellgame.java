import java.util.*;
import java.io.*;

public class shellgame {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("shell");

        int n = io.nextInt();

        // shellAtPos[i] stores the label of the shell located at position i
        int[] shellAtPos = new int[3];

        // Arbitrarily place the shells down
        for (int i = 0; i < 3; i++) {
            shellAtPos[i] = i;
        }

        // counter[i] stores the number of times the shell with label i was picked
        int[] counter = new int[3];

        for (int i = 0; i < n; i++) {
            // Zero indexing: offset all positions by 1
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            int g = io.nextInt() - 1;

            // Perform Bessie's swapping operation
            int temp = shellAtPos[b];
            shellAtPos[b] = shellAtPos[a];
            shellAtPos[a] = temp;

            // Count the number of times Elsie guesses each particular shell
            counter[shellAtPos[g]]++;
        }

        io.println(Math.max(counter[0], Math.max(counter[1], counter[2])));
        io.close();
    }

    // BeginCodeSnip{Kattio}
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    // EndCodeSnip
}