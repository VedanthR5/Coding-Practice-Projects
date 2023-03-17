import java.util.*;

public class circPrimes {

    public static void main(String[] args) {

        int result = run((int) 10);
        System.out.println(result);

    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;

    }

    static boolean checkCircular(int N) {

        int num = N;
        while (isPrime(num)) {

            int lastDig = num % 10;
            int div = num / 10;
            if (div == 0) {
                return true;

            } else {

                String s1 = Integer.toString(lastDig);
                String s2 = Integer.toString(div);
                String s = s1 + s2;
                num = Integer.parseInt(s);
            }

            if (num == N)
                return true;
        }

        return false;
    }

    static int run(int max) {
        ArrayList<Integer> hello = new ArrayList<>();

        for (int i = 1; i < max; i++) {
            if (isPrime(i)) {
                if (checkCircular(i)) {
                    hello.add(i);

                }
            }
        }
        return hello.size();
    }

}
