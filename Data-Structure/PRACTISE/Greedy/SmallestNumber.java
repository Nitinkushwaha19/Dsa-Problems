public class SmallestNumber {
    public static String smallestNumber(int sum, int d) {
        StringBuilder sb = new StringBuilder("");
        if( sum == 0 || sum > 9*d) {
            sb.append(-1);
            return sb.toString();
        }
        sum -= 1;

        for(int i = d-1;i>0;i--) {
            if(sum > 9) {
                sb.append(9);
                sum -= 9;
            }else {
                sb.append(sum);
                sum = 0;
            }
        }

        sb.append(sum + 1);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        int s = 20, d = 3;
        System.out.println(smallestNumber(s, d));   
    }
}
