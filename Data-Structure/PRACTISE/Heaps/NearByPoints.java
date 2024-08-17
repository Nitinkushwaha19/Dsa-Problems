import java.util.PriorityQueue;

public class NearByPoints {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int d, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = d;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point d2) {
            return this.distSq - d2.distSq;
        }
    }

    public static void kNearestPoint(int pts[][], int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq,i));
        }

        for(int i = 0;i<k;i++){
            System.out.println("C" + pq.remove().idx);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        kNearestPoint(pts, k);
    }
}
