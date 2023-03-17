import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class search {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] xInput = br.readLine().split(" ");
        String[] yInput = br.readLine().split(" ");
        int[] xCoords = new int[n];
        int[] yCoords = new int[n];
        for (int i = 0; i < n; i++) { // translates string array into int array
            xCoords[i] = Integer.parseInt(xInput[i]);
            yCoords[i] = Integer.parseInt(yInput[i]);
        }

        double maxDistance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.pow((xCoords[i] - xCoords[j]), 2) + Math.pow((yCoords[i] - yCoords[j]), 2);
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
            }
        }
        System.out.println(maxDistance);
    }
}