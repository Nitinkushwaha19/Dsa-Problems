import java.util.*;

public class TwoClique {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] adj){
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0;i<adj.length;i++){
            for(int j = 0;j<adj[i].length;j++){
                if(adj[i][j] == 1){
                    graph[i].add(new Edge(i, j));
                }
            }
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0;i<graph.length;i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 1;

                while(!q.isEmpty()){
                    int curr = q.remove();
                    
                    for(int j = 0;j<graph[curr].size();j++){
                        Edge e  = graph[curr].get(i);

                        if(col[e.dest] == -1){
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);

                        }else if( col[curr] == col[e.dest]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int V = 3;
        int G[][] = { { 0, 1, 1, 1, 0 },
                { 1, 0, 1, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 0, 0, 1, 0 }
        };

        int GC[][] = new int[V][V];

        for(int i = 0;i<V;i++){
            for(int j = 0;j<V;j++){
                if( i != j && G[i][j] == 0){
                    GC[i][j] = G[i][j];
                }
            }
        }

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph,GC);

        boolean ans = isBipartite(graph);
        System.out.println(ans);

    }
}
