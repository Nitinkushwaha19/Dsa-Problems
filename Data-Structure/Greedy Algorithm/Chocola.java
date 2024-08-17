import java.util.*;

public class Chocola {

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costHor, Comparator.reverseOrder());
        Arrays.sort(costVer, Comparator.reverseOrder());

        int v = 0, h = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if(costVer[v] <= costHor[h]) {  // Horizontal cuts
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {  // Vertical cuts
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        
        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++; 
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("min cost for cuts = " + cost);
    }
}
