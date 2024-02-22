package org.example;

public class ContainerWithMostWater {
    public static int maxArea(int[] heights){
        int maxArea =0;
        int left=0,right=heights.length-1;
        while(left<right){
            int curArea = (right - left)*Math.min(heights[right], heights[left]);
            maxArea = Math.max(curArea, maxArea);
            if(heights[right]<heights[left]){
                right-=1;
            }else{
                left+=1;
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        // two pointer
        // left, right, maxArea, current Area
        // left>right right-- else left-- else left--
        int maxArea = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println("Container with Most water: "+maxArea);
    }
}
