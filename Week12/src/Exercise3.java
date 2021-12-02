import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Roads and Libraries
public class Exercise3 {
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // if cost lib <= cost road then it's better to just build a library at every city
        if (c_lib <= c_road) return (long) n * c_lib;

        // else if cost lib > cost road, build one library in each connected component
        // construct an undirected graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        // construct list of lists of adjacent cities
        // example: city 3 is connected to city 2, 4, 6
        // then graph[3] = {2,4,6};
        for (List<Integer> city : cities) {
            graph.get(city.get(0)).add(city.get(1));
            graph.get(city.get(1)).add(city.get(0));
        }

        // list of connected components' sizes
        List<Integer> components = new ArrayList<>();

        // a boolean array to check if the algorithm has visited a city
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        for (int i = 1; i <= n; i++) {
            if (graph.get(i).size() == 0) { // if a city is alone, which by itself is a component
                components.add(1); // add itself to the component list
            } else {
                if (!visited[i]) { // if found an unvisited city
                    components.add(count_connected(graph, i, visited)); // add the component it belongs to
                }
            }
        }

        long result = 0;
        // the total cost equals the total cost of roads and one library in each connected components
        for (Integer component : components) {
            result += (long) (component - 1) * c_road + c_lib; // number of roads = component's size - 1
        }
        return result;
    }

    // count the number of cities in a connected components
    static int count_connected(List<List<Integer>> graph, int i, boolean[] visited) {
        visited[i] = true; // mark the current city as visited
        int count = 1; // count itself
        for (int k = 0; k < graph.get(i).size(); k++) { // check every adjacent cities
            if (!visited[graph.get(i).get(k)]) { // if not visited yet
                // increment current count by results of consecutive count_connected calls
                count += count_connected(graph, graph.get(i).get(k), visited);
            }
        }
        return count;
    }
}
