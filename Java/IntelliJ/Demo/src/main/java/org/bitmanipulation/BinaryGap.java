package org.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryGap {

    public static int binaryGap(int n){
        if(n<0){
            return 0;
        }
        String binary = Integer.toBinaryString(n);
        int count =0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1' && (i+1)<binary.length() && binary.charAt(i+1)=='0'){
                count++;
                i++;
                while ((i+1)<binary.length() && binary.charAt(i+1)=='0'){
                    count++;
                    i++;
                }
            }
            if((i+1)<binary.length() && binary.charAt(i+1)=='1'){
                list.add(count);
                count=0;
            }
        }
        if(list.size()==0){
            return 0;
        }else {
            return Collections.max(list);
        }
    }

    public static void main(String[] s){
        int n = binaryGap(529 );
        System.out.println("Binary gap of 529 - "+n);
    }
}
