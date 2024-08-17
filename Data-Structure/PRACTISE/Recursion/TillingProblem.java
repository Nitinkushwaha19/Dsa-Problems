public class TillingProblem {
    public static int tillingProblem (int n ) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int hor = tillingProblem(n-2);
        int ver = tillingProblem(n-1);

        return hor + ver;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(tillingProblem(n));
    }
}