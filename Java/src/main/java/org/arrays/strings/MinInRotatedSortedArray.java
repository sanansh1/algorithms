package org.arrays.strings;

public class MinInRotatedSortedArray {
    public static int getMin(int[] a){
        if(a== null || a.length==0){
            return 0;
        }
        //[3,4,5,1,2]
        int left=0,right=a.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(a[mid]>a[right]){
                left =mid+1;
            }else if(a[mid]<a[left]){
                right=mid-1;
            }else{
                return a[mid];
            }
        }
        return 0;
    }

    public static void main(String[] s){
        int n = getMin(new int[]{3,4,5,1,2});
        System.out.println("MinInRotatedSortedArray- "+n);
    }
}
