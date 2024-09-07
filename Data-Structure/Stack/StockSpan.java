import java.util.Stack;
public class StockSpan {

    public static void stockSpan(int[] stock, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1;i<stock.length;i++) {
            int currPrice = stock[i];
            while (!s.isEmpty() && currPrice > stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }
    public static void main(String[] args) {
        int stock[] = {100,80,60,70,60,85,100};
        int span[] = new int[stock.length];

        stockSpan(stock, span);
        for(int i=0;i<span.length;i++) {
            System.out.println(span[i] + " ");
        }
    }
}




// Leetcode :- Approach 
class StockSpanner {

    class Pair {
        int price;
        int index;

        public Pair(int p, int i){
            this.price = p;
            this.index = i;
        }
    }

    Stack<Pair> s;
    int idx;

    public StockSpanner() {
        s = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx++;
        int ans = 0;

        while(!s.isEmpty() && s.peek().price <= price){
            s.pop();
        }

        ans = idx - ( s.isEmpty() ? -1 : s.peek().index );
        s.push(new Pair(price,idx));

        return ans;
    }
}