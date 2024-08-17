import java.util.*;

public class MostWater {

    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        // brute force -- time complexity : O(n^2)
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int lineHeight = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = lineHeight * width;
                if (maxWater < currWater) {
                    maxWater = currWater;
                }
            }
        }

        return maxWater;
    }

    public static int maxStoreWater(ArrayList<Integer> height) {
        int maxWater = 0;
        // two pointer approach -- time complexity : O(n)
        int lp = 0, rp = height.size() - 1;
        while (lp < rp) {
            int lineHeight = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = lineHeight * width;

            
            maxWater = Math.max(maxWater, currWater);
            
            System.out.println("left"+lp + " " + "right"+rp + " "+  "max"+maxWater);
            if (lp < rp) {
                lp++;
            } else {
                rp--;
            }

        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        // 1, 8, 6, 2, 5, 4, 8, 3, 7
        height.add(2);
        height.add(3);
        height.add(4);
        height.add(5);
        height.add(18);
        height.add(17);
        height.add(6);
        System.out.println(height);
        System.out.println(storeWater(height));
    }
}
