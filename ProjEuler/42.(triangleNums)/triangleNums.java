import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class triangleNums {
    public static void main(String[] args) throws FileNotFoundException {
        // Read the words from the file
        Scanner scanner = new Scanner(new File("p042_words.txt"));
        scanner.useDelimiter(",");
        String[] words = new String[2000];
        int count = 0;
        while (scanner.hasNext()) {
            words[count] = scanner.next().replaceAll("\"", ""); //regex for quotes
            count++;
            
        }
        scanner.close();

        // Check which words are triangle words
        int triangleCount = 0;
        for (String word : words) {
            if (word != null && isTriangleWord(word)) {
                triangleCount++;
            }
        }

        System.out.println(triangleCount + " words are triangle words.");
    }

    public static boolean isTriangleWord(String word) {
        int wordValue = 0;
        for (char c : word.toCharArray()) {
            int charValue = c - 'A' + 1;
            wordValue += charValue;
        }
        int n = 1;
        while (true) {
            int triangleNumber = n * (n + 1) / 2;
            if (triangleNumber == wordValue) {
                return true;
            } else if (triangleNumber > wordValue) {
                return false;
            }
            n++;
        }
    }
}
