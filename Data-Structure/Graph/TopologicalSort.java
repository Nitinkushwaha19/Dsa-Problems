import java.lang.reflect.Array;
import java.util.*;

public class TopologicalSort {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createdGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    
    
    // Dfs Approach 
    public static void topSort_Dfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                topSortUtil_Dfs(graph, i, visit, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil_Dfs(ArrayList<Edge>[] graph, int curr, boolean[] visit, Stack<Integer> s) {
        visit[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                topSortUtil_Dfs(graph, e.dest, visit, s);
            }
        }
        s.push(curr);

    }

    // BFS Approach ---> Kahn's Algorithm 
    public static void topSort (ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        calIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<indeg.length;i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i =0;i<graph[curr].size();i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void calIndeg(ArrayList<Edge>[] graph, int [] indeg) {
        for(int i =0;i<graph.length;i++) {
            int v = i;
            for(int j = 0;j<graph[v].size();j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createdGraph(graph);

        topSort(graph);
    }
}
