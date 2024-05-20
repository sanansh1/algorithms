package org.streamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] a) {
        List<Integer> nums = Arrays.asList(1, 6, 4, 8, 2, 9);
        System.out.print(nums.stream().map(n -> n * n).reduce(0, (b, c) -> b + c));
        System.out.print("\n");
        nums.forEach(n -> System.out.print(n + " "));

    }
}
