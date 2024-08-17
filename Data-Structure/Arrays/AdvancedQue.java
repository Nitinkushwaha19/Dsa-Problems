public class AdvancedQue {

    public static int trappedRainwater(int height[]) {
        int n = height.length;

        // calculate left max boundary - array
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }
        // calculate right max boundary - array
        int rightmax[] = new int[height.length];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }

        // loop
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            // Waterlevel = min(leftmax bound,rightmax bound)
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            // trapped water = waterlevel - height[i]
            trapped += waterlevel - height[i];
        }

        return trapped;
    }

    // Buy and sell stock
    public static int buyAndSellStocks(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {
            if (buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = price[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        // Trapping rainwater
        // int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        // System.out.println("Total trapped water is : " + trappedRainwater(height));

        // Buy and Sell Stocks
        int price [] = {7,1,5,3,6,4};
        System.out.println(buyAndSellStocks(price));
    }
}
