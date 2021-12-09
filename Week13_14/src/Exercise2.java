import java.util.*;

public class Exercise2 {
    public static boolean[] marked;
    public static PriorityQueue<Cost> pq;
    static class Cost implements Comparable<Cost> {
        public int r, v;
        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }
        @Override
        public int compareTo(Cost c) {
            if (r < c.r) return -1;
            if (r> c.r) return 1;
            if (v < c.v) return -1;
            if (v > c.v) return 1;
            return 0;
        }
    }

    public static int mst(ArrayList<ArrayList<Cost>> graph, int N, int start) {
        marked = new boolean[N + 1];
        int result = 0;
        Queue<Cost> mst = new LinkedList<>();
        pq = new PriorityQueue<>();
        visit(graph, start);

        while (!pq.isEmpty() && mst.size() < N - 1) {
            Cost e = pq.poll();
            if (marked[e.v]) continue;
            mst.add(e);
            result += e.r;
            visit(graph, e.v);
        }
        return result;
    }

    public static void visit(ArrayList<ArrayList<Cost>> graph, int v) {
        marked[v] = true;
        for (int i = 0; i < graph.get(v).size(); i++) {
            int vertex = graph.get(v).get(i).v;
            if (!marked[vertex]) {
                pq.add(graph.get(v).get(i));
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M, start;
        N = scanner.nextInt();
        M = scanner.nextInt();
        ArrayList<ArrayList<Cost>> graph = new ArrayList<>();
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; ++i) {
            int v, w, weight;
            v = scanner.nextInt();
            w = scanner.nextInt();
            weight = scanner.nextInt();
            graph.get(v).add(new Cost(weight, w));
            graph.get(w).add(new Cost(weight, v));
        }
        start = scanner.nextInt();
        System.out.println(mst(graph, N, start));
    }
}
