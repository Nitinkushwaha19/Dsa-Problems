import java.util.*;

class Sample
{
    static class Edge {
        int src, dest, wt;

        public Edge (int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 7, 8));

        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 2, 8));
        graph[1].add(new Edge(1, 7, 11));

        graph[2].add(new Edge(2, 1, 8));
        graph[2].add(new Edge(2, 3, 7));
        graph[2].add(new Edge(2, 5, 4));
        graph[2].add(new Edge(2, 8, 2));

        graph[3].add(new Edge(3, 2, 7));
        graph[3].add(new Edge(3, 4, 9));
        graph[3].add(new Edge(3, 5, 14));

        graph[4].add(new Edge(4, 3, 9));
        graph[4].add(new Edge(4, 5, 10));
        
        graph[5].add(new Edge(5, 2, 4));
        graph[5].add(new Edge(5, 3, 14));
        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 2));

        graph[6].add(new Edge(6, 5, 2));
        graph[6].add(new Edge(6, 7, 1));
        graph[6].add(new Edge(6, 8, 6));

        graph[7].add(new Edge(7, 0, 8));
        graph[7].add(new Edge(7, 1, 11));
        graph[7].add(new Edge(7, 6, 1));
        graph[7].add(new Edge(7, 8, 7));

        graph[8].add(new Edge(8, 2, 2));
        graph[8].add(new Edge(8, 6, 6));
        graph[8].add(new Edge(8, 7, 7));

    }

    static class Pair implements Comparable<Pair> {
        int v;
        int path;

        public Pair(int v, int p){
            this.v = v;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.path - this.path;
        }
    }

    public static boolean pathGreaterThanK(ArrayList<Edge>[] graph, int V, int k) {
        int dist[] = new int[V];
        boolean vis[] = new boolean[V];

        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int d = curr.path;
            
            if(!vis[curr.v]){
                vis[curr.v] = true;

                for(int i = 0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    int v = e.dest;
                    int wt = e.wt;

                    if(d + wt > dist[v]){
                        dist[v] = d + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }

        }

        for(int i = 0;i<V;i++){
            System.out.println(dist[i] + " ");
            if(dist[i] >= k){
                return true;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        int V = 9;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(pathGreaterThanK(graph, V, 62));
    }
}