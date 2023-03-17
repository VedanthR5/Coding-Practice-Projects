import java.io.*;

public class shellAI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        int n = Integer.parseInt(br.readLine());
        int[] shells = new int[] {1, 2, 3};
        int score = 0;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int g = Integer.parseInt(line[2]);

            swap(shells, a, b);
            if (shells[g-1] == g) {
                score++;
            }
        }

        int max = 0;
        for (int i = 1; i <= 3; i++) {
            int tempScore = 0;
            for (int j = 0; j < n; j++) {
                String line = br.readLine();
                if(line == null) break;
                int a = Integer.parseInt(line.split(" ")[0]);
                int b = Integer.parseInt(line.split(" ")[1]);
                int g = Integer.parseInt(line.split(" ")[2]);

                int[] tempShells = shells.clone();
                swap(tempShells, a, b);
                if (tempShells[g-1] == i) {
                    tempScore++;
                }
            }
            max = Math.max(max, tempScore);
        }

        pw.println(max);
        br.close();
        pw.close();
    }

    private static void swap(int[] shells, int a, int b) {
        int temp = shells[a-1];
        shells[a-1] = shells[b-1];
        shells[b-1] = temp;
    }
}
