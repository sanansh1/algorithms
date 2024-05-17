package org.arrays.strings;

public class DecryptString {

    public static String decryptString(String word) {
        int nextStep = 1;
        /*
        Convert every letter to its ASCII value. Add 1 to the first letter,
        and then for every letter from the second one to the last one,
        add the value of the previous letter. Subtract 26 from every letter until
        it is in the range of lowercase letters a-z in ASCII. Convert the values
        back to letters.
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i);
            ascii -= nextStep;
            while (ascii < (int) 'a') {
                ascii += 26;
            }
            sb.append((char) ascii);
            nextStep = ascii + nextStep;
        }
        return sb.toString();
    }

    public static void main(String[] s) {
        System.out.println(decryptString("dnotq"));
    }
}
