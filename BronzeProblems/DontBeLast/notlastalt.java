import java.io.*;
import java.util.*;

public class notlastalt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> cowMilk = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            String cow = line[0];
            int milk = Integer.parseInt(line[1]);
            if (!cowMilk.containsKey(cow)) {
                cowMilk.put(cow, 0);
            }
            cowMilk.put(cow, cowMilk.get(cow) + milk);
        }
        br.close();

        List<String> cows = new ArrayList<>(cowMilk.keySet());
        Collections.sort(cows, (a, b) -> cowMilk.get(a) - cowMilk.get(b));
        int minMilk = cowMilk.get(cows.get(0));
        int secondMinMilk = Integer.MAX_VALUE;
        for (String cow : cows) {
            int milk = cowMilk.get(cow);
            if (milk > minMilk) {
                secondMinMilk = Math.min(secondMinMilk, milk);
            }
        }
        List<String> secondMinCows = new ArrayList<>();
        for (String cow : cows) {
            if (cowMilk.get(cow) == secondMinMilk) {
                secondMinCows.add(cow);
            }
        }
        if (secondMinCows.size() == 1) {
            pw.println(secondMinCows.get(0));
        } else {
            pw.println("Tie");
        }
        pw.close();
    }
}
