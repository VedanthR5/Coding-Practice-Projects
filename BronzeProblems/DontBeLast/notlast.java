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

public class notlast {
    public static void main(String[] args) throws IOException {
        USACO io = new USACO("notlast");
        int N = io.nextInt();
        TreeMap<String, Integer> cowXMilk = new TreeMap<>();
        String key = "";
        int value = 0;

        for (int i = 0; i < N; i++) {
            key = io.next();
            value = io.nextInt();
            if (cowXMilk.containsKey(key)) {
                cowXMilk.put(key, cowXMilk.get(key) + value);
            } else {
                cowXMilk.put(key, value);
            }
        }
        int minMilk = Integer.MAX_VALUE;
        int secondMinMilk = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : cowXMilk.entrySet()) {
            int milk = entry.getValue();
            minMilk = Math.min(minMilk, milk);
            if (milk > minMilk) {
                secondMinMilk = Math.min(secondMinMilk, milk);
            }
        }

        List<String> secondMinCows = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cowXMilk.entrySet()) {
            if (entry.getValue() > minMilk && entry.getValue() <= secondMinMilk) {
                secondMinCows.add(entry.getKey());
            }
        }

        if (secondMinCows.size() == 1) {
            io.println(secondMinCows.get(0));
        } else {
            io.println("Tie");
        }
        io.close();
    }
}
