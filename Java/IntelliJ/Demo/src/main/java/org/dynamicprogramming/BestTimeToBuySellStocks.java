package org.dynamicprogramming;

/*
We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days.
The following guidelines need to be followed:
We can buy and sell a stock only once.
We can buy and sell the stock on any day but to sell the stock, we need to first buy it on the same or any previous day.
We need to tell the maximum profit one can get by buying and selling this stock.
*/
public class BestTimeToBuySellStocks {
    public static int maxProfit(int[] arr) {
        int maxProfit = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int curProfit = arr[i] - min;
            maxProfit = Math.max(curProfit, maxProfit);
            min = Math.min(arr[i], min);
        }
        return maxProfit;
    }

    public static void main(String[] s) {
        int[] Arr = {7, 1, 5, 3, 6, 4};

        System.out.println("The maximum profit by selling the stock is " +
                maxProfit(Arr));
    }
}
