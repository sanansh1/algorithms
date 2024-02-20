package com.example;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public String encode(List<String> strs) {
        StringBuilder bd = new StringBuilder();
        for(String str:strs){
            bd.append(str.length()).append("#").append(str);
        }
        return bd.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.valueOf(str.substring(i, j));
            i= j+1+len;
            list.add(str.substring(j+1, i));
        }
        return list;
    }

    public static void main(String[] args){

    }
}
