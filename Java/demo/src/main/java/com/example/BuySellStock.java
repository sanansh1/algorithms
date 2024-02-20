package com.example;
public class BuySellStock {

    public static int getMaxProfit(int[] a){
        int profit =0;
        int l=0,r=1;
        while(r<a.length){
            int curProfit = a[r]-a[l];
            if(a[l]<a[r]){
                profit = Math.max(profit, curProfit);
            }else{
                l=r;
            }
            r+=1;
        }
        return profit;
    }

    public static void main(String[] args) {
        int maxProfit = getMaxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(maxProfit);
    }
}
