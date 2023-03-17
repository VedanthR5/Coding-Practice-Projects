import java.io.*;
import java.util.*;

/**
 * Simple yet moderately fast I/O routines.
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 * USACO-instance, otherwise, you may lose output.
 *
 * - The nextInt(), nextDouble(), and nextLong() methods will throw an
 * exception if there is no more data in the input.
 *
 * @author: Vedanth Ramanathan
 */

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

public class count {
    public static void main(String[] args) throws IOException {
        USACO io = new USACO("promote");
        int initbronze = io.nextInt();
        int finalbronze = io.nextInt();
        int initsilver = io.nextInt();
        int finalsilver = io.nextInt();
        int initgold = io.nextInt();
        int finalgold = io.nextInt();
        int initplat = io.nextInt();
        int finalplat = io.nextInt();

        int goldtoplat = finalplat - initplat;

        io.println(initbronze + finalbronze + initsilver + finalsilver + initgold + finalgold + initplat + finalplat);
        io.close();
    }

}