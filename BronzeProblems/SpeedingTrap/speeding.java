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

/**
 * speeding
 */
public class speeding {

    public static void main(String[] args) throws IOException {
        USACO io = new USACO("speeding");
        int N = io.nextInt();
        int M = io.nextInt();

        int length, speed, pos = 0;
        int[] limit = new int[100], bessie = new int[100];

        for (int i = 0; i < N; i++) {
            length = io.nextInt();
            speed = io.nextInt();
            // for each of the next length positions, set the speed limit
            for (int j = pos; j < pos + length; j++) {
                limit[j] = speed;
            }
            pos += length;
        }

        pos = 0;
        for (int i = 0; i < M; i++) {
            length = io.nextInt();
            speed = io.nextInt();
            // for each of the next length positions, set bessie's speed
            for (int j = pos; j < pos + length; j++) {
                bessie[j] = speed;
            }
            pos += length;
        }
        int currentMax = 0;

        for (int i = 0; i < 100; i++) {

            currentMax = Math.max(currentMax, bessie[i] - limit[i]);

        }


        io.println(currentMax);

        io.close();
    }
}