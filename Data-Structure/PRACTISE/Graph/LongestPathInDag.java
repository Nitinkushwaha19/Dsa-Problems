import java.util.*;

public class LongestPathInDag {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 3));

        graph[1].add(new Edge(1, 3, 6));
        graph[1].add(new Edge(1, 2, 2));

        graph[2].add(new Edge(2, 4, 4));
        graph[2].add(new Edge(2, 5, 2));
        graph[2].add(new Edge(2, 3, 7));

        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 4, -1));

        graph[4].add(new Edge(4, 5, -2));
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for(int i = 0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for(int i = 0;i<V;i++){
            if(!vis[i]){
                topSortUtil(graph,i,vis,s);
            }
        }

        int src = 1;
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        while (!s.isEmpty()) {
            int u = s.pop();

            if(dist[u] != Integer.MIN_VALUE){
                
                for(int i = 0;i<graph[u].size();i++){
                    Edge e = graph[u].get(i);

                    int v = e.dest;
                    int wt =  e.wt;

                    if(dist[v] < dist[u] + wt){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // print longest calculated distance 
        for(int n : dist){
            if(n == Integer.MIN_VALUE){
                System.out.print("INF" + " ");
            }else {
                System.out.print(n + " ");
            }
        }

    }
}
