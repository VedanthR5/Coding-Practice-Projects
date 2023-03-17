import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class liars {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Information[] infos = new Information[n];
        for (int j = 0; j < n; j++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            char direction = tokenizer.nextToken().charAt(0);
            int reference = Integer.parseInt(tokenizer.nextToken());
            infos[j] = new Information(direction, reference);

        }

        int answer = n;
        for (Information tight : infos) {

            int x = tight.reference;

            int liars = 0;
            for (Information info : infos) {
                if (info.direction == 'G') {

                    if (x < info.reference) {
                        liars++;
                    }
                } else {
                    if (x > info.reference) {

                        liars++;
                    }
                }
            }
            answer = Math.min(answer, liars);
        }
        System.out.println(answer);
    }

    public static class Information {
        public final char direction;
        public final int reference;

        public Information(char direction, int reference) {
            this.direction = direction;
            this.reference = reference;
        }

        public String toString() {
            return direction + " " + reference + " ";
        }
    }
}