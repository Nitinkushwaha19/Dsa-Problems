import java.util.Stack;

public class PostfixEvaluation {
      public static int evaluatePostFix(String str)
    {
        // Your code here
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0;i<str.length();i++) {
            char ch = str.charAt(i);
            int a;
            int b;
            
            switch(ch) {
                case '+' : 
                    b = s.pop();
                    a = s.pop();
                    s.push(a + b);
                    break;
                
                case '-' :
                    b = s.pop();
                    a = s.pop();
                    s.push(a-b);
                    break;
                
                case '*' :
                    b = s.pop();
                    a = s.pop();
                    s.push(a*b);
                    break;
                
                case '/' :
                    b = s.pop();
                    a = s.pop();
                    s.push(a/b);
                    break;
                
                case '%' :
                    b = s.pop();
                    a = s.pop();
                    s.push(a%b);
                    break;

                default : 
                int curr = ch - '0';
                s.push(curr);
            }
        }
        return s.peek();
        
    }
    public static void main(String[] args) {
        String str = "231*+9-";
        System.out.println(evaluatePostFix(str));
    }
}
