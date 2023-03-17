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

public class billboard {
    public static int area(int[] s1) {
        int bl_x = s1[0], bl_y = s1[1], tr_x = s1[2], tr_y = s1[3];
        int length = tr_y - bl_y;
        int width = tr_x - bl_x;
        return length * width;
    }

    public static boolean intersect(int[] s1, int[] s2) {
        int bl_a_x = s1[0], bl_a_y = s1[1], tr_a_x = s1[2], tr_a_y = s1[3];
        int bl_b_x = s2[0], bl_b_y = s2[1], tr_b_x = s2[2], tr_b_y = s2[3];

        // no overlap
        if (bl_a_x >= tr_b_x || tr_a_x <= bl_b_x
                || bl_a_y >= tr_b_y || tr_a_y <= bl_b_y) {
            return false;
        } else {
            return true;
        }
    }

    public static int interArea(int[] s1, int[] s2) {
        int bl_a_x = s1[0], bl_a_y = s1[1], tr_a_x = s1[2], tr_a_y = s1[3];
        int bl_b_x = s2[0], bl_b_y = s2[1], tr_b_x = s2[2], tr_b_y = s2[3];
        return ((Math.min(tr_a_x, tr_b_x) - Math.max(bl_a_x, bl_b_x))
                * (Math.min(tr_a_y, tr_b_y) - Math.max(bl_a_y, bl_b_y)));
    }

    public static void main(String[] args) throws IOException {
        USACO io = new USACO("billboard");
        int bl_x_A = io.nextInt();
        int bl_y_A = io.nextInt();

        int tr_x_A = io.nextInt();
        int tr_y_A = io.nextInt();
        int[] A = { bl_x_A, bl_y_A, tr_x_A, tr_y_A };

        int bl_x_B = io.nextInt();
        int bl_y_B = io.nextInt();

        int tr_x_B = io.nextInt();
        int tr_y_B = io.nextInt();
        int[] B = { bl_x_B, bl_y_B, tr_x_B, tr_y_B };

        int bl_x_BB = io.nextInt();
        int bl_y_BB = io.nextInt();
        int tr_x_BB = io.nextInt();
        int tr_y_BB = io.nextInt();

        int[] BB = { bl_x_BB, bl_y_BB, tr_x_BB, tr_y_BB };
        int totalVisible = (area(A) - interArea(A, BB)) + (area(B) - interArea(B, BB));

        if (intersect(A, BB) && intersect(B, BB)) {
            io.println(totalVisible);

        } else if (!intersect(A, BB) && intersect(B, BB)) {
            io.println((area(B) - interArea(B, BB)) + area(A));

        } else if (!intersect(B, BB) && intersect(A, BB)) {
            io.println((area(A) - interArea(A, BB)) + area(B));
        } else {
            io.println(area(A) + area(B));
        }

        /*
         * Make sure to include the line below, as it
         * flushes and closes the output stream.
         */
        io.close();
    }
}