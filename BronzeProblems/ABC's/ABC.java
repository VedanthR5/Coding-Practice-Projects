import java.io.*;
import java.util.*;

public class ABC {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());
        }

        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }

        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
        }
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // YOUR CODE HERE
        for (int i = 0; i < 7; i++) {
            numbers.add(r.nextInt());
        }
        Collections.sort(numbers);
        int a = numbers.get(0);
        int b = numbers.get(1);
        int c = numbers.get(6) - b - a;
        pw.println(a + " " + b + " " + c);

        pw.close(); // flushes the output once printing is done
    }
}