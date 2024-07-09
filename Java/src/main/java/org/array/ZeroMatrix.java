package org.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroMatrix {

    public static List<List<Integer>> zeroMatrix(List<List<Integer>> arr){
        int n=arr.size();
        int m =arr.get(0).size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr.get(i).get(j)==0){
                    markRow(arr, i);
                    markCol(arr, j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr.get(i).get(j)==-1){
                    arr.get(i).set(j,0);
                }
            }
        }
        return arr;
    }

    private static void markCol(List<List<Integer>> arr, int i) {
        for (int j = 0; j < arr.get(0).size(); j++) {
            if (arr.get(i).get(j) != 0) {
                arr.get(i).set(j, -1);
            }
        }
    }

    private static void markRow(List<List<Integer>> arr, int i) {
        // set all non-zero elements as -1 in the row i:
        for (int j = 0; j < arr.size(); j++) {
            if (arr.get(i).get(j) != 0) {
                arr.get(i).set(j, -1);
            }
        }
    }

    public static void main(String[] a){
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        List<List<Integer>> ans = zeroMatrix(matrix);

        System.out.println("The Final matrix is: ");
        for (List<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }

}
