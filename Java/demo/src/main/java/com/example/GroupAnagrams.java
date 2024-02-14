package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            } 
            map.get(sorted).add(s);            
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println("Group Anagram!");
        List<List<String>> list = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for(List<String> s:list){
            System.out.println(s);
        }
    }
}
