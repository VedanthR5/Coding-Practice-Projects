
/**
 * milkerALT
 */
import java.io.*;
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

class Cup {
    private int capacity;
    private int milk;
    public Cup(int c, int m) {
        capacity = c;
        milk = m;
    }
    public int getCapacity() { return capacity; }
    public int getMilk() { return milk; }
    public void setMilk(int m) { milk = m; }
}

public class milkerALT {
    public static void pour(Cup from, Cup to) {
        int amt = Math.min(from.getMilk(), to.getCapacity() - to.getMilk());
        from.setMilk(from.getMilk() - amt);
        to.setMilk(to.getMilk() + amt);
    }

    public static void main(String[] args) throws IOException {
        USACO io = new USACO("mixmilk");

        int c1, c2, c3, m1, m2, m3;
        c1 = io.nextInt();
        m1 = io.nextInt();
        c2 = io.nextInt();
        m2 = io.nextInt();
        c3 = io.nextInt();
        m3 = io.nextInt();
        Cup cup1 = new Cup(c1,m1);
        Cup cup2 = new Cup(c2,m2);
        Cup cup3 = new Cup(c3,m3);
        for (int i = 0; i < 33; i++) {
            pour(cup1, cup2);
            pour(cup2, cup3);
            pour(cup3, cup1);
        }
        pour(cup1, cup2);
        io.println(cup1.getMilk() + "\n" + cup2.getMilk() + "\n" + cup3.getMilk());
        io.close();
    }
}
