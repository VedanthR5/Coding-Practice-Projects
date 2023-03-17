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

public class bucket {
    public static void main(String[] args) throws IOException {
        USACO io = new USACO("buckets");
        int barnX = 0, barnY = 0, rockX = 0, rockY = 0, lakeX = 0, lakeY = 0;
        for (int i = 0; i < 10; i++) {
            String row = io.next();
            for (int j = 0; j < 10; j++) {
                if (row.charAt(j) == 'B') {
                    barnX = i;
                    barnY = j;
                } else if (row.charAt(j) == 'R') {
                    rockX = i;
                    rockY = j;
                } else if (row.charAt(j) == 'L') {
                    lakeX = i;
                    lakeY = j;
                }
            }
        }

        //System.out.println(barnX + "," + barnY);
        //System.out.println(rockX + "," + rockY);
        //System.out.println(lakeX + "," + lakeY);
        int cows = Math.abs(lakeX-barnX) + Math.abs(lakeY-barnY) - 1;
        
        // case 1: if barn, rock, and lake are all in the same row/column
        if (((barnX == lakeX && barnX == rockX) || (barnY == lakeY && barnY == rockY))
                && (((lakeY < rockY && rockY < barnY) || (barnY < rockY && rockY < lakeY))
                        || ((lakeX < rockX && rockX < barnX) || (barnX < rockX && rockX < lakeX)))) {

                            cows +=2;


        }
        io.println(cows);
        /*
         * int a = io.nextInt();
         * int b = io.nextInt();
         * int x = io.nextInt();
         * 
         * int y = io.nextInt();
         */

        /*
         * Make sure to include the line below, as it
         * flushes and closes the output stream.
         */
        io.close();
    }
}