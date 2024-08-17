public class TrappingRainwater {
    public static int trappingWater(int height[]) {
        // Calculate left max boundary
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1;i<leftMax.length;i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // Calculate right max boundary 
        int n = height.length;
        int rightMax[] = new int[height.length];
        rightMax[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        // Logic
        int trapWater = 0;
        for(int i = 0;i<height.length;i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trapWater += ( waterLevel - height[i] ) * 1; // trapwate = ( waterlevel - height ) * width
        }

        return trapWater;
    }
    public static void main(String[] args) {
        int height [] = {4,2,0,6,3,2,5};
        System.out.println(trappingWater(height));
    }
}
