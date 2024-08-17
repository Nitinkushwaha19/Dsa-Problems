import java.util.Arrays;

public class MinimumCostForCoins {
    public static int minCost(int coin[], int k) {
        Arrays.sort(coin);
        int coins = (int) Math.ceil(coin.length/(k+1));
        int cost = 0;
        for(int i=0;i<=coins;i++) {
            cost += coin[i];
        }

        return cost;
    }
    public static void main(String[] args) {
        int coin[] = {100, 20, 50, 10, 2, 5}; 
        int k = 3;
        System.out.println(minCost(coin, k));
    }
}