import java.util.Stack;

public class MaxAreaHistogram {
    public static int maxArea(int[] height) {
        Stack<Integer> s = new Stack<>();
        // calc. next smaller element in right
        int nsr[] = new int[height.length];
        for (int i = height.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = height.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // calc next smaller element in left
        s = new Stack<>();
        int nsl[] = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        // calc. max area
        for (int i = 0; i < height.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = height[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(maxArea(height));
    }
}
