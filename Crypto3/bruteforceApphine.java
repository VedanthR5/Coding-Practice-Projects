public class bruteforceApphine {
    public static void main(String[] args) {
        String encrypted = "WEZBF TBBNJ THNBT ADZQE TGTYR BZAJN ANOOZ ATWGN ABOVG FNWZV A";
        String decrypted = "";

        // Brute force values of a and b
        for (int a = 1; a < 26; a++) {
            if (a == 13) continue; // Skip a = 13
            if (gcd(a, 26) != 1) continue; // Skip non-coprime values of a
            for (int b = 0; b < 26; b++) {
                decrypted = decrypt(encrypted, a, b);

                // Check if decrypted message contains common letters
                if (decrypted.contains("A") && decrypted.contains("E") && decrypted.contains("N") && decrypted.contains("S")) {
                    System.out.println("a = " + a + ", b = " + b + ": " + decrypted);
                }
            }
        }
    }

    // Decrypt using affine cipher with given values of a and b
    public static String decrypt(String encrypted, int a, int b) {
        String decrypted = "";
        for (char c : encrypted.toCharArray()) {
            if (Character.isLetter(c)) {
                int x = c - 'A';
                x = modInverse(a, 26) * (x - b + 26) % 26; // Apply inverse affine transformation
                decrypted += (char) (x + 'A');
            } else {
                decrypted += c;
            }
        }
        return decrypted;
    }

    // Calculate modular multiplicative inverse of a mod m
    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1; // Should never happen
    }

    // Calculate the greatest common divisor of a and b using Euclid's algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
