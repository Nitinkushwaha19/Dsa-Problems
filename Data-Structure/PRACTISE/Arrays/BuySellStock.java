public class BuySellStock {
    public static int buySellStock(int prices[]) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1;i<prices.length;i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {5,4,3,2,1};
        System.out.println(buySellStock(prices));
    }
}
