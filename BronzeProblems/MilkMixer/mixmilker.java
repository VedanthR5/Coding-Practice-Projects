import java.io.*;

public class mixmilker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("mixmilk.out"));

        int[] c = new int[3];
        int[] m = new int[3];
        for (int i = 0; i < 3; i++) {
            String[] line = reader.readLine().split(" ");
            c[i] = Integer.parseInt(line[0]);
            m[i] = Integer.parseInt(line[1]);
        }

        int a = 0, b = 1, cnt = 0;
        while (cnt < 100) {
            int pour = Math.min(m[a], c[b] - m[b]);
            m[a] -= pour;
            m[b] += pour;
            cnt++;
            a = (a + 1) % 3;
            b = (b + 1) % 3;
        }

        for (int i = 0; i < 3; i++) {
            writer.println(m[i]);
        }
        writer.close();
        reader.close();
    }
}
