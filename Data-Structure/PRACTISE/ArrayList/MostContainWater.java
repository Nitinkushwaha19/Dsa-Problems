import java.util.*;
public class MostContainWater {
    public static int mostWater (ArrayList<Integer>h) {
        int si = 0;
        int ei = h.size() - 1;
        int MaxWater = Integer.MIN_VALUE;

        while (si < ei) {
            int waterlevel = Math.min(h.get(si), h.get(ei));
            int curr = waterlevel * (ei - si);
            MaxWater = Math.max(MaxWater, curr);

            if(h.get(si) < h.get(ei)) {
                si++;
            } else {
                ei--;
            }
        }
        return MaxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> h = new ArrayList<>();
        int height [] = {1,8,6,2,5,4,8,3,7};
        for(int i = 0;i<height.length;i++) {
            h.add(height[i]);
        }

        System.out.println(mostWater(h));
    }
}