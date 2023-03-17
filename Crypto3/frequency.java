import java.util.*;

public class frequency {

    public static void main(String[] args) {

        String msg = "IVQLM IQATQ SMIKP QTLVW VMQAJ MBBMZ BPIVG WCZWE VNZWU KPQVM AMNWZ BCVMK WWSQM";

        char[] msgArray = msg.replaceAll(" ", "").toCharArray();
        char[] decrypted = new char[msgArray.length];

        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            array.add(0);
        }

        for (int j = 0; j < msgArray.length; j++) {

            array.set(msgArray[j] - 'A', array.get(msgArray[j] - 'A') + 1);

        }

        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
                index = i;
            }

        }

        System.out.println((int) (char) (index) - 4);
        for (int z = 0; z < decrypted.length; z++) {
            decrypted[z] = (char)((((((msgArray[z]-65)-8)%26)+26)%26 )+65);
            //decrypted[z] = (char) (((msgArray[z] + 8) % 26));
            System.out.print(decrypted[z]);
          


        }


    }

}
