package org.intuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}, {4, 1}, {1, 4}};
        int[] order = solution.findOrder(5, prerequisites);
        System.out.println("Course order:");
        for (int course : order) {
            System.out.print(course + " ");
        }
        // Output: [0, 2, 1, 3] or [0, 1, 2, 3]
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited, stack)) {
                return new int[]{};
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            order[index++] = stack.pop();
        }
        return order;
    }

    private boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        if (visited[node]) return true; // Already visited
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, visited, stack)) {
                return false;
            }
        }
        stack.push(node);
        return true;
    }
}
