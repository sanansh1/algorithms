package org.recursion;

public class ReverseString {

    public static void reverse(String s){
        helper(0,s);
    }

    public static void helper(int index, String s){
        if(index>=s.length()|| s==null){
            return ;
        }
        helper(index+1, s);
        System.out.println(s.charAt(index));
    }

    public static void main(String[] s){
    reverse("hello world");
    }
}
