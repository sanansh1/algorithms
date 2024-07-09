package org.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] a) {
        List<Integer> nums = Arrays.asList(1, 6, 4, 8, 2, 9);
        System.out.print(nums.stream().map(n -> n * n).reduce(0, (b, c) -> b + c));
        System.out.print("\n");
        nums.forEach(n -> System.out.print(n + " "));
        System.out.print("\n");
        // Display unique numbers
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);

        List<Integer> res = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        res.stream().forEach(System.out::print);
        System.out.print("\n");
        // longest string
        List<String> strings = List.of("apple", "banana", "cherry", "grapefruit");
        Optional<String> longest = strings.stream()
                .max((s1, s2) -> s1.length() - s2.length());
        System.out.println(longest.orElse(null));

        List<String> smaller_strings = List.of("apple", "banana", "cherry");
        smaller_strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList()).forEach(System.out::print);

    }
}
