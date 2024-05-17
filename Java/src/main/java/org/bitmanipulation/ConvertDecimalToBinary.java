package org.bitmanipulation;

public class ConvertDecimalToBinary {
    public static String convert2Binary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 1) {
            if (n % 2 == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            n = n / 2;
        }
        sb.reverse();
        return sb.toString();
    }

    public static int convertBinary2Decimal(String n) {
        int res = 1, num = 0;

        for (int i = n.length() - 1; i > 0; i--) {

            if (n.charAt(i) == '1') {
                num = num + res;
            }
            res = res * 2;
        }


        return res;
    }

    public static void main(String[] s) {

    }
}
