package com.example;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {
    public static int getLenLongestSubstring(String s){
        int res =0;
        List<Character> uniqueCh = new ArrayList<>();
        for(int r=0;r<s.length();r++){
            while(uniqueCh.contains(s.charAt(r))){
                int index = uniqueCh.indexOf(s.charAt(r));
                uniqueCh.remove(index);
                if (index!=0){
                    uniqueCh.subList(0, index).clear();
                }
            }
            uniqueCh.add(s.charAt(r));
            res = Math.max(res,uniqueCh.size());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("length of longest substring"+getLenLongestSubstring("sandpaper"));
    }
}
