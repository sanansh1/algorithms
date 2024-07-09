package org.array;

//https://leetcode.com/problems/average-waiting-time/description/
public class AverageWaitingTime {
    public static void main(String[] s) {
        int[][] customers = new int[][]{{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers) {
        var n = customers.length;
        var time = 0;
        var sum = 0L;

        for (var i = 0; i < n; i++) {
            time = Math.max(time, customers[i][0]) + customers[i][1];
            sum += time - customers[i][0];
        }
        return (double) sum / n;
    }
}
