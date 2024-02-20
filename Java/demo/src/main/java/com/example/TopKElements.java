package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {

    public static int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);                        
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        /**
         * 2-2
        6-2
        8-2
        3-2
        4-1
        5-1
        pq - 2-2
         */
        for(Map.Entry<Integer, Integer> element:map.entrySet()){
            pq.add(element);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int i=k;
        while(!pq.isEmpty()){
            topK[--i]=pq.poll().getKey();
        }

        return topK;
    }

    public static void main(String[] args) {
        
        int[] arr = topKFrequent(new int[]{2,6,8,3,4,2,6,3,5,8},3);
        for(int n:arr){
            System.out.println("Top K - "+n);
        }
        
    }
    
}
