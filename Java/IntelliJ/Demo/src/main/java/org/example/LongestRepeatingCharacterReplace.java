package org.example;

public class LongestRepeatingCharacterReplace {

    public static int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;
        for(int j=0;j<s.length();j++){
            arr[s.charAt(j)-'A']++;
            max= Math.max(max, arr[s.charAt(j)-'A']);
            if(j-i+1-max>k){
                arr[s.charAt(j)-'A']--;
                i++;
            }
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }

    public static void main(String[] s){
    int count = characterReplacement("ABAB",2);
    System.out.println("LongestRepeatingCharacterReplacement - "+count);
    }
}
