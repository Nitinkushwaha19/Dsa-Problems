import java.util.*;

public class CheapestFlight {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int flights[][]) {
       for(int i = 0;i<graph.length;i++) {
        graph[i] = new ArrayList<>();
       } 

       for(int i = 0;i<flights.length;i++) {
        int src = flights[i][0];
        int dest = flights[i][1];
        int wt = flights[i][2];

        graph[src].add(new Edge(src, dest, wt));
        
       }
    }

    static class Info {
        int v;
        int cost;
        int stop;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }
    
    public static int cheapestFlight(int n, int flights[][], int src, int des, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, flights);

        int dist[] = new int[graph.length];
        for(int i = 0;i<dist.length;i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            
            if(curr.stop > k) {
                break;
            }

            for(int i = 0;i<graph[curr.v].size();i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < dist[v] && curr.stop <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stop + 1));
                }
            }
        }

        // Destination distance 
        if(dist[des] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[des];
        }
    }
    public static void main(String args[]) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dest = 3, k = 1;
        int cost = cheapestFlight(n, flights, src, dest, k);
        System.out.println(cost);
    }    
}
