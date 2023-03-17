import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Dynamic Programming Approach'
//Start from 2nd row from the bottom and keep going up, layer by layer.
public class pascal {
    public static void main(String[] args) throws FileNotFoundException {
        // Read the triangle from the file
        Scanner scanner = new Scanner(new File("p067_triangle.txt"));
        int[][] triangle = new int[100][300];
        int row = 0;
        while (scanner.hasNextLine()) {
            String[] nums = scanner.nextLine().split(" ");
            for (int i = 0; i < nums.length; i++) {
                triangle[row][i] = Integer.parseInt(nums[i]);
            }
            row++;
        }
        scanner.close();

        // Find the maximum total from top to bottom
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int left = triangle[i + 1][j];
                int right = triangle[i + 1][j + 1];
                triangle[i][j] += Math.max(left, right);
            }
        }
        int maximumTotal = triangle[0][0]; //totoal sum is the first element.

        System.out.println("The maximum total from top to bottom is: " + maximumTotal);
    }
}
