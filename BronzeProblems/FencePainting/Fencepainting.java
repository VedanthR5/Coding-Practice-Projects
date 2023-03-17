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

public class Fencepainting {
	public static void main(String[] args) throws IOException {
		USACO io = new USACO("paint");
		int a = io.nextInt();
		int b = io.nextInt();
		int c = io.nextInt();
		int d = io.nextInt();

		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		io.close();
	}
}