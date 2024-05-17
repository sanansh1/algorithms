package org.arrays.strings;

public class CharacterFrequency {
    public static boolean frequency(String s){
        int[] frequency = new int[26];
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a'] += 1;
            System.out.println(frequency[ch - 'a']);
            if (frequency[ch - 'a'] == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] s){
        boolean b = frequency("sandhya");
        System.out.println("frequency - "+b);
    }
}
