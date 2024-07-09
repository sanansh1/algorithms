package org.intuit;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {

    public static void main(String[] args) {
        CourseScheduleI solution = new CourseScheduleI();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Can finish courses: " + solution.canFinish(numCourses, prerequisites)); // Output: true
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited, recStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return false; // Cycle detected
        if (visited[node]) return true; // Already visited
        visited[node] = true;
        recStack[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, visited, recStack)) {
                return false;
            }
        }
        recStack[node] = false;
        return true;
    }
}
