

import java.io.*;
import java.util.*;

class USACO extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    // standard input
    public USACO() {
        this(System.in, System.out);
    }

    public USACO(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    // USACO-style file input
    public USACO(String problemName) throws IOException {
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


public class Teleporter {
    public static void main(String[] args) throws IOException {
        USACO io = new USACO("teleport");
        int a = io.nextInt();
        int b = io.nextInt();
        int x = io.nextInt();
        int y = io.nextInt();

        // Case 1: No Teleporter
        int pureHaul = Math.abs((b - a));

        // Case 2
        int xTeleporter = Math.abs(x - a) + Math.abs(b - y);

        // Case 3

        int yTeleporter = Math.abs(y - a) + Math.abs(b - x);

        int initialD = Math.min(pureHaul, xTeleporter);
        int distance = Math.min(initialD, yTeleporter);

        io.println(distance);
        /*
         * Make sure to include the line below, as it
         * flushes and closes the output stream.
         */
        io.close();
    }
}