import java.util.Stack;

public class LongestValidParanthesis {
    public static int longestvalidString(String str) {
        Stack<Character> s = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        idx.push(-1);
        int ans = 0;
        for(int i = 0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                s.push(ch);
                idx.push(i);
            }
            else if(!s.isEmpty() && ch == ')' ) {
                    s.pop();
                    idx.pop();
                    ans = Math.max(ans, i - idx.peek());
            }
            else {
                idx.push(i);
                
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(longestvalidString(str));

        Stack<Integer> st = new Stack<>();
        st.push(16);
        st.push(15);
        st.push(29);
        st.push(19);
        st.push(18);

    }
}
