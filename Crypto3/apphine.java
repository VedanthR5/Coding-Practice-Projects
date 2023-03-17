import java.util.*;

public class apphine {

    // Key values of a and b

    public static String encryptMessage(String msg, int a, int b) {
        /// Cipher Text initially empty
        String cipher = "";
        for (int i = 0; i < msg.length(); i++) {

            if (msg.charAt(i) != ' ') {
                cipher = cipher + (char) ((((a * (msg.charAt(i) - 'A')) + b) % 26) + 'A');
            } else {
                cipher += msg.charAt(i);
            }
        }
        return cipher;
    }

    public static String decryptCipher(String cipher, int a, int b) {
        String msg = "";
        int a_inv = 0;
        int flag = 0;

        for (int i = 0; i < 26; i++) {
            flag = (a * i) % 26;

            if (flag == 1) {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++) {

            if (cipher.charAt(i) != ' ') {
                msg = msg + (char) (((a_inv *
                        ((cipher.charAt(i) + 'A' - b)) % 26)) + 'A');
            } else // else simply append space character
            {
                msg += cipher.charAt(i);
            }
        }

        return msg;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String msg = sc.nextLine();
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Calling encryption function
        String cipherText = encryptMessage(msg, a, b);
        System.out.println("Encrypted Message is : " + cipherText);

        // Calling Decryption function
        System.out.println("Decrypted Message is: " + decryptCipher(msg, a, b));
        sc.close();

    }
}
