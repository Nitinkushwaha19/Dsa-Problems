import java.util.*;

public class CycleDetection {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new Edge(1, 9));
        graph[1].add(new Edge(1, 5));

        graph[2].add(new Edge(2, 5));
        graph[2].add(new Edge(2, 4));

        graph[4].add(new Edge(4, 2));

        graph[5].add(new Edge(5, 1));
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 9));

        graph[9].add(new Edge(9, 1));
        graph[9].add(new Edge(9, 5));

    }

    // Bfs Approach

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        int par[] = new int[graph.length];

        for(int i = 0;i<par.length;i++) {
            par[i] = -1;
        } 
        
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i] && isCycleUtil(graph, i, vis, par)) {
                return true;
            }
        }
        return false;
    }

    // Bfs --> O(V + E)
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int j, boolean vis[], int[] par) {
        Queue<Integer> q = new LinkedList<>();
        q.add(j);
        vis[j] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!vis[e.dest]) {
                    q.add(e.dest);
                    vis[e.dest] = true;
                    par[e.dest] = curr;
                } else if (e.dest != par[curr]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 10;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }

}