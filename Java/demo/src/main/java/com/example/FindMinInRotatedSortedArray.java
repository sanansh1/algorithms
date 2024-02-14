package com.example;

public class FindMinInRotatedSortedArray{
    public static int findMin(int[] arr){
        int left =0, right=arr.length-1;
        while(left <=right){
            if(arr[left]<=arr[right]){
                return arr[left];
            }
            int mid = (left+right)/2;

            if(arr[left]<=arr[mid]){
                left=mid+1;
            } else{
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int min = findMin(new int[]{3,4,5,6,1,2});
        System.out.println("min = "+min);
    }
}