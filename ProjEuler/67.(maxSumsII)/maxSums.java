import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Scanner;

public class maxSums {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("p067_triangle.txt")));
        int rows = 100;
        int columns = 300;
        int[][] triangle = new int[rows][columns];
        while (sc.hasNextLine()) {
            for (int i = 0; i < triangle.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    triangle[i][j] = Integer.parseInt(line[j]);
                    // System.out.print(triangle[i][j] + " ");
                }
                // System.out.println();
            }
        }

        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int left = triangle[i + 1][j];
                int right = triangle[i + 1][j + 1];
                triangle[i][j] += Math.max(left, right);
            }
        }
        int maximumTotal = triangle[0][0]; // totoal sum is the first element.

        System.out.println("The maximum total from top to bottom is: " + maximumTotal);
    }
}