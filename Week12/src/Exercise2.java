import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// Breadth First Search: Shortest Reach
public class Exercise2 {
    public static class Solution {

        static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(start);

            int[] costs = new int[graph.size()];
            int UNIT_COST = 6;
            Arrays.fill(costs, -1);
            costs[start] = 0; // cost from start to itself = 0

            // bfs
            while (!queue.isEmpty()) {
                int current = queue.poll();
                // for every adjacent vertex adjacent to the dequeued
                // if found an unvisited vertex
                // update its cost
                // then add it to the queue
                for (int adjacent : graph.get(current)) {
                    if (costs[adjacent] == -1) { // cost = -1 means haven't visited (costs is initialized with -1)
                        costs[adjacent] = costs[current] + UNIT_COST;
                        // cost from start to adjacent = cost from start to current node + 1 edge
                        queue.add(adjacent);
                    }
                }
            }
            return costs;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int Q = scanner.nextInt();
            for (int q = 0; q < Q; ++q) {
                int N, M, start;
                N = scanner.nextInt();
                M = scanner.nextInt();
                ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
                for (int i = 0; i <= N; ++i) {
                    graph.add(new ArrayList<>());
                }
                for (int i = 0; i < M; ++i) {
                    int n1, n2;
                    n1 = scanner.nextInt();
                    n2 = scanner.nextInt();
                    graph.get(n1).add(n2);
                    graph.get(n2).add(n1);
                }
                start = scanner.nextInt();
            /*
            for (int i = 0; i < N; ++i) {
                Collections.sort(graph.get(i));
            }
            for (int i = 1; i <= N; ++i) {
                System.out.println("Node: " + i);
                System.out.println(graph.get(i).toString());
            }
            System.out.println("Start: " + start);
            */
                int[] costs = findShortestReach(graph, start);
                for (int i = 1; i < costs.length; ++i) {
                    if (i == start) continue;
                    System.out.print(costs[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
