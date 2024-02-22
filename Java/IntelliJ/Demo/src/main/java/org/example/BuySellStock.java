package org.example;

public class BuySellStock {

    public static int maxProfit(int[] prices){
        int maxProfit =0;
        // left should be low, right should be high
        //left>right->left=right, right+1
        int left=0, right=left+1;
        while(right<prices.length){
            int curProfit = prices[right]-prices[left];
            maxProfit = Math.max(curProfit, maxProfit);
            if(prices[left]>prices[right]){
                left=right;
            }
            right+=1;
        }
        return maxProfit;
    }


    public static void main(String[] s){
    int maxProfit = maxProfit(new int[]{7,6,4,3,1});
    System.out.println("Best time to buy sell stock - with maxprofit - "+maxProfit);
    }
}
